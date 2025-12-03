package Linked_List;
// 环形链表2
// 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

// 1.判断链表是否环
// 2.如果有环，如何找到这个环的入口

public class detectCycle_142 {

    public static class ListNode {
        int val;
        detectCycle_142.ListNode next;  // 修复：使用当前类的ListNode

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, detectCycle_142.ListNode next) {  // 修复：使用当前类的ListNode
            this.val = val;
            this.next = next;
        }

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
