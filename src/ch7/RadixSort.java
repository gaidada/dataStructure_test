package ch7;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--02--19
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        sortRadix(arr);
    }

    //基数排序方法
    public static void sortRadix(int[] arr) {

        //得到数组中最大的数
        int max = arr[0];//假设第一个数是最大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //最大数是几位数
        int maxLength = (max + "").length();

        //定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中实际存放多少个数据，定义一个一维数组记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //第一轮（针对每个元素的个位进行排序）
            for (int j = 0; j < arr.length; j++) {
                //取出元素的个位
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照桶的顺序，依次取出数据放入原来数组
            int index = 0;
            //遍历每一个桶，并将桶中的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据放到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶放入数据
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //第一轮处理后需要将每个bucketElementCounts[k]=0
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮" + Arrays.toString(arr));
        }


//        //第2轮（针对每个元素的十位进行排序）
//        for (int j = 0; j < arr.length; j++) {
//            //取出元素的十位
//            int digitOfElement = arr[j] / 10 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序，依次取出数据放入原来数组
//        index = 0;
//        //遍历每一个桶，并将桶中的数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据放到原数组
//            if (bucketElementCounts[k] != 0) {
//                //循环该桶放入数据
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第2轮" + Arrays.toString(arr));
//
//        //第3轮（针对每个元素的百位进行排序）
//        for (int j = 0; j < arr.length; j++) {
//            //取出元素的百位
//            int digitOfElement = arr[j] / 100 % 10;
//            //放入到对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
//            bucketElementCounts[digitOfElement]++;
//        }
//        //按照桶的顺序，依次取出数据放入原来数组
//        index = 0;
//        //遍历每一个桶，并将桶中的数据放入到原数组
//        for (int k = 0; k < bucketElementCounts.length; k++) {
//            //如果桶中有数据放到原数组
//            if (bucketElementCounts[k] != 0) {
//                //循环该桶放入数据
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    //取出元素放入到arr
//                    arr[index++] = bucket[k][l];
//                }
//            }
//            bucketElementCounts[k] = 0;
//        }
//        System.out.println("第3轮" + Arrays.toString(arr));
    }
}
