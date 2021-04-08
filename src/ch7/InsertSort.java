package ch7;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author gai
 * @create 2021--02--18
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date start = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String date1 = simpleDateFormat.format(start);
        System.out.println(date1);

        insertSort(arr);
        Date end = new Date();
        String date2 = simpleDateFormat.format(end);
        System.out.println(date2);
        //int[] arr = {101, 34, 119, 1, -1, 89};
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {

            //第1轮
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i - 1;//arr[1]前面这个数的下标

            //给insertVal找插入位置时，不越界
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //给insertVal找到插入的位置
                //将arr[insertIndex]后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //退出while时，说明插入的位置找到,insertIndex+1
            arr[insertIndex + 1] = insertVal;
            //System.out.println("第" + i + "轮后");
            //System.out.println(Arrays.toString(arr));
        }

//        //第二轮
//        insertVal = arr[2];
//        insertIndex = 2 - 1;//arr[1]前面这个数的下标
//
//        //给insertVal找插入位置时，不越界
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            //给insertVal找到插入的位置
//            //将arr[insertIndex]后移
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        //退出while时，说明插入的位置找到,insertIndex+1
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第2轮后");
//        System.out.println(Arrays.toString(arr));
//
//        //第3轮
//        insertVal = arr[3];
//        insertIndex = 3 - 1;//arr[1]前面这个数的下标
//
//        //给insertVal找插入位置时，不越界
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            //给insertVal找到插入的位置
//            //将arr[insertIndex]后移
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex--;
//        }
//        //退出while时，说明插入的位置找到,insertIndex+1
//        arr[insertIndex + 1] = insertVal;
//        System.out.println("第3轮后");
//        System.out.println(Arrays.toString(arr));
    }
}
