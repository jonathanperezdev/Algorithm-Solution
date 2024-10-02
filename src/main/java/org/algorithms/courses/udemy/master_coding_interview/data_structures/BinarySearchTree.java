package org.algorithms.courses.udemy.master_coding_interview.data_structures;

import org.algorithms.courses.udemy.master_coding_interview.data_structures.utils.TreeNode;

import java.util.Objects;
import java.util.Optional;

/*
 * Data Structure and Algorithms
 *
 * Section 10: Data Structures: Trees
 *  134. Exercise: Binary Search Tree
 * */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(int value){
        this.root = new TreeNode(value);
    }

    public boolean insert(int value){
        addNode(root,value);
        return true;
    }

    private Optional<TreeNode> addNode(TreeNode node, int value){
        TreeNode nodeToAdd;
        //Base Case
        if(Objects.isNull(node)){
            return Optional.of(new TreeNode(value));
        }

        //Recursive case reducing problem
        if(value < node.getValue()){
            addNode(node.getLeft(), value).ifPresent(node::setLeft);
        }else{
            addNode(node.getRight(), value).ifPresent(node::setRight);
        }

        return Optional.empty();
    }

    public Optional<TreeNode> lookup(int value){
        return findNode(this.root, value);
    }

    private Optional<TreeNode> findNode(TreeNode node , int value){
        //Base case, we reach the end of the tree and not found
        if(Objects.isNull(node)){
            return Optional.empty();
        }

        //Base case, we found the value
        if(node.getValue() == value){
            return Optional.of(node);
        }

        //Recursive case
        if(value < node.getValue()){
            return findNode(node.getLeft(), value);
        }else{
            return findNode(node.getRight(), value);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);

        tree.lookup(200).ifPresent(node -> System.out.println(node.getValue()));

    }
}
