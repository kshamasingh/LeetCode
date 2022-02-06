package com.ks.LeetCode.Array;

public class TotalSurfaceArea {

    public static int surfaceArea(int[][] grid) {
        int area = 0;
            for (int i=0;i<grid.length; i++) {
                for (int j=0;j<grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        area += 6 * (grid[i][j]) - 2 * (grid[i][j] - 1);
                        System.out.println("grid[" + i + "][ " + j + "] = " + grid[i][j]);
                        System.out.println("area = " + area);
                    }
                    if (i>0) {
                        area -= 2* Math.min(grid[i][j], grid[i-1][j]);
                        System.out.println("FIND MIN" );

                        System.out.println("grid[" + i + "][ " + j + "] = " + grid[i][j]);
                        System.out.println("grid[" + (i-1) + "][ " + j + "] = " + grid[i-1][j]);
                        System.out.println("area = " + area);
                    }
                    if (j>0) {
                        area -= 2* Math.min(grid[i][j-1], grid[i][j]);
                        System.out.println("********* FIND MIN **********" );
                        System.out.println("grid[" + i + "][ " + j + "] = " + grid[i][j]);
                        System.out.println("grid[" + i + "][ " + (j-1) + "] = " + grid[i][j-1]);
                        System.out.println("area = " + area);
                    }
                }
            }
            return area;
    }

    public static void main(String[] args) {
        int[][] grid =  {{1,2},{3,4}};
        System.out.println(surfaceArea(grid));
    }
}
