package com.jack.algorithm.sort;

/**
 * @author xijin.zeng created on 2019/7/5
 */
public class QuickSort {

    private void swap(int[] data, int from, int to) {
        int tmp = data[from];
        data[from] = data[to];
        data[to] = tmp;
    }

    public void quickSort(int[] data, int left, int right) {
        int startIndex = (left + right) >> 1;
        int startData = data[startIndex];

        int i = left;
        int j = right;
        while (i <= j ) {
            while (data[i] < startData) {
                i++;
            }

            while (data[j] > startData) {
                j--;
            }

            if (i <= j) {
                swap(data, i, j);
                i++;
                j--;
            }

            if (left < j) {
                quickSort(data, left, j);
            }

            if (right > i) {
                quickSort(data, i, right);
            }
        }

    }

    public static void main(String[] args) {
        int[] data = {1, 4, 2, 3, 10, 4, 2, 1, 23, 16};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(data, 0, data.length - 1);
        System.out.println(data);
    }
}
