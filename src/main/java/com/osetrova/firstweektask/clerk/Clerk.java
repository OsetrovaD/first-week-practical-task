package com.osetrova.firstweektask.clerk;

import lombok.Getter;

@Getter
public class Clerk {

    private static final int IN_SEVENTY_FIVE_NUMBER = 3;
    private int twentyFiveDollarNumber = 0;
    private int fiftyDollarNumber = 0;
    private int hundredDollarNumber = 0;

    public int getSum() {
        return twentyFiveDollarNumber * Money.TWENTY_FIVE.getValue()
                + fiftyDollarNumber * Money.FIFTY.getValue()
                + hundredDollarNumber * Money.HUNDRED.getValue();
    }

    public void addTwentyFiveDollar() {
        twentyFiveDollarNumber++;
    }

    public void addFiftyDollar() {
        fiftyDollarNumber++;
    }

    public void addHundredDollar() {
        hundredDollarNumber++;
    }

    public void giveTwentyFiveDollar() {
        twentyFiveDollarNumber--;
    }

    public void giveChangeWithFiftyDollar() {
        fiftyDollarNumber--;
        twentyFiveDollarNumber--;
    }

    public void giveChangeThreeTwentyFiveDollar() {
        twentyFiveDollarNumber -= IN_SEVENTY_FIVE_NUMBER;
    }
}
