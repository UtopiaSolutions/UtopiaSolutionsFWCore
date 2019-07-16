package com.usf.utils.logging;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class USFLogger {

    public static org.slf4j.Logger createLogger(Class className) {
        Logger logger = (Logger) LoggerFactory.getLogger(className);
        logger.setLevel(Level.DEBUG);
        logger.setAdditive(true); /* set to true if root should log too */

        return logger;
    }

}
