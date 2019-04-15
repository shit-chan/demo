package com.shit.demo_algorithm.dataStructure;

import com.alibaba.fastjson.JSONObject;

public class TestStackAndQueue {
    public static void main(String[] args){
        Queue q= new ArrayQueue(0);
        Stack s= new Stack(0);
        System.out.println(q.isEmpty());
        System.out.println(s.isEmpty());
        for(int i=0;i<30;i++){
            q.push(i);
            s.push(i);
        }
        System.out.println("q:"+q);
        System.out.println("s:"+s);
        System.out.println(q.pop());
        System.out.println(s.pop());
        System.out.println("q:"+q);
        System.out.println("s:"+s);
        System.out.println(q.isEmpty());
        System.out.println(s.isEmpty());
        q.push(30);
        System.out.println("q:"+q);
        q.push(31);
        System.out.println("q:"+q);
        s.push(30);
        System.out.println("s:"+s);
        s.push(31);
        s.push(32);
        System.out.println("s:"+s);
        System.out.println(q.pop());
        System.out.println(q);
        System.out.println(s.pop());
        System.out.println(s);
    }
}
