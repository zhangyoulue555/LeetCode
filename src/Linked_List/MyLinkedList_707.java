package Linked_List;

public class MyLinkedList_707 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    //size存储链表元素的个数
    private int size;
    //注意这里记录的是虚拟头结点
    private ListNode head;

    //初始化链表
    public MyLinkedList_707() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    // 获取链表第index个节点的数值
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head; // 虚拟头结点
        for (int i = 0; i <= index; i++) { // 找到第index个节点
            cur = cur.next;
        }
        return cur.val; // 返回第index个节点的数值

    }

    // 在链表最前面插入一个节点
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val); // 创建一个新节点
        newNode.next = head.next; // 新节点的next指向原来链表的第一个节点
        head.next = newNode; // 虚拟头结点的next指向新节点
        size++;

    }

    // 在链表的最后插入一个节点
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        ListNode cur = head;
        while (cur.next != null) { // 找到链表的最后一个节点
            cur = cur.next;
        }
        cur.next = newNode; // 链表的最后一个节点的next指向新节点
        size++;
    }

    // 在链表的第index个节点之前插入一个值为val的节点
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode cur = head; // 虚拟头结点
        for (int i = 0; i <= index; i++) { // 找到第index个节点
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        cur.next = newNode;
        size++;


    }

    // 删除链表的第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        //因为有虚拟头节点，所以不用对index=0的情况进行特殊处理
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        size--;

    }
}
