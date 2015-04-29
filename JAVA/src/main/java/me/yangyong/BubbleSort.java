package me.yangyong;

import java.util.Arrays;

/**
 * Bubble sort implementation 冒泡排序
 * 
 * @author yangyong
 * @since 2015-4-29
 */
public class BubbleSort {

    /**
     * 每一轮循环前 子数组A[0-i]都是已排序的 并且是最小的
     * 
     * @param args
     */
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

        // 循环数组 从第2个元素开始
        for (int i = 0; i < array.length; i++) {
            for (int k = i + 1; k < array.length; k++) {
                if (array[k] < array[i]) {
                    int temp = array[k];
                    array[k] = array[i];
                    array[i] = temp;
                }
            }
            // 每个数组元素和之前已经排序好的元素进行从尾至首的比较 大则后退原有元素，小则插入
        }

        // 输出数组
        System.out.println(Arrays.toString(array));
    }
}
