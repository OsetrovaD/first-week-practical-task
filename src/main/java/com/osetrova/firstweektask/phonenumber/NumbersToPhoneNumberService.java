package com.osetrova.firstweektask.phonenumber;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class NumbersToPhoneNumberService {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("(\\d{3})(\\d{3})(\\d{4})");
    private static final String NOTHING = "";
    private static final String HYPHEN = "-";
    private static final String LEFT_ROUND_BRACKET = "(";
    private static final String RIGHT_ROUND_BRACKET = ")";

    public String numbersListToPhoneNumberByRegex(List<Integer> numbers) {

        if (numbers.size() != 10) {
            throw new RuntimeException("List size is not equal 10");
        }

        String string = numbers.stream()
                .map(String::valueOf)
                .collect(joining(NOTHING, NOTHING, NOTHING));

        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(string);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(LEFT_ROUND_BRACKET)
                    .append(matcher.group(1))
                    .append(RIGHT_ROUND_BRACKET)
                    .append(matcher.group(2))
                    .append(HYPHEN)
                    .append(matcher.group(3));
        }

        return result.toString();
    }

    public String numbersListToPhoneNumber(List<Integer> numbers) {

        if (numbers.size() != 10) {
            throw new RuntimeException("List size is not equal 10");
        }

        return numbers.subList(0, 3).stream()
                        .map(String::valueOf)
                        .collect(joining(NOTHING, LEFT_ROUND_BRACKET, RIGHT_ROUND_BRACKET))
                + numbers.subList(3, 6).stream()
                        .map(String::valueOf)
                        .collect(joining(NOTHING, NOTHING, HYPHEN))
                + numbers.subList(6, 10).stream()
                        .map(String::valueOf)
                        .collect(joining(NOTHING, NOTHING, NOTHING));
    }
}
