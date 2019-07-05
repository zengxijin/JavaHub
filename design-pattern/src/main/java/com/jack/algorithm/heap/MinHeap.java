package com.jack.algorithm.heap;

import java.util.Vector;

/**
 * @author xijin.zeng created on 2019/7/5
 */
public class MinHeap {

    private Vector<Integer> heapData;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        heapData = new Vector<>(capacity);
    }

    public MinHeap() {
        heapData = new Vector<>();
    }

    public void swap(int from, int to) {
        int tmp = heapData.get(from);
        heapData.setElementAt(heapData.get(to), from);
        heapData.setElementAt(tmp, to);
    }

    public int parent(int index) {
        if (index == 0) return 0;

        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return (index * 2 + 1);
    }

    public int rightChild(int index) {
        return (index * 2 + 2);
    }

    public int size() {
        return heapData.size();
    }

    public boolean isLeaf(int index) {
        return (index < size() && index >= (size() / 2));
    }

    public void heapifyDown(int index) {
        if (isLeaf(index)) return;

        int left = leftChild(index);
        int right = rightChild(index);
        int minIndex = index;

        if (left < size() && heapData.get(index) > heapData.get(left)) {
            minIndex = left;
        }

        if (right < size() && heapData.get(minIndex) > heapData.get(right)) {
            minIndex = right;
        }

        if (minIndex != index) {
            swap(index, minIndex);

            heapifyDown(minIndex);
        }
    }

    public void heapifyUp(int index) {
        if (index == 0) return;

        if (index < size() && heapData.get(index) < heapData.get(parent(index))) {
            swap(index, parent(index));

            heapifyUp(parent(index));
        }
    }

    public boolean isFull() {
        return ((size() + 1) % 2 == 0);
    }

    public void insert(int data) {
        heapData.add(data);
        int index = size() - 1;

        heapifyUp(index);
    }

    public int poll() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("heap is empty");
        }

        int min = heapData.firstElement();
        heapData.setElementAt(heapData.lastElement(), 0);
        heapData.remove(size() - 1);

        heapifyDown(0);

        return min;
    }

    public int peek() {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("heap is empty");
        }

        return heapData.firstElement();
    }

    public void printLeafs() {
        System.out.println("leaf nodes:");
        for (int i=0; i < size(); i++) {
            if (isLeaf(i)) {
                System.out.print(heapData.get(i) + " ");
            }
        }
        System.out.println("");
    }

    public void dump() {
        for (int i=0; i < (size() / 2); i++) {
            String info = "node:" + heapData.get(i);
            if (leftChild(i) < size()) {
                info += " left-child:" + heapData.get(leftChild(i));
            }

            if (rightChild(i) < size()) {
                info += " right-child:" + heapData.get(rightChild(i));
            }
            System.out.println(info);
        }

        printLeafs();
        System.out.println("full tree:" + isFull());
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(16);
        minHeap.insert(12);
        minHeap.insert(2);
        minHeap.insert(17);
        minHeap.insert(3);
        minHeap.insert(9);
        minHeap.insert(28);
        minHeap.insert(18);
        minHeap.insert(39);

        minHeap.dump();

        System.out.println("poll min:" + minHeap.poll());
        minHeap.dump();
    }
}
