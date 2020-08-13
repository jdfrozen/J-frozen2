package com.frozen.helloboot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author frozen
 */
public class SleepHelper {

    private static final Logger logger = LoggerFactory.getLogger(SleepHelper.class);

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
	        logger.warn(e.getMessage());
        }

    }

    public static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
	        logger.warn(e.getMessage());
        }

    }


}
