package com.jack.leetcode.linkedlist;

import lombok.Data;

/**
 * @author xijin.zeng created on 2019/7/11
 */
@Data
public class Node {
    private int data;

    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
