package org.algorithms.courses.udemy.master_coding_interview.data_structures.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private final int value;
}
