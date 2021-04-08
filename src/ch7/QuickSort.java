package ch7;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--02--19
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left + right) / 2];//中间值
        int temp = 0;//临时变量，交换时使用
        //while循环的目的，让比pivot小的值放到左边，比pivot大的值放右边
        while (l < r) {
            //在pivot左边一直找，找到大于等于pivot值才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot右边一直找，找到小于等于pivot值才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l>=r说明pivot左右两边的值，已经按照左边都是小，右边都是大的
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //交换完后，发现这个arr[l]==pivot值，r--前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //交换完后，发现这个arr[r]==pivot值，l++后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l==r，必须l++,r--否则栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        //左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        //右递归
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
