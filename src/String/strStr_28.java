package String;

public class strStr_28 {

    // 内置解法
    public int strStr1(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        return haystack.indexOf(needle); // String 类的一个内置方法，用于查找指定子字符串在当前字符串中第一次出现的起始索引位置。
    }

    // 暴力
    public int strStr2(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        for (int i = 0; i <= haystack.length()-needle.length(); i++) {
            boolean isMatch = true;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i+j)!=needle.charAt(j)){ // 匹配失败
                    isMatch =false;
                    break;
                }
            }
            if (isMatch) {
                return i; // 找到第一个匹配项，返回起始下标
            }
        }
        return -1;
    }
}

