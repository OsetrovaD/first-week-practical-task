package com.osetrova.firstweektask.supermarket;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.concurrent.Semaphore;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Buyer implements Runnable, Comparable<Buyer> {

    private Semaphore cashDesk;
    private List<Product> products;

    @Override
    public void run() {
        try {
            cashDesk.acquire();
            for (Product product : products) {
                System.out.println(Thread.currentThread().getName() + " buying " + product);
                Thread.sleep(1000L);
            }
            cashDesk.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(Buyer o) {
        return Thread.currentThread().getName().compareTo(new Thread(o).getName());
    }
}
