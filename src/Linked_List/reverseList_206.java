package Linked_List;
// 反转链表
public class reverseList_206 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, reverseList_206.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 1. 初始化指针：
        // prev：指向当前节点的“前一个节点”（初始为null，因为原链表头节点反转后是尾节点，next为null）
        ListNode prev = null;
        // cur：指向“当前需要处理的节点”（初始为原链表的头节点）
        ListNode cur = head;
        // temp：临时保存当前节点的“下一个节点”（防止反转指针后丢失后续节点）
        ListNode temp = null;

        // 2. 遍历链表，逐个反转节点的指针方向：
        // 循环条件：当前节点不为null（直到处理完所有节点）
        while (cur != null) {
            // 步骤1：先保存当前节点的下一个节点（否则反转后会找不到）
            temp = cur.next;

            // 步骤2：反转当前节点的指针（让当前节点的next指向它的前一个节点prev）
            cur.next = prev;

            // 步骤3：移动prev指针到当前节点（因为下一次循环，当前节点会变成“前一个节点”）
            prev = cur;

            // 步骤4：移动cur指针到下一个节点（继续处理下一个节点）
            cur = temp;
        }

        // 3. 循环结束后，prev指向原链表的最后一个节点（即反转后新链表的头节点）
        return prev;
    }
}
