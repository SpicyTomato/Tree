package com.spicytomato.javastructrueexperiment_3;

public class BinaryNode<T> {
    private T data;
    public BinaryNode<T> left,right;

    BinaryNode(T data,BinaryNode<T> left, BinaryNode<T> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    BinaryNode(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    public T getData() {
        return data;
    }

    public BinaryNode<T> getLeft() {
        return left;
    }

    public BinaryNode<T> getRight() {
        return right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
}

