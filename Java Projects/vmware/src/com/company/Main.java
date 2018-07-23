package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] k =  {5, 6, 13, 99, 13, 5, 6};
        boolean test;
        int n= 0;
        for(int i=0; i<3; i++){
            for(int p = (k.length-1); p>(k.length-1-3); p--)
            {if(k[i]==k[p]) n++;}
        }
        if(n==3) test = true;
        else test = false;

        System.out.println(Boolean.toString(test));
    }

}
