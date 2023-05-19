package org.algorithms.books.commond_sense_guide;

import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 8: Blazing Fast Lookup with Hash Tables
 * Exercise 3 - Given a String, return the first missing letter of alphabet
 * Examples:
 * 1. input: "the quick brown box jumps over a lazy dog" output: f
 *
 * Solution:
 * 1. Create an index(Set) in which you add all letters of the input string to be searched with O(1)
 * 2. Iterate since "a" to "z", and validate if all letters are present in the index
 * */
class MissingLetterOfAlphabet {
    public String findMissingLetterOfAlphabet(String phrase){
        Set<String> letters = Stream.of(phrase.toUpperCase().split("")).collect(toSet());

        String letterString;
        for(char letter = 'a'; letter <='z'; letter++ ){
            letterString = String.valueOf(letter).toUpperCase();
            if(!letters.contains(letterString)){
                return letterString;
            }
        }

        return "All letters of alphabet";
    }
}

//region Test
class MissingLetterOfAlphabetTest{

    MissingLetterOfAlphabet alphabet = new MissingLetterOfAlphabet();
    public static void main(String[] args){
        MissingLetterOfAlphabetTest test = new MissingLetterOfAlphabetTest();
        test.test1();
    }

    private void test1(){
        String missingLetter = alphabet.findMissingLetterOfAlphabet("the quick brown box jumps over a lazy dog");
        assertEquals("F", missingLetter);
    }
}
//endregion
