package org.algorithms.courses.udemy.master_coding_interview.recursion;

public class Fibonacci {
    private int fibRecursive(int steps){
        if(steps < 2){
            return steps;
        }

        return fibRecursive(steps-1) + fibRecursive(steps-2);
    }

    private int fibIterate(int steps){
        Integer[] fibArray = new Integer[]{0,1};
        int aux;

        if(steps < 2){
            return steps;
        }

        for(int i = 1; i < steps; i++){
            aux = fibArray[1];
            fibArray[1] = fibArray[0] + fibArray[1];
            fibArray[0] = aux;
        }

        return fibArray[1];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibRecursive(3));

        System.out.println(fibonacci.fibIterate(3));
    }
}
