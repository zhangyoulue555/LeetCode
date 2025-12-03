package Hash;

import java.util.*;

// 给定两个数组 nums1 和 nums2 ，返回它们的交集 。
// 输出结果中的每个元素一定是唯一的。我们可以 不考虑输出结果的顺序 。
public class intersection_349 {

    // 哈希表解法1-使用HashSet的核心原因：需要高效去重或频繁判断元素是否存在，且不依赖顺序。
    public int[] intersection1(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for (int value : set2) {
            res[i] = value;
            i++;
        }

        return res;
    }

    // 哈希表解法2-使用HashMap
    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>(); // 存储交集元素（临时容器）
        HashMap<Integer, Integer> map = new HashMap<>(); // 统计nums1中元素的出现次数
        // 第一步：遍历nums1，记录每个元素的出现次数（至少1次）
        for (int num : nums1) {
            // 若元素已存在，次数+1；否则初始化为1
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 第二步：遍历nums2，查找在nums1中存在的元素（即交集）
        for (int num : nums2) {
            // 若map中包含该元素，且次数>0（说明未被添加到交集）
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, 0); // 标记为已添加（避免重复）
                // map.put(num,map.get(num)-1); 重复
            }
        }
        // 第三步：将List转换为数组（结果）
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 双指针
    public int[] intersection3(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[i]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[i]) {
                i++;
            } else if (nums1[i] > nums2[i]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index] = num;
            index++;
        }
        return res;
    }

    // hash数组
    public int[] intersection4(int[] nums1, int[] nums2) {
        // 创建两个哈希数组，大小为1002（下标0~1001），用于统计元素出现次数
        // 哈希数组的核心思想：用"数组下标"代表元素值，用"数组元素"代表该值的出现次数
        int[] hash1 = new int[1002]; // 统计nums1中各元素的出现次数
        int[] hash2 = new int[1002]; // 统计nums2中各元素的出现次数

        // 遍历第一个数组nums1，统计每个元素的出现次数
        // 例如：若nums1中有元素3，则hash1[3]的值会+1（出现几次就+几次）
//      for(int i : nums1)
//            hash1[i]++; // 下标i对应元素值，自增表示出现次数+1
        for (int index = 0; index < nums1.length; index++) {
            // 1. 通过索引获取当前元素
            int num = nums1[index];
            // 2. 不简写的"自增"过程：先获取hash1[num]的当前值
            int currentCount = hash1[num];
            // 3. 给当前值加1
            currentCount = currentCount + 1;
            // 4. 把加1后的值重新赋给hash1[num]
            hash1[num] = currentCount;
        }


        // 遍历第二个数组nums2，统计每个元素的出现次数（逻辑同上）
        for (int i : nums2)
            hash2[i]++;

        // 创建一个动态列表resList，用于临时存储交集元素
        List<Integer> resList = new ArrayList<>();

        // 遍历哈希数组的所有下标（0~1001），筛选交集元素
        // 下标i代表元素值，若hash1[i]>0且hash2[i]>0，说明元素i在两个数组中都出现过（是交集）
        for (int i = 0; i < 1002; i++)
            if (hash1[i] > 0 && hash2[i] > 0) // 两个数组中都存在该元素
                resList.add(i); // 将元素i加入交集列表

        // 创建结果数组，长度为交集列表的大小
        int index = 0; // 用于填充结果数组的索引
        int res[] = new int[resList.size()];

        // 将交集列表中的元素依次存入结果数组
        for (int i : resList)
            res[index++] = i; // 先赋值，再将索引+1

        // 返回包含交集元素的数组
        return res;
    }
}
