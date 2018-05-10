package strings;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:48 2018/3/27
 * @ ModifiedBy:
 */
public class Test3 {

    public static void main(String[] args) {
        String[] string = {
                "66666....666666666666...66666666666666666666666666",
                "6...6....6....6....66...66....6........66...66...6",
                "6...6....66666666666666666666666666....66666666666",
                "6...6....66........6....6....66...6....66...6....6",
                "66666....66666666666....66666666666....66666666666"
        };
        char[][] digit2string = new char[5][];
        for (int i = 0; i < 5; i++) {
            digit2string[i] = string[i].toCharArray();
        }
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (; n > 0; n--) {
            String str;
            str = sc.next();
            Stack<Long> stackDig = new Stack<>();
            List<Character> ope = new ArrayList<>();
            long sum = 0;
            long res = 0;
            char sign = '+';
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                char c = ch[i];
                if (c == '6') {
                    sum = sum * 10 + 6;
                }
                if (!Character.isDigit(c) || i == ch.length-1){
                    if (sign == '-') {
                        stackDig.push(-sum);
                    }
                    if (sign == '+') {
                        stackDig.push(sum);
                    }
                    if (sign == '*') {
                        stackDig.push(stackDig.pop() * sum);
                    }
                    sign = c;
                    sum = 0;
                }
            }
            for (long i : stackDig) {
                res += i;
            }
            List<Integer> list = new ArrayList<>();
            long result = Math.abs(res);
            while (result > 0) {
                int d = (int) (result % 10);
                list.add(d);
                result = result / 10;
            }
            Collections.reverse(list);
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < list.size(); j++) {
                    int k = 0;
                    for (; k < 5; k++) {
                        System.out.print(digit2string[i][list.get(j) * 5 + k]);
                    }
                    System.out.print(j + 1 == list.size() ? "\n" : "..");
                }
            }
        }
    }
}
