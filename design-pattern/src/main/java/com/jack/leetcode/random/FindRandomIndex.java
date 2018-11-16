package com.jack.leetcode.random;

import java.util.Random;

/**
 * @author xijin.zeng created on 2018/11/16
 */
public class FindRandomIndex {
    private Random random;
    private int[] nums;

    public FindRandomIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int ret = -1;
        int targetCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }

            targetCount++;

            /**
             * 这里的实现逻辑：
             * (1)第一次一定成立的，这个时候是[0,1)之间返回肯定是0，所以ret会被赋值为i，也就是第一个匹配的值
             * (2)如果有重复值，从后面每一次开始累加开始相等概率抽取0，比如重复值为3，即targetCount=3
             * (3)需要证明(2,3)时(targetCount=1时，即没有重复值是是100%)，保证每个index抽取的概率为1/targetCount
             *    反过来证明，即2次取数中，都取不到0，那么概率是 p=1/2*(1-1/3)=1/3
             *    可以证明，任意个重复值K，都有
             */
            if (random.nextInt(targetCount) == 0) {
                ret = i;
            }
        }

        return ret;
    }

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3};
        FindRandomIndex findRandomIndex = new FindRandomIndex(nums);
        System.out.println(findRandomIndex.pick(3));
    }
}
