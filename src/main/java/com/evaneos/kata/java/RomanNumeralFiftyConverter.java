package com.evaneos.kata.java;

import java.util.ArrayList;

public class RomanNumeralFiftyConverter implements Converter {
    private final static Character ROMAN_CHARACTER = 'L';
    private final static int DECIMAL_VALUE = 50;

    private final ArrayList<Converter> converters;

    public RomanNumeralFiftyConverter() {
        this.converters = new ArrayList<Converter>();
        this.converters.add(new RomanNumeralTenConverter());
        this.converters.add(new RomanNumeralFiveConverter());
        this.converters.add(new RomanNumeralOneConverter());
    }

    public String convertToRomanNumerals(int number) {
        if (number < 39 || number > 100) {
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
