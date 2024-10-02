package org.algorithms.courses.udemy.master_coding_interview;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedArrays {
    private Queue mergedSortedArrays(Integer[] array1, Integer[] array2){
        Queue<Integer> sortedMerged = Stream.of(array1).collect(Collectors.toCollection(PriorityQueue::new));
        for(Integer element : array2){
            sortedMerged.offer(element);
        }

        return sortedMerged;
    }

    public static void main(String[] args) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        Queue merged = mergeSortedArrays.mergedSortedArrays(new Integer[]{0,3,4,31}, new Integer[]{4,6,30});
        while(CollectionUtils.isNotEmpty(merged)){
            System.out.print(merged.poll()+", ");
        }
    }
}
