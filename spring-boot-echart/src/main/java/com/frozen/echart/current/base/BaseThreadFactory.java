package com.frozen.echart.current.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author frozen
 */
public class BaseThreadFactory implements ThreadFactory {
	String threadName ;

	public BaseThreadFactory(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Worker(threadName, r);
		t.setDaemon(true);
		t.setPriority(5);
		return t;
	}

    static class Worker extends Thread {
	    private static final Logger logger = LoggerFactory.getLogger(Worker.class);
	    private static final UncaughtExceptionHandler uncaughtExceptionHandler = (t, e)
			    -> logger.warn("Exception occurred from thread {}", t.getName(), e);

	    public Worker(String threadName, Runnable r) {
		    super(r, threadName);
		    setUncaughtExceptionHandler(uncaughtExceptionHandler);
	    }
    }
}
