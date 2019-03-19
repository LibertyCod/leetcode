package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Binbin Wang
 * @date 2019/2/21
 */
public class Test8 {

    private static List<Caculate> caculates = new ArrayList<>();

    static {
        caculates.add(new Plus());
        caculates.add(new Multipart());
        caculates.add(new Substract());
        caculates.add(new Divide());
    }

    public static boolean to24(Integer[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (Caculate caculate : caculates) {
                    List<Integer> numList = new ArrayList<>(Arrays.asList(nums));
                    int val = caculate.caculate(numList.get(i), numList.get(j));
                    numList.remove(nums[i]);
                    numList.remove(nums[j]);
                    if (loop(val, new ArrayList<>(numList)) == 24)
                        return true;
                }
            }
        }
        return false;
    }

    public static int loop(int val, List<Integer> left) {
        Iterator<Integer> i = left.iterator();
        int num;
        while (i.hasNext()) {
            num = i.next();
            i.remove();
            for (Caculate caculate : caculates) {
                if (loop(caculate.caculate(val, num), new ArrayList<>(left)) == 24)
                    return 24;
            }
        }
        return val;
    }


    interface Caculate {
        int caculate(int x, int y);
    }

    static class Plus implements Caculate {

        @Override
        public int caculate(int x, int y) {
            return x + y;
        }
    }

    static class Multipart implements Caculate {

        @Override
        public int caculate(int x, int y) {
            return x * y;
        }
    }

    static class Divide implements Caculate {

        @Override
        public int caculate(int x, int y) {
            return x / y;
        }
    }

    static class Substract implements Caculate {

        @Override
        public int caculate(int x, int y) {
            return x - y;
        }
    }

    public static void main(String[] args) {
        System.out.println(to24(new Integer[]{2,6,8,10}));
    }
}
