package org.algorithms.books.commond_sense_guide.recursion;

import lombok.Getter;
import lombok.Setter;

class QuickSort {
    private Integer[] array;

    public Integer[] quickSortOf(Integer[] array){
        this.array = array;
        quickSort(0, array.length-1);
        return array;
    }

    private void quickSort(int leftIndex, int rightIndex){
        if(rightIndex - leftIndex <=0)
            return;

        int pivotIndex = partition(leftIndex, rightIndex);

        quickSort(leftIndex, pivotIndex -1);
        quickSort(pivotIndex +1, rightIndex);
    }

    //We star with one pointer at the beginning of the array (letPointer) and one at the end(rightPointer)
    private int partition(int leftPointer, int rightPointer){
        int pivotIndex;
        pivotIndex = rightPointer;
        while(true){
            //Select as pivot, the right pointer

            int pivot = array[pivotIndex];

            //Right pointer will be moved 1 place to the left
            rightPointer -=1;

            //Finding a value greater or equal to pivot
            while(array[leftPointer] < pivot)
                leftPointer +=1;


            //Finding a value less than pivot
            while(array[rightPointer] >= pivot)
                rightPointer -=1;


            //If left pointer reaches or gone beyond right, it means
            if(leftPointer >= rightPointer) {
                break;
            }else {
                swap(leftPointer, rightPointer);
                leftPointer += 1;
            }
        }

        swap(leftPointer, pivotIndex);

        return leftPointer;
    }

    private void swap(int origin, int target){
        int temp = array[origin];
        array[origin] = array[target];
        array[target] = temp;
    }
}

//region Test
class QuickSortTest{
    private QuickSort quickSort = new QuickSort();

    public static void main(String[] args){
        QuickSortTest test = new QuickSortTest();
        test.test1();
    }

    private void test1(){
        Integer[] array =  quickSort.quickSortOf(new Integer[]{0,5,2,1,6,3});
        for (Integer element : array){
            System.out.print(element+"-");
        }
    }
}
//endregion
