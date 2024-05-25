package com.hello;

import java.util.ArrayList;
import java.util.List;

public class RatMazeIII {
    static List<String> list;
    private static int mazeIII(int i, int j, int n, int m, String str, int [][]maze){
        if(i<0 || i>n || j<0 || j>m) return 0;
        if(maze[i][j]==0) return 0;
        if(i==n && j==m){
            list.add(str);
            return 1;
        }

        maze[i][j] = 0;
        int right = mazeIII(i, j+1, n, m, str+"R", maze);
        int left = mazeIII(i, j-1, n, m, str+"L", maze);
        int up = mazeIII(i-1, j, n, m, str+"U", maze);
        int down = mazeIII(i+1, j, n, m, str+"D", maze);
        maze[i][j] = 1;
        return left + right + up + down;
    }
    public static void main(String[] args) {
        int [][]maze = {{1,0,1,1},
                        {1,1,1,1},
                        {1,1,0,1}};
        list = new ArrayList<>();
        int result = mazeIII(0, 0, maze.length-1, maze[0].length-1, "", maze);
        System.out.println(result);
        for(String str : list) System.out.println(str);
    }
}
