package com.portlet.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/11 下午6:09
 */
@Slf4j
public class HeapSort {
    public static void main(String[] args){
        int[] arr = {8,2,9,10,5,3,7};
        sort(arr);
        log.info("{}", arr);
    }

    private static void sort(int[] arr){
        int n = arr.length;
        for(int i=(n-2)/2; i>=0; i--){
            shiftDown(arr, n, i);
        }
        log.info("{}", arr);
        for (int i=n-1; i>0; i--){
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(int[] arr, int n, int k){
        int e = arr[k];
        while (2*k+1 < n){
            int j = 2 * k + 1;
            if(j+1 < n && arr[j] < arr[j+1]){
                j += 1;
            }
            if(arr[j] < e){
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
