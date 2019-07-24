package com.jack.algorithm.matrix;

/**
 * @author xijin.zeng created on 2019/7/22
 * 下面介绍一个公式，那就是著名的钩子公式。
 *
 * 对于给定形状，不同的杨氏矩阵的个数为：n！除以每个格子的钩子长度加1的积。其中钩子长度定义为该格子
 * 右边的格子数和它上边的格子数之和
 *
 * 钩子公式：res=n!  /  (hock[1]*hock[2]*.....hock[n]);
 * hock[i]=在其上方和右方的所有个数 + 1
 * (防止分子或分母的越界情况，要进行单一元素的约分化简)
 *
 * 杨辉三角递推公式：f[n]=f[n-1]+(n-1)*f[n-2]
 */
public class MatrixFilling {
}
