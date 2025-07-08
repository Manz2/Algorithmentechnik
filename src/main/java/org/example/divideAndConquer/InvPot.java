package org.example.divideAndConquer;

public class InvPot {
    private static double invpov(double n, double y){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1.0/y;
        }

        double half = invpov(n/2,y);

        if(n%2==0){
            return half*half;
        }else{
            return (1.0/y)*half*half;
        }
    }
}
