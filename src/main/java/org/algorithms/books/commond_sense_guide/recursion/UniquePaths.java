package org.algorithms.books.commond_sense_guide.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 11: Learning to Write in Recursive
 * Excessive 5 - unique paths
 * Given a number of rows and columns, find the number of possible shorted possible paths starting in position 1,1 and finishing in position rows,columns, you only can advance one step to right and une step down
 *
 * Solution:
 * 1. Paint a tree with the possible with the only two possible options, move one step right and one step down
 * 2. Recursive Case: uniquePaths(rows-1, columns) and uniquePaths(rows, columns-1)
 * 3. Base Case: When rows and columns are equals to 1, we have a valid path
 * */
class UniquePaths {
    public int numberOfUniquePaths;
    public void findUniquePaths(int rows, int columns){
        //Base Case: We reach the initial position
        if(rows == 1 && columns == 1)
            numberOfUniquePaths++;

        //Recursive Case 1: We call the Fx() reducing rows-1 until rows is greater than 1
        if(rows > 1)
            findUniquePaths(rows -1, columns);

        //Recursive Case 2: We call the Fx() reducing columns-1 until is greater than 1
        if(columns > 1)
            findUniquePaths(rows, columns-1);
    }
}

//region Test
class UniquePathsTest{
    private UniquePaths uniquePaths = new UniquePaths();

    public static void main(String[] args){
        UniquePathsTest test = new UniquePathsTest();
        test.test1();
    }

    private void test1(){
        uniquePaths.findUniquePaths(2,3);
        assertEquals(3,uniquePaths.numberOfUniquePaths);
    }
}
//endregion
