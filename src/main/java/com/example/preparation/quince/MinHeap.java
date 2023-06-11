package com.example.preparation.quince;

import java.util.PriorityQueue;

public class MinHeap {


    public static void main(String args[]){
        int[] in = {4,3,2,6};
        System.out.println("minimum cost ==== "+minimumCost(in));
    }

    private static int minimumCost(int[] in) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i < in.length; i++){
            pq.add(in[i]);
        }
        int res = 0;
        while(!pq.isEmpty() && pq.size() != 1){
            int f = pq.poll();
            int s = pq.poll();
            int sum = f+s;
            res += sum;
            pq.offer(sum);
        }
        return res;
    }
}
