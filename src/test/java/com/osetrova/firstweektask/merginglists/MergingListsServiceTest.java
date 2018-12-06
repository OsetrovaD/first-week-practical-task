package com.osetrova.firstweektask.merginglists;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MergingListsServiceTest {

    private static final MergingListsService SERVICE = new MergingListsService();

    @Test
    public void twoListsMerge() {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 10, 15, 16, 17));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(6, 8, 9, 10, 11, 12, 13));

        SERVICE.mergeTwoArrayLists(first, second);

        Assert.assertThat(first, Matchers.contains(1, 2, 3, 5, 6, 8, 9, 10, 10, 11, 12, 13, 15, 16, 17));
    }
}
