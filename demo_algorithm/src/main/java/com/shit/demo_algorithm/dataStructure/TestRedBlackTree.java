package com.shit.demo_algorithm.dataStructure;

public class TestRedBlackTree {
    public static void main(String[] args) {
        int[] a = {11,2,14,1,7,15,5,8,4};
        Tree binaryTree = new RedBlackTree(a);
//        binaryTree.delete(10);
        System.out.println(binaryTree);

        //根据后序遍历构造树
//        System.out.println(binaryTree.getTreeByPreAfter("124769853"));
    }
}
