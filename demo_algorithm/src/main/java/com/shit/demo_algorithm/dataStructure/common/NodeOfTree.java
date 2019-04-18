package com.shit.demo_algorithm.dataStructure.common;

public class NodeOfTree {
    private NodeOfTree parent;
    private NodeOfTree left;
    private NodeOfTree right;
    private int key;
    //红黑树：红色或者黑色
    private Color color;

    public NodeOfTree(){

    }
    public NodeOfTree(int key){
        this.key=key;
    }
    public NodeOfTree(char key){
        this.key=Integer.valueOf(key);
    }
    public String toString(){
//        return JSONObject.toJSONString(this);
        return String.valueOf(key);
    }
    public NodeOfTree getParent() {
        return parent;
    }

    public void setParent(NodeOfTree parent) {
        this.parent = parent;
    }

    public NodeOfTree getLeft() {
        return left;
    }

    public void setLeft(NodeOfTree left) {
        this.left = left;
    }

    public NodeOfTree getRight() {
        return right;
    }

    public void setRight(NodeOfTree right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
