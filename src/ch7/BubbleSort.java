package ch7;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--02--18
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 20};
        //int arr[] = {1, 2, 3, 4, 5, 6};
        int temp = 0;//临时变量
        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            //第一趟排序，将最大的数排在最后
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("第" + (i + 1) + "趟排序后的数组");
            System.out.println(Arrays.toString(arr));
            if (!flag) {//在一趟排序中，没有发生过交换
                break;
            } else {
                flag = false;//重置flag，进行下次判断
            }
        }
    }

//        //第二趟排序，将第二大的数排在倒二
//        for (int j = 0; j < arr.length - 1 - 1; j++) {
//            //如果前面的数比二后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第二趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//        //第3趟排序，将第3大的数排在倒3
//        for (int j = 0; j < arr.length - 1 - 2; j++) {
//            //如果前面的数比二后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第3趟排序后的数组");
//        System.out.println(Arrays.toString(arr));
//
//        //第4趟排序，将第二大的数排在倒4
//        for (int j = 0; j < arr.length - 1 - 3; j++) {
//            //如果前面的数比二后面的数大，则交换
//            if (arr[j] > arr[j + 1]) {
//                temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//        System.out.println("第4趟排序后的数组");
//        System.out.println(Arrays.toString(arr));

}
