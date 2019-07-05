package com.jack.algorithm.heap;

/**
 * @author xijin.zeng created on 2019/7/3
 * 最大堆的规则：
 * 假如当前的节点index位置为k：（数组下标从0开始存储数据）
 * 那么：
 * （0）父节点的index为(k-1)/2
 * （1）左子节点index为2k+1
 * （2）右子节点index为2k+2
 * 一般用动态大小的数组ArrayList，可以使用数组作为隐式树（因为结构是完全二叉树）来存储堆结构的数据，并且堆的调整与类似于插入排序
 */
public class MaxHeap {

    private int heapSize;
    private int size;
    /**
     * data index start from 1
     */
    private int[] data;

    public MaxHeap(int heapSize) {
        this.size = 0; // initial size
        this.heapSize = heapSize;
        this.data = new int[heapSize + 1];
        data[0] = Integer.MAX_VALUE;
    }

    public int getLeftNodeIndex(int currentIndex) {
        return 2 * currentIndex;
    }

    public int getParentIndex(int currentIndex) {
        // invalid index
//        if (currentIndex <= 1) return 1;

        return (currentIndex) / 2;
    }

    public int getRightNodeIndex(int currentIndex) {
        return 2 * currentIndex + 1;
    }

    public boolean isLeaf(int index) {
        if (index > (size / 2) && index <= size) {
            return true;
        }
        return false;
    }

    public void maxHeapify(int index) {
        if (isLeaf(index)) return;

        if (data[index] < data[getLeftNodeIndex(index)] || data[index] < data[getRightNodeIndex(index)]) {
            if (data[getRightNodeIndex(index)] > data[getLeftNodeIndex(index)]) {
                swap(index, data[getRightNodeIndex(index)]);
                maxHeapify(getParentIndex(index));
            } else {
                swap(index, data[getLeftNodeIndex(index)]);
                maxHeapify(getLeftNodeIndex(index));
            }
        }
    }

    public int getMax() {
        return size >= 1 ? data[1] : Integer.MAX_VALUE;
    }

    public int popMax() {
        int max = getMax();

        data[1] = data[size--];
        this.maxHeapify(1);

        return max;
    }

    public void insert(int e) {
        data[++size] = e;

        int currentIndex = size;
        while (data[currentIndex] > data[getParentIndex(currentIndex)]) {
            swap(currentIndex, getParentIndex(currentIndex));
            currentIndex = getParentIndex(currentIndex);
        }
    }

    public void swap(int srcIndex, int dstIndex) {
        int tmp = data[srcIndex];
        data[srcIndex] = data[dstIndex];
        data[dstIndex] = tmp;
    }

    public void print()
    {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + data[i] + " LEFT CHILD : " +
                    data[2 * i] + " RIGHT CHILD :" + data[2 * i + 1]);
            System.out.println();
        }
    }

    public static void main(String[] arg)
    {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.popMax());
    }
}
