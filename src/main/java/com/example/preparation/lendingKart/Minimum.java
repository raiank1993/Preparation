package com.example.preparation.lendingKart;

public class Minimum {

    public static void main(String[] arg){
        int in[] = {1,2,3,1,7,1,8,4,4,5,6};
        int target = 9;
        System.out.println("min len --- "+findMinLen(in, target));
    }

    private static int findMinLen(int[] in, int target) {
        int i = 0;
        int j = 0;
        int l = in.length;
        int sum = in[0];
        int minLen = l;
        while(j < l-1 && i < l-1){
            if(sum >= target){
                minLen = Math.min(minLen, j - i + 1); // minLen = 4
                sum-=in[i];
                i++;
            }else{
                j++;
                sum += in[j]; // sum = 10    i = 1 , j = 3
            }
        }
        return minLen;
    }
}
