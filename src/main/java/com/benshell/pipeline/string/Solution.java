package com.benshell.pipeline.string;

public class Solution {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        rotate(matrix);
        for(int i = 0 ;i<matrix.length ;i++){
            for(int j = 0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void rotate(int[][] martix){
        int size = martix.length;
        for(int i = 0; i<size / 2 ;i++){
            System.out.println("---------" + i + "-----------");
            for(int j = i;j < size - i - 1 ;j++){
                int x = i;
                int y = j;
                int prev = martix[x][y];
                System.out.println("起点 x=" + x + " y=" + y);
                do{
                    int temp = x;
                    x = y;
                    y = size - 1 - temp;
                    System.out.println("x=" + x + " y=" + y);
                    int current = martix[x][y];
                    martix[x][y] = prev;
                    prev = current;
                }
                while(x != i || y != j);
            }
        }
    }

}
