package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//有效字符串需满足：
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//每个右括号都有一个对应的相同类型的左括号。
public class isValid_20 {

    class Solution {
        public boolean isValid(String s) {
            if (s.length() % 2 != 0) { // s 长度必须是偶数
                return false;
            }
            Map<Character, Character> mp = new HashMap<>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> st = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (!mp.containsKey(c)) { // c 是左括号
                    st.push(c); // 入栈
                } else if (st.isEmpty() || st.pop() != mp.get(c)) { // c 是右括号
                    return false; // 没有左括号，或者左括号类型不对
                }
            }
            return st.isEmpty(); // 所有左括号必须匹配完毕
        }
    }

}
