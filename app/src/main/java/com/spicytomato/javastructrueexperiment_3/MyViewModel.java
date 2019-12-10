package com.spicytomato.javastructrueexperiment_3;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MyViewModel extends AndroidViewModel {
    private BinaryTree<String> binaryTree;
    private Stack<String> stringStack;
    private int flag;
    public MyViewModel(@NonNull Application application) {
        super(application);
        if (binaryTree == null){
            binaryTree = new BinaryTree<String>();
        }if (stringStack == null){
            stringStack = new Stack<String>();
        }
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getFlag() {
        return flag;
    }

    public void setBinaryTree(BinaryTree<String> binaryTree) {
        this.binaryTree = binaryTree;
    }

    public BinaryTree<String> getBinaryTree() {
        return binaryTree;
    }

    public void setStringStack(Stack<String> stringStack) {
        this.stringStack = stringStack;
    }

    public Stack<String> getStringStack() {
        return stringStack;
    }


}
