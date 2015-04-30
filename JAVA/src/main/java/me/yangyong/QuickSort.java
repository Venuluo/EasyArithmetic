package me.yangyong;

import java.util.Arrays;

/**
 * Quick sort implementation O(nlogn) 稳定排序算法
 * 
 * @author yangyong
 * @since 2015-4-30
 */
public class QuickSort {

    /**
     * 快速排序 递归
     * 
     * @param arr
     * @param low
     * @param high
     */
    private static void sort(int arr[], int low, int high) {
        int index = quick(arr, low, high);
        // System.out.println(arr);
        // System.out.println("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + key + "\n");
        if (index - 1 > low)
            sort(arr, low, index - 1);
        if (index + 1 < high)
            sort(arr, index + 1, high);
    }

    /**
     * 分割数组 返回中间关键元素的下标
     * 
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int quick(int arr[], int low, int high) {
        // 起始位置
        int l = low;
        // 结束位置
        int h = high;
        // 关键数据为第一个数组元素
        int key = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= key)
                h--;
            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                l++;
            }

            while (l < h && arr[l] <= key)
                l++;

            if (l < h) {
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                h--;
            }
        }

        // l和h相等
        return l;
    }

    public static void main(String[] args) {
        // 初始化数组
        int[] array = {
            5,
            2,
            4,
            6,
            1,
            3
        };

        sort(array, 0, 5);

        // 输出数组
        System.out.println(Arrays.toString(array));
    }
}
