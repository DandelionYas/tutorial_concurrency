package tutorial.concurrency;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tutorial.concurrency.thread.AsyncTaskRunnable;

public class ApplicationRunner {
    private static final Log LOGGER = LogFactory.getLog(ApplicationRunner.class);

    public static void main(String[] args) throws InterruptedException {
        AsyncTaskRunnable task = new AsyncTaskRunnable();
        LOGGER.info("Calling AsyncTask Runner.");
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(2_000);
        LOGGER.info("Main thread finished.");
    }
}