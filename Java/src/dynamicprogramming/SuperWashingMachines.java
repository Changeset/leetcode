package dynamicprogramming;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:14 2018/6/21
 * @ ModifiedBy:
 */
public class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        int total = 0;
        for (int i : machines) total += i;
        if (total % machines.length != 0) return -1;
        int avg = total / machines.length, cnt = 0, max = 0;
        for (int load : machines) {
            cnt += load - avg;
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] machines = {1,0,5};
        SuperWashingMachines s = new SuperWashingMachines();
        System.out.println(s.findMinMoves(machines));
    }
}
