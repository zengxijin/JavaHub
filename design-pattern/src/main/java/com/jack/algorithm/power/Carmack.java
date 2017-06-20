package com.jack.algorithm.power;

/**
 * Created by XijinZeng on 2017/6/18.
 */
public class Carmack {

    //Carmack算法
    //1999年12月，美国id Software公司发布了名为“雷神之锤III”的电子游戏。它是第一个支持软件加速的游戏，取得了极大成功。
    //他于2005年公布了雷神之锤III的源代码。至此人们得以通过研究这款游戏引擎的源文件来查看它成功的秘密。
    //它的效率比上述牛顿法程序要快几十倍。也比c++标准库的sqrt()函数要快好几倍。
    //算法原理分析 http://blog.csdn.net/yutianzuijin/article/details/40268445
    //由这个公式我们就很清楚地明白代码y  =y*(threehalfs-(x2*y*y));  的含义，这其实就是执行了单次牛顿迭代。
    //为啥只执行了单次迭代就完事了呢？因为单次迭代的精度已经达到相当高的程度，代码也特别注明无需第二次迭代（达到游戏要求的精度）。
    //最根本的原因就是选择的初值非常接近精确解。而估计初始解的关键就是下面这句代码：i  = 0x5f3759df - ( i >> 1 );
    // 首先将float类型的数直接进行地址转换转成int型（代码中long在32位机器上等价于int），
    // 然后对int型的值进行一个神奇的操作，最后再进行地址转换转成float类型就是很精确的初始解。

//    float Q_rsqrt( float number ) {
//        long i; float x2, y; const float threehalfs = 1.5F;
//        x2 = number * 0.5F;
//        y = number;
//        i = * ( long * ) &y; // evil floating point bit level hacking
//        i = 0x5f3759df - ( i >> 1 ); // what the fuck?
//        y = * ( float * ) &i;
//        y = y * ( threehalfs - ( x2 * y * y ) ); // 1st iteration
//        // y = y * ( threehalfs - ( x2 * y * y ) ); // 2nd iteration, this can be removed
//    #ifndef Q3_VM #
//        ifdef __linux__ assert( !isnan(y) ); // bk010122 - FPE?
//    #endif
//    #endif return y;
//    }


}
