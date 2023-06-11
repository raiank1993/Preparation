package com.example.preparation.Nyka;

import java.util.HashMap;
import java.util.Map;

public class FIFO implements Cache{
    Map<Integer ,Node> map = new HashMap<>();
    int capacity = 0;
    int length = 0;
    Node lastNode = null;

    Node head = null;

    public FIFO(int capacity){
        this.capacity = capacity;
        this.length = 0;
        this.head = new Node(0);
        this.lastNode = this.head;

    }
    @Override
    public void put(int key, int value) {
        if(length >= capacity){
           // NOde
        }
    }

    @Override
    public int get(int key) {

        return 0;
    }

    @Override
    public void print() {

    }
}
