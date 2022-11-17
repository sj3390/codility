package FloodDepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static class Peak {
        Integer index;
        Integer level;

        public Peak(Integer index, Integer level) {
            this.index = index;
            this.level = level;
        }
    }

    public int solution(int[] A) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int leftMax = 0;
        for (int x = 0; x < A.length; x++) {
            if (A[x] > leftMax) {
                leftMax = A[x];
            }
            left.add(leftMax);
        }

        int rightMax = 0;
        for (int y = A.length - 1; y >= 0; y--) {
            if (A[y] > rightMax) {
                rightMax = A[y];
            }
            right.add(rightMax);
        }

        Collections.reverse(right);

        List<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int min = 0;
            if (left.get(i) < right.get(i)) {
                min = left.get(i);
            } else {
                min = right.get(i);
            }
            resultList.add(min - A[i]);
        }

        return resultList.stream().mapToInt(r -> r).max().orElse(0);
    }
}
