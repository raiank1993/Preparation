package com.example.preparation.Nyka;

public interface Cache {
    void put(int key, int value);
    int get(int key);

    void print();
}
