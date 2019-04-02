package com.shit.demothread;

import java.math.BigDecimal;
import java.util.Random;
import java.util.*;

public class MyTest {
    private final static Random random = new Random();
    public static void main(String[] args){
        System.out.println(random.nextInt(10));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(UUID.randomUUID().toString().length());
        BigDecimal bd = new BigDecimal("0.1");
        BigDecimal dd = new BigDecimal("10");
        System.out.println(bd.max(dd));
        Comparator c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1<o2?-1:(o1==o2?0:1);
            }
        };
        System.out.println(c.compare(new Integer(3),new Integer(3)));
        long sum = 0L;
        for(long i=0;i<Integer.MAX_VALUE;i++){
            sum+=i;
        }
        System.out.println(sum);
    }



}
