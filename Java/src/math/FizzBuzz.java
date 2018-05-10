package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:33 2018/3/5
 * @ ModifiedBy:
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        String fizz = "Fizz";
        String buzz = "Buzz";
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i%3 + i%5 == 0) result.add(fizz+buzz);
            else if (i%3 == 0) result.add(fizz);
            else if (i%5 == 0) result.add(buzz);
            else result.add(Integer.toString(i));
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz f = new FizzBuzz();
        for (String s : f.fizzBuzz(n))
            System.out.println(s);
    }
}
