package org.example.divideAndConquer;

public class Oktal {
    public static void main(String[] args) {
        oktal(17);
    }
    static void oktal(int n) {
        if (n > 0) {
            oktal(n / 8);    // Teile: Bearbeite kleinere Zahl
            System.out.print(n % 8);
        }
    }

    void oktal2(int n) {
        if (n >= 8) {
            oktal(n / 8);    // Teile: Bearbeite kleinere Zahl
        }
        System.out.print(n % 8);   // Herrsche: Gib aktuelle Oktalstelle aus
    }


}
