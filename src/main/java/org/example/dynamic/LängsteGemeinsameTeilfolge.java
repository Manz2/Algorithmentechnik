package org.example.dynamic;

public class LängsteGemeinsameTeilfolge {
    private static int folge(int[] a, int[] b){
        int[][] C = new int[a.length+1][b.length+1];
        C[0][0] = 0;
        // Alle felder sind in Java standartmäßig mit 0 initialisiert ich brauche in int[0][*] und int[*][0] sind 0
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if(a[i-1] == b[j-1]){
                    C[i][j] = C[i-1][j-1] +1;
                }else {
                    C[i][j] = Math.max(C[i-1][j],C[i][j-1]);
                }
            }
        }
        return C[a.length-1][b.length-1];
    }
}
