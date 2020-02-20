package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 走棋盘 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[][] dp = new int[n + 1][m + 1];
            dp[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j <= m; j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
