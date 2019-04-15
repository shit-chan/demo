package com.shit.demo_algorithm.dataStructure;

import com.shit.demo_algorithm.dataStructure.common.NodeOfTree;

public class BinaryTree extends Tree {

    public BinaryTree() {

    }

    public BinaryTree(NodeOfTree root) {
        this.root = root;
        number++;
        height++;
    }

    public BinaryTree(int[] a){
        for(int i=0;i<a.length;i++){
            insert(new NodeOfTree(a[i]));
        }
    }

    @Override
    public NodeOfTree search(int key) {
        NodeOfTree x = root;
        while (x != null && key != x.getKey()) {
            if (key < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        return x;
    }

    @Override
    public NodeOfTree min() {
        if (root == null) {
            return root;
        }
        NodeOfTree x = root;
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

    @Override
    public NodeOfTree max() {
        if (root == null) {
            return root;
        }
        NodeOfTree x = root;
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

    @Override
    public void insert(NodeOfTree node) {
        number++;
        if (root == null) {
            root = node;
            return;
        }
        NodeOfTree x = root;
        //用来存放
        NodeOfTree y = null;
        int key = node.getKey();
        while (x != null) {
            y = x;
            if (key < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        node.setParent(y);
        if (key < y.getKey()) {
            y.setLeft(node);
        } else {
            y.setRight(node);
        }
    }


    public void delete(int key){
        NodeOfTree nodeKey = search(key);
        if (nodeKey == null) {
            //找不到key
            return;
        }
        number--;

        if (nodeKey.getRight() == null) {
            //要删除的节点没有右孩子
            changeNode(nodeKey, nodeKey.getLeft());
        } else if (nodeKey.getLeft() == null) {
            //删除的节点没有左孩子
            changeNode(nodeKey, nodeKey.getRight());
        } else {
            /*如果要删除的节点有左右两个孩子节点，那么情况就需要仔细分析一下，
            思路是左孩子不用动，从右孩子中找到key值最小的值（由于它是最小值，所以它一定是没有左孩子了），
            接下来分两种情况，如果这个最小值是删除节点的后继，那么需要将最小值和删除的节点替换，注意需要给最小值补上删除节点的左孩子
            如果这个最小值不是删除节点的后继，那么就需要将它右孩子替换它自己，然后将最小值和删除的节点替换，注意要给最小值补上删除节点的左右孩子
            */
            //1、从右孩子中找到key值最小的值
            NodeOfTree x = nodeKey.getRight();
            while (x.getLeft() != null) {
                x = x.getLeft();
            }
            //2、将它的右孩子替换它自己
            if (nodeKey != x.getRight()) {
                changeNode(x, x.getRight());
                x.setRight(nodeKey.getRight());
                x.getRight().setParent(x);
            }
            //3、将它替换要删除的节点
            changeNode(nodeKey, x);
            x.setLeft(nodeKey.getLeft());
            x.getLeft().setParent(x);
        }
    }

    @Override
    public void delete(NodeOfTree node) {
        int key = node.getKey();
        delete(key);
    }

    //交换nodeKey和one
    private void changeNode(NodeOfTree nodeKey, NodeOfTree one) {
        //如果是叶子节点，直接将它的父节点设置为null
        if (one != null) {
            one.setParent(nodeKey.getParent());
        }
        if (nodeKey.getParent().getLeft() == nodeKey) {
            nodeKey.getParent().setLeft(one);
        } else {
            nodeKey.getParent().setRight(one);
        }
    }

    /*前序遍历：根-左-右
     * 从根节点开始，先输出根节点，然后插入栈中，一直往左遍历，到没有左孩子之后，从栈弹出，处理右孩子
     * 有两个临界点，第一个是整个循环当栈为空并且节点为null的时候结束，第二个是节点为null之后要从栈弹出*/
    @Override
    public String traversalPre() {
        StringBuilder sb = new StringBuilder();
        Stack s = new Stack(10);
        NodeOfTree x = root;
        while (!s.isEmpty() || x != null) {
            if (x != null) {
                sb.append(x);
                s.push(x);
                x = x.getLeft();
            } else {
                x = (NodeOfTree) s.pop();
                x = x.getRight();
            }
        }
        return sb.toString();
    }

    /*中序遍历：左-根-右
     * 和前序规则一样，不同点是前序是是如栈前输出节点，而中序是在弹出栈时输出节点*/
    @Override
    public String traversalMid() {
        StringBuilder sb = new StringBuilder();
        Stack s = new Stack(10);
        NodeOfTree x = root;
        while (!s.isEmpty() || x != null) {
            if (x != null) {
                s.push(x);
                x = x.getLeft();
            } else {
                x = (NodeOfTree) s.pop();
                sb.append(x);
                x = x.getRight();
            }
        }
        return sb.toString();
    }

    /*后序遍历：左-右-根
     * 这个比较复杂一点，需要栈可以返回栈顶元素而不弹出栈
     * 因为要用这个栈顶元素来做一个判断：如果节点没有右孩子，或者右孩子已经输出过的节点，那么就将这个节点输出
     * 一开始我想到的是，要判断节点的右孩子为空的时候，再弹栈输出，但是这样会导致死循环，
     * 所以得增加一个保存最新输出节点的变量，用来判断如果节点的右孩子是最新的输出节点，那么即使节点有右孩子，也要弹栈输出*/
    @Override
    public String traversalAfter() {
        StringBuilder sb = new StringBuilder();
        Stack s = new Stack(10);
        Stack sp = new Stack(10);
        NodeOfTree x = root;
        //计算树高
        int h=0;
        //接受栈顶元素
        NodeOfTree lastVisit = root;
        while (!s.isEmpty() || x != null) {
            if (x != null) {
                s.push(x);
                x = x.getLeft();
            } else {
                x = (NodeOfTree) s.top();
                if (x.getRight() == null || x.getRight() == lastVisit) {
                    if(h<s.size()){
                        h=s.size();
                    }
                    x = (NodeOfTree) s.pop();
                    sb.append(x);
                    lastVisit = x;
                    x = null;
                } else {
                    x = x.getRight();
                }
            }
        }
        while (!sp.isEmpty()) {
            sb.append(sp.pop());
        }
        height=h;
        return sb.toString();
    }

    /*层级遍历，利用队列，出队然后再找它的孩子节点入队*/
    @Override
    public String traversalLevel() {
        StringBuilder sb = new StringBuilder();
        Queue q = new ArrayQueue(10);
        NodeOfTree x = root;
        //树高
        int h=0;
        q.push(x);
        while (!q.isEmpty()) {
            h++;
            int size=((ArrayQueue) q).size();
            for(int i=0;i<size;i++){
                x = (NodeOfTree) q.pop();
                sb.append(x);
                if (x.getLeft() != null) {
                    q.push(x.getLeft());
                }
                if (x.getRight() != null) {
                    q.push(x.getRight());
                }
            }
        }
        height=h;
        return sb.toString();
    }
    @Override
    public int getHeight(){
        //求树高
        //后续遍历求树高:由于是左-右️-根，栈中保存的是根，在每一次弹出的时候，比较栈大小，最大栈就是树高
        traversalAfter();
        //层次遍历求树高：每一个循环开始的时，队列中保存的都是将要访问的下一层的所有元素
        traversalLevel();
        return height;
    }

    /*根据后序遍历构造树
     逆序输出后序遍历，然后调用insert方法*/
    public BinaryTree getTreeByPreAfter(String after) {
        BinaryTree binaryTree = new BinaryTree();
        char[] a = after.toCharArray();
        int root;
        for(int i=a.length-1;i>=0;i--){
            root = a[i]-48;
            NodeOfTree node = new NodeOfTree(root);
            binaryTree.insert(node);
        }
        return binaryTree;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("树根："+root+"\n");
        sb.append("树的总元素：" + number+"\n");
        sb.append("树高:" + getHeight()+"\n");
        sb.append("前序遍历：" + traversalPre()+"\n");
        sb.append("中序遍历：" + traversalMid()+"\n");
        sb.append("后序遍历：" + traversalAfter()+"\n");
        sb.append("层次遍历：" + traversalLevel());
        return sb.toString();
    }
}
