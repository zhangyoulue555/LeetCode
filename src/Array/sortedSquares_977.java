package Array;

import java.util.Arrays;

public class sortedSquares_977 {

    // 暴力解
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;

    }

    // 快慢指针法
    public int[] sortedSquares2(int[] nums) {


        int l = 0;
        int len = nums.length;
        int r= len-1;
        int[] result =new int[len]; // 创建结果数组：长度与原数组相同，用于存储平方后有序的元素
        for (int i = len - 1; i > 0; i--) {
            if (nums[r]*nums[r]>nums[l]*nums[l]){
                result[i]=nums[r]*nums[r];
                r--;

            }
            else{
                result[i]=nums[l]*nums[l];
                l++;
            }

        }
        return result;
    }

}
