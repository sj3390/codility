package FirstUnique;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int result = -1;
        Map<Integer, Long> map = Arrays.stream(A).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for(int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                // System.out.println("i : " + i + ", A[i] count : (" + A[i] + ") " + map.get(A[i]));
                if (map.get(A[i]) == 1) {
                    result = A[i];
                    break;
                }
            } else {
                result = -1;
                break;
            }
        }
        return result;
    }
}
