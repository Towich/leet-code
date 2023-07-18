package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Objects;
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

    static BigInteger maxMult4Optimized(int n, int[] array){
        MergeSort.mergeSort(array);
        BigInteger maxMult_allPositives = BigInteger.valueOf((long) array[n - 1] * array[n-2] * array[n-3]);
        maxMult_allPositives = maxMult_allPositives.multiply(BigInteger.valueOf(array[n-4]));

        BigInteger maxMult = maxMult_allPositives;

        int negatives = 0;
        for(int i = 0; i < 4; i++){
            if(array[i] < 0)
                negatives++;
        }

        if(negatives > 1){
            BigInteger maxMult_twoNegativeTwoPositive = BigInteger.valueOf((long) array[n-1] * array[n-2] * array[0]);
            maxMult_twoNegativeTwoPositive = maxMult_twoNegativeTwoPositive.multiply(BigInteger.valueOf(array[1]));

            if(maxMult_twoNegativeTwoPositive.compareTo(maxMult) > 0){
                maxMult = maxMult_twoNegativeTwoPositive;
            }
        }
        if(negatives > 3){
            BigInteger maxMult_allNegatives = BigInteger.valueOf((long) array[0] * array[1] * array[2]);
            maxMult_allNegatives = maxMult_allNegatives.multiply(BigInteger.valueOf(array[3]));

            if(maxMult_allNegatives.compareTo(maxMult) > 0){
                maxMult = maxMult_allNegatives;
            }
        }

        return maxMult;
    }

    static BigInteger maxMultBruteForce(int n, int[] array){
        BigInteger maxMult = BigInteger.valueOf((long) array[0] * array[1] * array[2]);
        maxMult = maxMult.multiply(BigInteger.valueOf(array[3]));

        for(int i = 0; i < n-3; i++){
            for(int j = i+1; j < n-2; j++){
                for(int k = j+1; k < n-1; k++){
                    for(int l = k+1; l < n; l++) {
                        BigInteger localMult = BigInteger.valueOf((long) array[i] * array[j] * array[k]);
                        localMult = localMult.multiply(BigInteger.valueOf(array[l]));
                        if (localMult.compareTo(maxMult) > 0)
                            maxMult = localMult;
                    }
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

            BigInteger maxMult = maxMult4Optimized(n, array);
            BigInteger maxMultBruteForce = maxMultBruteForce(n, array);

            if(Objects.equals(maxMult, maxMultBruteForce)){
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

    static void mergeSortImpl(int[] values, int[] buffer, int l, int r){
        if(l < r){
            int m = (l + r)/2;
            mergeSortImpl(values, buffer, l, m);
            mergeSortImpl(values, buffer, m+1, r);

            int k = l;
            for(int i = l, j = m+1; i <= m || j <= r; ){
                if(j > r || (i <= m && values[i] < values[j])){
                    buffer[k] = values[i];
                    ++i;
                }
                else{
                    buffer[k] = values[j];
                    ++j;
                }
                ++k;
            }

            for(int i = l; i <= r; i++){
                values[i] = buffer[i];
            }
        }
    }

    static void mergeSort(int[] values){
        if(values.length > 0){
            int[] buffer = new int[values.length];
            mergeSortImpl(values, buffer, 0, values.length-1);
        }
    }

    public static void main(String[] args){
//        int n = 5;
//        int[] array = generateArray(n, -10, 10);

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++){
            array[i] = s.nextInt();
        }

        System.out.println(maxMult4Optimized(n, array));

//        stressTest(20, -200000, 200000, 25);
    }
}
