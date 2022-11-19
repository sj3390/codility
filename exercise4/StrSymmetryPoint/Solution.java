package StrSymmetryPoint;

public class Solution {

    /*
    Score 71% ...
     */
    public int solution(String S) {
        // write your code in Java SE 8
        int result = -1;

        if (S == null)
            return -1;

        if (S.isEmpty())
            return -1;

        if (S.length() == 1)
            return 0;

        if (S.length() % 2 == 0)
            return -1;

        if (S.length() > 2000000)
            return -1;

        int lastIdx = -1;
        char[] cArr = S.toCharArray();
        for (int i=0; i<cArr.length/2; i++) {
            if (cArr[i] == cArr[cArr.length - 1 - i]) {
                lastIdx = i;
            } else {
                break;
            }
        }

        if (lastIdx > -1) {
            result = lastIdx + 1;
        }

        return result;
    }
}
