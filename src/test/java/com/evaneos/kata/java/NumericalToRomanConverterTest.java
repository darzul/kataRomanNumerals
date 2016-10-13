package com.evaneos.kata.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumericalToRomanConverterTest {

    private NumericalToRomanConverter SUT;
    private int number;
    private String result;

    @Before
    public void before() {
        this.SUT = new NumericalToRomanConverter();
    }

    @Test
    public void one_should_return_I() {
        Assert.assertEquals(SUT.convertToRomanNumerals(1), "I");
    }

    @Test
    public void three_should_return_III() {
        Assert.assertEquals(SUT.convertToRomanNumerals(3), "III");
    }

    @Test
    public void five_should_return_V() {
        Assert.assertEquals(SUT.convertToRomanNumerals(5), "V");
    }

    @Test
    public void four_should_return_IV() {
        Assert.assertEquals(SUT.convertToRomanNumerals(4), "IV");
    }

    @Test
    public void ten_should_return_X() {
        Assert.assertEquals(SUT.convertToRomanNumerals(10), "X");
    }

    @Test
    public void thirteen_should_return_XIII() {
        Assert.assertEquals(SUT.convertToRomanNumerals(13), "XIII");
    }

    @Test
    public void forty_eight_should_return_XLVIII() {
        Assert.assertEquals(SUT.convertToRomanNumerals(48), "XLVIII");
    }

    @Test
    public void it_should_respect_roman_numeral_rules() {
        given_a_random_number();
        when_convert_number_to_roman_numerals();
        then_result_should_only_contain_available_characters();
        then_result_should_not_place_char_before_other_chars('I', new char[]{'L', 'C', 'D', 'M'});
        then_result_should_not_place_char_before_other_chars('X', new char[]{'D', 'M'});
    }

    private void then_result_should_not_place_char_before_other_chars(char testedChar, char[] unauthorizedChars) {
        for (char unauthorizedChar : unauthorizedChars) {
            Assert.assertTrue(result.indexOf(testedChar) == -1 ||
                    result.indexOf(testedChar) >= result.lastIndexOf(unauthorizedChar));
        }
    }

    private void then_result_should_only_contain_available_characters() {
        List<Character> availableCharacters = new ArrayList<Character>();
        availableCharacters.add('I');
        availableCharacters.add('V');
        availableCharacters.add('X');
        availableCharacters.add('L');
        availableCharacters.add('C');
        availableCharacters.add('D');
        availableCharacters.add('M');

        for (int i = 0; i < result.length(); i++) {
            Assert.assertTrue("Invalid character in '" + result + "'  for " + number,
                    availableCharacters.contains(result.charAt(i)));
        }
    }

    private void when_convert_number_to_roman_numerals() {
        result = SUT.convertToRomanNumerals(number);
    }

    private void given_a_random_number() {
        number = (int) (Math.random() * NumericalToRomanConverter.MAX);
    }
}
