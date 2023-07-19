package com.company;

import java.util.Scanner;

public class Fibonacci {

    static int memoFibonacci(int n){
        if(n <= 1)
            return n;

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n];
    }


    static int memoFibonacciMod10(int n){
        if(n <= 1)
            return n;

        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= n; i++){
            memo[i] = (memo[i-1] + memo[i-2]) % 10;
        }

        return memo[n];
    }

    static long memoFibonacciModM(long n, int m){
        if(n == 0 || n == 1)
            return n;

        int oldNext, current = 1, next = 1;

        for(long i = 2; i <= n; i++){
            oldNext = next;
            next = (current + next) % m;
            current = oldNext;
        }

        return current;
    }

    static int pisanoPeriod(int m){
        long oldNext, current = 0, next = 1;
        int period = 0;

        while(true){
            oldNext = next;
            next = (current + next) % m;
            current = oldNext;
            period++;

            if(current == 0 && next == 1)
                return period;
        }
    }

    static void stressTest1(int tests, int m){

        for(int n = 0; n < tests; n++) {
            long fib1 = memoFibonacciModM(n, m);

            int period = pisanoPeriod(m);
            int minimalFibonacci = n % period;
            long fib2 = memoFibonacciModM(minimalFibonacci, m);

            System.out.print("F[" + n + "] | ");
            if (fib1 == fib2) {
                System.out.println("OK | " + "Fib 1 = " + fib1 + " | fib 2 = " + fib2);
            } else {
                System.out.println("ERROR");
                System.out.println("Fib 1 = " + fib1 + " | fib 2 = " + fib2);
            }
        }
    }

    static int lastDigitOfSumFibonacci(long n){
        // sum of first 60 elements ~ '0' in last digit
        // sum has period = 60
        // sooo we can just do n % 60
        // and then just find the last digit for 0 <= n <= 59 <--- this will be answer.
        n = n % 60;

        int lastDigit = 0;

        for(int i = 0; i <= n; i++){
            int memoFib = (int) memoFibonacciModM(i, 10);
            lastDigit = (lastDigit + memoFib) % 10;
//            System.out.println("F[" + i + "] = " + memoFib + " | " + lastDigit);
        }

        return lastDigit;
    }

    static int lastDigitOfSumFibonacci(long m, long n){
        int lastDigit = 0;
        long quantityOfNums = n - m + 1;
        quantityOfNums %= 60;

        int m_mod60 = (int) (m % 60);

        for(int i = m_mod60; i < m_mod60 + quantityOfNums; i++){
            int memoFib = (int) memoFibonacciModM(i, 10);
            lastDigit = (lastDigit + memoFib) % 10;
//            System.out.println("F[" + i + "] = " + memoFib + " | " + lastDigit);
        }

        return lastDigit;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long m = s.nextLong();
        long n = s.nextLong();

        System.out.println(lastDigitOfSumFibonacci(m, n));
    }
}
