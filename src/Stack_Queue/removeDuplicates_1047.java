package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
// 入栈，判断入栈的字符是否和栈顶字符重复，重复就直接把栈顶元素弹出，不重复就入栈
public class removeDuplicates_1047 {

    public String removeDuplicates(String s) {

        // Deque是Java官方推荐的栈实现方式。
        // ArrayDeque：是Deque接口的常用实现类，
        // 基于动态数组实现（而非链表），没有容量限制
        Deque<Character> deque = new ArrayDeque<>();
        // 遍历字符串，处理相邻重复字符
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            // 栈空 或 栈顶元素与当前字符不同 → 入栈
            if (deque.isEmpty()||deque.peek()!=c){
                deque.push(c);

            }else {
                // 栈顶与当前字符相同 → 弹出栈顶（移除重复）
                deque.pop();
            }

        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.pop() + str;
        }
        return str;
    }
}
