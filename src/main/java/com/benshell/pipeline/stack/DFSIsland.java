package com.benshell.pipeline.stack;

import java.util.HashSet;
import java.util.Set;

public class DFSIsland {


    public static void main(String[] args) {

    }

    public int numIslands(char[][] grid) {
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i = 0; i<grid.length; i ++){
            for(int j = 0 ; j<grid[i].length;j++){
                int key = i * grid[i].length + j;
                if(grid[i][j] == '1' && !visited.contains(key)){
                    count++;
                    //递归把上下左右的计入
                    dfs(grid,i,j,visited);
                }

            }
        }
        return count;
    }

    public void bfs(char[][] grid,int i , int j, Set<Integer> visited){
        //上方
        if(i != 0 && grid[i - 1][j] == '1'){
            int upKey = (i-1) * grid[i-1].length + j;
            if(!visited.contains(upKey)){
                visited.add(upKey);
                bfs(grid,i-1,j,visited);
            }
        }
        //下方
        if(i < grid.length - 1 && grid[i+1][j] == '1'){
            int downKey = (i+1) * grid[i+1].length + j;
            if(!visited.contains(downKey)){
                visited.add(downKey);
                bfs(grid,i+1,j,visited);
            }
        }
        //左
        if(j > 0 && grid[i][j-1] == '1'){
            int leftKey = i * grid[i].length + j -1;
            if(!visited.contains(leftKey)){
                visited.add(leftKey);
                bfs(grid,i,j-1,visited);
            }
        }
        //右
        if(j < grid[i].length - 1 && grid[i][j+1] == '1'){
            int rightKey = i * grid[i].length + j + 1;
            if(!visited.contains(rightKey)){
                visited.add(rightKey);
                bfs(grid,i,j+1,visited);
            }
        }
    }

    public void dfs(char[][] grid, int i,int j,Set<Integer> visited){
        if(i<0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0' || visited.contains(i * grid[i].length + j)){
            return ;
        }
        visited.add(i * grid[i].length + j);
        //上
        dfs(grid,i -1,j,visited);
        //下
        dfs(grid, i + 1, j,visited);
        //左
        dfs(grid, i,j-1,visited);
        //右
        dfs(grid,i,j+1,visited);
    }
}
