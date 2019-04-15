package com.shit.demo_algorithm.dataStructure;

import com.shit.demo_algorithm.dataStructure.common.NodeOfTree;

public abstract class Tree {
    protected NodeOfTree root;
    protected int height=0;
    protected int number=0;
    //前序遍历
    String traversalPre(){return String.valueOf(root.getKey());}
    //中序遍历
    String traversalMid(){return String.valueOf(root.getKey());}
    //后序遍历
    String traversalAfter(){return String.valueOf(root.getKey());}
    //层级遍历
    String traversalLevel(){return String.valueOf(root.getKey());}
    NodeOfTree search(int key){return root;}
    NodeOfTree min(){return root;}
    NodeOfTree max(){return root;}
    void insert(NodeOfTree node){}
    void delete(NodeOfTree node){}
    int getHeight(){return 0;};
}
