package com.jack.leetcode.linkedlist;

/**
 * @author xijin.zeng created on 2019/7/11
 */
public class LinkedListUtils {

    public static Node buildList(int... datas) {
        if (datas == null || datas.length == 0) return null;

        Node head = new Node(datas[0]);

        Node pre = head;
        for (int i=1; i < datas.length; i++) {
            Node node = new Node(datas[i]);
            pre.setNext(node);
            pre = node;
        }

        return head;
    }

    public static void print(Node nodeHead) {
        Node head = nodeHead;
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }

    public static void main(String[] args) {
        Node head = buildList(1, 2, 3, 4, 5, 6, 7, 8);

        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
    }
}
