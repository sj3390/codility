package LongestPassword;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int solution(String S) {
        String[] passArray = S.split(" ");
        List<String> passList = Arrays.asList(passArray);
        passList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // TODO Auto-generated method stub
                if (o2.length() > o1.length())
                    return 1;
                else if (o2.length() < o1.length())
                    return -1;
                else
                    return 0;
            }
        });

        int result = passList.stream().filter(pass -> {
            char[] ch = pass.toCharArray();
            int numberCnt = 0;
            int alphabetCnt = 0;
            int wrongCharater = 0;
            for (char c : ch) {
                // number
                if (((byte) c) >= 48 && ((byte) c) <= 57) {
                    numberCnt++;
                }
                // alphabet
                else if (((byte) c) >= 65 && ((byte) c) <= 92) {
                    alphabetCnt++;
                } else if (((byte) c) >= 97 && ((byte) c) <= 122) {
                    alphabetCnt++;
                } else {
                    wrongCharater++;
                }

            }

            if (alphabetCnt % 2 == 0 && numberCnt % 2 == 1 && wrongCharater == 0) {
                return true;
            } else {
                return false;
            }
        }).findFirst().map(p -> p.length()).orElse(-1);

        return result;
    }
}
