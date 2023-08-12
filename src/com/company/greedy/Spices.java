package com.company.greedy;

import java.util.*;

public class Spices {

    /*
        3 50
        60 20  = 30
        100 50 = 20
        120 30 = 40  <--- the most expensive

        0) take the most expensive spice until:
            1) Weight of backpack is full ---> return answer
            2) These spices are out of stock ---> continue from 0)


        100
        130
        14
        + 8/30 * 77 = 20.53
        \\\\\
        264.5333

     */


    static float getMaxSumOfSpices_recursive(float backpackWeight, List<Float> spicePrices, List<Float> spiceWeights) {
        if(backpackWeight == 0 || spiceWeights.isEmpty()){
            return 0f;
        }

        int mostExpensiveIndex = 0;

        for (int i = 1; i < spicePrices.size(); i++) {
            float localCost = spicePrices.get(i) / spiceWeights.get(i);
            float maxCost = spicePrices.get(mostExpensiveIndex) / spiceWeights.get(mostExpensiveIndex);

            if (localCost > maxCost) {
                mostExpensiveIndex = i;
            }
        }

        float amount = Math.min(spiceWeights.get(mostExpensiveIndex), backpackWeight);
        float value = spicePrices.get(mostExpensiveIndex) / spiceWeights.get(mostExpensiveIndex) * amount;
        spicePrices.remove(mostExpensiveIndex);
        spiceWeights.remove(mostExpensiveIndex);

        return value + getMaxSumOfSpices_recursive(backpackWeight - amount, spicePrices, spiceWeights);
    }

    static double getMaxSumOfSpices(int backpackWeight, List<Double> spicePrices, List<Double> spiceWeights) {
        double bounty = 0;
        double backpackFreeSpace = backpackWeight;

        while (backpackFreeSpace > 0 && spicePrices.size() > 0) {
            int mostExpensiveIndex = 0;

            for (int i = 1; i < spicePrices.size(); i++) {
                double localCost = spicePrices.get(i) / spiceWeights.get(i);
                double maxCost = spicePrices.get(mostExpensiveIndex) / spiceWeights.get(mostExpensiveIndex);

                if (localCost > maxCost) {
                    mostExpensiveIndex = i;
                }
            }

            double amount = Math.min(backpackFreeSpace, spiceWeights.get(mostExpensiveIndex));
            bounty += (amount / spiceWeights.get(mostExpensiveIndex)) * spicePrices.get(mostExpensiveIndex);
            backpackFreeSpace -= amount;

            spicePrices.remove(mostExpensiveIndex);
            spiceWeights.remove(mostExpensiveIndex);
        }

        return bounty;
    }

    static double test() {
        List<Double> spicePrices = new ArrayList<>();
        List<Double> spiceWeights = new ArrayList<>();

        Random random = new Random();
        int n = random.nextInt(1000);
        int backpackWeight = random.nextInt(2000000);

        for (int i = 0; i < n; i++) {
            spicePrices.add((double) random.nextInt(2000000));
            spiceWeights.add((double) random.nextInt(2000000));
        }

        System.out.println(n + " " + backpackWeight);

        for (int i = 0; i < n; i++) {
            System.out.println(spicePrices.get(i) + " " + spiceWeights.get(i) + " (" + spicePrices.get(i) / spiceWeights.get(i) + ")");
        }

        return getMaxSumOfSpices(backpackWeight, spicePrices, spiceWeights);
    }

    public static void main(String[] args) {
        List<Double> spicePrices = new ArrayList<>();
        List<Double> spiceWeights = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int backpackWeight = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            spicePrices.add((double)scanner.nextInt());
            spiceWeights.add((double)scanner.nextInt());
        }

        double answer = getMaxSumOfSpices(backpackWeight, spicePrices, spiceWeights);

        System.out.printf(Locale.ENGLISH, "%.5f%n", answer);
    }
}
