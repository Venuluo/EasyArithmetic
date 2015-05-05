package me.yangyong;

/**
 * 在循环有序数组中查找指定元素
 * 
 * @author yangyong
 * @since 2015-5-5
 */
public class CycleSearch {

    private static int searchVal(int[] arr, int val) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (val == arr[mid])
                return mid; // found val
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= val && val < arr[mid]) {
                    right = mid - 1; // val is in left side
                } else {
                    left = mid + 1; // val is in right side
                }
            } else {
                if (arr[left] > val && val > arr[mid]) {
                    left = mid + 1; // val is in right side
                } else {
                    right = mid - 1; // val is in left side
                }
            }
        }
        return -1; // cannot find val
    }

    public static void main(String[] args) {
        // 初始化数组
        int[] array = {
            3,
            4,
            5,
            6,
            1,
            2
        };
        System.out.println(searchVal(array, 4));
    }
}
