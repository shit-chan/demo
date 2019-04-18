package com.shit.demo_algorithm.dataStructure;

import com.shit.demo_algorithm.dataStructure.common.Color;
import com.shit.demo_algorithm.dataStructure.common.NodeOfTree;

public class RedBlackTree extends BinaryTree {

    //黑高：指的是从叶子节点开始数（叶子节点的黑高是0），沿着路径，如果节点是黑色，那么黑高加1
    private int blackHeigh;

    public RedBlackTree(int[] a){
        for(int i=0;i<a.length;i++){
            NodeOfTree node=new NodeOfTree(a[i]);
            node.setColor(Color.Red);
            insert(node);
        }
    }
    @Override
    public void insert(NodeOfTree node) {
        super.insert(node);
        node.setColor(Color.Red);
        fixup(node);
    }

    private void fixup(NodeOfTree node){
        NodeOfTree x = node;
        NodeOfTree y;
        root.setColor(Color.Black);
        if(node.getParent()==null||node.getParent().getColor().equals(Color.Black)){
            //如果node是根节点或者它的父节点是黑色，直接返回
            return;
        }
        while(x.getParent()!=null&&x.getParent().getColor().equals(Color.Red)) {
            if (x.getParent() == x.getParent().getParent().getLeft()) {
                //插入节点的父节点是个左孩子
                //先拿到叔节点，判断叔叔节点的颜色
                y = x.getParent().getParent().getRight();
                if (y.getColor().equals(Color.Red)) {
                    //第一种情况，叔节点是红色的，父节点和叔叔节点一起染黑，指针指向祖父节点
                    x.getParent().setColor(Color.Black);
                    y.setColor(Color.Black);
                    x.getParent().getParent().setColor(Color.Red);
                    x = x.getParent().getParent();
                } else if (x.getParent().getRight()==x) {
                    x=x.getParent();
                    leftRotarion(x);
                }else{
                    x.getParent().setColor(Color.Black);
                    x.getParent().getParent().setColor(Color.Red);
                    rightRotarion(x.getParent().getParent());
                }
            } else {
                //插入节点的父节点是个右孩子的情况和左孩子的情况差不多，只是左右互换
                //插入节点的父节点是个左孩子
                //先拿到叔节点，判断叔叔节点的颜色
                y = x.getParent().getParent().getLeft();
                if (y.getColor().equals(Color.Red)) {
                    //第一种情况，叔节点是红色的，父节点和叔叔节点一起染黑，指针指向祖父节点
                    x.getParent().setColor(Color.Black);
                    y.setColor(Color.Black);
                    x.getParent().getParent().setColor(Color.Red);
                    x = x.getParent().getParent();
                } else if (x.getParent().getRight()==x) {
                    x=x.getParent();
                    leftRotarion(x);
                }else{
                    x.getParent().setColor(Color.Black);
                    x.getParent().getParent().setColor(Color.Red);
                    rightRotarion(x.getParent().getParent());
                }
            }
        }
    }

    //对x进行左旋
    private void leftRotarion(NodeOfTree x){
        NodeOfTree y=x.getRight();
        x.setRight(y.getLeft());
        if(y.getLeft()!=null) {
            y.getLeft().setParent(x);
        }
        y.setParent((x.getParent()));
        if(x.getParent()!=null) {
            if (x.getParent().getLeft().equals(x)) {
                x.getParent().setLeft(y);
            } else {
                x.getParent().setRight(y);
            }
        }else{
            root=y;
        }
        y.setLeft(x);
        x.setParent(y);
    }
        
        

    //对node进行右旋
    private void rightRotarion(NodeOfTree y){
        NodeOfTree x=y.getLeft();
        y.setLeft(x.getRight());
        if(x.getRight()!=null) {
            x.getRight().setParent(y);
        }
        x.setParent((y.getParent()));
        if(y.getParent()!=null) {
            if (y.getParent().getLeft().equals(y)) {
                y.getParent().setLeft(x);
            } else {
                y.getParent().setRight(x);
            }
        }else{
            root=x;
        }
        x.setRight(y);
        y.setParent(x);
    }

    @Override
    public void delete(NodeOfTree node) {
        super.delete(node);
    }
    public int getBlackHeigh() {
        return blackHeigh;
    }

    public void setBlackHeigh(int blackHeigh) {
        this.blackHeigh = blackHeigh;
    }

}
