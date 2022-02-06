package com.ks.LeetCode.Array;

public class TwoDMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n=matrix[0].length;
            for (int i =0; i<m;i++) {
                for (int j=0; j<n; j++) {
                    if (target >= matrix[i][0] && target <= matrix[i][n-1]) {
                        System.out.println("matrix[i][0] = " + matrix[i][0]);
                        System.out.println("matrix[i][n-1] = " + matrix[i][n-1]);
                        if (target == matrix[i][j])
                            return true;
                    }
                }
            }
            return false;
    }

    public static boolean searchSortedMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n=matrix[0].length;
        for (int i =0; i<m;i++) {
            for (int j=0; j<n; j++) {
                if (target >= matrix[0][j] && target <= matrix[m-1][j]) {
                    System.out.println("matrix[0][j] = " + matrix[0][j]);
                    System.out.println("matrix[m-1][j] = " + matrix[m-1][j]);
                    if (target == matrix[i][j])
                        return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchSortedMatrix(matrix, 30));
    }
}
