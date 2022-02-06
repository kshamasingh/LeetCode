package com.company.LeetCode;

public class PayPalTwo {

    /*
    *
Question 2:
    city: 0. 1.  2
    [i,j] =1 i!=j = connection between city
    [i,j]=1 i==j = city
    Connection Array: [[1,1,0],[1,1,0],[0,0,1]]
    Number of sectors = 2
    [1,1,0]
    [1,1,0]
    [0,0,1]


     0, 1, 2 ,3,4
    [1,1,0,0,0]   => 0-0, 0-1
    [1,1,1,0,0]   => 1-0, 1-1, 1-2
    [0,1,1,0,0]   => 3
    [0,0,0,1,0]
    [0,0,0,0,1]


    input : int [][]cities
    *
    * */

    public static int findCity(int [][]cities ) {
        int m =cities.length;
        int n = cities[0].length;
        boolean[][] visited = new boolean[m][n];
        int output = 0;

        for (int i =0; i<m; i++) {
            for (int j =0; j<n; j++) {

                if (cities[i][j]==1 && visited[i][j] == false) {
                    dfs(cities, visited, m , n,i, j);
                    output++;
                }


            }

        }
        return output;
    }

    private static void dfs(int[][] cities, boolean[][] visited, int m, int n, int i, int j){
        if(i>0 || j >0 || i <=m || j<=n || visited[i][j] == true || cities[i][j]==0)
            return;

        visited[i][j] = true;

        dfs(cities, visited, m , n,i+1, j);
        dfs(cities, visited, m , n,i-1, j);
        dfs(cities, visited, m , n,i, j+1);
        dfs(cities, visited, m , n,i, j-1);

    }

    public static void main(String[] args) {
//        System.out.println(findCity(new int[][] arr("{{0,1}, {1,0}}"));
    }
}
