package com.company;
//this is class for binary search tree
public class MyBSTree {
    Node rootprava;

    MyBSTree(){
        rootprava = null;
    }

    MyBSTree(int valuevalue){
        rootprava = new Node(valuevalue);
    }

    // insert() - вставить новый элемент
    Node insert(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }

        if (key < root.keykey){
            root.leftleft = insert(root.leftleft, key); // если ключ меньше корня, он переходит в левую часть узла
        }

        else if (key > root.keykey) {
            root.rightright = insert(root.rightright, key); // если ключ больше, чем корень, он переходит в правую часть узла
        }

        return root;
    }

    // inorder() - печать текущих левых и правых конечных элементов
    void inorder(Node root){
        if (root != null){
            inorder(root.leftleft);
            System.out.println(root.keykey);
            inorder(root.rightright);
        }
    }

    // search() - поиск предметов
    // здесь я написал поисковую функцию в массиве
    public Node search(Node rootprava, int keykey){
        if (rootprava == null || rootprava.keykey == keykey){
            return rootprava;
        }

        if (rootprava.keykey < keykey){
            return search(rootprava.rightright, keykey);
        }

        return search(rootprava.leftleft, keykey);
    }

    // deleteNode() - удаление узла
    // здесь я написал функцию которая удаляет узлы
    Node deleteNode(Node rootprava, int keykey){
        if (rootprava == null){
            return rootprava;
        }

        if (keykey < rootprava.keykey){
            rootprava.leftleft = deleteNode(rootprava.leftleft, keykey);
        }

        else if (keykey > rootprava.keykey){
            rootprava.rightright = deleteNode(rootprava.rightright, keykey);
        }

        else {
            if (rootprava.leftleft == null){
                return rootprava.rightright;
            }

            else if (rootprava.rightright == null){
                return rootprava.leftleft;
            }

            rootprava.keykey = minVal(rootprava.rightright);

            rootprava.rightright = deleteNode(rootprava.rightright, rootprava.keykey);
        }
        return rootprava;
    }

    // minVal() - возвращаемое минимальное значение
    //здесь я написал функцию которая возвращает минимальное значение в массиве
    int minVal(Node rootprava){
        int minvalu = rootprava.keykey;
        while (rootprava.leftleft != null){
            minvalu = rootprava.leftleft.keykey;
            rootprava = rootprava.leftleft;
        }
        return minvalu;
    }
}