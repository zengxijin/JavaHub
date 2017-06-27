package com.jack.algorithm.math;

/**
 * Created by XijinZeng on 2017/6/26.
 */
public class GreatestDivisor {
    public static int calculate(int a,int b){
        int val = 1;
        int max = a >= b ? a : b;
        int min = a < b ? a : b;

        int remainder = max % min;
        if(remainder == 0){
            return min;
        }

        while (remainder != 0){
            val = remainder;
            remainder = min % remainder;
            if(remainder == 0){
                return val;
            }
        }

        return val;
    }
}
