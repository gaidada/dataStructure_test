package ch10;

/**
 * @author gai
 * @create 2021--02--24
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
    }
}

//ArrayBinaryTree类实现顺序存储二叉树遍历
class ArrayBinaryTree {
    private int[] arr;//存储数据节点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    //顺序存储二叉树的前序遍历,index数组的下标
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数据为空");
        }
        System.out.println(arr[index]);
        //向左递归遍历
        if ((2 * index + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归
        if ((2 * index + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
