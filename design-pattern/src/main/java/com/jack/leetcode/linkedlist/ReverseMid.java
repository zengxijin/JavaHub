package com.jack.leetcode.linkedlist;

import static com.jack.leetcode.linkedlist.LinkedListUtils.buildList;

/**
 * @author xijin.zeng created on 2019/7/11
 */
public class ReverseMid {

    private Node getMid(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    private Node reverseList(Node head) {
        if (head == null || head.getNext() == null) return head;

        Node pre = head;
        Node current = head.getNext();
        head.setNext(null);

        while (current != null) {
            Node next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        Node head = buildList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        LinkedListUtils.print(head);

        ReverseMid reverseMid = new ReverseMid();
        Node mid = reverseMid.getMid(head);
        System.out.println();
        LinkedListUtils.print(mid);

        Node reverseHead = reverseMid.reverseList(mid);

        System.out.println();
        LinkedListUtils.print(reverseHead);

        System.out.println();
        Node n1 = head;
        Node n2 = reverseHead;

        Node newHead = head;
        Node newTail = head.getNext();

        while (n1 != null && n2 != null && n1 != n2) {
            System.out.print(n1.getData() + "-" + n2.getData() + " ");
            Node t1 = n1.getNext();
            Node t2 = n2.getNext();
            if (newHead != n1) {
                newHead.setNext(n1);
            }

            newHead.getNext().setNext(n2);
            newTail = n2;

            n1 = t1;
            n2 = t2;
        }

        // process the mid element
        if (n1 != null || n2 != null) {
            System.out.println(mid.getData());
            newTail.setNext(mid);
            mid.setNext(null);
        }

        System.out.println();
        LinkedListUtils.print(newHead);

    }
}
