package com.shit.demo_algorithm.dataStructure.common;

/*
* 红黑树的节点
* */
public class NodeOfRedBlackTree extends NodeOfTree {
    //红色或者黑色
    private Color color;
    //黑高：指的是从叶子节点开始数（叶子节点的黑高是0），沿着路径，如果节点是黑色，那么黑高加1
    private int blackHeigh;

    public int getBlackHeigh() {
        return blackHeigh;
    }

    public void setBlackHeigh(int blackHeigh) {
        this.blackHeigh = blackHeigh;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
