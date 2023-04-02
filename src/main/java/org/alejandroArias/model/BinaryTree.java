package org.alejandroArias.model;

/**
 * This class represents a binary tree
 * @author Alejandro
 * @version 1.0.0
 * @since 1.0.0
 */
public class BinaryTree<T> {


    private Node<T> root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * This method adds a node to the tree
     * @param data the data of the node
     */
    public void add(T data){
        Node<T> node = new Node<>(data);
        if(root == null){
            root = node;
        }else{
            add(root, node);
        }
        size++;
    }

    /**
     * This method adds a node to the tree
     * @param root the root of the tree
     * @param node the node to add
     */
    private void add(Node<T> root, Node<T> node){
        if((int)node.getData() < (int)root.getData()){
            if(root.getLeft() == null){
                root.setLeft(node);
            }else{
                add(root.getLeft(), node);
            }
        }else{
            if(root.getRight() == null){
                root.setRight(node);
            }else{
                add(root.getRight(), node);
            }
        }
    }

    /**
     * This method searches a node in the tree
     * @param data the data of the node
     * @return true if the node is found, false otherwise
     */
    public boolean search(T data){
        return search(root, data);
    }

    /**
     * This method searches a node in the tree
     * @param root the root of the tree
     * @param data the data of the node
     * @return true if the node is found, false otherwise
     */
    private boolean search(Node<T> root, T data){
        if(root == null){
            return false;
        }else if(root.getData().equals(data)){
            return true;
        }else if((int)data < (int)root.getData()){
            return search(root.getLeft(), data);
        }else{
            return search(root.getRight(), data);
        }
    }

    /**
     * This method prints the tree in pre order
     */
    public void printPreOrder(){
        printPreOrder(root);
    }

    /**
     * This method prints the tree in preOrder
     * @param root the root of the tree
     */

    private void printPreOrder(Node<T> root) {
        if (root != null) {
            System.out.println(root.getData());
            printPreOrder(root.getLeft());
            printPreOrder(root.getRight());
        }

    }



    private static class Node<T> {

        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

    }
}
