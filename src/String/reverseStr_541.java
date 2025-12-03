package String;

import java.util.Scanner;

// 每隔k个反转k个，末尾不够k个时全部反转；
public class reverseStr_541 {

    public static String reverseStr(String s, int k) {

        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();  // 读取字符串s
        int k = scanner.nextInt();     // 读取整数k
        scanner.close();  // 关闭输入流（可选）

        // 调用算法方法并输出结果
        String result = reverseStr(s, k);
        System.out.println(result);
    }
}
