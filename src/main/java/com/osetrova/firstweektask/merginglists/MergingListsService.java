package com.osetrova.firstweektask.merginglists;

import java.util.ArrayList;

public class MergingListsService {

    public void mergeTwoArrayLists(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
        int firstListIndex = 0;
        int secondListIndex = 0;
        int resultListSize = firstList.size() + secondList.size();

        for (int i = 0; i < resultListSize; i++) {
            if (firstListIndex == firstList.size()) {
                firstList.add(secondList.get(secondListIndex++));
            } else if (secondListIndex == secondList.size()) {
                break;
            } else if (firstList.get(firstListIndex) > secondList.get(secondListIndex)) {
                firstList.add(firstListIndex++, secondList.get(secondListIndex++));
            } else {
                firstListIndex++;
            }
        }
    }
}
