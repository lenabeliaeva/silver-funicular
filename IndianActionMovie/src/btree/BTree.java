package btree;

class BTree {

    private int t;
    Node root;

    private class Node {
        boolean leaf;
        int n;  //количество ключей в узле
        int[] key = new int[n];  //ключи узла
        Node[] child;   //указатель на детей
    }

    void add(){

    }
}
