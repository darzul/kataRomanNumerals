package com.evaneos.kata.java;

public class RomanNumeralOneConverter implements Converter {
    private final static Character ROMAN_CHARACTER = 'I';

    public String convertToRomanNumerals(int number) {
        StringBuilder result = new StringBuilder();

        if (number < 1 || number > 3) {
            return "";
        }

        for (int i = 0; i < number; i++) {
            result.append(ROMAN_CHARACTER);
        }

        return result.toString();
    }
}
