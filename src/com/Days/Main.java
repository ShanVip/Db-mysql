package com.Days;

import java.lang.reflect.Array;
import java.util.Arrays;



public class Main {
    public static void main(String[] args) {
        String date ="2019-04-09";
        String delimeter = "-";
        String[] dateArray = date.split(delimeter);
        System.out.println(Arrays.toString(dateArray));
        int sum = 0;
        int x = Integer.parseInt(ltrim(dateArray[1]));
        int year =Integer.parseInt(ltrim(dateArray[0]));

        for (int month = 1; month <Integer.parseInt(ltrim(dateArray[1]))+1; month++) {
            if(month == x){
                sum+=Integer.parseInt(ltrim(dateArray[2]));
                break;
            }
            if ((month%2!=0 && month<8) ||(month%2==0 && month>=8) ) {
                sum += 31;
            }
            if (month==2){
                if (year%4==0 || (year%100==0&&year%400==0)){
                    sum+=29;
                }
                else sum+=28;
                continue;
            }
            if ((month%2==0 && month<8) ||(month%2!=0 && month>=8) ) {
                sum += 30;
            }


        }
        System.out.println(sum);


    }
    public static String ltrim(String str) {
        return str.replaceAll("^0+", "");
    }

}