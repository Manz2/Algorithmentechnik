package org.example;

import java.util.ArrayList;
import java.util.List;

public class AehnlicheSumme {

    public static void main(String[] args) {
        int[] t = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(sum(t));
    }

    static List sum(int[] a) {
        int sum = 0;
        for(int n : a){
            sum += n;
        }
        int target = sum/2;
        boolean [][] s = new boolean[a.length][target+1];
        s[0][0] = true;

        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j<=target; j++) {
                if(s[i-1][j]){
                    s[i][j] = true;
                } else {
                    if(j-a[i] < 0){
                        continue;
                    }
                    if(s[i-1][j-a[i]]) {
                        s[i][j] = true;
                    }
                }
            }
        }
        int start =  0;
        for(int i = target; i >= 0; i--) {
            if(s[a.length-1][i]){
                start = i;
                break;
            }
        }
        List res = new ArrayList();
        for(int i = a.length-1; i >=0; i--){
            if(start == 0) return res;
            if(!s[i][start]) {
                res.add(a[i+1]);
                start -= a[i+1];
            }
        }
        return res;
    }
}
