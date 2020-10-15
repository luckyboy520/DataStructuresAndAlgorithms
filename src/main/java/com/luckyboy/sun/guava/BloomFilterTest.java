package com.luckyboy.sun.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @description:
 * @author: LuckyBoy
 * @create: 2020-09-28 15:03
 **/
public class BloomFilterTest {
    private static int total = 1000000;
    private static BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), total);

    public static void main(String[] args) {
        for(int i = 0; i< total;i++) {
            bf.put(i);
        }

        for(int i=0;i<total;i++) {
            if(!bf.mightContain(i)) {
                System.out.println("有坏人逃跑啦");
            }
        }

        int count=0;
        for(int i=total;i< total+100000;i++) {
            if(bf.mightContain(i)) {
                count++;
            }
        }
        System.out.println("误伤的数量：" + count);
    }
}
