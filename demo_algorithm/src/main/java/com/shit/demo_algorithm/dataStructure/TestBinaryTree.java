package com.shit.demo_algorithm.dataStructure;

public class TestBinaryTree {
    public static void main(String[] args) {
        int[] a = {3,2,1,5,4,8,6,7,9,10};
        Tree binaryTree = new BinaryTree(a);
        binaryTree.delete(10);
        System.out.println(binaryTree);

        //根据后序遍历构造树
        System.out.println(binaryTree.getTreeByPreAfter("124769853"));
    }
}
