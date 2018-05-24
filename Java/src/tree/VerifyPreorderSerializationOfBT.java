package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 19:19 2018/5/23
 * @ ModifiedBy:
 */
public class VerifyPreorderSerializationOfBT {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        VerifyPreorderSerializationOfBT v = new VerifyPreorderSerializationOfBT();
        System.out.println(v.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
