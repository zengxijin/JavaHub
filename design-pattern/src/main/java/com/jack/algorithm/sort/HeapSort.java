package com.jack.algorithm.sort;

import java.util.Vector;

/**
 * @author xijin.zeng created on 2019/7/8
 * 如果是正序（从小到大），则使用最小堆，因为堆顶每次都是最小值
 * 如果是倒序（从大到小），则使用最大堆，因为堆顶每次都是最大值
 */
public class HeapSort {

    /**
     * start from index 0
     */
    private Vector<Integer> data;

    public void sort(int[] input) {
        if (input == null || input.length == 1) {
            return;
        }

        data = new Vector<>();
        for (int i = 0; i < input.length; i++) {
            this.insert(input[i]);
        }

        this.dump();

        while (size() > 0) {
            System.out.print(this.poll() + " ");
        }
    }

    private int size() {
        return data.size();
    }

    private void insert(int e) {
        data.add(e);
        int index = size() - 1;
        heapifyUp(index);
    }

    private void dump() {
        for (int i=0; i < (size() / 2); i++) {
            String info = "node:" + data.get(i);
            if (left(i) < size()) {
                info += " left-child:" + data.get(left(i));
            }

            if (right(i) < size()) {
                info += " right-child:" + data.get(right(i));
            }
            System.out.println(info);
        }

        // printLeafs();
        // System.out.println("full tree:" + isFull());
    }

    private int poll() {
        int min = data.firstElement();
        data.setElementAt(data.lastElement(), 0);
        data.remove(size() - 1);

        heapifyDown(0);

        return min;
    }

    private void heapifyUp(int index) {
        if (index == 0) return;

        if (index < size() && data.get(index) < data.get(parent(index))) {
            swap(index, parent(index));

            heapifyUp(parent(index));
        }
    }

    private boolean isLeaf(int index) {
        return (index < size() && index >= (size() / 2));
    }

    private void heapifyDown(int index) {
        // if (isLeaf(index)) return;

        int l = left(index);
        int r = right(index);

        int minIndex = index;

        if (l < size() && data.get(index) > data.get(l)) {
            minIndex = l;
        }

        if (r < size() && data.get(minIndex) < data.get(r)) {
            minIndex = r;
        }

        if (minIndex != index) {
            swap(index, minIndex);

            heapifyDown(minIndex);
        }
    }

    private void swap(int from, int to) {
        int tmp = data.get(from);
        data.setElementAt(data.get(to), from);
        data.setElementAt(tmp, to);
    }

    private int parent(int index) {
        if (index == 0) return 0;

        return (index - 1) / 2;
    }

    private int left(int index) {
        return (2 * index + 1);
    }

    private int right(int index) {
        return (2 * index + 2);
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 4, 29, 12, 3};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(data);
    }

}
