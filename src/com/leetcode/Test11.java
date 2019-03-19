package com.leetcode;

import org.junit.Test;

public class Test11 {

    @Test
    public void test2() {
        System.out.println(isMatch("asdv", "a."));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    //如果是“*”，则判断是否重复0次还是重复多次（如果重复多次的话，还保证p[0:j]和s[0:i - 1]也能够匹配）
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    //如果不是“*”，则直接看对应的是否匹配, i = 0 是初始状态
                    dp[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

}
