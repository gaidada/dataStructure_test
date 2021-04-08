package ch11;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--02--25
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9, -1, 10, -99, 88};
        heapSort(arr);
    }

    public static void heapSort(int arr[]) {
        int temp = 0;
        System.out.println("堆排序");
//        分步完成
//        adjustHeap(arr, 1, arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//        adjustHeap(arr, 0, arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));
        //大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //交换
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    //将一个数组（二叉树）调整成一个大顶堆,i表示非叶子节点在数组中索引，length表示多少个元素继续调整
    public static void adjustHeap(int arr[], int i, int length) {
        int temp = arr[i];//取出当前元素的值，保存在临时变量
        //开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {//左子节点的值小于右子节点的值
                k++;//k指向右子节点
            }
            if (arr[k] > temp) {//子节点大于父节点
                arr[i] = arr[k];//较大的值赋给当前节点
                i = k;//i指向k，继续循环比较
            } else {
                break;
            }
        }
        //for结束后，将以i为父节点的树的最大值放在了最顶
        arr[i] = temp;//将temp放到调整后的位置
    }
}
