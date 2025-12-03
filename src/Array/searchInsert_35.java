package Array;

import java.util.Scanner;

public class searchInsert_35 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2; // 更安全的中间值计算
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l; // 循环结束后，l 是正确插入位置
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取数组长度
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // 读取n个元素（支持单行或多行输入）
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // 读取目标值（确保此时才读取目标值）
        int target = scanner.nextInt();

        System.out.println(searchInsert(nums, target));
        scanner.close(); // 关闭扫描器，避免资源泄漏
    }
}
