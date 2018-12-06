package com.osetrova.firstweektask.clerk;

import java.util.List;

public class ClerkService {

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
                    } else if (clerk.getTwentyFiveDollarNumber() >= 3) {
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
