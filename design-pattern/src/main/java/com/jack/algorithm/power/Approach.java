package com.jack.algorithm.power;

/**
 * Created by XijinZeng on 2017/6/16.
 */
public class Approach {

    //二分法求近似解，任意次根
    public static double xsquare(double value,int n){
        double left = 0;
        double right = value;

        while (true){
            double mid = (left + right) / 2;
            double testValue = Math.pow(mid,n);
            if(Math.abs(value - testValue) < 1e-6){
                return mid;
            }

            if(testValue > value){
                right = mid;
            }else {
                left = mid;
            }
        }
    }
}
