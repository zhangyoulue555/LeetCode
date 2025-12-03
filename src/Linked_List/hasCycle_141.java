package Linked_List;
// 给你一个链表的头节点 head ，判断链表中是否有环。
// 快慢指针
public class hasCycle_141 {

    public static class ListNode {
        int val;
        hasCycle_141.ListNode next;  // 修复：使用当前类的ListNode

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, hasCycle_141.ListNode next) {  // 修复：使用当前类的ListNode
            this.val = val;
            this.next = next;
        }

    }
    public boolean hasCycle(ListNode head) {
        // 边界条件：空链表或只有一个节点，一定无环
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;       // 慢指针从 head 开始
        ListNode fast = head.next;  // 快指针从 head.next 开始（初始位置与 slow 错开）

        while (slow != fast) {      // 若相遇则有环，否则继续
            // 快指针到达末尾（无环）
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;       // 慢指针走1步
            fast = fast.next.next;  // 快指针走2步
        }
        return true;  // 相遇，有环

    }
}
