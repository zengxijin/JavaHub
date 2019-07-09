package com.jack.algorithm.sort;

/**
 * @author xijin.zeng created on 2019/7/9
 * 现场在数组内部进行排序
 */
public class HeapSortII {

    public void heapSort(int[] data) {
        if (data == null || data.length <= 1) return;

        int size = data.length;

        // 将数组堆化
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(data, size, i);
        }

        // 扫描一遍数组，将堆顶的元素换到数组前面
        for (int i = size - 1; i >= 0; i--) {
            int tmp = data[0]; // 拿出堆顶元素
            data[0] = data[i];
            data[i] = tmp; // 将堆顶元素放在尾部，缩小数组

            // 将缩小的数组从新从堆顶做堆化操作
            heapifyDown(data, i, 0);
        }

    }

    // 构建大顶堆，然后向堆顶放置到数组末尾，将末尾数据放置堆顶，重新大顶堆堆化，得到1个正序排序数组
    // 空间开销为O(1)，时间为O(nlogn)
    public void heapifyDown(int[] data, int size, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        int minIndex = index;

        if (left < size && data[minIndex] < data[left]) {
            minIndex = left;
        }

        if (right < size && data[minIndex] < data[right]) {
            minIndex = right;
        }

        if (minIndex != index) {
            swap(data, index, minIndex);

            heapifyDown(data, size, minIndex);
        }
    }

    private void swap(int[] data, int from, int to) {
        if (from != to) {
            int tmp = data[from];
            data[from] = data[to];
            data[to] = tmp;
        }
    }

    public static void main(String[] args) {
        HeapSortII heapSortII = new HeapSortII();
        int[] data = {2, 3, 1, 89, 23, 45, 12};
        heapSortII.heapSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
