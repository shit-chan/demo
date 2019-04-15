package com.shit.demo_algorithm.dataStructure;

public abstract class Queue {
    protected int font;
    protected int tail;

    public void push(Object one){

    }
    public Object pop(){
        return null;
    }
    public boolean isEmpty(){
        if(font>tail){
            return true;
        }else{
            return false;
        }
    }
}
