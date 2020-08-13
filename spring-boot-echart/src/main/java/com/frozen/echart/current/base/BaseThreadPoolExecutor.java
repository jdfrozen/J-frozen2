package com.frozen.echart.current.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author frozen
 */
public class BaseThreadPoolExecutor extends ThreadPoolExecutor {

    private static final Logger logger = LoggerFactory.getLogger(BaseThreadPoolExecutor.class);

    private static final ThreadLocal<Long> COST_TIME_WATCH = ThreadLocal.withInitial(System::currentTimeMillis);

    public BaseThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                                      BlockingQueue<Runnable> workQueue, BaseThreadFactory nameThreadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, nameThreadFactory);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        COST_TIME_WATCH.get();
	    logger.debug("thread pool before Execute");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
	    logger.debug("thread pool after Execute, cost time : {}", System.currentTimeMillis() - COST_TIME_WATCH.get());
        COST_TIME_WATCH.remove();
    }

    @Override
    protected void terminated() {
	    logger.info("active count : {}, queueSize : {}, poolSize : {}", getActiveCount(), getQueue().size(), getPoolSize());
    }
}
