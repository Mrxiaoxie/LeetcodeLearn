package com.benshell.pipeline.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IlandNum {


    public static void main(String[] args) {
        IlandNum ilandNum = new IlandNum();
//        char[][] grid = new char[][]{
//                {'1','1','1','1','0'},
//                {'1','1','0','1','0'},
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'}
//        };
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
//        char[][] grid = new char[][]{
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };
        System.out.println(ilandNum.numIslands(grid));
    }



    public int numIslands(char[][] grid) {
        List<Integer> visited = new ArrayList<>();
        int count =0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && !visited.contains(i * m + j)){
                    count ++;
//                    bfs(i,j,grid,m,n,visited);
                    dfs(i,j,grid,m,n);
                }
            }
        }
        return count;
    }

    public void dfs(int i,int j,char[][] grid,int m, int n){
        if(i<0 || i >= m || j <0 || j >= n || grid[i][j] == '0'){
            return ;
        }
        grid[i][j] = '0';
        dfs(i-1,j,grid,m,n);
        dfs(i+1,j,grid,m,n);
        dfs(i,j-1,grid,m,n);
        dfs(i,j+1,grid,m,n);
    }

    public void bfs(int i ,int j, char[][] grid,int m, int n,List<Integer> visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i * n + j);
        while(!queue.isEmpty()){
            Integer id = queue.remove();
            visited.add(id);
            int line = id / n;
            int column = id % n;
            grid[line][column] = '0';
            if(line - 1 >= 0 ){
                //上方
                if(grid[line - 1][column] == '1' && !visited.contains((line - 1) * n + column)){
                    queue.add((line - 1) * n + column);
                    grid[line-1][column] = '0';
                }
            }
            if(line + 1 < m){
                //下方
                if(grid[line+ 1][column] == '1' && !visited.contains((line+ 1) * n +column)){
                    queue.add((line+ 1) * n +column);
                    grid[line+1][column] = '0';
                }

            }
            if(column - 1 >= 0){
                //左边
                if(grid[line][column - 1] == '1' && !visited.contains(line * n + column -1)){
                    queue.add(line * n + column -1);
                    grid[line][column-1] = '0';
                }
            }
            if(column +  1 < n){
                //右边
                if(grid[line][column +  1 ] == '1' && !visited.contains(line * n + column + 1)){
                    queue.add(line * n + column + 1);
                    grid[line][column+1] = '0';
                }
            }
        }
    }


}
