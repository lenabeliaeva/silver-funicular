package btree;

import java.util.LinkedList;

class Node {

    private int t;
    boolean leaf;
    Node root;
    LinkedList<Integer> key = new LinkedList<>();  //ключи узла
    LinkedList<Node> child = new LinkedList<>();   //указатель на детей

    void add(){
    }
}
