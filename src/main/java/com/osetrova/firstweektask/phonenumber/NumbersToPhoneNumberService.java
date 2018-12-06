package com.osetrova.firstweektask.phonenumber;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class NumbersToPhoneNumberService {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("(\\d{3})(\\d{3})(\\d{4})");

    public String numbersListToPhoneNumberByRegex(List<Integer> numbers) {

        if (numbers.size() != 10) {
            throw new RuntimeException("List size is not equals 10");
        }

        String string = numbers.stream()
                .map(String::valueOf)
                .collect(joining("", "", ""));

        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(string);
        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append("(")
                    .append(matcher.group(1))
                    .append(")")
                    .append(matcher.group(2))
                    .append("-")
                    .append(matcher.group(3));
        }

        return result.toString();
    }

    public String numbersListToPhoneNumber(List<Integer> numbers) {

        if (numbers.size() != 10) {
            throw new RuntimeException("List size is not equals 10");
        }

        return numbers.subList(0, 3).stream()
                        .map(String::valueOf)
                        .collect(joining("", "(", ")"))
                + numbers.subList(3, 6).stream()
                        .map(String::valueOf)
                        .collect(joining("", "", "-"))
                + numbers.subList(6, 10).stream()
                        .map(String::valueOf)
                        .collect(joining("", "", ""));
    }
}
