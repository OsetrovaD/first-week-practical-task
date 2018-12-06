package com.osetrova.firstweektask.clerk;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClerkServiceTest {

    private static final ClerkService SERVICE = new ClerkService();

    @Test
    public void checkHasClerkEnoughMoney() {
        Clerk firstClerk = new Clerk();
        List<Visitor> visitors = Arrays.asList(
                new Visitor(Money.TWENTY_FIVE),
                new Visitor(Money.TWENTY_FIVE),
                new Visitor(Money.FIFTY),
                new Visitor(Money.HUNDRED));

        boolean firstResult = SERVICE.hasClerkEnoughMoney(firstClerk, visitors);
        assertTrue(firstResult);
        assertEquals(100, firstClerk.getSum());

        Clerk secondClerk = new Clerk();
        List<Visitor> nextVisitors = Arrays.asList(
                new Visitor(Money.TWENTY_FIVE),
                new Visitor(Money.TWENTY_FIVE),
                new Visitor(Money.HUNDRED));

        boolean secondResult = SERVICE.hasClerkEnoughMoney(secondClerk, nextVisitors);
        assertFalse(secondResult);
        assertEquals(50, secondClerk.getSum());
    }
}
