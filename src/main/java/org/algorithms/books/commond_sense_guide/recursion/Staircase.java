package org.algorithms.books.commond_sense_guide.recursion;
/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 11: Learning to Write in Recursive
 * Staircase Problem
 *
 * Solution:
 * 1. Is a Recursive top-down algorithms, in which we start at the end of the staircase and, we start to subtract combinations of 1,2 and 3 steps
 * 2. Recursive Case: Sum all the possible paths of 1,2 and 3 steps
 * 3. Base Case: If after subtract we get 0 steps pending, it means we found a valid path, if we get < 0, means, this is no valid path
 * */
class StairCase {
    public int findPossiblePaths(int n){
        //Base case 1: The last step is greater than the staircase, 0 because is not a valid path
        if(n < 0)
            return 0;
        //Base case 2: Exist an exact match of steps, so, return 1 because is a valid path
        if(n == 0)
            return 1;

        //Recursive case: Result should be equals to sum all possible valid paths of 1,2 and 3 steps
        return findPossiblePaths(n-1)+findPossiblePaths(n-2)+findPossiblePaths(n-3);
    }
}

//region Test
class StaircaseTest{
    private StairCase template = new StairCase();

    public static void main(String[] args){
        StaircaseTest test = new StaircaseTest();
        test.test1();
    }

    private void test1(){
        System.out.println(template.findPossiblePaths(5));
    }
}
//endregion
