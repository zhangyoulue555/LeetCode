package Array;

import java.util.Scanner;

public class moveZeroes_283 {

    public static void moveZeroes(int[] nums) {
        int s = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[s] = nums[j];
                s++;
            }

        }
        for (int i = s; i<nums.length;i++){
            nums[i]=0;
        }

    }

    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }

        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }





    }
}
