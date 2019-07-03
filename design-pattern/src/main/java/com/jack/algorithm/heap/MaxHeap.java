package com.jack.algorithm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xijin.zeng created on 2019/7/3
 * 最大堆的规则：
 * 假如当前的节点index位置为k，那么左子节点index为2k+1，右子节点index为2k+2
 * 一般用动态大小的数组ArrayList来存储堆结构的数据，并且堆的调整与类似于插入排序
 */
public class MaxHeap {

    /**
     * dynamic buffer for heap
     */
    private List<Integer> heapData = new ArrayList<>();

    public int getLeftNodeIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    public int getRightNodeIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
}
