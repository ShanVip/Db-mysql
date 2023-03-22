package com.ClumbingStair;

public class Main {
    public static void main(String[] args) {

        int n = 44;
        int answer = move(0, n);
        System.out.println(answer);

    }
    public static int move(int sum, int max){

        if(sum<max) {
            int first =move(sum+2, max);
            int second = move(sum+1, max);
            return second + first;
        }
        if(sum>max) {
            return 0;
        }

        return 1;

    }
}

