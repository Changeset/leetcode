package strings;

import java.util.Scanner;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:11 2018/3/15
 * @ ModifiedBy:
 */
public class CharacterMove {
    public static String move(char[] str) {
        int n = str.length;
        for (int i = n - 1; i >= 0; i--) {
            if (Character.isUpperCase(str[i])) {
                char temp = str[i];
                int j = i + 1;
                while (j != n && Character.isLowerCase(str[j])) {
                    str[j - 1] = str[j];
                    ++j;
                }
                str[j-1] = temp;
            }
        }
        return new String(str);
    }

    public static void getMove() {
        Scanner scan  = new Scanner(System.in);
        while (scan.hasNext()) {
            String s = scan.nextLine();
            System.out.println(move(s.toCharArray()));
            System.out.println(getResult(s));
        }
    }

    public static String getResult(String str) {
        return str.replaceAll("[A-Z]", "") + str.replaceAll("[a-z]", "");
    }

    public static void main(String[] args) {
        getMove();
    }
}
