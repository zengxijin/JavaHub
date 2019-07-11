package com.jack.algorithm.linkedlist;

/**
 * @author zengxijin created on 2019-07-11
 */
public class ReverseList {

    public LinkNode getMid(final LinkNode head) {
        if (head == null || head.getNext() == null) return head;

        LinkNode fast = head;
        LinkNode slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;
    }

    public LinkNode reverse(final LinkNode head) {
        if (head == null || head.getNext() == null) return head;

        LinkNode pre = head;
        LinkNode current = head.getNext();
        pre.setNext(null);

        while (current != null) {
            LinkNode next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }

        return pre;
    }

    public LinkNode merge(LinkNode p1, LinkNode p2) {
        LinkNode t1 = p1;
        LinkNode t2 = p2;

        LinkNode tail = t1;

        while ( t1 != null && t2 != null) {
            LinkNode n1 = t1.getNext();
            LinkNode n2 = t2.getNext();
            if (t1 == p1) {
                t1.setNext(t2);
            } else {
                t1.setNext(t2);
                tail.setNext(t1);
            }
            tail = t2;

            t1 = n1;
            t2 = n2;
        }
        tail.setNext(null);

        if (t2 != null) {
            t2.setNext(null);
            tail.setNext(t2);
        }

        return p1;
    }

    public static void main(String[] args) {
        LinkNode head = LinkNode.buildList(1, 2, 3, 4, 5, 6, 7, 8);
        LinkNode.dump(head);

        ReverseList reverseList = new ReverseList();

        LinkNode midPointer = reverseList.getMid(head);
        System.out.println(midPointer.getData());
        LinkNode.dump(midPointer);

        LinkNode reverseHead = reverseList.reverse(midPointer);
        LinkNode.dump(reverseHead);

        LinkNode mergeHead = reverseList.merge(head, reverseHead);
        LinkNode.dump(mergeHead);


    }
}
