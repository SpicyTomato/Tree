package com.spicytomato.javastructrueexperiment_3;

import android.util.Log;

public class BinaryTree<T> {
    BinaryNode<T> root;
    StringBuilder string = new StringBuilder();
    private final static String TAG = "nisile!!!!!!!!!";

    BinaryTree(){
        this.root = null;
    }

    BinaryTree(BinaryNode root){
        this.root = root;
    }

//    BinaryTree(T[] prelist){
//        this.root = creat(prelist);
//    }

    private int i =0;
    BinaryNode<T> creat(T[] prelist){
        BinaryNode<T> p = null;
        if(i < prelist.length){
            T elem = prelist[i];
            i++;
            if(!elem.equals("#")){
                p = new BinaryNode<T>(elem);
                Log.d(TAG, "creat: " + elem);
                p.left = creat(prelist);
                p.right = creat(prelist);
            }
        }

        return  p;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    //插入x作为根结点 原根结点作为x的左孩子
    public BinaryNode<T> insert(T x){
        return this.root = new BinaryNode<T>(x, this.root,null);
    }

    //插入x为parent节点的左右孩子 leftChild指定孩子 true是左孩子 false是右孩子
    public BinaryNode<T> insert(BinaryNode<T> parent , T data , boolean leftChild){
        if(data == null){
            return null;
        }
        if(leftChild){
            return parent.left = new BinaryNode<T>(data,parent.left,null);
        }
        return parent.right = new BinaryNode<T>(data,null,parent.right);
    }

    public  void remove(BinaryNode<T> parent , boolean leftChild){
        if(leftChild){
            parent.left = null;
        }else {
            parent.right = null;
        }
    }

    public void clear(){
        this.root = null;
    }

    //前序递归
    public void preorder(){
        preorder(this.root);
//        System.out.println();
    }

    private void preorder(BinaryNode<T> p){
        if(p != null){
//            System.out.print(p.getData().toString() + " ");
            string.append(p.getData().toString() + " ");
            Log.d(TAG, p.getData() +"preorder: " + string);
            preorder(p.left);
            preorder(p.right);
        }
    }

    //中序递归
    public void inorder(){
        inorder(this.root);
//        System.out.println();
    }

    private void inorder(BinaryNode<T> p ){
        if(p != null) {
            inorder(p.left);
            string.append(p.getData().toString() + " ");
            inorder(p.right);
        }
    }

    //后序递归
    public void postorder(){
        postorder(this.root);
//        System.out.println();
    }

    private void postorder(BinaryNode<T> p){
        if(p != null) {
            postorder(p.left);
            postorder(p.right);
            string.append(p.getData().toString() + " ");
        }
    }

    //前序非递归
    public void preorderTraverse(){
        Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
        BinaryNode<T> p = this.root;
//        Log.d(TAG, "preorderTraverse: " + stack.toString() + p.getData());
        while (p!=null || !stack.isEmpty()){
            if(p!=null){
//                System.out.print(p.getData().toString() + " ");
                string.append(p.getData().toString() + " ");
                Log.d(TAG, "preorderTraverse: " + stack.toString() + String.valueOf(stack.head == null));
                try {
                    stack.StackPush(p);
                }catch (Exception e){
                    Log.e(TAG, "preorderTraverse: ", e);
                }
                Log.d(TAG, "preorderTraverse: " + stack.toString());
                p = p.left;
            }else {
//                System.out.print("^ ");
                string.append("^ ");
                p = stack.StackPop();
                p = p.right;
            }
        }
    }

    //中序非递归
    public void inorderTraverse(){
        Stack<BinaryNode<T>> stack = new Stack<BinaryNode<T>>();
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty()){
            if(p!=null){
                try {
                    stack.StackPush(p);
                }catch (Exception e){
                    Log.e(TAG, "inorderTraverse: ",e );
                }
                p = p.left;
            }else {
                string.append("^ ");
                p = stack.StackPop();
                string.append(p.getData().toString() + " ");
                p = p.right;
            }
        }
    }
}

