package com.company;

import java.util.Scanner;

public class CrookedSum {

    static String crookedSum(int n, StringBuilder str1, StringBuilder str2){
        StringBuilder resultStr = new StringBuilder();
        for(int i = 0; i < n; i++){
            resultStr.append(str1.charAt(i));
            resultStr.append(str2.charAt(i));
        }
        return resultStr.toString();
    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        int n = s.nextInt();

        str1.append(s.next());
        str2.append(s.next());

        System.out.println(crookedSum(n, str1, str2));
    }
}
