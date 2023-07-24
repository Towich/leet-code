package com.company;

import java.util.Scanner;

public class Euclid_GCD_LCM {
    static int GCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b)
                a = a % b;
            else
                b = b % a;
        }
        return Math.max(a, b);
    }

    static int GCD_counter(int a, int b) {
        int count = 0;
        while (a > 0 && b > 0) {
            if (a >= b)
                a = a % b;
            else
                b = b % a;
            count++;
        }
        return count;
    }

    static int GCD_recursive(int a, int b, int counter) {
        if (a == 0 || b == 0)
            return counter;
        return GCD_recursive(b, a % b, counter + 1);
    }

    static int[] LongestCountOfRecursiveEuclid_bruteForce(int n) {
        int longestCount = 0;
        int a = 0;
        int b = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int localCount = GCD_recursive(i, j, 1);
                if(localCount > longestCount) {
                    longestCount = localCount;
                    a = i;
                    b = j;
                }
            }
        }

        int[] answer = { longestCount, a, b };

        return answer;
    }

    static long LCM(int a, int b) {
        return (((long) a * b) / GCD(a, b));
    }

    static void StressTest(int countOfTests){
        for(int i = 1; i <= countOfTests; i++){

            int[] answer_bruteForce = LongestCountOfRecursiveEuclid_bruteForce(i);
            int longestCount_bruteForce = answer_bruteForce[0];
            int a_bruteForce = answer_bruteForce[1];
            int b_bruteForce = answer_bruteForce[2];

            int[] answer_optimized = LongestCountOfRecursiveEuclid(i);
            int longestCount_optimized = answer_optimized[0];
            int a_optimized = answer_optimized[1];
            int b_optimized = answer_optimized[2];

            if(longestCount_bruteForce == longestCount_optimized)
                System.out.println("OK");
            else
                System.out.println("ERROR");
            System.out.println("n = " + i);
            System.out.println("BruteForce | Longest count = " + longestCount_bruteForce + " (" + a_bruteForce + " " + b_bruteForce + ")");
            System.out.println("Optimized  | Longest count = " + longestCount_optimized + " (" + a_optimized + " " + b_optimized + ")");
            System.out.println();
        }
    }

    static int[] LongestCountOfRecursiveEuclid(int n) {

        if (n < 2) {
            return new int[] { 2, 1, 1 };
        }

        int resultCount = 3;
        int a = 2;
        int b = 1;

        while (true) {
            int local_a = a + b;
            int local_b = a;

            if (local_a > n || local_b > n)
                break;

            a = local_a;
            b = local_b;
            resultCount++;
        }

        return new int[]{ resultCount, b, a };
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] answer = LongestCountOfRecursiveEuclid(n);
        System.out.println(answer[1] + " " + answer[2]);
//
//        StressTest(5);
//
//        System.out.println(GCD_recursive(5, 8, 1));
    }
}
