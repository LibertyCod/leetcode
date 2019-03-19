package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Binbin Wang
 * @date 2018/10/29
 */
public class Test6 {


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int x1 = x;
        List<Integer> list = new ArrayList<>();
        for (;x1 > 0 ; x1 = x1 / 10) {
            int a = x1 % 10;
            list.add(a);
        }
        long result = 0;
        for (int j = 0; j < list.size(); j++) {
            result += list.get(j) * Math.pow(10, list.size() - 1 - j);
        }
        return result == x;
    }


}
