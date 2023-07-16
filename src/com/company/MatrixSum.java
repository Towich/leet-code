package com.company;

import java.util.Scanner;

public class MatrixSum {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];
        int[][] resultMatrix = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix1[i][j] = s.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix2[i][j] = s.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
