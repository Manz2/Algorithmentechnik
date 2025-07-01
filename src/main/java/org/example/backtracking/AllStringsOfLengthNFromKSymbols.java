package org.example.backtracking;

public class AllStringsOfLengthNFromKSymbols {
    public static void main(String[] args) {
        char[] a = new char[]{'0','1'};
        StringBuilder s = new StringBuilder();
        asol(3,a,s);
    }

    private static void asol(int length, char[] alphabet, StringBuilder s){

        if(length == 0){
            System.out.println(s.toString());
            return;
        }
        for(char c : alphabet){
            s.append(c);
            asol(length-1,alphabet,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
//Laufzeit O(n^m) mit n alphabet und m ist länge
