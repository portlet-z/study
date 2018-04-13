package com.portlet.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/12 下午2:57
 */
@Slf4j
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {5,4,3,7,9,1,8,2,0};
        int l=0, r=arr.length-1;
        sort(arr, l, r);
        log.info("{}", arr);
    }

    private static void sort(int[] arr, int l, int r){
        if(l >= r){
            return;
        }
        int partition = partition(arr, l, r);
        sort(arr, l, partition-1);
        sort(arr, partition+1, r);
    }

    private static int partition(int[] arr, int l, int r){
        int e = arr[l];
        int j = l;
        for (int i=l+1; i<=r; i++){
            if(arr[i] < e){
            }else {
                swap(arr, i, j);
                j++;
            }
        }
        return j;
    }

    private static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
