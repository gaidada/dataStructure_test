package ch14.c2_divide;

/**
 * @author gai
 * @create 2021--03--24
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(10, 'A', 'B', 'C');
    }

    //使用分治算法，汉诺塔的移动方法
    public static void hanoiTower(int num, char a, char b, char c) {
        //只有一个盘
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            hanoiTower(num - 1, b, a, c);
        }
    }
}
