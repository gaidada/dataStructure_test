package ch4;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        System.out.println("双向链表测试");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        HeroNode2 hero5 = new HeroNode2(4, "林冲", "豹子");
        doubleLinkedList.update(hero5);
        doubleLinkedList.list();

        doubleLinkedList.delete(4);
        doubleLinkedList.list();
    }
}

//创建一个双向列表的类
class DoubleLinkedList {
    //初始化一个头节点，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //双向链表中删除节点
    public void delete(int no) {

        //判断当前链表是否为空
        if (head.name == null) {
            System.out.printf("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;//辅助指针
        boolean flag = false;//标志是否找到待删除节点的
        while (true) {
            if (temp == null) {//已经到链表的最后
                break;
            }
            if (temp.no == no) {//找到待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//找到，可以删除
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面一句话
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {//没有找到，不存在要删除的节点
            System.out.printf("要删除的节点%d 不存在", no);
        }
    }

    //根据no编号修改节点的信息，双向链表和单向链表代码一样
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.printf("链表为空");
            return;
        }
        //根据no编号找到需要修改的节点
        HeroNode2 temp = head.next;
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

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //添加节点到双向链表表尾
    //找到当前链表的最后节点，将最后节点的next指向新节点
    public void add(HeroNode2 heroNode) {
        //head节点不能动
        HeroNode2 temp = head;
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
        //形成一个双向列表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    //显示链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不能动，需要一个临时变量来遍历
        HeroNode2 temp = head.next;
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
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个节点
    //构造器

    public HeroNode2(int no, String name, String nickName) {
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