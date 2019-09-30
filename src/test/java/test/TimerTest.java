package test;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.Test;

public class TimerTest {

	@Test
	public void test1() throws InterruptedException {
		test2();
	}

	public static void test2() {
		final Timer time = new Timer();
		final TimerTask task = new TimerTask() {

			@Override
			public void run() {
				System.out.println(1);
//				this.cancel();
			}
		};
		time.schedule(task, 0, 2 * 1000);
	}
}
