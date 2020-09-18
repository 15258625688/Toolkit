package com.toolkit.obj.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class PoolTest {
    private static GenericObjectPool<TestObjectPoolClass> objectPool;

    public static void main(String[] args) throws InterruptedException {
	GenericObjectPoolConfig<TestObjectPoolClass> config = new GenericObjectPoolConfig<>();
	config.setMaxTotal(10);
	config.setMaxIdle(10);
	config.setMaxWaitMillis(60 * 1000);
	objectPool = new GenericObjectPool<TestObjectPoolClass>(new TestObjectPoolFactory(), config);
	ExecutorService exec = Executors.newFixedThreadPool(10);
	for (int n = 0; n < 10; n++) {
	    exec.submit(new Runnable() {

		@Override
		public void run() {
		    TestObjectPoolClass obj = null;
		    try {
			obj = objectPool.borrowObject();
			System.out.println(obj);
			Thread.sleep(1000);
		    } catch (Exception e) {
			e.printStackTrace();
		    } finally {
			if (obj != null)
			    objectPool.returnObject(obj);
		    }
		}
	    });
	}
	Thread.sleep(10 * 1000);
	System.out.println("end");
	exec.shutdown();
    }
}
