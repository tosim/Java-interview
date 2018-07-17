package com.tosim.interview.designpartten.struction.composite;

/**
 * 将对象组合成树形结构以表示“部分-整体”关系，它使用户对单个对象和复合对象的使用具有一致性
 */
public class Test {

    public static void main(String[] args) {
        Tree tree = new Tree("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);
        System.out.println("build the tree finished!");
    }
}
