package com.jack.algorithm.heap;

import java.util.Vector;

/**
 * @author xijin.zeng created on 2019/7/5
 * 存储的索引位置从0开始
 * 如果是满的完全二叉树，那么树的节点数就是2^k-1(k是树的层数)，判断满秩很简单，即查看当前的(size+1)%2==0
 * 最大堆实现（适合处理问题比如查找最小的TOP K个数）
 */
public class MaxHeapII {

    private Vector<Integer> heapData;

    private int capacity;

    public MaxHeapII(int capacity) {
        this.capacity = capacity;
        heapData = new Vector<>(this.capacity);
    }

    public MaxHeapII() {
        heapData = new Vector<>();
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public int parent(int index) {
        if (index == 0) return 0;

        return (index - 1) / 2;
    }

    /**
     * 判断是否为叶子节点
     * @param index
     * @return
     */
    public boolean isLeaf(int index) {
        if (index >= (this.heapData.size() / 2) && index < heapData.size()) {
            return true;
        }

        return false;
    }

    public void heapifyDown(int index) {
        if (isLeaf(index)) return;

        int left = leftChild(index);
        int right = rightChild(index);
        int largeIndex = index;

        if (left < heapData.size() && heapData.get(index) < heapData.get(left)) {
            largeIndex = left;
        }

        if (right < heapData.size() && heapData.get(index) < heapData.get(right)) {
            largeIndex = right;
        }

        if (left < heapData.size() && right < heapData.size()) {
            if (heapData.get(left) > heapData.get(right)) {
                largeIndex = left;
            } else {
                largeIndex = right;
            }
        }

        if (largeIndex != index) {
            swap(index, largeIndex);

            heapifyDown(largeIndex);
        }
    }

    public void heapifyUp(int index) {
        if (index == 0) return;

        if (heapData.get(index) > heapData.get(parent(index))) {
            swap(index, parent(index));

            heapifyUp(parent(index));
        }
    }

    private void swap(int from, int to) {
        int tmp = heapData.get(from);
        heapData.setElementAt(heapData.get(to), from);
        heapData.setElementAt(tmp, to);
    }

    public void insert(int e) {
        heapData.add(e);
        int index = heapData.size() - 1;

        this.heapifyUp(index);
    }

    public int poll() {
        if (heapData.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("the heap is empty");
        }

        int data = heapData.firstElement();
        // set the root with last element then remove last element, then heapify down
        heapData.setElementAt(heapData.lastElement(), 0);
        heapData.remove(heapData.size() - 1);
        heapifyDown(0);

        return data;
    }

    public int peek() {
        if (heapData.size() == 0) {
            throw new ArrayIndexOutOfBoundsException("the heap is empty");
        }

        return heapData.firstElement();
    }

    public boolean isFullTree() {
        return (heapData.size()+1) % 2 == 0;
    }

    public void dump() {
        for (int i = 0; i < (heapData.size() / 2); i++) {
            int root = heapData.get(i);
            int leftNode = leftChild(i) < heapData.size() ? heapData.get(leftChild(i)) : -1;
            int rightNode = rightChild(i) < heapData.size() ? heapData.get(rightChild(i)) : -1;
            System.out.println("node:" + root + " left-child:" + leftNode + " right-child:" + rightNode);
        }

        System.out.println("is full tree:" + isFullTree());
    }

    public void printLeafs() {
        for (int i=0; i < heapData.size(); i++) {
            if (isLeaf(i)) {
                System.out.println(heapData.get(i));
            }
        }
    }

    public static void main(String[] args) {
        MaxHeapII maxHeapII = new MaxHeapII(16);
        maxHeapII.insert(12);
        maxHeapII.insert(2);
        maxHeapII.insert(17);
        maxHeapII.insert(3);
        maxHeapII.insert(9);
        maxHeapII.insert(28);
        maxHeapII.insert(18);
        maxHeapII.insert(39);

        maxHeapII.dump();
        maxHeapII.printLeafs();

        System.out.println("poll max:" + maxHeapII.poll());
        maxHeapII.dump();
    }
}
