package org.algorithms.books.commond_sense_guide.recursion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 11: Learning to Write in Recursive
 * Excessive 1
 * Given an array of strings, return the total number of letters in this array
 *
 * Solution:
 * 1. Is a Recursive top-down algorithms, I use a Queue and use poll to Reduce the problem
 * 2. Recursive Case: sum size of polled word + count letters for the rest array elements
 * 3. Base Case: Ir array size is 1, return number of letters for last element
 * */
class CountNumberOfLetters {
    public int countNumberOfLetters(Queue<String> words){
        //Reducing the problem: taking last element and deleted from the array words
        int size = words.poll().length();

        //Base Case: If words is empty, return length of last item of words
        if(words.isEmpty()){
            return size;
        }

        //Recursive Case: Sum size of last element with size of letters for the rest of words
        return size + countNumberOfLetters(words);
    }
}

//region Test
class CountNumberOfLettersTest{
    private CountNumberOfLetters CountNumberOfLetters = new CountNumberOfLetters();

    public static void main(String[] args){
        CountNumberOfLettersTest test = new CountNumberOfLettersTest();
        test.test1();
    }

    private void test1(){
        assertEquals(7,CountNumberOfLetters.countNumberOfLetters(new LinkedList<>(Arrays.asList("Car", "Bike"))));
    }
}
//endregion
