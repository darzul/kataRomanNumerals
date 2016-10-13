package com.evaneos.kata.java;

import java.util.ArrayList;

public class NumericalToRomanConverter implements Converter {
    public static final int MAX = 3999;


    private final ArrayList<Converter> converters;

    public NumericalToRomanConverter() {
        this.converters = new ArrayList<Converter>();
        this.converters.add(new RomanNumeralOneConverter());
        this.converters.add(new RomanNumeralFiveConverter());
        this.converters.add(new RomanNumeralTenConverter());
    }

    public String convertToRomanNumerals(int number) {
        StringBuilder result = new StringBuilder();

        for (Converter converter : this.converters) {
            result.append(converter.convertToRomanNumerals(number));
        }

        return result.toString();
    }
}
