package com.jack.leetcode.linkedlist;

import com.jack.algorithm.linkedlist.LinkNode;
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

    public static Node buildList(final int... args) {
        if (args == null || args.length == 0) return null;

        Node head = new Node(args[0]);
        Node pointer = head;
        for (int i=1; i < args.length; i++) {
            Node node = new Node(args[i]);
            pointer.setNext(node);
            pointer = node;
        }

        return head;
    }

    public static void dump(final Node head) {
        int count = 0;
        Node pointer = head;
        System.out.print("data: ");
        while (pointer != null) {
            count++;
            System.out.print(pointer.getData() + " ");
            pointer = pointer.getNext();
        }

        System.out.println();
        System.out.println("size: " + count);
    }
}
