package com.company.greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectSigns {
    /*

            3
            1 3   |     ------------|
            2 5   |           ------|------------
            3 6   |                 |------------------             answer: 3
                  |-----1-----2-----3-----4-----5-----6-----7


            4
            4 7   |                       -------------------
            1 3   |     ------------|
            2 5   |           ------|------------
            3 6   |                 |------------------             answer: 3 + [4;7]
                  |-----1-----2-----3-----4-----5-----6-----7

     */
    static List<Integer> minHomeEntries(List<Integer> leftList, List<Integer> rightList){
        List<Integer> listOfEntries = new ArrayList<>();

        while(!rightList.isEmpty()){
            int min_rightIndex = 0;

            for(int i = 1; i < rightList.size(); i++){
                if(rightList.get(i) < rightList.get(min_rightIndex))
                    min_rightIndex = i;
            }

            int superRight = rightList.get(min_rightIndex);
            listOfEntries.add(rightList.get(min_rightIndex));

            for(int i = leftList.size() - 1; i >= 0; i--){
                if(leftList.get(i) <= superRight){
                    leftList.remove(i);
                    rightList.remove(i);
                }
            }
        }

        return listOfEntries;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        int n = scanner.nextInt();

        for(int i = 0; i < n; i++){
            leftList.add(scanner.nextInt());
            rightList.add(scanner.nextInt());
        }

        List<Integer> listOfEntries = minHomeEntries(leftList, rightList);
        int answer = listOfEntries.size();
        System.out.println(answer);

        for(int i = 0; i < answer; i++){
            if(i == 0)
                System.out.print(listOfEntries.get(i));
            else
                System.out.print(" " + listOfEntries.get(i));
        }
    }
}
