package Array;

import java.util.Scanner;

public class mySqrt_69 {
    public static int mySqrt(int x) {
        if (x == 0) { // 特殊情况：x=0直接返回0
            return 0;
        }
        int left = 1;
        int right = x;
        int ans = 0; // 用于记录最大的有效解
        while (left <= right) {
            int mid = left + (right - left) / 2; // 避免(left+right)溢出
            long square = (long) mid * mid; // 用long防止mid*mid溢出

            if (square == x) {
                return mid; // 完全平方数，直接返回
            } else if (square < x) {
                // 当前mid是候选解，记录后尝试更大的数
                ans = mid;
                left = mid + 1;
            } else {
                // 平方过大，缩小右边界
                right = mid - 1;
            }
        }
        return ans; // 返回最大的有效解
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入x：");
        int x = scanner.nextInt();
        System.out.println("输出：" + mySqrt(x)); // 输入8时，输出2
        scanner.close();
    }
}
