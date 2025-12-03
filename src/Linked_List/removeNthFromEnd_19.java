package Linked_List;

public class removeNthFromEnd_19 {
    public static class ListNode {
        int val;
        removeNthFromEnd_19.ListNode next;  // 修复：使用当前类的ListNode

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, removeNthFromEnd_19.ListNode next) {  // 修复：使用当前类的ListNode
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumyHead = new ListNode(); // 创建虚拟头节点
        dumyHead.next = head; // 将虚拟头节点的指针指向真正的头节点
        ListNode cur = dumyHead; //创建一个当前节点，从头节点开始
        ListNode fastNode = cur; // 创建快指针
        ListNode slowNode = cur; // 创建慢指针
        while (n > 0) { // 删除第倒数n个节点，就将快指针移动几次
            fastNode = fastNode.next;
            n--;
        }
        while (fastNode.next != null) { // 当快指针移动到最后一个节点的时候退出循环
            // 同时移动快慢指针
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        // 删除第倒数n个节点
        slowNode.next = slowNode.next.next;

        return dumyHead.next; // 返回头节点
    }
}
