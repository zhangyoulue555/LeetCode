package Linked_List;


import java.util.Scanner;
// 移除链表元素：删除链表中等于给定值 val 的所有节点。
public class removeElements_203 {
    // 定义链表节点内部类
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
//        先读长度 n，再读 n 个整数
//        int n = scanner.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n ; i++) {
//            nums[i] = scanner.nextInt();
//        }

//      先存字符串再转数组-直接给所有元素，无显式长度
        // 步骤1：读取链表的元素（以空格分隔）
        String[] nodeStrs = scanner.nextLine().split(" ");
        // 步骤2：读取要删除的目标值 val
        int val = scanner.nextInt();
        // 步骤3：构建链表
        ListNode dummy = new ListNode();
        ListNode cur = dummy; // 创建一个虚拟头节点
        for (int i = 0; i < nodeStrs.length; i++) {
            int num = Integer.parseInt(nodeStrs[i]); // 直接获取字符串并转换为整数
            cur.next = new ListNode(num); // 创建新节点
            cur = cur.next; // 移动指针
        }
        ListNode head = dummy.next;

        // 步骤4：调用方法删除节点
        removeElements_203 solution = new removeElements_203(); // 创建对象
        ListNode result = solution.removeElements(head, val);

        // 步骤5：输出结果链表
        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val).append(" ");
            result = result.next;
        }
        // 去除最后多余的空格
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.println(sb.toString());



    }
}
