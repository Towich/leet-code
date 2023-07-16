package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class SumOfTwoDigits {
    static void sumOfAxBx(){
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        Scanner s = new Scanner(System.in);

        int first_n = s.nextInt();
        for(int i = 0; i < first_n + 1; i++){
            firstStack.push(s.nextInt());
        }

        int second_n = s.nextInt();
        for(int i = 0; i < second_n + 1; i++){
            secondStack.push(s.nextInt());
        }

        ArrayDeque<Integer> resultArray = new ArrayDeque<>();
        int minSize = Math.min(firstStack.size(), secondStack.size());
        for(int i = 0; i < minSize; i++){
            int localSum = firstStack.pop() + secondStack.pop();
            resultArray.addFirst(localSum);
        }

        while(firstStack.size() > 0){
            resultArray.addFirst(firstStack.pop());
        }

        while(secondStack.size() > 0){
            resultArray.addFirst(secondStack.pop());
        }

        System.out.println(resultArray.size() - 1);

        for (int num:resultArray) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        sumOfAxBx();
    }
}
