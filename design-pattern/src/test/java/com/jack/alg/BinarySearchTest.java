package com.jack.alg;

import com.jack.algorithm.search.BinarySearch;
import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/23.
 */
public class BinarySearchTest {
    @Test
    public void binarySearchTest() throws Exception {
        int[] array = {1,4,6,7,8,9,12,17,19};
        int index = BinarySearch.searchRecursive(array,1,0,array.length-1);
        if(index >= 0){
            System.out.println(array[index]);
        }else {
            System.out.println("can't found!");
        }

        int index2 = BinarySearch.search(array,19,0,array.length-1);
        if(index2 >= 0){
            System.out.println(array[index2]);
        }else {
            System.out.println("can't found!");
        }
    }
}
