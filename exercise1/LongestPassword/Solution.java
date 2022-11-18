package LongestPassword;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int solution(String S) {
        // 문자열 쪼개기
        String[] passArray = S.split(" ");
        List<String> passList = Arrays.asList(passArray);
        // 가장 긴 문자열이 가장 먼저 위치하도록 정렬
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

        // 조건에 부합하는 가장 첫번째 값을 반환 (아스키코드값으로 조건 검사)
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
