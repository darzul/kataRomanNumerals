package com.evaneos.kata.java;

import java.util.ArrayList;

public class RomanNumeralTenConverter implements Converter {
    private final static Character ROMAN_CHARACTER = 'X';
    private final static int DECIMAL_VALUE = 10;

    private final ArrayList<Converter> converters;

    public RomanNumeralTenConverter() {
        this.converters = new ArrayList<Converter>();
        this.converters.add(new RomanNumeralFiveConverter());
        this.converters.add(new RomanNumeralOneConverter());
    }

    public String convertToRomanNumerals(int number) {
        if (number < 9 || number > 38) {
            return "";
        }
        StringBuilder result = new StringBuilder();

        result.append(ROMAN_CHARACTER);

        int remainder = number - DECIMAL_VALUE;

        String romanRemainder = "";
        for (Converter converter : this.converters) {
            romanRemainder = converter.convertToRomanNumerals(Math.abs(remainder));
        }

        if (remainder > 0) {
            result.append(romanRemainder);
        } else {
            result.insert(0, romanRemainder);
        }

        return result.toString();
    }
}
