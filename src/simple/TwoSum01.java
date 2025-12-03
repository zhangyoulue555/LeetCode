package simple; // 声明当前类所在的包为hash
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; // 导入Scanner类，用于从标准输入流（键盘）读取用户输入

/**
 * 两数之和问题的解决方案类
 * 功能：给定一个整数数组和一个目标值，返回数组中两个元素的下标，使得它们的和等于目标值
 */
public class TwoSum01 {
    public static int[] twoSum1(int[] nums, int target) {
        int n = nums.length; // 获取数组长度，用于控制循环范围
        // 外层循环：遍历数组中的每个元素作为第一个候选元素
        for (int i = 0; i < n; i++){
            // 内层循环：遍历当前元素之后的所有元素作为第二个候选元素（避免重复计算同一对元素）
            for (int j = i + 1; j < n; j++){
                // 检查两个元素的和是否等于目标值
                if (nums[i] + nums[j] == target){
                    // 若符合条件，返回两个元素的下标组成的数组
                    return new int[]{i, j};
                }
            }
        }
        // 若遍历完所有可能的组合都未找到符合条件的元素对，返回空数组
        return new int[0];
    }

    public static int[] twoSum2(int[] nums, int target) {
        // 创建哈希表（键：需要的补数；值：该补数对应的元素下标）
        // 作用：记录遍历过的元素"需要搭配的另一个数"及其下标，用于后续快速查找
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        // 遍历数组中的每个元素，i为当前元素的下标
        for (int i = 0; i < nums.length; i++) {
            // 核心逻辑：判断当前元素是否是之前某元素需要的"补数"
            // 例如：若之前有元素x，其需要的补数是target - x，当前元素若等于target - x，
            // 则x和当前元素的和为target，直接返回两者的下标
            if (hashtable.containsKey(nums[i])) {
                // 若包含，说明当前元素是哈希表中某个键对应的补数
                // 返回：哈希表中该键对应的值（之前元素的下标） 和 当前元素的下标i
                return new int[]{hashtable.get(nums[i]), i};
            }

            // 若不包含，说明当前元素还未找到匹配的补数，将"当前元素需要的补数"和"当前下标"存入哈希表
            // 补数计算：target - nums[i]（即另一个需要的元素值）
            // 后续遍历到该补数时，就能通过哈希表快速找到当前元素的下标
            hashtable.put(target - nums[i], i);
        }

        // 题目保证有唯一解，因此理论上不会执行到此处，仅作为语法补充
        return new int[0];
    }


    /**
     * 程序主入口方法
     * 功能：读取用户输入的数组和目标值，调用核心算法计算结果并输出
     * @param args 命令行参数（未使用）
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 创建Scanner实例，用于读取用户输入

        // 读取用户输入的数组元素
        System.out.println("请输入数组元素（用空格分隔，例如：3 2 4）：");
        String[] numStrs = scanner.nextLine().split(" "); // 将用户输入的一行字符串按空格分割为字符串数组
        int[] nums = new int[numStrs.length]; // 创建与输入元素数量相同的整数数组

        // 将字符串数组转换为整数数组
        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]); // 字符串转整数并存储
        }

        // 读取用户输入的目标值
        System.out.println("请输入目标值（例如：6）：");
        int target = scanner.nextInt(); // 读取整数类型的目标值

        // 调用两数之和核心方法计算结果
        int[] result = twoSum2(nums, target);

        // 输出计算结果
        System.out.println("和为目标值的两个元素下标为：");
        System.out.println("[" + result[0] + ", " + result[1] + "]");

        scanner.close(); // 关闭Scanner资源，避免资源泄漏
    }
}
