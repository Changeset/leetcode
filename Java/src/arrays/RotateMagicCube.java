package arrays;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:39 2018/3/18
 * @ ModifiedBy:
 */
public class RotateMagicCube {
    public void getResult() {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        char[][][] result = new char[n][2][];
        int i = 0, j = 0;
        while (i < n) {
            j = 0;
            StringBuilder sb = new StringBuilder();
            while (j < 3) {
                sb.append(s.nextLine());
                result[i][0] = sb.toString().toCharArray();
                j++;
            }
            while (3 <= j && j < 6) {
                sb.append(s.nextLine());
                result[i][1] = sb.toString().toCharArray();
                j++;
            }
            if (s.nextLine().isEmpty()) continue;
        }
        for (int k = 0; k < n; k++) {
            System.out.println(minOperation(result[k][0], result[k][1]));
        }
    }

    public int minOperation(char[] source, char[] dest) {
        Queue<String> queue = new LinkedList<>();
        String s = new String(source);
        queue.offer(s);
        Map<String, Integer> map = new HashMap<>();
        map.put(s, 0);
        String target = new String(dest);
        boolean found = false;
        int step = 0;
        while (!queue.isEmpty()) {
            String state = queue.poll();
            step = map.get(state);
            int[] rotate = new int[]{0, 1, 3, 4};
            for (int i = 0; i < 4; i++) {
                char[] c_state = state.toCharArray();
                rotate90(c_state, rotate[i]);
                String state90 = new String(c_state);
                if (state90.equals(target)) {
                    found = true;
                    break;
                } else {
                    if (!map.containsKey(state90)) {
                        queue.offer(state90);
                        map.put(state90, step + 1);
                    }
                }
                c_state = state.toCharArray();
                rotate180(c_state, rotate[i]);
                String state180 = new String(c_state);
                if (state180.equals(target)) {
                    found = true;
                    break;
                } else {
                    if (!map.containsKey(state180)) {
                        queue.offer(state180);
                        map.put(state180, step + 1);
                    }
                }
                c_state = state.toCharArray();
                rotate270(c_state, rotate[i]);
                String state270 = new String(c_state);
                if (state270.equals(target)) {
                    found = true;
                    break;
                } else {
                    if (!map.containsKey(state270)) {
                        queue.offer(state270);
                        map.put(state270, step + 1);
                    }
                }
                if (found) return step + 1;
            }
        }
        return found ? step + 1 : -1;
    }

    public void rotate90(char[] state, int i) {
        char temp = state[i+3];
        state[i+3] = state[i+4];
        state[i+4] = state[i+1];
        state[i+1] = state[i];
        state[i] = temp;
    }

    public void rotate180(char[] state, int i) {
        char temp = state[i];
        state[i] = state[i+4];
        state[i+4] = temp;
        temp = state[i+1];
        state[i+1] = state[i+3];
        state[i+3] = temp;
    }

    public void rotate270(char[] state, int i) {
        char temp = state[i];
        state[i] = state[i+1];
        state[i+1] = state[i+4];
        state[i+4] = state[i+3];
        state[i+3] = temp;
    }

    public static void main(String[] args) {
        RotateMagicCube r = new RotateMagicCube();
        String s1 = "123456789";
        String s2 = "541623789";
        System.out.println(r.minOperation(s1.toCharArray(), s2.toCharArray()));
    }
}
