package com.jack.algorithm.linkedlist;

/**
 * @author xijin.zeng created on 2019/7/15
 */
public class FindLastK {

    /**
     * 使用2个指针的形式，先让第1个指针走K步，然后第2个指针开始走，当第1个指针走到底的时候，慢指针的位置即是当前的倒是K个节点的位置
     * @param head
     * @param k
     * @return
     */
    public static LinkNode findLastKNode(final LinkNode head, int k) {
        if (k < 0) throw new IndexOutOfBoundsException("must k >= 0");

        if (head == null || k == 0 || (head.getNext() == null && k == 1)) return head;

        LinkNode fast = head;
        LinkNode slow = head;

        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.getNext();
            } else {
                break;
            }
        }

        if (fast == null) {
            throw new IndexOutOfBoundsException("k=" + k + " is greater than list size");
        }

        while (fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
        }

        return slow;
    }

    public static void main(String[] args) {
        LinkNode node = LinkNode.buildList(1, 2, 3, 4, 5, 6, 7);
        LinkNode.dump(node);

        LinkNode lastK = findLastKNode(node, 8);
        System.out.println(lastK.getData());
    }
}
