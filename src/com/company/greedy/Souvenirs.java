package com.company.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Souvenirs {

    /*
        1) find m = minimum in $souvenirPrices
        2) money -= souvenirPrices[m] (need to check if money >= price)
        3) count++
        4) remove m from $souvenirPrices
        5) money <= 0 ?
            yes ---> return answer
            no ----> go to 1)
     */

    static int maxCountSouvenirs(int money, List<Integer> souvenirPrices){
        int maxCount = 0;

        while(money > 0) {
            int minPriceIndex = 0;

            for (int i = 1; i < souvenirPrices.size(); i++) {
                int minPrice = souvenirPrices.get(minPriceIndex);
                int local_minPrice = souvenirPrices.get(i);

                if (local_minPrice < minPrice) {
                    minPriceIndex = i;
                }
            }

            int currMinPrice = souvenirPrices.get(minPriceIndex);
            if(money < currMinPrice)
                break;

            maxCount++;
            money -= souvenirPrices.get(minPriceIndex);

            souvenirPrices.remove(minPriceIndex);
        }

        return maxCount;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> souvenirPrices = new ArrayList<>();

        int n = scanner.nextInt();
        int money = scanner.nextInt();

        for(int i = 0; i < n; i++){
            souvenirPrices.add(scanner.nextInt());
        }

        int answer = maxCountSouvenirs(money, souvenirPrices);

        System.out.println(answer);
    }
}
