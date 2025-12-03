package Array;

import java.util.Scanner;

public class removeDuplicates_26 {
    public static int removeElement(int[] nums) {
        int s = 1;
        int n = nums.length;
        for (int f = 1; f < n; f++) {
            if (nums[f] != nums[f-1]) {
                nums[s]=nums[f];
                s++;
            }

        }
        return s;
    }

    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        int newLength = removeElement(nums); // 获取去重后的新长度
        System.out.println(newLength); // 输出新长度

        // 只输出去重后的有效元素（前newLength个）
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }


    }
}
