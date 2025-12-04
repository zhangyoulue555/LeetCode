package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

// 遇到数字入栈，遇到运算符将栈顶和栈顶的下一个元素出栈后进行运算并将该结果入栈
public class evalRPN_150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i]; // 按索引取出当前元素
            if ("+".equals(s)) {
                deque.push(deque.pop() + deque.pop());
            } else if ("-".equals(s)) {
                // 减法：后弹的数 - 先弹的数
                int num1 = deque.pop(); // 操作数
                int num2 = deque.pop(); // 被操作数
                deque.push(num2 - num1);
            } else if ("*".equals(s)) {
                deque.push(deque.pop() * deque.pop());
            } else if ("/".equals(s)) {
                int temp1 = deque.pop();
                int temp2 = deque.pop();
                deque.push(temp2 / temp1);
            } else {
                // 数字转整数入栈
                deque.push(Integer.valueOf(s));
            }
        }
        return deque.pop();

    }
}
