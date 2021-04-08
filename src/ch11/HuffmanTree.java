package ch11;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author gai
 * @create 2021--02--26
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        preOrder(root);
    }

    //前序遍历
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树");
        }
    }

    //创建赫夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        //遍历arr数组，将arr的每个元素构建成一个Node
        ArrayList<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        while (nodes.size() > 1) {

            //排序
            Collections.sort(nodes);
            System.out.println("nodes=" + nodes);

            //取出根节点权值最小的两个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //从ArrayList中删除处理过的
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将parent加入到nodes
            nodes.add(parent);
            //System.out.println("第一次处理后" + nodes);
        }
        //返回赫夫曼树的root节点
        return nodes.get(0);
    }
}

//创建节点类
class Node implements Comparable<Node> {
    int value;//权值
    Node left;//左子节点
    Node right;//右子节点

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }


    @Override
    public int compareTo(Node o) {
        //从小到大进行排序
        return this.value - o.value;
    }
}
