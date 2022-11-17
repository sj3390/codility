package FloodDepth;

public class FloodDepth {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] A = { 1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2 };
        // int[] A = { 1, 2, 1, 2, 1, 6, 4, 3, 2, 5, 4, 1 };
        int[] A = { 1, 2, 1, 2 };
        int result = solution.solution(A);
        System.out.println("result : " + result);
    }
}
