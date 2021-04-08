package ch9;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * @author gai
 * @create 2021--02--22
 */
public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        String key = "";

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add：添加");
            System.out.println("list：显示");
            System.out.println("find：查找");
            System.out.println("exit：退出");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "find":
                    System.out.println("请输入查找的id");
                    int findId = scanner.nextInt();
                    hashTab.findEmpById(findId);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
            }
        }

    }
}

//创建哈希表，管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;//表示有多少条链表

    public HashTab(int size) {
        this.size = size;
        //初始化
        empLinkedListArray = new EmpLinkedList[size];
        //分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加员工
    public void add(Emp emp) {
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp加入到对应的链表
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //根据输入id查找员工
    public void findEmpById(int id) {
        //先确定到哪条链表
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.printf("第%d 条链表找到员工id = %d\n", empLinkedListNo, id);
        } else {
            System.out.println("哈希表中没有找到该员工");
        }
    }

    //遍历所有的hash表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }

    //简单的取模法，散列函数
    public int hashFun(int id) {
        return id % size;
    }
}


//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//默认为空

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//链表
class EmpLinkedList {
    //头指针，指向第一个Emp
    private Emp head;

    //添加员工到链表，假设添加雇员时，id是自增长，从小到大
    public void add(Emp emp) {
        //如果是第一个员工
        if (head == null) {
            head = emp;
            return;
        }
        //不是第一个，使用一个辅助的指针，帮助定位到最后
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {//链表最后
                break;
            }
            curEmp = curEmp.next;//后移
        }
        //退出时将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的员工信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.print("第" + no + "链表为:");
        Emp curEmp = head;//辅助指针
        while (true) {
            System.out.printf("=>id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;//后移，遍历
        }
        System.out.println();
    }

    //根据id查找员工
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {//找到
                break;
            }
            if (curEmp.next == null) {//到当前链表最后
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//后移
        }
        return curEmp;
    }
}
