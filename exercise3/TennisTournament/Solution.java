package TennisTournament;

public class Solution {
    public int solution(int P, int C) {
        // write your code in Java SE 8
        int result = P/2;
        if (result > C) {
            result = C;
        }

        return result;
    }
}
