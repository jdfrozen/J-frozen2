package com.frozen.helloboot.current;


import com.frozen.helloboot.current.base.BaseThreadFactory;
import com.frozen.helloboot.current.base.BaseThreadPoolExecutor;

import java.util.concurrent.*;

/**
 *
 * @author frozen
 */
public class WfsErrorRootThreadPool {

    private static int cup = 2;
    private static int maxPoolSize = cup * 2;
    private static String threadName = "WfsErrorTask";
    private static final int queueSize = 1024;
    private static final long keepTime = 1000 * 60;
    private static TimeUnit keepTimeUnit = TimeUnit.MILLISECONDS;

    private static ScheduledExecutorService ss = getScheduled();
    private static ThreadPoolExecutor te = getThreadPool();

    private static ThreadPoolExecutor getThreadPool() {
        return new BaseThreadPoolExecutor(
            cup,
            maxPoolSize,
            keepTime,
            keepTimeUnit,
            new LinkedBlockingQueue<>(queueSize),
            new BaseThreadFactory(threadName));
    }

    private static ScheduledExecutorService getScheduled() {
        return new ScheduledThreadPoolExecutor(cup, new BaseThreadFactory(threadName));
    }


    public static void scheduleAtFixedRate(Runnable r, long initDelay, long delay) {
        ss.scheduleAtFixedRate(r, initDelay, delay, TimeUnit.MILLISECONDS);
    }


    public static void scheduleWithFixedDelay(Runnable r, long delay) {
        ss.scheduleWithFixedDelay(r, 0, delay, TimeUnit.MILLISECONDS);
    }

    @SuppressWarnings("unchecked")
    public static <T> Future<T> submit(Callable r) {
        return te.submit(r);
    }

    public static void execute(Runnable r) {
        te.execute(r);
    }

    public static void execute(Runnable r, boolean sync) {
        if (sync) {
            r.run();
        } else {
            te.execute(r);
        }
    }

}
