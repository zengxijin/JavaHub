package com.jack.algorithm.power;

/**
 * Created by XijinZeng on 2017/6/18.
 */
public class NewtonIteration {
    public static double getSquareRoot(double value){
        if(value < 0d){
            return Double.NaN;
        }

        double current = value;
        final double EXP_ERROR = 1e-6;

        while (Math.abs(Math.pow(current,2) - value) > EXP_ERROR){
            current = (current + value / current) / 2d;
        }

        return current;
    }
}
