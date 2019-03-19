package com.leetcode;

import org.junit.Test;

public class Test10 {

    @Test
    public void test1() {
        System.out.println(muAtoi(" b3-2"));
    }

    public int muAtoi(String str) {
        if (str == null || str.length() == 0 || str.equals("+") || str.equals("-"))
            return 0;
        int offset = 0;
        String ans = "";
        boolean hasSign = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
                if (('0' <= ch && ch <= '9') || !hasSign && (ch == '-' || ch == '+')) {
                    ans = ans.concat(new Character(ch).toString());
                    hasSign = true;
                    offset = -1;
                } else {
                    if (offset == -1)
                        break;
                    offset++;
                }
        }
        try {
            if (ans.equals("") || ans.equals("-") || ans.equals("+") || ((ans.contains("+")) &&ans.contains("-")))
                return 0;
            return Integer.parseInt(ans);
        }catch (NumberFormatException e) {
            if (ans.startsWith("-"))
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
    }

    private boolean isEffective(char ch) {
        if ('0' < ch && ch < '9')
            return true;
        return false;
    }

}
