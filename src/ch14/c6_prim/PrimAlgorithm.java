package ch14.c6_prim;

import java.util.Arrays;

/**
 * @author gai
 * @create 2021--03--26
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        int[][] weight = new int[][]{
                {100, 5, 7, 100, 100, 100, 2},
                {5, 100, 100, 9, 100, 100, 3},
                {7, 100, 100, 100, 8, 100, 100},
                {100, 9, 100, 100, 100, 4, 100},
                {100, 100, 8, 100, 100, 5, 4},
                {100, 100, 100, 4, 5, 100, 6},
                {2, 3, 100, 100, 4, 6, 100}
        };
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);

        minTree.prim(graph, 0);
    }
}

//创建最小生成树
class MinTree {
    //创建图的邻接矩阵
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        for (int i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (int j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的方法
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    public void prim(MGraph graph, int v) {
        //标记节点是否被访问过
        int[] visited = new int[graph.verxs];
        //默认为0，表示没访问过
        for (int i = 0; i < graph.verxs; i++) {
            visited[i] = 0;
        }
        //把当前节点标记为已访问
        visited[v] = 1;
        //h1和h2记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 100;
        for (int k = 1; k < graph.verxs; k++) {

            for (int i = 0; i < graph.verxs; i++) {//i节点表示被访问过的节点
                for (int j = 0; j < graph.verxs; j++) {//j表示还没有访问过的节点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值：" + minWeight);
            //将找到的节点标记为已访问
            visited[h2] = 1;

            minWeight = 100;
        }
    }
}

class MGraph {
    int verxs;//表示图的节点个数
    char[] data;//存放节点数据
    int[][] weight;//存放边

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
