package com.jack.algorithm.linkedlist;

/**
 * @author xijin.zeng created on 2019/7/16
 * 1->2->3->4->5->6->7
 * 8->9->|
 */
public class SameCommonNode {

    /**
     * 使用2个指针，刚开始一起走
     * 当短列表的指针开始走到尾部时，让短列表的指针指向长列表的开头，继续走
     * 当长列表的指针走到尾部时，让长列表的指针指向短列表的开头，继续走
     * 最后2个指针对相遇到第1个公共节点中，即p1==p2，即可以找到
     * 复杂度(m+n)
     * @param h1
     * @param h2
     * @return
     */
    public static LinkNode findSameNode(LinkNode h1, LinkNode h2) {
        if (h1 == null || h2 == null) return null;

        LinkNode p1 = h1;
        LinkNode p2 = h2;

        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }

            if (p1.getNext() == null) {
                p1 = h2;
            }
            if (p2.getNext() == null) {
                p2 = h1;
            }

            p1 = p1.getNext();
            p2 = p2.getNext();
        }

        return p1;
    }

    public static void main(String[] args) {
        LinkNode h1 = LinkNode.buildList(1, 2, 3, 4, 5, 6, 7);
        LinkNode h2 = LinkNode.buildList(8, 9);
        LinkNode h2Tail = LinkNode.getTail(h2);

        LinkNode sameNode = h1.getNext().getNext(); // node data 3
        System.out.println(sameNode.getData());
        System.out.println(LinkNode.getTail(h2).getData());

        h2Tail.setNext(sameNode);
        LinkNode.dump(h2);

        LinkNode node = findSameNode(h1, h2);
        System.out.println(node.getData()); // should be 3

    }


}
