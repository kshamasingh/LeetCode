package com.company.LeetCode.Array;

public class Matrix {

    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int row = mat.length; // row
        int col = mat[0].length; // col

        int[] arr = new int[r*c];
        int k=0;
        int[][] output = new int[r][c];
        int R = 0, C = 0;
        if (row * col == r * c) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    arr[k++] = mat[i][j];
                }
            }

            int q =0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    output[i][j] = arr[q++];
                }
            }
            return output;

        }

        return mat;
    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int q =0;
        int[][] output = new int[m][n];

        if(original.length == m*n) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    output[i][j] = original[q++];
                }
            }
            return output;
        }
        return new int[0][0];
    }

    public static void main(String[] args) {

    }
}
