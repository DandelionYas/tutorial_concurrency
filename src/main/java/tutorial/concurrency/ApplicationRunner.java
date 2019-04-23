package tutorial.concurrency;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import tutorial.concurrency.thread.AsyncTaskRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ApplicationRunner {
    private static final Log LOGGER = LogFactory.getLog(ApplicationRunner.class);

    public static void main(String[] args) throws InterruptedException {
        AsyncTaskRunnable task = new AsyncTaskRunnable();
        LOGGER.info("Calling AsyncTask Runner.");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(task);
        Thread.sleep(2_000);
        LOGGER.info("Main task finished.");
        executorService.awaitTermination(8, TimeUnit.SECONDS);
        if(!executorService.isTerminated()) {
            executorService.shutdown();
            LOGGER.info("ExecutorService has been shut down.");
        }
    }
}