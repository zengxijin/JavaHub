package com.jack.alg;

import com.jack.algorithm.power.QuickSort;
import org.junit.Test;

/**
 * Created by XijinZeng on 2017/6/19.
 */
public class QuickSortTest {
    @Test
    public void quickSortTestCase() throws Exception {
        QuickSort qs = new QuickSort();
        int[] array = {3,1,6,23,11,21,89,10,2};

        qs.sort(array);

        for(int i : array){
            System.out.println(i);
        }
    }
}
