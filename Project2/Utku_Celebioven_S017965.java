package com.utkuc99;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        System.out.println("number of outlets ??");
        int num_outlets = myScan.nextInt();
        myScan.nextLine();

        System.out.println("enter outlets on the wall (from up to down)");
        String input1 = myScan.nextLine();
        String[] outlets = input1.split(" ");

        System.out.println("enter lamps on the other wall (from up to down)");
        String input2 = myScan.nextLine();
        String[] lamps = input2.split(" ");

        String[] onlamps;
        onlamps = solve_dynamically(num_outlets, outlets, lamps);
        int count = onlamps.length;

        System.out.println(count);
        for(int i = onlamps.length-1; i > -1; i--){
            System.out.print(onlamps[i]);
            System.out.print(" ");
        }
    }

    private static String[] solve_dynamically(int num_outlets, String[] outlets, String[] lamps) {
        
        int[][] table = new int[num_outlets][num_outlets];

        for (int i = 0; i < num_outlets; i++) {
            for (int j = 0; j < num_outlets; j++) {
                if (outlets[i].equals(lamps[j])) {
                    if(i > 0 && j > 0){
                        table[i][j] = table[i][j - 1] + 1;
                    }else{
                        table[i][j] = 1;
                    }
                }
                else {
                    if(i > 0 && j > 0){
                        table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                    }else if(i > 0){
                        table[i][j] = table[i - 1][j];
                    }
                    else if(j > 0){
                        table[i][j] = table[i][j-1];
                    }
                }
            }
        }
        
        String[] onlamps = new String[table[num_outlets - 1][num_outlets - 1]];
        int n = 0;
        int j = num_outlets;
        for (int i = num_outlets - 1; i >= 0; i--) {
            if (table[i][j - 1] != 0 && table[i][j - 1] != table[i - 1][j - 1]) {
                onlamps[n] = outlets[i];
                n++;
                j = j - table[i - 1][j - 1];
            }
        }
        
        return onlamps;

    }
}
