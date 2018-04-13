package com.portlet.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: 张新征
 * @date: 2018/4/11 下午5:35
 */
@Slf4j
public class Merge {

    public static void main(String[] args){
        int[] a = {1,2,3,4};
        int[] b = {2,3,5,7,8};
        int length = a.length + b.length;
        int[] result = new int[length];
        int a1=0,b1=0;
        for (int i=0; i<length; i++){
            //数组a元素全部处理完毕
            if(a1 > a.length-1){
                result[i] = b[b1];
                b1++;
            //数组b元素处理完毕
            }else if(b1 > b.length-1){
                result[i] = a[a1];
                a1++;
            //a中的元素小于b中的元素
            }else if(a[a1] <= b[b1]){
                result[i] = a[a1];
                a1++;
            //b中的元素小于a中的元素
            }else{
                result[i] = b[b1];
                b1++;
            }
        }
        log.info("{}", result);
    }
}
