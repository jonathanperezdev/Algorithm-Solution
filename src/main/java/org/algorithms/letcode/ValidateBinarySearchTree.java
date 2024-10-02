package org.algorithms.letcode;

import org.algorithms.letcode.utils.TreeNode;

import java.util.Objects;

/**
 * 98. Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST). *
 * A valid BST is defined as follows:
 *
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 * */
public class ValidateBinarySearchTree {
    private enum Side {
        LEFT, RIGHT
    }

    private boolean isValidBTS = true;

    public boolean isValidBST(TreeNode root) {
        validateBTS(root, null, 0);
        return isValidBTS;
    }

    private void validateBTS(TreeNode node,  Side side, int rootVal){
        if(!isValidBTS)
            return;

        if(Objects.nonNull(node.left) && Objects.nonNull(node.right)){
            validateBTS(node.left, Side.LEFT, node.val);
            validateBTS(node.right, Side.RIGHT, node.val);
        }

        if((Objects.nonNull(node.left) && Objects.isNull(node.right)) || Objects.nonNull(node.right) && Objects.isNull(node.left)){
            isValidBTS = false;
            return;

        }

        if(Objects.isNull(side)){
            return;
        }

        isValidBTS = (Side.LEFT == side)
                ? rootVal > node.val
                : rootVal < node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3, null, null),
                new TreeNode(8,null,null));

        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }
}
