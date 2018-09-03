package org.jackzeng;

/**
 * @author xijin.zeng created on 2018/9/3
 * 在一个数组中找出重复1次的数：
 * 方法1：使用sum(x)-sum(unique(x))
 * 方法2：
 * 将原来的数组全部异或，得到结果：（根据交换律，会去掉相同的数）
 * A^B^C^B=A^C
 * 将原来不重复的数全部异或：
 * A^B^C
 * 再跟之前异或的结果再次异或：(A^B^C)^(A^C)=B, 就得到那个有重复数的结果
 * 但是那个得到原来不重复的数据的异或过程其实已经可以用来做是否重复的计算了
 */
public class FindWithXOR {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 3}; // original array
        int originXOR = 0;
        for (int i = 0; i < array.length; i++) {
            originXOR ^= array[i];
        }

        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // unique array
        int uniqueXOR = 0;
        for (int i = 0; i < array2.length; i++) {
            uniqueXOR ^= array2[i];
        }


        System.out.println("重复的数是:" + (originXOR ^ uniqueXOR));

    }
}
