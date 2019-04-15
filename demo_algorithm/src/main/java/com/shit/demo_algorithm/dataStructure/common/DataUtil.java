package com.shit.demo_algorithm.dataStructure.common;

public class DataUtil {
    /*扩充一个数组*/
    public static Object[] resize(Object[] a,int n){
        Object[] tmpS=new Object[n];
        Object[] b= new Object[3];
        for (int i=0;i<a.length;i++){
            tmpS[i]=a[i];
        }
        return tmpS;
    }
}
