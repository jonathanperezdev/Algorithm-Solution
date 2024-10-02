package org.algorithms.courses.udemy.master_coding_interview.recursion;

public class Factorial {
    private int factorialOf(int number){
        if(number <= 1){
            return 1;
        }

        return number * factorialOf(number - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.factorialOf(3))
        ;
    }
}
