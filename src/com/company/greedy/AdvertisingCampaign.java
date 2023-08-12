package com.company.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdvertisingCampaign {

    static long maxRevenue(List<Integer> pricesList, List<Integer> clicksList){

        long revenue = 0;

        while(!pricesList.isEmpty()){
            int maxPriceIndex = 0, maxClicksIndex = 0;

            for(int i = 0; i < pricesList.size(); i++){
                int currPrice = pricesList.get(i);
                int maxPrice = pricesList.get(maxPriceIndex);

                int currClicks = clicksList.get(i);
                int maxClicks = clicksList.get(maxClicksIndex);

                if(currPrice > maxPrice){
                    maxPriceIndex = i;
                }

                if(currClicks > maxClicks){
                    maxClicksIndex = i;
                }
            }

            revenue += (long) pricesList.get(maxPriceIndex) * clicksList.get(maxClicksIndex);

            pricesList.remove(maxPriceIndex);
            clicksList.remove(maxClicksIndex);
        }

        return revenue;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> pricesList = new ArrayList<>();
        List<Integer> clicksList = new ArrayList<>();

        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            pricesList.add(scanner.nextInt());
        }
        for(int i = 0; i < n; i++){
            clicksList.add(scanner.nextInt());
        }

        long answer = maxRevenue(pricesList, clicksList);

        System.out.println(answer);
    }
}
