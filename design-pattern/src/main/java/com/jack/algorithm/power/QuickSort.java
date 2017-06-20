package com.jack.algorithm.power;

/**
 * Created by XijinZeng on 2017/6/19.
 */
public class QuickSort {

    public void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sort(int[] array){
        if(array == null || array.length == 1)
            return;

        quickSort(array,0,array.length - 1);
    }

    public void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[(left + right)/2];

        while (i <= j){
            while (array[i] < pivot){
                i++;
            }

            while (array[j] > pivot){
                j--;
            }

            if(i <= j){
                swap(array,i,j);
                i++;
                j--;
            }
        }

        if(left < j){
            quickSort(array,left,j);
        }

        if(i < right){
            quickSort(array,i,right);
        }
    }
}
