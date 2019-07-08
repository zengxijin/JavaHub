package com.jack.algorithm.sort;

/**
 * @author xijin.zeng created on 2019/7/8
 */
public class MergeSort {

    public void mergeSort(int[] data, int left, int right) {
        if (data == null || data.length == 1 || left >= right) return;

        if (left < right) {
            int middle = (left + right) >> 1;

            mergeSort(data, left, middle);
            mergeSort(data, middle + 1, right);

            merge(data, left, middle, right);
        }
    }

    public void merge(int[] data, int left, int middle, int right) {
        int n1 = middle - left + 1; // include middle element
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = data[left + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = data[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                data[k] = L[i];
                i++;
            } else {
                data[k] = R[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = {2, 1, 2, 3, 10, 30, 12};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(data, 0, data.length - 1);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]  + " ");
        }

    }
}
