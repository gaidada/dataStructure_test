package ch7;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gai
 * @create 2021--02--18
 */
public class SelectSort {
    public static void main(String[] args) {
        //int[] arr = {101, 34, 119, 1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1 = simpleDateFormat.format(start);
        System.out.println(date1);

        selectSort(arr);
        Date end = new Date();
        String date2 = simpleDateFormat.format(end);
        System.out.println(date2);
        //System.out.println(Arrays.toString(arr));
    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //第一轮排序
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {//说明假定的最小值不是最小的
                    min = arr[j];
                    minIndex = j;
                }
            }
            //将最小值和arr[0]交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            //System.out.println("第" + (i + 1) + "轮后");
            //System.out.println(Arrays.toString(arr));
        }
//        //第2轮排序
//        minIndex = 1;
//        min = arr[1];
//        for (int j = 1 + 1; j < arr.length; j++) {
//            if (min > arr[j]) {//说明假定的最小值不是最小的
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        //将最小值和arr[0]交换
//        if (minIndex != 1) {
//            arr[minIndex] = arr[1];
//            arr[1] = min;
//        }
//        System.out.println("第2轮后");
//        System.out.println(Arrays.toString(arr));
//        //第2轮排序
//        minIndex = 2;
//        min = arr[2];
//        for (int j = 2 + 1; j < arr.length; j++) {
//            if (min > arr[j]) {//说明假定的最小值不是最小的
//                min = arr[j];
//                minIndex = j;
//            }
//        }
//        //将最小值和arr[0]交换
//        if (minIndex != 2) {
//            arr[minIndex] = arr[2];
//            arr[2] = min;
//        }
//        System.out.println("第3轮后");
//        System.out.println(Arrays.toString(arr));
    }
}
