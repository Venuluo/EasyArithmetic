package me.yangyong;

import java.util.Arrays;

/**
 * Merge sort implementation 时间复杂度O(nlgn) 合并排序 归并排序 稳定排序
 * <p>
 * 有很多算法在结构上是递归的：为了解决一个给定的问题，算法要一次或多次地递归调用其自身来解决相关的子问题。<br>
 * 这些算法通常采用分治策略：将原问题划分成n个规模较小而结构与原问题相似的子问题；<br>
 * 递归地解决这些子问题，然后再合并其结果，就得到原问题的解。 <br>
 * 分治模式在每一层递归上都有三个步骤：
 * <li>分解（Divide）：将原问题分解成一系列子问题；</li>
 * <li>解决（Conquer）：递归地解各子问题。若子问题足够小，则直接求解；</li>
 * <li>合并（Combine）：将子问题的结果合并成原问题的解。</li>
 * <p>
 * 合并排序（merge sort）算法完全依照了上述模式，直观地操作如下：
 * <li>分解：将n个元素分成各含n/2个元素的子序列；</li>
 * <li>解决：用合并排序法对两个子序列递归地排序；</li>
 * <li>合并：合并两个已排序的子序列以得到排序结果。 在对子序列排序时，其长度为1时递归结束。单个元素被视为是已排好序的。</li>
 * 
 * @author yangyong
 * @since 2015-4-29
 */
public class MergeSort {

    /**
     * MERGE SORT 假定原问题的规模是2的幂次，这样每一次分解所产生的子序列的长度就恰好为n/2。合并排序一个元素的时间是个常量。当n>1时，将运行时间如下分解： 分解：这一步仅仅是计算出子数组的中间位置，需要常量时间，因而D（n）=Θ(1)。 解决：递归地解两个规模为n/2的子问题，时间为2T（n/2）。
     * 合并：我们已经注意到，在一个含有n个元素的子数组上，MERGE过程的运行时间为Θ(n)，则C（n）=Θ(n)。
     * <p>
     * 原地分割数组 假设分割子数组都是已排序的 <br>
     * 合并操作
     */

    private static void merge(int[] arr, int p, int q, int r) {
        // System.out.println("in" + Arrays.toString(arr));
        // System.out.println("in入参" + " p:" + p + " q:" + q + " r:" + r);
        int n1 = q - p + 1;// 左数组长度
        int n2 = r - q;// 右数组长度

        int[] left = new int[n1 + 1];// 左数组
        int[] right = new int[n2 + 1];// 右数组

        // 初始化左数组
        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }

        // 初始化右数组
        for (int i = 0; i < n2; i++) {
            right[i] = arr[q + i + 1];
        }

        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        // System.out.println(Arrays.toString(left) + Arrays.toString(right));

        for (int i = 0, j = 0, k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
        // System.out.println("out" + Arrays.toString(arr));
    }

    /**
     * 合并排序算法
     * 
     * @param arr
     * @param p
     * @param r
     */
    public static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private static void merge1(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }

        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    public static void mergeSort1(int[] a, int s, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        // -------归并到只剩一个有序集合的时候结束算法-------//
        if (mid == 0)
            return;
        // ------进行一趟归并排序-------//
        for (int i = 0; i < mid; ++i) {
            s = i * 2 * len;
            merge1(a, s, s + len, (len << 1) + s - 1);
        }
        // -------将剩下的数和倒数一个有序集合归并-------//
        if (c != 0)
            merge1(a, size - c - 2 * len, size - c, size - 1);
        // -------递归执行下一趟归并排序------//
        mergeSort1(a, 0, 2 * len);
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

        mergeSort(array, 0, 5);

        // 输出数组
        System.out.println(Arrays.toString(array));
    }
}
