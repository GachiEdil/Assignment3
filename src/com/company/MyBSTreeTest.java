package com.company;

public class MyBSTreeTest {
    public static void main(String[] args){
        Node rootprava = null;
        MyBSTree bst = new MyBSTree();
        rootprava = bst.insert(rootprava, 75);
        rootprava = bst.insert(rootprava, 23);
        rootprava = bst.insert(rootprava, 43);
        rootprava = bst.insert(rootprava, 46);
        rootprava = bst.insert(rootprava, 53);
        rootprava = bst.insert(rootprava, 58);
        rootprava = bst.insert(rootprava, 69);
        System.out.printf("\nFirst Tree\n");
        bst.inorder(rootprava);

        rootprava = bst.deleteNode(rootprava, 75);
        rootprava = bst.deleteNode(rootprava, 69);
        System.out.printf("\nSecond Tree\n");
        bst.inorder(rootprava);
    }
}
