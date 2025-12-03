package simple;

import java.nio.channels.Pipe;
import java.util.Arrays;
import java.util.Scanner;

public class moveZeroes283 {

    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++){
            if (nums[right]!=0){
                nums[left] = nums[right]; // 移动非零元素
                left++;

            }

        }
        for (int i = left; i<nums.length;i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取一行输入，按空格分割为字符串数组（无需提前输入数组长度）
        String[] inputStrs = scanner.nextLine().split(" ");
        int[] nums = new int[inputStrs.length];

        // 将字符串数组转换为整数数组
        for (int i = 0; i < inputStrs.length; i++) {
            nums[i] = Integer.parseInt(inputStrs[i]);
        }

        // 调用方法处理数组
        moveZeroes283 solution = new moveZeroes283();
        solution.moveZeroes(nums);

        // 输出处理后的数组（格式：[元素1, 元素2, ...]）
        System.out.println(Arrays.toString(nums));

        scanner.close();
    }
}
