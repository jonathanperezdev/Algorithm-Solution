package org.algorithms.books.commond_sense_guide.node_based_data_structures;

/*
 * Book: A common sense guide to Data Structures and Algorithms
 * Chapter 14: Node-Based Data Structures
 * Excessive 4
 * Add a method to the classic LinkedList class that reverses the list. That is, if the original list is A -> B -> C, all of the list’s links should change so that C -> B -> A.
 *
 * Solution:
 * 1. Is a Recursive top-down algorithms
 * 2. Recursive Case: Find the reserve of next element
 * 3. Base Case: If node getNext is null, means is the last element and should be converted into first
 * */
//region Test
class ReverseLinkedListTest{

    public static void main(String[] args){
        ReverseLinkedListTest test = new ReverseLinkedListTest();
        test.test1();
    }

    private void test1(){
        LinkedListPersonal linkedListPersonal = LinkedListPersonal.createLinkedList(new Integer[]{5,4,3,2,1});
        linkedListPersonal.reverse();
        linkedListPersonal.printLinkedList();
    }
}
//endregion
