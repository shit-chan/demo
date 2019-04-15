package com.shit.demo_algorithm.dataStructure;

import com.alibaba.fastjson.JSONObject;
import com.shit.demo_algorithm.dataStructure.common.DataUtil;

public class ArrayQueue extends Queue{
    private Object[] q;

    public ArrayQueue(int n){
        this.font=0;
        this.tail=-1;
        this.q=new Object[n];
    }
    @Override
    public void push(Object one){
        if(tail==q.length-1){
            //数组到尽头，需要扩充数组
            resize();
        }
        q[++tail]=one;
    }

    private void resize() {
        Object[] tmpS=new Object[tail+16];
        if(!isEmpty()) {
            for (int i = 0, j = font; i <= tail - font && j <= tail; i++, j++) {
                tmpS[i] = q[j];
            }
            tail=tail-font;
            font=0;
        }
        q=tmpS;
    }

    @Override
    public Object pop(){
        if(font<=tail){
            return q[font++];
        }else{
            return null;
        }

    }
    public String toString(){
        return "s:"+size()+",font:"+font+",tail:"+tail+JSONObject.toJSONString(this.q);
    }
    public int size(){
        return tail-font+1;
    }
}
