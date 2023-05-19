package org.algorithms.interview.disney;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Company: Disney
 * Type of Algorithms: Maths
 *
 * Given a list of adds represented by letters ABCD, a number of spaces between them, and a number of spots, return in a string, the possible combinations to show this adds
 *
 * Note 1: Between each group of adds should exist the spaces defined
 * Note 2: The returned string with the distribution can not be greater than the available spots
 *
 * Solution:
 * 1. This problem is solved using the combination's formula, as K is equals to N, combination is N!,
 * 2. Second step is define the total spots needed = N(N!) + Y(N!-1), Y is the number of spaces between groups of adds
 *
 * Example:
 * Input-> adds: ABC spaces:2 spots: 30
 * Output-> ABC__ACB__BAC__BCA__CAB__CBA -> 6 possible combinations
 *
 * Input-> adds: ABCD spaces:2 spots: 30
 * Output-> ABCD__ABDC__ACDB__ACBD__ADBC__ -> 5 possible combinations
 */
class AllAddsCombinations {
    public int findAddsCombinations(int numberOfAdds, int spots, int spaces){
        int totalSpots;
        totalSpots = numberOfAdds * factorial(numberOfAdds);
        totalSpots = totalSpots + spaces * (factorial(numberOfAdds) - 1);

        if(totalSpots <= spots){
            return factorial(numberOfAdds);
        }else{
            return (spots)/(numberOfAdds+spaces);
        }

    }

    private int factorial(int n){
        if(n <= 2)
            return n;
        else
            return n * factorial(n-1);
    }
}

//region Test
class AllAddsCombinationsTest{
    private AllAddsCombinations allAddsCombinations = new AllAddsCombinations();

    public static void main(String[] args){
        AllAddsCombinationsTest test = new AllAddsCombinationsTest();
        test.test1();
        test.test2();
        test.test3();
    }
    private void test1(){
        assertEquals(2,allAddsCombinations.findAddsCombinations(3, 10, 1));
    }

    private void test2(){
        assertEquals(6,allAddsCombinations.findAddsCombinations(3, 30, 2));
    }

    private void test3(){
        assertEquals(5,allAddsCombinations.findAddsCombinations(4, 30, 2));
    }
}
//endregion
