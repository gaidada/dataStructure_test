package ch8;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--02--22
 */
//插值查找算法也要求数组是有序的
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(insetValueSearch(arr, 0, arr.length - 1, 100));
    }

    public static int insetValueSearch(int[] arr, int left, int right, int findVal) {
        System.out.println("查找次数");
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        //求出mid
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal = arr[mid];
        if (findVal > midVal) {//向右边递归查找
            return insetValueSearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return insetValueSearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }
}
