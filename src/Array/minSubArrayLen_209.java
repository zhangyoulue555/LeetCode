package Array;

import java.util.Scanner;

public class minSubArrayLen_209 {

    // 暴力解
    public static int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        int len = n + 1;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum >= target) {
                    len = Math.min(len, j - i + 1);
                    break;

                }
            }
        }

        return len == n + 1 ? 0 : len; // 条件 ? 结果1(true) : 结果2(false)
    }

    // 滑动窗口-双指针
    public static int minSubArrayLen2(int target, int[] nums) {

        int n = nums.length;
        int len = n + 1;
        int sum = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {

            sum += nums[end];
            while (sum >= target) {
                len = Math.min(len, end - start + 1);

                sum =sum-nums[start];
                start++;
            }
        }
        return len==n + 1 ? 0 : len;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n ; i++) {
            nums[i] = scanner.nextInt();
        }
        int target =scanner.nextInt();
        int i = minSubArrayLen2(target,nums);
        System.out.println(i);

    }
}
