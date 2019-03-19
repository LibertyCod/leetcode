package com.leetcode;

public class Test9 {

    public static void main(String[] args) {
        int[] ans = fairCandySwap(new int[]{35, 17, 4, 24, 10}, new int[]{63, 21});
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int totalA = 0;
        int totalB = 0;
        for (int a : A) {
            totalA += a;
        }

        for (int b : B) {
            totalB += b;
        }

        int i = 0;
        int j = 0;
        while (true) {
            int tempA = totalA - A[i] + B[j];
            int tempB = totalB - B[j] + A[i];
            if (tempA == tempB){
                System.out.println(A[i]);
                break;
            }


            if (i < A.length - 1) {
                i++;
                continue;
            }
            if (j < B.length - 1) {
                j++;
                i = 0;
                continue;
            }
            break;
        }
        return new int[]{A[i], B[j]};
    }
}
