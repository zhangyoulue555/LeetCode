package String;

import java.util.Scanner;

// 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
public class reverseString_344 {
    // 双指针
    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        // 读取输入字符串
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();  // 关闭输入流

        // 转换为字符数组，调用反转方法
        char[] s = input.toCharArray();
        reverseString(s);

        // 输出反转后的结果
        System.out.println(new String(s));
    }


}
