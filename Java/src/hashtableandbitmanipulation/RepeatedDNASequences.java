package hashtableandbitmanipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:15 2018/5/3
 * @ ModifiedBy:
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet();
        if (s == null || s.length() < 2)
            return new ArrayList();
        Set<String> temp = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String x = s.substring(i, i + 10);
            if (temp.contains(x)) {
                result.add(x);
            } else {
                temp.add(x);
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        RepeatedDNASequences r = new RepeatedDNASequences();
        System.out.println(r.findRepeatedDnaSequences(s));
    }
}
