package ch6;

public class MiGong {

    public static void main(String[] args) {
        //先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][7];
        //1表示墙体
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

//        map[2][2] = 1;
//        map[1][2] = 1;

        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);

        //小球走过的路，并标识
        System.out.println("-------------------");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    //递归回溯给小球找路,i,j从哪个位置开始出发，下右上左的策略走
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {//找到了出口
            return true;
        } else {
            if (map[i][j] == 0) {//当前的点没有走过
                map[i][j] = 2;//假定该点可以走通
                if (setWay(map, i + 1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j + 1)) {//向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明该点是死路
                    map[i][j] = 3;
                    return false;
                }
            } else {//map可能是1，2，3
                return false;
            }
        }
    }
}
