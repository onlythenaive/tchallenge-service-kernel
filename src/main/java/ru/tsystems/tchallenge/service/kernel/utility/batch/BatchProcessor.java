package ru.tsystems.tchallenge.service.kernel.utility.batch;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class BatchProcessor {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void submit(Runnable runnable) {
        executorService.submit(runnable);
    }
}
