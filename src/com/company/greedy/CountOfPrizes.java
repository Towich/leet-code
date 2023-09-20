package com.company.greedy;

import java.util.Scanner;

public class CountOfPrizes {

    static int countOfPrizes(int numOfSweets){
        int k = 0;
        int currSweets = 1;
        int totalSweets = 0;
        while(totalSweets + currSweets <= numOfSweets){
            totalSweets += currSweets;
            k++;
            currSweets++;
        }

        return k;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(countOfPrizes(n));
    }
}
