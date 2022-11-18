package FloodDepth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int solution(int[] A) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // 왼쪽 방향에서부터 계산한 해수면 높이
        int leftMax = 0;
        for (int x = 0; x < A.length; x++) {
            if (A[x] > leftMax) {
                leftMax = A[x];
            }
            left.add(leftMax);
        }

        // 오른쪽 방향에서부터 계산한 해수면 높이
        int rightMax = 0;
        for (int y = A.length - 1; y >= 0; y--) {
            if (A[y] > rightMax) {
                rightMax = A[y];
            }
            right.add(rightMax);
        }

        // 순서 뒤집기
        Collections.reverse(right);

        List<Integer> resultList = new ArrayList<>();

        // 각각 계산한 해수면 높이중 최소값을 추출하고 그 값을 이용하여 깊이값을 계산한다.
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
