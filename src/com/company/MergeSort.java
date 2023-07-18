package com.company;

public class MergeSort {

    static void mergeSortImpl(int[] values, int[] buffer, int l, int r){
        if(l < r){
            int m = (l + r)/2;
            mergeSortImpl(values, buffer, l, m);
            mergeSortImpl(values, buffer, m+1, r);

            int k = l;
            for(int i = l, j = m+1; i <= m || j <= r; ){
                if(j > r || (i <= m && values[i] < values[j])){
                    buffer[k] = values[i];
                    ++i;
                }
                else{
                    buffer[k] = values[j];
                    ++j;
                }
                ++k;
            }

            for(int i = l; i <= r; i++){
                values[i] = buffer[i];
            }
        }
    }

    static void mergeSort(int[] values){
        if(values.length > 0){
            int[] buffer = new int[values.length];
            mergeSortImpl(values, buffer, 0, values.length-1);
        }
    }

    static void bubbleSort(int[] values){
        for(int i = 0; i < values.length-1; i++){
            for(int j = i+1; j < values.length; j++){
                if(values[j] < values[i]){
                    int local = values[i];
                    values[i] = values[j];
                    values[j] = local;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] array1 = MaxMultiplication.generateArray(200000, -20000, 20000);
        int[] array2 = array1.clone();

        long start1 = System.currentTimeMillis();
        mergeSort(array1);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
//        bubbleSort(array2);
        long end2 = System.currentTimeMillis();

        System.out.println("MergeSort - " + (end1 - start1) + " ms");
//        for(int num : array1){
//            System.out.print(num + " ");
//        }
        System.out.println();
//        System.out.println("BubbleSort - " + (end2 - start2) + " ms");
//        for(int num : array2){
//            System.out.print(num + " ");
    }
}
