package com.williamfiset.algorithms.dp;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.Ints;
import com.williamfiset.algorithms.utils.TestUtils;
import java.util.*;
import org.junit.*;



public class LongestCommonSubstringTest {


    /*
    Tests that two inputs with no overlapping substring returns empty string.
    */
    @Test
    public void testNullSubstring(){
        char[] s1 = {'a','b','c'};
        char[] s2 = {'e','e','f'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo("");
    }


    /*
     Tests that two inputs with common substring embedded in word returns
     that substring
    */
    @Test
    public void testEmbeddedWord(){
        char[] s1 = {'a','b','c'};
        char[] s2 = {'b','c','d'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo("bc");
    }

    /*
    Tests inputs with varying length to ensure common substring is found,
    where the common substring in the longer string is located at indices greater
    than the length of the shorter string
    */
    @Test
    public void testVaryingLength(){
        char[] s1 = {'a','b','c'};
        char[] s2 = {'d','e','f','d','e','f','d','e','f','a','b','c'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo("abc");
    }


    /*
    Inputs with more than one common substring, tests that the correct
    (longest one), is returned
     */
    @Test
    public void testCorrectSubstring(){
        char[] s1 = {'a','b','c','d','e','f','h','u','s'};
        char[] s2 = {'b','i','l','h','u','s','a','b','c','d','e','f'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo("abcdef");
    }

    /*
    Inputs with an empty substring, tests that null is returned
    */
    @Test
    public void testEmptySubstring(){
        char[] s1 = {};
        char[] s2 = {'a','b','c'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo(null);
    }

    /*
    Inputs with null as inputs, tests that null is returned
    */
    @Test
    public void testNullInput(){
        char[] s1 = null;
        char[] s2 = null;
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo(null);
    }

    /*
    Inputs with same character multiplied still, tests that only one character is returned
    */
    @Test
    public void testSameCharacterSubstring(){
        char[] s1 = {'a','a','a'};
        char[] s2 = {'a','b','c'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo("a");
    }


    /*
    Inputs with Integer inputs, test that it does not return an exception/error aswell as not including it in the answer
    */
    @Test
    public void testIntegerInput(){
        char[] s1 = {1, 'a','c'};
        char[] s2 = {'a','b'};
        String result = LongestCommonSubstring.lcs(s1,s2);
        assertThat(result).isEqualTo("a");
    }

}