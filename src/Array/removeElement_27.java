package Array;

public class removeElement_27 {
    // 暴力解
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        for (i = 0; i < n; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < n; j++) {
                    nums[j - 1] = nums[j];
                }
                i--;
                n--;
            }
        }
        return n;
    }

    // 快慢指针法
    public int removeElement2(int[] nums, int val) {
        int s = 0;
        int n = nums.length;
        for (int f = 0; f < n; f++) {
            if (nums[f] != val) {
                nums[s]=nums[f];
                s++;
            }
        }
        return s;
    }


}
