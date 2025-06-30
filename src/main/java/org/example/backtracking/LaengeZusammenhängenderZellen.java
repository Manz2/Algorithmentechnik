package org.example.backtracking;

public class LaengeZusammenhängenderZellen {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        System.out.println(largestConnectedRegion(matrix));

    }

    private static int largestConnectedRegion(int[][] a){
        int[][] visited = new int[4][4];
        int max = 0;
        for(int i = 0; i<a.length; i++){
            for(int j = 0; j<a[0].length; j++){
                if(a[i][j] == 1 && visited[i][j] == 0){
                    int res = visit(i,j,visited,a);
                    if(res > max){
                        max = res;
                    }
                }
            }
        }
        return max;
    }

    private static int visit(int i, int j, int[][] visited, int[][] a) {
        visited[i][j] = 1;
        int streak = 1;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int newX = i + dx;
                int newY = j + dy;
                if(newX >= 0 && newY >= 0 && newX < a.length && newY < a.length && visited[newX][newY] == 0 && a[newX][newY] == 1){
                    streak += visit(newX,newY,visited,a);
                }
            }
        }
        return streak;
    }
}
