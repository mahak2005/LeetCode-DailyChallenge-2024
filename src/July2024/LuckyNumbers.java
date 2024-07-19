package July2024;
import  java.util.ArrayList;
import java.util.List;

public class LuckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] minA = new int[matrix.length];
        int[] maxA = new int[matrix[0].length];
        for (int i = 0; i < minA.length; i++) {
            minA[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < maxA.length; j++) {
            maxA[j] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < minA[i]) {
                    minA[i] = matrix[i][j];
                }
                if (matrix[i][j] > maxA[j]) {
                    maxA[j] = matrix[i][j];
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == minA[i] && matrix[i][j] == maxA[j]) {
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }

}
