package org.algorithms.courses.udemy.master_coding_interview.sorting;

import java.util.stream.Stream;

public class BubbleSort {
    private Integer[] numbers;

    public BubbleSort(Integer[] numbers){
        this.numbers = numbers;
    }

    public Integer[] bubbleSort(){
        for (int i = 0; i < numbers.length; i ++){
            for (int j = 0; j < numbers.length -1 - i; j++){
                if(numbers[j]> numbers[j+1]){
                    swap(j,j+1);
                }
            }
        }

        return numbers;
    }

    private void swap(int pos1, int pos2){
        int aux = numbers[pos1];
        numbers[pos1] = numbers[pos2];
        numbers[pos2] = aux;
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort(new Integer[]{6,5,3,1,8,7,2,4});
        Stream.of(bubbleSort.bubbleSort()).forEach(System.out::print);
    }
}
