package Hash;

import java.util.HashMap;
import java.util.Map;

public class canConstruct_383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        // 统计ransomNote中各个字母出现的次数
        // 增强for循环：把str1里的字符“一个一个自动抓出来”，每次抓的字符存在变量z里
        for (char z : str1) {
            if (map.containsKey(z)) {
                map.put(z, map.get(z) + 1);
            } else {
                map.put(z, 1);
            }
        }

        // 统计magazine中各个字母出现的次数
        for (char z : str2) {
            if (map.containsKey(z)) {
                map.put(z, map.get(z) - 1);
            }
        }

        for (char z : str1) {
            Integer index = map.get(z);
            if (index > 0) { //如果index存在大于0的，说明magazine未能完全抵消ransomNote，即不能由他里面的字符构成
                return false;
            }

        }

        return true;

    }
}
