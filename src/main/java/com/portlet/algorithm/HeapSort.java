package com.portlet.algorithm;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

/**
 * @author: 张新征
 * @date: 2018/4/11 下午6:09
 */
@Slf4j
public class HeapSort {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(5,3,2,7,9,1);
        sort(list);
        log.info("{}", list);
    }

    private static void sort(List<Integer> list){
        int n = list.size();
        for(int i=(n-2)/2; i>=0; i--){
            shiftDown(list, n, i);
        }
        for (int i=n-1; i>0; i--){
            swap(list, 0, i);
            shiftDown(list, i, 0);
        }
    }

    private static void shiftDown(List<Integer> list, int n, int k){
        int e = list.get(k);
        while (2*k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && list.get(j + 1) > list.get(j)) {
                j += 1;
            }
            if (e > list.get(j)) {
                break;
            }
            list.set(k, list.get(j));
            k = j;
        }
    }

    private static void swap(List<Integer> list, int a, int b){
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
