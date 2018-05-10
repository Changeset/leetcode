package arrays;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:00 2018/3/17
 * @ ModifiedBy:
 */
public class FindFriendRequest {
    public int findRequest(int[] ages) {
        int n = ages.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    if (ages[j] <= (ages[i]/2 + 7))
                        continue;
                    if (ages[j] > ages[i])
                        continue;
                    if (ages[j] < 100 && ages[i] > 100)
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ages={10,39,50};
        FindFriendRequest f = new FindFriendRequest();
        System.out.println(f.findRequest(ages));
    }
}
