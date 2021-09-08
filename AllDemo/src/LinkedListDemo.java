public class LinkedListDemo {

    public static void main(String [] args){
//        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.
      HeroNode heroNode1 =   new HeroNode(1,"宋江1","及时雨");
      HeroNode heroNode2 =   new HeroNode(2,"卢俊义","玉麒麟");
      HeroNode heroNode3 =   new HeroNode(3,"无用","智多星");
      HeroNode heroNode4 =   new HeroNode(4,"林冲","豹子头");
      HeroNode heroNode5 =   new HeroNode(5,"林冲1","豹子头1");
      HeroNode heroNode6 =   new HeroNode(6,"林冲2","豹子头2");
      HeroNode heroNode7 =   new HeroNode(7,"林冲3","豹子头3");
      HeroNode heroNode8 =   new HeroNode(8,"林冲4","豹子头4");
      SingleLinkedList singleLinkedList = new SingleLinkedList();
      singleLinkedList.add(heroNode1);

      singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode3);
        singleLinkedList.add(heroNode8);
        singleLinkedList.add(heroNode5);
        singleLinkedList.add(heroNode7);
        singleLinkedList.add(heroNode6);
      singleLinkedList.printList();
    }


}
class SingleLinkedList{
    //初始化一个头结点
    private HeroNode head = new HeroNode(0,"","");

    //添加接单到单链表

    //思路 不考虑编号顺序是
    public void add (HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            //最后一个元素的next为空
            if (temp.next == null){
                break;
            }
            if (heroNode.num< temp.next.num ){
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            if (heroNode.num == temp.num){
                System.out.println("请勿重复添加");
                break;

            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void printList(){
        if (head.next == null){
            System.out.print("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}

class HeroNode{
    public int num;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode (int num, String name , String nickname){
        this.num = num;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
//                ", next=" + next +
                '}';
    }
}