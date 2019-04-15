package com.shit.demo_algorithm.dataStructure;

import com.alibaba.fastjson.JSONObject;

public class Stack {
    private int top;
    private Object[] s;

    public Stack(int n){
        this.top=-1;
        this.s = new Object[n];
    }

    public boolean isEmpty(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }
    public void push(Object key){
        if(top==s.length-1){
            //如果数组已经满了，需要重新扩充一个新数组
            Object[] tmpS=new Object[top+16];
            if(!isEmpty()) {
                for (int i = 0; i <= top; i++) {
                    tmpS[i] = s[i];
                }
            }
            s=tmpS;
        }
        s[++top]=key;
    }

    /*
    * 如果栈为空，那么返回null
    * */
    public Object pop(){
        if(isEmpty()){
            return null;
        }
        return s[top--];
    }

    /*返回栈顶元素*/
    public Object top(){
        return s[top];
    }

    public String toString(){
        return "s:"+size()+",top:"+top+JSONObject.toJSONString(this.s);
    }

    public int size(){
        return top+1;
    }
}
