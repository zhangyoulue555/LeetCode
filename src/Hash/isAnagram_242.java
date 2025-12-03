package Hash;

import java.util.Arrays;
import java.util.HashMap;
// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
public class isAnagram_242 {

    // 先排序再比较
    public boolean isAnagram1(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);

        return Arrays.equals(chars,chart);
    }

    // 哈希表
    public boolean isAnagram2(String s, String t) {
        if (s.length()!=t.length()){
            return  false;
        }
        // 创建hash表
        HashMap<Character,Integer> charCountMap = new HashMap<>();

        // 步骤1：将字符串s中的字母加入到hash表中，统计s中字母出现的次数
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            charCountMap.put(c,charCountMap.getOrDefault(c,0)+1); // getOrDefault(c, 0)：从哈希表中获取字符c当前的出现次数。
        }

        // 步骤2：减去字符串t中字母出现的次数
        for (int i=0;i<s.length();i++){
            char c = t.charAt(i);
            charCountMap.put(c,charCountMap.getOrDefault(c,0)-1);
            // 步骤3：如果hash表中有字母出现次数小于0，则返回false
            if (charCountMap.get(c)<0){
                return false;
            }
        }

        // 步骤4：验证所有字符次数是否为0
        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
