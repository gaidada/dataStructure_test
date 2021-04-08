package ch6;

public class Queue8 {

    //定义一个max表示有多少个皇后
    int max = 8;
    static int count = 0;
    static int judgeCount = 0;
    //定义数组array，保存皇后的位置
    int[] array = new int[max];

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d解法", count);
        System.out.printf("一共有%d冲突", judgeCount);
    }

    //一个方法，放置第n个皇后
    private void check(int n) {
        if (n == max) {//八个皇后已经放好
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前皇后n，放到该行的第1列
            array[n] = i;
            //判断放置第n个皇后到i列时，是否冲突
            if (judge(n)) {//不冲突
                //接着放n+1个皇后，开始递归
                check(n + 1);
            }
            //冲突，继续执行array[n]=i，将第n个皇后，放置到本行的后移的一个位置

        }
    }

    //一个方法，查看当我们放置第n个皇后检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //判断是否在同一列和是否同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    //写一个方法，将皇后的位置输出
    private void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
