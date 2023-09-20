package com.company.greedy;

import com.company.MergeSort;

import java.util.Scanner;

public class CoveragePoints {

    static int coverageSegments(int segmentLength, int[] points) {
        if (points.length == 1)
            return 1;

        int segmentsCount = 0;

        int currIndex = 0;
        int n = points.length;
        while (currIndex < n) {
            int firstPoint = points[currIndex];

            do {
                currIndex++;
            }
            while (currIndex < n && points[currIndex] - firstPoint <= segmentLength);

            segmentsCount++;
        }

        return segmentsCount;
    }

    static int coveragePointsMinimalSegments(int numOfPoints, int countOfLines, int minNum, int maxNum){
        if(countOfLines >= numOfPoints)
            return 0;

        float m_max = (maxNum - minNum) / (float)countOfLines;

        for(int m = 1; m <= m_max; m++){
            if(m * countOfLines < (maxNum - minNum))
                continue;
            return m;
        }

        return 5;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int minNum;
        int maxNum;

        int n = s.nextInt();
        int k = s.nextInt();

        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = s.nextInt();
        }

        minNum = points[0];
        maxNum = points[0];

        for (int p:points) {
            if(p < minNum)
                minNum = p;
            if(p > maxNum)
                maxNum = p;
        }

        int segmentsCount = coveragePointsMinimalSegments(n, k, minNum, maxNum);
        System.out.println(segmentsCount);
    }
}
