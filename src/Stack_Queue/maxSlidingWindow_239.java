package Stack_Queue;

// 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
// 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
// 返回滑动窗口中的最大值 。
public class maxSlidingWindow_239 {
    // 暴力解
    public int[] maxSlidingWindow1(int[] nums, int k) {
        // 1. 边界情况处理：如果数组为空，直接返回空数组
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        // 2. 结果数组的长度：如果有 n 个数，窗口大小为 k，那么一共会产生 n - k + 1 个窗口
        int[] result = new int[n - k + 1];
        // 3. 外层循环：代表窗口的左边界 i
        // i 从 0 开始，一直移动到 n - k (最后一个窗口的起始位置)
        for (int i = 0; i <= n - k; i++) {
            // 初始化当前窗口的最大值为最小整数，方便比较
            int max = Integer.MIN_VALUE;
            // 4. 内层循环：遍历当前窗口内的 k 个元素
            // j 代表窗口内的具体每一个位置
            for (int j = i; j < i + k; j++) {
                // 这里的 nums[j] 就是窗口里的数，我们通过比较找出最大的
                max = Math.max(max, nums[j]);
            }
            // 5. 将找到的最大值放入结果数组
            result[i] = max;
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {


    }
}
