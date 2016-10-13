package com.evaneos.kata.java;

import java.util.ArrayList;

public class RomanNumeralFiveConverter implements Converter {
    private final static Character ROMAN_CHARACTER = 'V';
    private final static int DECIMAL_VALUE = 5;

    private final ArrayList<Converter> converters;

    public RomanNumeralFiveConverter() {
        this.converters = new ArrayList<Converter>();
        this.converters.add(new RomanNumeralOneConverter());
    }

    public String convertToRomanNumerals(int number) {
        if (number < 4 || number > 8) {
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
        }else{
            result.insert(0, romanRemainder);
        }

        return result.toString();
    }
}
