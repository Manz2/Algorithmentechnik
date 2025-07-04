package org.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 1, 0, 0}
        };
        int[][] visited = new int[maze.length][maze[0].length];
        List<int[]> path = new ArrayList<>();
        int[] start = new int[]{0,0};
        maze(maze,visited,start,path);
    }
    private static boolean maze(int[][] maze, int[][] visited, int[] visit,  List<int[]> path){
        int x = visit[0];
        int y = visit[1];

        if (x < 0 || x > maze.length-1 || y < 0 || y > maze.length-1 || maze[x][y] == 1 || visited[x][y]==1 ) {
            return false;
        }
        visited[x][y]=1;
        path.add(visit);
        if(visit[1]==maze.length-1 && visit[0]==maze[0].length-1){
            System.out.println("found");
            for(int[] i : path){
                System.out.println("("+i[0]+"," + i[1] +"), ");
            }
            return true;
        }
        if( //Links
            maze(maze,visited,new int[]{visit[0]-1,visit[1]},path) ||
            maze(maze,visited,new int[]{visit[0],visit[1]-1},path) ||
            maze(maze,visited,new int[]{visit[0]+1,visit[1]},path) ||
            maze(maze,visited,new int[]{visit[0],visit[1]+1},path)){
            return true;
        }
        path.removeLast();
        return false;
    }
}
