package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class threeSum_15 {

    // 三个for循环暴力解
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 定义一个列表的列表
        // 处理边界情况：数组为空或长度不足3，直接返回空列表
        if (nums == null || nums.length < 3) {
            return result;
        }
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        // 把三个整数（nums[i]、nums[j]、nums[k]）打包成一个 “整数列表”
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        // 对三元组排序（用于去重：相同元素的不同排列会被统一为同一顺序）
                        Collections.sort(triplet);
                        // 若结果列表中不存在该三元组，则加入结果
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 双指针
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // 定义一个列表的列表
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                return result;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left<right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                }
                else if (sum>0){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return result;
    }
}
