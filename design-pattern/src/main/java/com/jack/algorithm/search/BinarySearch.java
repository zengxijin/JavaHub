package com.jack.algorithm.search;

/**
 * Created by XijinZeng on 2017/6/23.
 */
public class BinarySearch {
    /**
     * recursive, O(logn)
     * @param src
     * @param data
     * @param left
     * @param right
     * @return
     */
    public static int searchRecursive(int[] src, int data, int left, int right){
        int mid = (left + right) / 2;
        int i = left;
        int j = right;

        if(data == src[mid])
            return mid;

        if(left >= right )
            return -1;

        if(data > src[mid]){
            return searchRecursive(src, data, mid + 1, right);
        }

        if(data < src[mid]){
            return searchRecursive(src, data, left, mid - 1);
        }

        return -1;
    }

    public static int search(int[] src, int data, int left, int right){
        if(src == null ) return -1;

        int i = left;
        int j = right;

        while (i <= j){
            int mid = (i + j) / 2;
            if(data == src[mid]){
                return mid;
            }
            if(data > src[mid]){
                i = mid+1;
            }
            if(data < src[mid]){
                j = mid - 1;
            }
        }

        return -1;
    }
}
