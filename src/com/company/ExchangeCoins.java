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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void testAllExchangeVariants() {

        // Test BruteForce and Optimized algorithms with money = 0..50
        for (int i = 0; i <= 50; i++) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static List<Integer> getMinimalQuantityExchangeCoins(int money) {
        List<Integer> list = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

        int numCoins = 0;
        while (money > 0) {
            if (money >= 50) {
                money -= 50;
                list.set(1, list.get(1) + 1);
            } else if (money >= 20) {
                money -= 20;
                list.set(2, list.get(2) + 1);
            } else if (money >= 10) {
                money -= 10;
                list.set(3, list.get(3) + 1);
            } else if (money >= 5) {
                money -= 5;
                list.set(4, list.get(4) + 1);
            } else {
                money--;
                list.set(5, list.get(5) + 1);
            }
            numCoins++;
        }

        list.set(0, numCoins);

        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputMoney = scanner.nextInt();
        List<Integer> answer = getMinimalQuantityExchangeCoins(inputMoney);

        System.out.println(answer.get(0));
        boolean isFirst = true;
        for (int i = 0; i < answer.get(1); i++) {
            if(isFirst) {
                System.out.print("50");
                isFirst = false;
            }
            else
                System.out.print(" 50");
        }
        for (int i = 0; i < answer.get(2); i++) {
            if(isFirst) {
                System.out.println("20");
                isFirst = false;
            }
            else
                System.out.print(" 20");
        }
        for (int i = 0; i < answer.get(3); i++) {
            if(isFirst) {
                System.out.print("10");
                isFirst = false;
            }
            else
                System.out.print(" 10");
        }
        for (int i = 0; i < answer.get(4); i++) {
            if(isFirst) {
                System.out.print("5");
                isFirst = false;
            }
            else
                System.out.print(" 5");
        }
        for (int i = 0; i < answer.get(5); i++) {
            if(isFirst) {
                System.out.print("1");
                isFirst = false;
            }
            else
                System.out.print(" 1");
        }
    }
}
