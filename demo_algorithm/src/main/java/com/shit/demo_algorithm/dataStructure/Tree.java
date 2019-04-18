package com.shit.demo_algorithm.dataStructure;

import com.shit.demo_algorithm.dataStructure.common.NodeOfTree;

public abstract class Tree {
    protected NodeOfTree root;
    protected int height=0;
    protected int number=0;
    //前序遍历
    abstract String traversalPre();
    //中序遍历
    abstract String traversalMid();
    //后序遍历
    abstract String traversalAfter();
    //层级遍历
    abstract String traversalLevel();
    abstract NodeOfTree search(int key);
    abstract NodeOfTree min();
    abstract NodeOfTree max();
    abstract void insert(NodeOfTree node);
    abstract void delete(NodeOfTree node);
    abstract void delete(int key);
    abstract int getHeight();
    abstract Tree getTreeByPreAfter(String after);
}
