package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Scanner;

public class MaxMultiplication {

    static long maxMultOptimized(int n, int[] array){
        int maxInt = array[0];
        int maxInt2 = array[1];
        int maxInt3 = array[2];

        int minInt = 0, minInt2 = 0;

        int countOfComparisons = 0;

        if(maxInt2 > maxInt){
            int local = maxInt;
            maxInt = maxInt2;
            maxInt2 = local;
        }

        if(maxInt3 > maxInt){
            int local = maxInt3;
            maxInt3 = maxInt2;
            maxInt2 = maxInt;
            maxInt = local;
        }
        else if(maxInt3 > maxInt2){
            int local = maxInt2;
            maxInt2 = maxInt3;
            maxInt3 = local;
        }

        for(int i = 3; i < n; i++) {
            countOfComparisons++;
            if (array[i] > maxInt) {
                maxInt3 = maxInt2;
                maxInt2 = maxInt;
                maxInt = array[i];
            } else if (array[i] > maxInt2) {
                countOfComparisons++;
                maxInt3 = maxInt2;
                maxInt2 = array[i];
            } else if (array[i] > maxInt3) {
                maxInt3 = array[i];
            } else {
                countOfComparisons++;
            }
        }

        if(n >= 4){
            minInt = array[0];
            minInt2 = array[1];

            if(minInt2 < minInt){
                int local = minInt2;
                minInt2 = minInt;
                minInt = local;
            }

            for(int i = 2; i < n; i++){
                countOfComparisons++;
                if(array[i] < minInt){
                    minInt2 = minInt;
                    minInt = array[i];
                }
                else if(array[i] < minInt2){
                    countOfComparisons++;
                    minInt2 = array[i];
                }
                else{
                    countOfComparisons++;
                }
            }
        }


//        System.out.println("n = " + n + " | comparisons = " + countOfComparisons + " | answer = " + (countOfComparisons > 1.5*n));

//        if(countOfComparisons >= 1.5*n){
//            System.out.println("Yes");
//            for(int num : array){
//                System.out.print(num + " ");
//            }
//        }
//        else{
//            System.out.println("No");
//        }

        long positiveMaxMult = (long) maxInt * maxInt2 * maxInt3;

        long twoNegativeOnePositiveMult = (long) minInt * minInt2 * maxInt;

        if(n >= 4){
            return Math.max(positiveMaxMult, twoNegativeOnePositiveMult);
        }
        else{
            return positiveMaxMult;
        }
    }

    static long maxMultBruteForce(int n, int[] array){
        long maxMult = (long) array[0] * array[1] * array[2];

        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = j+1; k < n; k++){
                    long localMult = (long) array[i] * array[j] * array[k];
                    if(localMult > maxMult)
                        maxMult = localMult;
                }

            }
        }

        return maxMult;
    }

    static int[] generateArray(int n, int min_a, int max_a){
        int[] array = new int[n];
        Random random = new Random();

        for(int i = 0; i < n; i++){
            array[i] = random.nextInt(min_a, max_a+1);
        }

        return array;
    }

    static int[] generateIncreaseArray(int n, int max_a){
        int[] array = new int[n];
        array[0] = n;

        for(int i = 1; i < n; i++){
            array[i] = i;
        }

        return array;
    }

    static void stressTest(int n, int min_a, int max_a, int tests){
        for(int i = 0; i < tests; i++){
            int[] array = generateArray(n, min_a, max_a);

            long maxMult = maxMultOptimized(n, array);
            long maxMultBruteForce = maxMultBruteForce(n, array);

            if(maxMult == maxMultBruteForce){
                System.out.println("OK");
            }
            else{
                System.out.println("ERROR");

                System.out.println();
            }

            System.out.println("n = " + n);
            for(int num : array){
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("Brute Force = " + maxMultBruteForce);
            System.out.println("Optimized   = " + maxMult);
            System.out.println();

//            n++;
        }
    }

    static void checkComparisons(int n){
        int comparisons = 1 + (n - 2)*2;

        if(comparisons > 1.5*n){
            System.out.println("Yes");
            int[] array = generateIncreaseArray(n, -1);
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
                for(int num : array) {
                    bw.write(num + " ");
                }
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("No");
        }
    }

    static void testCase(){
        int n = 4;
        int[] array = {-180726, -55391, -35302, -88174};

        System.out.println(maxMultOptimized(n, array));
    }

    public static void main(String[] args){
//        Scanner s = new Scanner(System.in);
//        int n = s.nextInt();            // 2 <= n <= 200 000
//
//        int[] array = new int[n];
//
//        for(int i = 0; i < n; i++){
//            array[i] = s.nextInt();
//        }
//
//        System.out.println(maxMultOptimized(n, array));
        stressTest(4, -200000, 200000, 100);

//        testCase();

    }
}
