package com.jack.algorithm.power;

/**
 * Created by XijinZeng on 2017/6/18.
 * 相当于方程：f(X) = X^2 - a = 0 (这是1个曲线)
 * f(x) = f(xi) + f’(xi)(x - xi)
 * 我们对方程求导：f`(X) = 2X (相当于用切线来近似模拟曲线)
 * 根据切线：X-[f(X)/f`(X)] = X-f(X)/2X, 带入f(X) = X^2 - a
 * 得到：xi+1=xi - (xi2 - n) / (2xi) = xi - xi / 2 + n / (2xi) = xi / 2 + n / 2xi = (xi + n/xi) / 2
 * 迭代条件：
 * X_0 = a^2 - a
 * X_k+1 = (X_k + a/X_k)/2
 * 收敛条件：|X_i^2 - a| < 指定误差
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
