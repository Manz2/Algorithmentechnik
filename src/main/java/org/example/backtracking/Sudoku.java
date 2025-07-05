package org.example.backtracking;

public class Sudoku {

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("Keine Lösung gefunden.");
        }
    }

    public static boolean solve(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if(board[row][col]==0){
                    for (int num = 1; num <= 9; num++) {
                        if(isValid(board,row,col,num)){ //O(n)
                            board[row][col] = num;
                            if(solve(board)){
                                return true;
                            }
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }

        }
        return true; // Dummy-Return
    }

    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < board.length-1; i++) {
            if(board[i][col]==num){
                return false;
            }
            if(board[row][i]==num){
                return false;
            }
        }
        for(int i = row - row % 3; i<=row % 3+2;i++){
            for(int j = col - col % 3; j<=col % 3+2;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true; // Dummy-Return
    }

    // Ausgabe des Sudoku-Boards
    public static void printBoard(int[][] board) {
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0 && r != 0) {
                System.out.println("-----------+-----------+-----------");
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0 && c != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + (board[r][c] == 0 ? "." : board[r][c]) + " ");
            }
            System.out.println();
        }
    }
}
