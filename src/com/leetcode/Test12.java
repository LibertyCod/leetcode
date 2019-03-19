package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Test12 {
    static Map<Integer, String> map = new HashMap<>(16);
    static {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>(16);
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        String ans = "";
        for (int i = 1; num > 0; num = num / 10, i = i * 10) {
            int k = num % 10 * i;
            String v = map.get(k);
            if (v != null) {
                ans = v + ans;
            } else if (k / i > 5) {
                for (int j = 0; j < k / i - 5; j++)
                    ans = map.get(i) + ans;
                ans = map.get(i * 5) + ans;
            } else {
                for (int j = 0; j < k / i; j++)
                    ans = map.get(i) + ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }

}
