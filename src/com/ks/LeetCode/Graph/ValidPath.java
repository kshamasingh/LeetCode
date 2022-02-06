package com.ks.LeetCode.Graph;

import java.util.ArrayList;

public class ValidPath {
        ArrayList<ArrayList<Integer>> al;
        boolean[] visited;
        boolean startFound = false;
        boolean endFound = false;

        public boolean validPath(int n, int[][] edges, int start, int end) {

            visited = new boolean[n];
            al = new ArrayList<>();
            for(int i=0;i<n;i++) al.add(new ArrayList<>());

            //Creating a Undirected Graph Completed.
            for(int i=0;i<edges.length;i++){
                al.get(edges[i][0]).add(edges[i][1]);
                al.get(edges[i][1]).add(edges[i][0]);
            }

            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(i,start,end);
                    if(startFound && endFound) return true;
                    else {
                        startFound = false;
                        endFound = false;
                    }
                }
            }

            return false;
        }

        public void dfs(int vertex,int start,int end){
            visited[vertex] = true;

            if(vertex == start) startFound = true;
            if(vertex == end) endFound = true;

            for(int ll : al.get(vertex))
                if(!visited[ll])
                    dfs(ll,start,end);

        }

        public void PrintGraph(ArrayList<ArrayList<Integer>> adj) {
            for (int i = 0; i < adj.size(); i++) {
                System.out.println("\n Adjacency list of vertex " + i);
                System.out.print(i);
                for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(" -> " + adj.get(i).get(j));
                }
                System.out.println();
            }
        }
}
