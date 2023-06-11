package com.example.preparation.Nyka;

public class MainClass {
    public static void main(String args[]){
        Cache cache = new LRUCache(5);
     //   Cache cache = new FIFO(5);
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.put(3, 3);
//        cache.put(4, 4);
//        cache.put(5, 5);
//        cache.put(6, 6);
        System.out.print("get node 2-->"+ cache.get(2));
        cache.print();
    }


    class A {
        private A a;

        synchronized A getInstance(){
            if(a == null){
                return new A();
            }
            return a;
        }
    }




}
