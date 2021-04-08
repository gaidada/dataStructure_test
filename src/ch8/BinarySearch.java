package ch8;

import java.util.ArrayList;

/**
 * @author gai
 * @create 2021--02--22
 */
//二分查找的前提是该数组是有序的
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1000, 1234};
        ArrayList<Integer> list = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("位置是" + list);
    }

    public static ArrayList<Integer> binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (left > right) {
            return new ArrayList<>();
        }
        if (findVal > midVal) {//向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {//退出
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;//temp左移
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {//退出
                    break;
                }
                resIndexList.add(temp);
                temp += 1;//temp右移
            }
            return resIndexList;
        }
    }
}
