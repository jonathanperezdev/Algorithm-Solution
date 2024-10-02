package org.algorithms.courses.udemy.master_coding_interview.sorting;

import java.util.stream.Stream;

public class InsertionSort {
    private Integer[] numbers;

    public InsertionSort(Integer[] numbers){
        this.numbers = numbers;
    }

    public Integer[] insertionSort(){
        for(int i = 0; i < numbers.length-1; i++){
            if(numbers[i] > numbers[i+1]){
                performSwaps(i+1);
            }
        }

        return numbers;
    }

    private void performSwaps(int position){
        for (int i = position; i > 0; i --){
            if(numbers[i] < numbers[i-1]){
                swap(i, i-1);
            }
        }
    }

    private void swap(int pos1, int pos2){
        int aux = numbers[pos1];
        numbers[pos1] = numbers[pos2];
        numbers[pos2] = aux;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort(new Integer[]{6,5,3,1,8,7,2,4});
        Stream.of(insertionSort.insertionSort()).forEach(System.out::print);
    }

}
