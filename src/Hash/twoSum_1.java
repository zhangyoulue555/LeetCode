package Hash;

import java.util.HashMap;
import java.util.Map;

public class twoSum_1 {
    // 暴力解
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // hash表
    public int[] twoSum2(int[] nums, int target) {

        // 初始化结果数组res，长度为2，用于存储满足条件的两个元素的索引
        int[] res = new int[2];

        // 处理边界情况：如果输入数组为null（未初始化）或长度为0（无元素），直接返回空结果数组
        if (nums == null || nums.length == 0) {
            return res;
        }

        // 创建HashMap，用于存储"数组元素值"与"其对应的索引"的映射关系
        // 键（key）：数组中的元素值；值（value）：该元素在数组中的索引
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 计算"与当前元素配对后和为target"的目标元素值：temp = target - 当前元素值nums[i]
            // 即：若存在一个元素值为temp，且它的索引与i不同，则这两个元素满足条件
            int temp = target - nums[i];

            // 判断map中是否已包含temp这个键（即之前是否遍历过值为temp的元素）
            if (map.containsKey(temp)) {
                // 若存在，则当前元素的索引i是第二个满足条件的索引
                res[1] = i;
                // 从map中获取temp对应的索引（即之前遍历过的元素的索引），作为第一个满足条件的索引
                res[0] = map.get(temp);
                // 找到结果后直接跳出循环，无需继续遍历
                break;
            }

            // 若map中不包含temp，说明当前元素暂时没有找到配对元素，将其"值-索引"存入map
            // 供后续元素遍历时分查找
            map.put(nums[i], i);
        }

        // 返回存储两个索引的结果数组（若未找到满足条件的元素，返回默认的[0,0]，但题目通常保证有解）
        return res;
    }
}
