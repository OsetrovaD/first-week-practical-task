package com.osetrova.firstweektask.phonenumber;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.matchesPattern;
import static org.junit.Assert.assertThat;

public class NumbersToPhoneNumberServiceTest {

    private static final Random RANDOM = new Random();
    private static final NumbersToPhoneNumberService SERVICE = new NumbersToPhoneNumberService();
    private static final Pattern PATTERN = Pattern.compile("^\\(\\d{3}\\)\\d{3}-\\d{4}$");

    @Test
    public void byRegexToPhoneNumberTest() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(RANDOM.nextInt(10));
        }

        String result = SERVICE.numbersListToPhoneNumberByRegex(numbers);

        assertThat(result, matchesPattern(PATTERN));
    }

    @Test
    public void toPhoneNumberTest() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(RANDOM.nextInt(10));
        }

        String result = SERVICE.numbersListToPhoneNumber(numbers);

        assertThat(result, matchesPattern(PATTERN));
    }
}
