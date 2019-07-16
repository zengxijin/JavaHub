package com.jack.leetcode.linkedlist;

/**
 * @author xijin.zeng created on 2019/7/12
 */
public class MergeSortLinkedList {

    public Node mergeSort(Node head) {
        if (head == null || head.getNext() == null) return head;

        Node mid = getMid(head);
        Node midNext = mid.getNext();
        System.out.println(mid.getData());
        mid.setNext(null); // split into two list

        Node left = mergeSort(head);
        Node right = mergeSort(midNext);

        return merge(left, right);
    }

    private Node getMid(final Node head) {
        if (head == null) return head;

        Node fast = head;
        Node slow = head; // get the mid pointer
        while (fast != null && fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

//        System.out.println(slow.getData());
        return slow;
    }

    //Merge subroutine to merge two sorted lists
    public Node merge(Node a, Node b)
    {
        Node dummyHead = new Node(-1);
        Node current = dummyHead;

        while (a != null && b != null) {
            if (a.getData() <= b.getData()) {
                current.setNext(a);
                a = a.getNext();
            } else {
                current.setNext(b);
                b = b.getNext();
            }
            current = current.getNext();
        }

        // last check
        Node x = (a == null) ? b : a;
        current.setNext(x);

        return dummyHead.getNext();
    }

    public static void main(String[] args) {
        final Node head = Node.buildList(2, 1, 3, 5, 4, 6, 19, 10);
        Node.dump(head);

        MergeSortLinkedList sort = new MergeSortLinkedList();
        Node p = sort.mergeSort(head);

        Node.dump(p);
    }

}
