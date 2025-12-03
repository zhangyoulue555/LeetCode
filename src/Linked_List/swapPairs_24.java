package Linked_List;
// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
// 你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
public class swapPairs_24 {
    public static class ListNode {
        int val;
        ListNode next;  // 修复：使用当前类的ListNode

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {  // 修复：使用当前类的ListNode
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        // 1. 创建虚拟头节点（dummy head），值为-1（值无实际意义，仅作为占位符）
        // 作用：简化边界处理（如链表为空、只有一个节点时无需特殊判断），统一操作逻辑
        ListNode dumyhead = new ListNode(-1);

        // 2. 虚拟头节点的next指向原链表的头节点，将虚拟头节点与原链表连接
        dumyhead.next = head;

        // 3. 定义cur指针，初始指向虚拟头节点
        // 作用：作为"当前待交换的两个节点"的前驱节点，用于调整指针连接关系
        ListNode cur = dumyhead;

        // 4. 定义临时节点（用于保存中间结果，避免指针修改后丢失引用）
        ListNode temp;       // 保存"待交换的两个节点"之后的节点（交换后需要重新连接）
        ListNode firstnode;  // 保存待交换的两个节点中的第一个节点
        ListNode secondnode; // 保存待交换的两个节点中的第二个节点

        // 5. 循环条件：当前cur后面至少有两个节点（才能进行交换）
        // 若cur.next为null（无节点）或cur.next.next为null（只剩一个节点），则退出循环
        while (cur.next != null && cur.next.next != null) {
            // 保存"待交换的两个节点"之后的节点（避免后续指针修改后丢失）
            temp = cur.next.next.next;

            // 确定待交换的两个节点
            firstnode = cur.next;       // 第一个节点（cur的下一个）
            secondnode = cur.next.next; // 第二个节点（cur的下下个）

            // 步骤1：cur的next指向第二个节点（让前驱节点连接到第二个节点，完成"第二个节点"的前移）
            cur.next = secondnode;

            // 步骤2：第二个节点的next指向第一个节点（完成两个节点的交换）
            secondnode.next = firstnode;

            // 步骤3：第一个节点的next指向temp（让交换后的第一个节点连接到原后续节点，保持链表连续）
            firstnode.next = temp;

            // 移动cur到交换后的第一个节点（作为下一轮交换的前驱节点）
            cur = firstnode;
        }

        // 6. 返回虚拟头节点的next（即交换后的新链表头节点）
        return dumyhead.next;
    }
}
