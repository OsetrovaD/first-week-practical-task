package com.osetrova.firstweektask.clerk;

import lombok.Getter;

@Getter
public enum Money {
    TWENTY_FIVE(25),
    FIFTY(50),
    HUNDRED(100);

    private int value;

    Money(int value) {
        this.value = value;
    }
}
