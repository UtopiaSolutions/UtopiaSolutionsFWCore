package com.usf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Class to handle setting/removing MDC on per test case basis. This helps
 * us log each test case into it's own log file. Please see
 *
 */
public class TestLogHelper
{
    private static final Logger log = LoggerFactory.getLogger(TestLogHelper.class);
    public static final String LOG_FILE_NAME = "logFileName";

    /**
     * Adds the test name to MDC so that sift appender can use it and log the new
     * log events to a different file
     * @param name name of the new log file
     */
    public static void startTestLogging(String name){
        MDC.put(LOG_FILE_NAME, name);
    }

    /**
     * Removes the key (log file name) from MDC
     * @return name of the log file, if one existed in MDC
     */
    public static String stopTestLogging() {
        String name = MDC.get(LOG_FILE_NAME);
        MDC.remove(LOG_FILE_NAME);
        return name;
    }
}