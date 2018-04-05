package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:36 2018/4/5
 * @ ModifiedBy:
 */
import java.util.Scanner;
public class Test1 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            long n = sc.nextInt();
            long m = sc.nextInt();
            long res = (n/(2*m)) * (m*m);
            System.out.println(res);
        }
}
