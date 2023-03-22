package com.SuffletheArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums ={2, 5, 1, 3, 4, 7};
        int n = 3;
        int[] answer =new int[n*2];

        for (int i = 0; i < n; i++) {
            answer[i*2] = nums[i];

            answer[i*2+1] = nums[i+n];

        }
        System.out.println(Arrays.toString(answer));

    }
}
