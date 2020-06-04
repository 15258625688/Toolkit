package test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.toolkit.util.LoggerUtil;

public class LoggerTest {

    @Test
    public void test1() throws IOException {
	Logger logger = LoggerUtil.getLogger("zhh");
	logger.info("测试log4j工具类");
    }
}
