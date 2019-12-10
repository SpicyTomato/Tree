package com.spicytomato.javastructrueexperiment_3;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(){
        this.data = null;
        this.next = null;
    }

    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }
}
