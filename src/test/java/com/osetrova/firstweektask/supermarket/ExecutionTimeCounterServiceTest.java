package com.osetrova.firstweektask.supermarket;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class ExecutionTimeCounterServiceTest {

    private static final ExecutionTimeCounterService SERVICE = new ExecutionTimeCounterService();

    @Test
    public void checkThreeBuyersOneCashDeskTime() {
        Buyer firstBuyer = Buyer.builder()
                .products(Arrays.asList(Product.POTATO, Product.CHOCOLATE, Product.MILK, Product.APPLE, Product.FISH))
                .build();
        Buyer secondBuyer = Buyer.builder()
                .products(Arrays.asList(Product.LEMON, Product.CHOCOLATE, Product.STRAWBERRY))
                .build();
        Buyer thirdBuyer = Buyer.builder()
                .products(Arrays.asList(Product.ICE_CREAM, Product.MINERAL_WATER, Product.CHEESE, Product.CHOCOLATE))
                .build();

        PriorityQueue<Buyer> buyers = new PriorityQueue<>();
        buyers.add(firstBuyer);
        buyers.add(secondBuyer);
        buyers.add(thirdBuyer);

        long resultTime = 0;
        try {
            resultTime = SERVICE.executionTimeCount(1, buyers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(12L, resultTime);
    }

    @Test
    public void checkFourBuyersTwoCashDesksTime() {
        Buyer firstBuyer = Buyer.builder()
                .products(Arrays.asList(
                        Product.POTATO, Product.BREAD, Product.CHEESE, Product.CHOCOLATE, Product.FISH,
                        Product.ICE_CREAM, Product.BREAD, Product.APPLE, Product.MINERAL_WATER, Product.MILK
                ))
                .build();
        Buyer secondBuyer = Buyer.builder()
                .products(Arrays.asList(Product.LEMON, Product.CHOCOLATE))
                .build();
        Buyer thirdBuyer = Buyer.builder()
                .products(Arrays.asList(Product.MINERAL_WATER, Product.BREAD, Product.LEMON))
                .build();
        Buyer fourthBuyer = Buyer.builder()
                .products(Arrays.asList(Product.POTATO, Product.BREAD, Product.CHEESE))
                .build();

        PriorityQueue<Buyer> buyers = new PriorityQueue<>();
        buyers.add(firstBuyer);
        buyers.add(secondBuyer);
        buyers.add(thirdBuyer);
        buyers.add(fourthBuyer);

        long resultTime = 0;
        try {
            resultTime = SERVICE.executionTimeCount(2, buyers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(10L, resultTime);
    }

    @Test
    public void checkThreeBuyersTwoCashDesksTime() {
        Buyer firstBuyer = Buyer.builder()
                .products(Arrays.asList(Product.POTATO, Product.BREAD))
                .build();
        Buyer secondBuyer = Buyer.builder()
                .products(Arrays.asList(Product.CHEESE, Product.CHOCOLATE, Product.CHOCOLATE))
                .build();
        Buyer thirdBuyer = Buyer.builder()
                .products(Arrays.asList(
                        Product.MILK, Product.BREAD, Product.MINERAL_WATER, Product.CHOCOLATE, Product.MILK,
                        Product.APPLE, Product.ICE_CREAM, Product.APPLE, Product.STRAWBERRY, Product.LEMON
                ))
                .build();

        PriorityQueue<Buyer> buyers = new PriorityQueue<>();
        buyers.add(firstBuyer);
        buyers.add(secondBuyer);
        buyers.add(thirdBuyer);

        long resultTime = 0;
        try {
            resultTime = SERVICE.executionTimeCount(2, buyers);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(12L, resultTime);
    }
}
