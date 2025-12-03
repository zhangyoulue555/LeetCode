package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class reverseWords_151 {

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        // 数组转集合
        // 数组本身没有 “反转”“排序” 等方法，若要反转 String[]，得自己写双指针逻辑；
        // 但 List 可以直接用 Collections.reverse(list) 实现反转
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }
}
