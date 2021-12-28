package queue;

import java.util.Scanner;

//
public class ArrayQueueDemo {
    public static void main(String args[]) {
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(6);
        Scanner scanner = new Scanner(System.in);
        String key = "";//接收用户输入
        boolean loop = true;
        while (loop) {
            System.out.println("s-show:显示队列");
            System.out.println("e-exit:退出");
            System.out.println("a-add:相队列新增数据");
            System.out.println("g-get:从队列里取数据");
            System.out.println("h-head:查看队列投数据");
            key = scanner.next().charAt(0) + "";
            switch (key) {
                case "s":
                    arrayQueue.showQueue();
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                case "a":
                    System.out.println("请输入一个数字");
                    int a = scanner.nextInt();
                    arrayQueue.addElement(a);
                    break;
                case "g":
                    try {
                        int res = arrayQueue.getElement();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        int res = arrayQueue.headQueue();
                        ;
                        System.out.println("队列头数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
            }
        }
    }

}

//使用数组模拟队列  不能复用需改进
class ArrayQueue {
    private int maxSize;//表示数组（队列）最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//用于存放数据，模拟队列

    //创建队列构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列尾，指向队列尾部数据（队列最后一个数据）
    }

    //判断队列是否满了
    public boolean isFull() {
        return maxSize == rear;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列，入队列
    public void addElement(int n) {
        //判断队列是否满了
        if (isFull()) {
            throw new RuntimeException("队列已满，无法新增数据");
        }
        rear++;
        arr[rear] = n;
    }

    //获取队列数据，出队列
    public int getElement() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //展示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "");
        }
    }

    //显示队列头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有头部数据");
        }
        return arr[front + 1];
    }
}


//使用数组模拟环形队列思路如下
// 1.front变量的含义做一个调整∶front就指向队列的第一个元素.也就是说arrlfrontl就是队列的第一个元素front 的初始值=0
// 2.rear变量的含义做一个调整∶rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间做为约定rear 的初始值=0
// 3.当队列满时，条件是（rear +1）%maxSize==front【满】
// 4.对队列为空的条件，rear == front空
// 5.当我们这样分析，队列中有效的数据的个数（rear+maxSize-front）%maxSize //rear=1front=0 6.
class CircleArray {
    private int maxSize; // 表示数组的最大容量
    // front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    // front 的初始值 = 0
    private int front;
    // rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    // rear 的初始值 = 0
    private int rear;
    private int[] arr;// 该数据用于存放数据, 模拟队列

    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //添加数据到队列，入队列
    public void addElement(int n) {
        //判断队列是否满了
        if (isFull()) {
            throw new RuntimeException("队列已满，无法新增数据");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出队列
    public int getElement() {
        //判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        // 这里需要分析出 front 是指向队列的第一个元素
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从 front 开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        // rear = 2
        // front = 1
        // maxSize = 3
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列头部数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有头部数据");
        }
        return arr[front];
    }

    //1) 求单链表中有效节点的个数
    //2)查找单链表中的倒数第 k 个结点 【新浪面试题】
    //1. 编写一个方法，接收 head 节点，同时接收一个 index
    // 2. index 表示是倒数第 index 个节点
    // 3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    // 4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    // 5. 如果找到了，则返回该节点，否则返回 nulll
    //3）单链表的反转【腾讯面试题，有点难度】
    //4）从尾到头打印单链表 【百度，要求方式 1：反向遍历 。 方式 2：Stack 栈】
//    5）合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
}
