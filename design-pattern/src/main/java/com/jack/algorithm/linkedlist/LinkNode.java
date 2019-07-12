package com.jack.algorithm.linkedlist;

/**
 * @author zengxijin created on 2019-07-11
 */
public class LinkNode {
    private int data;
    private LinkNode next;

    public LinkNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public static LinkNode buildList(final int... args) {
        if (args == null || args.length == 0) return null;

        LinkNode head = new LinkNode(args[0]);
        LinkNode pointer = head;
        for (int i=1; i < args.length; i++) {
            LinkNode node = new LinkNode(args[i]);
            pointer.setNext(node);
            pointer = node;
        }

        return head;
    }

    public static void dump(final LinkNode head) {
        int count = 0;
        LinkNode pointer = head;
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
