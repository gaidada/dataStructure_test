package ch4;

import java.util.Stack;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //测试
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        //singleLinkedList.addByOrder(hero4);

//        HeroNode newHero = new HeroNode(5, "小卢", "麒麟");
//        singleLinkedList.update(newHero);

        //singleLinkedList.delete(4);

        singleLinkedList.list();

        // System.out.println(getLength(singleLinkedList.getHead()));

//        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
//        System.out.println(res);

//        reversetList(singleLinkedList.getHead());
//        singleLinkedList.list();

        reversePrint(singleLinkedList.getHead());
    }

    //使用2栈，逆序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;//空链表
        }
        //创建一个栈，
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将各个节点压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;//cur后移
        }
        //出栈将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    //将单链表进行反转
    public static void reversetList(HeroNode head) {
        //如果当前链表为空，或只有一个节点，无需反转，直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }
        //定义一个辅助指针，帮我们遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点cur的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，将其取出，并放在新的链表reverseHead的最前端
        while (cur != null) {
            next = cur.next;//暂时保存当前节点得下一个节点
            cur.next = reverseHead.next;//将cur的下一个节点指向新链表的最前端
            reverseHead.next = cur;
            cur = next;//让cur后移
        }
        //将head.next指向reverseHead.next
        head.next = reverseHead.next;
    }

    //查找单链表中的倒数第k个节点
    //思路：1.编写一个方法，接受head节点，同时接受一个index
    //2.index表示是倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总长度getLength
    //4.得到length后，从链表的第一个开始遍历length-index就可以得到
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历，length-index就是要找的第k个节点
        //index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //辅助变量,for循环定位到倒数的index
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //方法：获取到单链表有效节点的个数，不统计头节点
    public static int getLength(HeroNode head) {
        //head链表的头节点，return返回有效节点的个数
        if (head.next == null) {//空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;//没有统计头节点
        while (cur != null) {
            length++;
            cur = cur.next;//遍历
        }
        return length;
    }
}

//定义SingleLinkedList管理英雄人物
class SingleLinkedList {
    //初始化一个头节点，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表表尾
    //找到当前链表的最后节点，将最后节点的next指向新节点
    public void add(HeroNode heroNode) {
        //head节点不能动
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        //退出while时，temp就是指到了最后
        temp.next = heroNode;
    }

    //第二种方式添加，插入指定位置
    public void addByOrder(HeroNode heroNode) {
        //头节点不能动，通过一个辅助指针帮助我们找到要添加的位置
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认false
        while (true) {
            if (temp.next == null) {//temp已经在temp在链表最后
                break;
            }
            if (temp.next.no > heroNode.no) {//位置找到，在temp后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//要添加的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if (flag) {//编号存在，不能添加
            System.out.printf("编号 %d已存在\n", heroNode.no);
        } else {
            //加入到链表中，temp后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //根据no编号修改节点的信息
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.printf("链表为空");
            return;
        }
        //根据no编号找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;//表示是否找到该节点
        while (true) {
            if (temp == null) {//遍历完链表
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {//没有找到
            System.out.printf("没有找到编号为%d的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点的
        while (true) {
            if (temp.next == null) {//已经到链表的最后
                break;
            }
            if (temp.next.no == no) {//找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//找到，可以删除
            temp.next = temp.next.next;
        } else {//没有找到，不存在要删除的节点
            System.out.printf("要删除的节点%d 不存在", no);
        }
    }


    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，需要一个临时变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}


//定义HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;//指向下一个节点
    //构造器

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
