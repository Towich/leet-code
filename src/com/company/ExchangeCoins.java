package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExchangeCoins {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void printAllExchangeVariants_BruteForce(int money) {
        List<List<Integer>> list = new ArrayList<>();

        for (int m10 = 0; m10 * 10 <= money; m10++) {
            for (int m5 = 0; m5 * 5 <= money; m5++) {
                for (int m1 = 0; m1 <= money; m1++) {
                    if (m10 * 10 + m5 * 5 + m1 == money) {
                        List<Integer> localList = new ArrayList<>();

                        int sum = m10 + m5 + m1;
                        localList.add(sum);

                        for (int i = 0; i < m10; i++)
                            localList.add(10);
                        for (int i = 0; i < m5; i++)
                            localList.add(5);
                        for (int i = 0; i < m1; i++)
                            localList.add(1);
                        list.add(localList);
                    }
                }
            }
        }

        try {
            bw.write(String.valueOf(list.size()));
            bw.newLine();
            for (int k = list.size() - 1; k >= 0; k--) {
                bw.write(list.get(k).get(0).toString());
                for (int i = list.get(k).size() - 1; i > 0; i--) {
                    bw.write(" " + list.get(k).get(i));
                }
                bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    static void printAllExchangeVariants_Optimized(int money) {
        List<List<Integer>> list = new ArrayList<>();

        // i - counter of coins '10'
        // k - counter of coins '5'
        for (int i = money / 10; i >= 0; i--) {
            for (int k = money / 5 - 2 * i; k >= 0; k--) {
                int totalCoins = i + k + (money - i * 10 - k * 5);
                int coins1 = (money - i * 10 - k * 5);
                list.add(new ArrayList<>(Arrays.asList(totalCoins, coins1, k, i)));
            }
        }

        try {
            bw.write(String.valueOf(list.size()));
            bw.newLine();
            for (List<Integer> integers : list) {

                // TotalCoins
                bw.write(integers.get(0).toString());

                // Print all '1'
                for (int k = 0; k < integers.get(1); k++) {
                    bw.write(" 1");
                }

                // Print all '5'
                for (int k = 0; k < integers.get(2); k++) {
                    bw.write(" 5");
                }

                // Print all '10'
                for (int k = 0; k < integers.get(3); k++) {
                    bw.write(" 10");
                }

                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    static void test(){

        // Test BruteForce and Optimized algorithms with money = 0..50
        for(int i = 0; i <= 50; i++){
            try {
                bw.write("money = " + i);
                bw.newLine();

                bw.write("~~~~~~~~~ BRUTE FORCE ~~~~~~~~~~~");
                bw.newLine();
                printAllExchangeVariants_BruteForce(i);

                bw.write("~~~~~~~~~ OPTIMIZED ~~~~~~~~~~~");
                bw.newLine();
                printAllExchangeVariants_Optimized(i);
                bw.newLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputMoney = scanner.nextInt();
        printAllExchangeVariants_Optimized(inputMoney);
    }
}
