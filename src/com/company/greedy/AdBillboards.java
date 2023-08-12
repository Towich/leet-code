package com.company.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdBillboards {
    /*
            |-------------------|  |-------------------|
            |                   |  |                   |
            |       hello       |  |       world!      |
            |                   |  |                   |
            |-------|   |-------|  |-------|   |-------|
                    |   |                  |   |
                    |===|                  |===|

                      There is billboards. =)
     */
    static int maxBillboardsProfit(int countBoards, int freeWeeksBoard, List<Integer> priceList, List<Integer> weeksList){
        int max_profit = 0;
        int freeWeeksAllBoards = countBoards * freeWeeksBoard;

        while(freeWeeksAllBoards > 0 && !priceList.isEmpty()){
            int maxPriceIndex = 0;

            for(int i = 1; i < priceList.size(); i++){
                int maxPrice = priceList.get(maxPriceIndex);
                int localPrice = priceList.get(i);

                if(localPrice > maxPrice){
                    maxPriceIndex = i;
                }
            }

            int amountWeeksToSell = Math.min(freeWeeksBoard, weeksList.get(maxPriceIndex));
            amountWeeksToSell = Math.min(amountWeeksToSell, freeWeeksAllBoards);

            max_profit += priceList.get(maxPriceIndex) * amountWeeksToSell;

            freeWeeksAllBoards -= amountWeeksToSell;

            priceList.remove(maxPriceIndex);
            weeksList.remove(maxPriceIndex);
        }

        return max_profit;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> priceList = new ArrayList<>();
        List<Integer> weeksList = new ArrayList<>();

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int w = scanner.nextInt();

        for(int i = 0; i < k; i++){
            priceList.add(scanner.nextInt());
            weeksList.add(scanner.nextInt());
        }

        int max_profit = maxBillboardsProfit(n, w, priceList, weeksList);

        System.out.println(max_profit);
    }
}
