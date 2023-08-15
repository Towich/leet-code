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

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int L = s.nextInt();

        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = s.nextInt();
        }

        MergeSort.mergeSort(points);

        int segmentsCount = coverageSegments(L, points);
        System.out.println(segmentsCount);
    }
}
