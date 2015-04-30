package me.yangyong;

import java.util.Arrays;

/**
 * Insert sort implementation 原地排序 只有常数个元素存储在数组织外 时间复杂度O(n^2) 稳定
 * <p>
 * 和打牌时整理手中牌一个道理，无论什么时候，左手中的牌都是排好序的，而这些牌原先都是桌上那副牌里最顶上的一些牌
 * <p>
 * 循环不变性<br>
 * 插入排序 冒泡排序 选择排序 快速排序 堆排序 归并排序 基数排序 希尔排序
 * 
 * @author yangyong
 * @since 2015-4-29
 */
public class InsertSort {

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
        for (int i = 1; i < array.length; i++) {
            int key = array[i];

            // 每个数组元素和之前已经排序好的元素进行从尾至首的比较 大则后退原有元素，小则插入
            int k;
            for (k = i - 1; k >= 0 && array[k] > key; k--) {
                array[k + 1] = array[k];
            }
            array[k + 1] = key;
        }

        // 输出数组
        System.out.println(Arrays.toString(array));

        /**
         * 循环不变式用来验证算法正确性
         * <p>
         * 对于循环不变式，必须证明它的三个性质
         * <li>初始化：它在循环的第一轮迭代开始之前，应该是正确的</li>
         * <li>保持：如果在循环的某一次迭代开始之前它是正确的，那么，在下一次迭代开始之前，它也应该保持正确</li>
         * <li>终止：当循环结束时，不变式给了我们一个有用的性质，它有助于表明算法是正确的。当i=array.length-1时，循环结束</li>
         */
    }
}
