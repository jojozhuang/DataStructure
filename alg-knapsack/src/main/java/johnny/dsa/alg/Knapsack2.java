package johnny.dsa.alg;

import java.util.Arrays;

/**
 * Backpack II
 *
 * There are n items and a backpack with size m. Given array A representing the size of each item and array V
 * representing the value of each item. What's the maximum value can you put into the backpack?
 *
 * A[i], V[i], n, m are all integers.
 * You can not split an item.
 * The sum size of the items you want to put into backpack can not exceed m.
 * Each item can only be picked up once
 *
 * Example
 * Example 1:
 * Input: m = 10, A = [2, 3, 5, 7], V = [1, 5, 2, 4]
 * Output: 9
 * Explanation: Put A[1] and A[3] into backpack, getting the maximum value V[1] + V[3] = 9
 *
 * Example 2:
 * Input: m = 10, A = [2, 3, 8], V = [2, 5, 8]
 * Output: 10
 * Explanation: Put A[0] and A[2] into backpack, getting the maximum value V[0] + V[2] = 10
 *
 * https://www.lintcode.com/problem/backpack-ii/
 */
public class Knapsack2 {
    public int knapsack21(int[] A, int[] V, int m) {
        int[][] dp = new int[A.length + 1][m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp[i]));
        }

        return dp[A.length][m];
    }

    public int knapsack22(int[] A, int[] V, int m) {
        // maximum size can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = m; j >= 0; j--) {
                if (j - A[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
            //System.out.println(Arrays.toString(dp));
        }

        return dp[m];
    }

    // set i = 0 instead of 1
    // move check "j - A[i - 1] >= 0" to for loop
    public int knapsack23(int[] A, int[] V, int m) {
        // maximum size can be filled for the every capacity
        int[] dp = new int[m + 1];

        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }

        return dp[m];
    }
}
