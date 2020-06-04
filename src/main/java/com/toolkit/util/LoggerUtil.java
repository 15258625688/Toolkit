package com.toolkit.util;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.TTCCLayout;

public class LoggerUtil {

    private final static TTCCLayout LAYOUT;
    private final static ConsoleAppender CA;
    private final static Map<String, Logger> LOG_MAP;
    private final static String DEFAULT_ENCODING = "UTF-8";
    private final static String DEFAULT_TIME_ZONE = "GMT+08";

    static {
	LAYOUT = new TTCCLayout("yyyy-MM-dd HH:mm:ss.S");
	LAYOUT.setTimeZone(DEFAULT_TIME_ZONE);
	CA = new ConsoleAppender(LAYOUT);
	CA.setEncoding(DEFAULT_ENCODING);
	LOG_MAP = new ConcurrentHashMap<String, Logger>();
    }

    public static Logger getLogger(String name) {
	if (name == null)
	    throw new NullPointerException("logger name is empty");
	Logger logger = LOG_MAP.get(name);
	if (logger != null)
	    return logger;
	logger = newLogger(name);
	if (logger != null)
	    LOG_MAP.put(name, logger);
	return logger;
    }

    private static Logger newLogger(String name) {
	try {
	    Logger logger = Logger.getLogger(name);
	    DailyRollingFileAppender drfa = new DailyRollingFileAppender(LAYOUT, "logs/" + name + "/info.log",
		    "'.'yyyy-MM-dd");
	    drfa.setEncoding(DEFAULT_ENCODING);
	    drfa.activateOptions();
	    logger.addAppender(drfa);
	    logger.addAppender(CA);
	    return logger;
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
