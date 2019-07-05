package com.jack.algorithm.heap;

/**
 * @author xijin.zeng created on 2019/7/5
 */
public class TopK {

    public static void main(String[] args) {
        int K = 5;
        int[] data = {2, 3, 7, 10, 1, 6, 4, 18, 12};

        MinHeap minHeap = new MinHeap(K);

        for (int i = 0; i < K; i++) {
            minHeap.insert(data[i]);
        }

        for (int i = K; i < data.length; i++) {
            if (data[i] > minHeap.peek()) {
                minHeap.setRoot(data[i]);
            }
        }

        while (minHeap.size() > 0) {
            System.out.print(minHeap.poll() + " ");
        }

    }
}
