package String;

public class repeatedSubstringPattern_459 {

    // 暴力解：枚举所有可能的子串
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        // 枚举所有可能的子串长度k（k必须是n的约数，且k≤n/2）
        for (int k = 1; k < n / 2; k++) {
            if (n % k != 0) {
                continue; // 不能整除，说明该长度k的子串无法重复构成原串
            }
            boolean ismatch = false;
            // 检查每个位置i的字符是否与子串对应位置（i%k）的字符一致
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) != s.charAt(k)) {
                    ismatch = false;
                    break;
                }
            }
            if (ismatch) {
                return true;
            }
        }
        return false;
    }
}
