package com.osetrova.firstweektask.supermarket;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ExecutionTimeCounterService {

    public long executionTimeCount(int numberOfCashDesks, PriorityQueue<Buyer> buyers) throws InterruptedException {
        Semaphore cashDesks = new Semaphore(numberOfCashDesks);

        long startTime = System.nanoTime();

        ExecutorService service = Executors.newFixedThreadPool(buyers.size());
        buyers.stream().peek(x -> x.setCashDesk(cashDesks)).forEach(service::execute);

        service.shutdown();
        service.awaitTermination(1L, TimeUnit.HOURS);

        long duration = System.nanoTime() - startTime;
        return TimeUnit.NANOSECONDS.toSeconds(duration);
    }
}
