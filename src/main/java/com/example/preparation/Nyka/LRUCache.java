package com.example.preparation.Nyka;

import java.util.HashMap;
import java.util.Map;

public class LRUCache implements Cache {
    public Map<Integer, Node> map = new HashMap<>();
    int capacity;
    int length;
    Node lastNode = null;

    Node head = null;

    int indexTobeRemove= 0;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.length = 0;
        this.head = new Node(0);
        this.lastNode = this.head;
    }

    @Override
    public void put(int key, int value) {
        if(length >= capacity){
            Node temp = head;
            Node nodeForDelete = temp.next;
            Node nextNode = temp.next.next;
            temp.next = temp.next.next;
            nextNode.prev = temp;
            // remove key from map also

            try {

                for (int i : map.keySet()) {
                    if (map.get(i) == nodeForDelete) {
                        indexTobeRemove = i;
                    }
                }
                map.remove(indexTobeRemove);
            }catch (Exception e){
                System.out.print(e);
            }
        }
            Node newNode = new Node(value);
            lastNode.next = newNode;
            newNode.prev = lastNode;
            newNode.next = null;
            map.put(key, newNode);
            lastNode = newNode; // assign lastNode to newNode
            if(length < capacity){
                length++;
            }
    }

    @Override
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            if(lastNode != node){
                Node temp = node.prev;
                Node nextNode = node.next;
                temp.next = node.next;
                nextNode.prev = temp;
                lastNode.next = node;
                node.prev = lastNode;
                node.next = null;
                lastNode = node; // assign lastNode to newNode
            }
            return node.data;
        }
        return -1;
    }

    @Override
    public void print() {
        Node temp = head;
        while(temp != null){
            System.out.print("print --->"+temp.data);
            temp = temp.next;
        }
    }
}
