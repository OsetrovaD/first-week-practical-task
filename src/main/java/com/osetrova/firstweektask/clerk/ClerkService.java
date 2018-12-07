package com.osetrova.firstweektask.clerk;

import java.util.List;

public class ClerkService {

    private static final int TWENTY_FIVE_IN_SEVENTY_FIVE_NUMBER = 3;

    public boolean hasClerkEnoughMoney(Clerk clerk, List<Visitor> visitors) {
        boolean result = false;

        for (Visitor visitor : visitors) {
            if (visitor.getMoney() != Money.TWENTY_FIVE) {
                if (clerk.getTwentyFiveDollarNumber() == 0) {
                    result = false;
                    break;
                } else if (visitor.getMoney() == Money.FIFTY) {
                    clerk.addFiftyDollar();
                    clerk.giveTwentyFiveDollar();
                } else {
                    if (clerk.getFiftyDollarNumber() != 0) {
                        clerk.addHundredDollar();
                        clerk.giveChangeWithFiftyDollar();
                    } else if (clerk.getTwentyFiveDollarNumber() >= TWENTY_FIVE_IN_SEVENTY_FIVE_NUMBER) {
                        clerk.addHundredDollar();
                        clerk.giveChangeThreeTwentyFiveDollar();
                    } else {
                        result = false;
                        break;
                    }
                }
            } else {
                clerk.addTwentyFiveDollar();
            }

            result = true;
        }

        return result;
    }
}
