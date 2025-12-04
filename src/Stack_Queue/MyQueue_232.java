package Stack_Queue;

import java.util.Stack;

public class MyQueue_232 {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /** 构造方法：修正后（无返回值，与类名一致） */
    public MyQueue_232() { // 关键：去掉void，成为真正的构造方法
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackIn.push(x);
    }

    /** 出队操作：移除并返回队列的队首元素 */
    public int pop() {
        // 先调用辅助方法，确保出队栈有可用元素（无则从入队栈转移）
        dumpStackIn(); // 优化命名：驼峰法
        // 弹出出队栈的栈顶元素（即队列的队首元素）
        return stackOut.pop();
    }

    /** 查看队首操作：返回但不移除队列的队首元素 */
    public int peek() {
        // 先调用辅助方法，确保出队栈有可用元素（无则从入队栈转移）
        dumpStackIn();
        // 查看出队栈的栈顶元素（不弹出）
        return stackOut.peek();
    }

    /** 判断队列是否为空：只有入队栈和出队栈都为空时，队列才为空 */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 私有辅助方法：将入队栈的元素转移到出队栈（仅当出队栈为空时执行）
    private void dumpStackIn() { // 优化命名：驼峰法
        // 关键：如果出队栈不为空，直接返回（避免重复转移导致元素顺序混乱）
        if (!stackOut.isEmpty()) return;
        // 循环弹出入队栈的栈顶元素，压入出队栈，直到入队栈为空
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue_232 queue = new MyQueue_232();
        queue.push(1);
        queue.push(2);
        System.out.println("查看队首：" + queue.peek());  // 输出：查看队首：1
        System.out.println("出队：" + queue.pop());     // 输出：出队：1
        queue.push(3);
        System.out.println("出队：" + queue.pop());     // 输出：出队：2
        System.out.println("出队：" + queue.pop());     // 输出：出队：3
        System.out.println("队列是否为空：" + queue.empty()); // 输出：队列是否为空：true
    }
}
