package Linked_List;

// 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
// 如果两个链表没有交点，返回 null 。
public class getIntersectionNode_160 {
    public static class ListNode {
        int val;
        getIntersectionNode_160.ListNode next;  // 修复：使用当前类的ListNode

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, getIntersectionNode_160.ListNode next) {  // 修复：使用当前类的ListNode
            this.val = val;
            this.next = next;
        }

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }
}
