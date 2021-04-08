package ch7;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--02--18
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void shellSort(int[] arr) {
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //第一轮，将10个数据分成5组
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有元素（共gap组，每组有2个元素），步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素，说明要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println((++count) + "轮后" + Arrays.toString(arr));
        }


//        //第2轮，将10个数据分成5/2=2组
//        for (int i = 2; i < arr.length; i++) {
//            for (int j = i - 2; j >= 0; j -= 2) {
//                //如果当前元素大于加上步长后的那个元素，说明要交换
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//        System.out.println("2轮后" + Arrays.toString(arr));
//
//        //第3轮，将10个数据分成2/2=1组
//        for (int i = 1; i < arr.length; i++) {
//            //遍历各组中所有元素（共5组，每组有2个元素），步长5
//            for (int j = i - 1; j >= 0; j -= 1) {
//                //如果当前元素大于加上步长后的那个元素，说明要交换
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//        System.out.println("3轮后" + Arrays.toString(arr));
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出while后，就给temp找到了插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
