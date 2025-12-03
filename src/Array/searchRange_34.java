package Array;

import java.util.Arrays;
import java.util.Scanner;

public class searchRange_34 {

    public static int findLeft(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int leftindex = -1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                leftindex = m;
                r = m - 1;
            }
        }
        return leftindex;
    }

    public static int findRight(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int rightindex = -1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                rightindex = m;
                l = m + 1;
            }
        }
        return rightindex;
    }

    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n ; i++) {
            nums[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int first = findLeft(nums, target);
        int last = findRight(nums, target);

        System.out.println("[" + first + "," + last + "]");

//        // 创建包含结果的数组
//        int[] result = new int[]{first, last};
//        // 转换为ACM要求的格式（去掉Arrays.toString自带的空格）
//        System.out.println(Arrays.toString(result).replace(" ", ""));

        scanner.close();


    }
}
