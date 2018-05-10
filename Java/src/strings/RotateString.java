package strings;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:32 2018/3/11
 * @ ModifiedBy:
 */
public class RotateString {
    public boolean rotateString(String A, String B) {
        char[] ah = A.toCharArray();
        char[] bh = B.toCharArray();
        if (A == null || B == null) return A == B;
        for (int i = 0; i < A.length(); i++) {
            char[] a = A.toCharArray();
            char[] temp = rotateString(a, i);
            if (isEqual(bh, temp)) return true;
        }
        return false;
    }

    public boolean isEqual(char[] a, char[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public char[] rotateString(char[] A, int offset) {
        if(null == A || A.length == 0) return A;
        offset = offset % A.length;
        for(int i  = 0; i < A.length/2; i++) {//整个字符串翻转
            char c = A[i];
            A[i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = c;
        }
        for(int i = 0; i < offset/2; i++) {//offset部分翻转
            char c = A[i];
            A[i] = A[offset - 1 - i];
            A[offset - 1 - i] = c;
        }
        for(int i = 0; i < (A.length - offset + 1)/2; i++) {//剩余部分翻转
            char c = A[offset + i];
            A[offset + i] = A[A.length - 1 - i];
            A[A.length - 1 - i] = c;
        }
        return A;
    }

    public char[] rotateString2(char[] A, int offset) {
        char[] temp = new char[A.length];
        int n = A.length;
        for (int i = 0; i < n; i++) {
            temp[i] = A[(i+n-offset)%n];
        }
        return temp;
    }

    public static void main(String[] args) {
        String A = "clrwmpkwru";
        String B = "wmpkwruclr";
        RotateString a = new RotateString();
        char[] ch = A.toCharArray();
        char[] h = A.toCharArray();
        System.out.println(a.rotateString(ch, 3));
        System.out.println(a.rotateString2(h, 3));
        System.out.println(a.rotateString(A,B));
    }
}
