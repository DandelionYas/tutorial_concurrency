package tutorial.concurrency.thread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AsyncTaskRunnable implements Runnable {
    private static final Log LOGGER = LogFactory.getLog(AsyncTaskRunnable.class);

    public void run() {
        try {
            LOGGER.info("Async task started.");
            Thread.sleep(10_000);
            LOGGER.info("Async task finished execution after 10 seconds.");
        } catch (InterruptedException e) {
            LOGGER.error(e,e);
        }
    }
}
