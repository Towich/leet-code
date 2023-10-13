package com.company.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MaxSalary {

    static boolean isBetter(int number, int maxNumber){
        if(number == maxNumber)
            return false;

        // 3
        // 6 67 65 --> 67665

        String numberStr = String.valueOf(number);
        String maxNumStr = String.valueOf(maxNumber);

        int currLeftIndex = 0;
        int currRightIndex = 0;

        for(int i = 0; i < Math.max(numberStr.length(), maxNumStr.length()); i++){
            int leftDigit = numberStr.charAt(currLeftIndex) - '0';
            int rightDigit = maxNumStr.charAt(currRightIndex) - '0';
            if(leftDigit > rightDigit){
                return true;
            }
            else if(leftDigit == rightDigit){
                if(currLeftIndex != numberStr.length() - 1){
                    currLeftIndex++;
                }
                if(currRightIndex != maxNumStr.length() - 1){
                    currRightIndex++;
                }
            }
            else{
                return false;
            }
        }

        return numberStr.length() < maxNumStr.length();
    }

    static String maxSalary(int n, List<Integer> nums){
        String salary = "";

        while(!nums.isEmpty()){
            int maxNumber = nums.get(0);

            for (int num:nums) {
                if(isBetter(num, maxNumber)){
                    maxNumber = num;
                }
            }

            salary += maxNumber + " ";
            nums.remove((Integer) maxNumber);
        }

        return salary;
    }

    static void stressTest(int tests, int n){
        Random random = new Random();
        for(int k = 0; k < tests; k++) {
            List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                numbers.add(random.nextInt(1, 100));
                System.out.print(numbers.get(i) + " ");
            }

            System.out.print("| " + maxSalary(n, numbers));
            System.out.println();
        }
    }


    // 10010
    // 10100

    public static void main(String[] args){
//        Scanner scanner = new Scanner(System.in);
//
//        int n = scanner.nextInt();
//        List<Integer> nums = new ArrayList<>();
//
//        for(int i = 0; i < n; i++){
//            nums.add(scanner.nextInt());
//        }
//
//        String result = maxSalary(n, nums);
//        System.out.println(result);
        stressTest(10, 10);
    }
}
