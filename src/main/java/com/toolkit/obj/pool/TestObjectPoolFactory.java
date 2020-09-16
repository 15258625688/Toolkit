package com.toolkit.obj.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class TestObjectPoolFactory extends BasePooledObjectFactory<TestObjectPoolClass> {

    @Override
    public TestObjectPoolClass create() throws Exception {
	return new TestObjectPoolClass();
    }

    @Override
    public PooledObject<TestObjectPoolClass> wrap(TestObjectPoolClass obj) {
	return new DefaultPooledObject<TestObjectPoolClass>(obj);
    }

}
