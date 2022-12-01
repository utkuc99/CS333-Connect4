package Utku_Celebioven_S017965;

import java.io.PrintStream;
import java.util.Scanner;

public class Connect4 {

    public static void main(String[] args) {

        PrintStream originalPrintStream = System.out;

        Scanner in = new Scanner(System.in);

        char[][] grid = new char[6][7];

        //initialize grid
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = '#';
            }
        }

        int turn = 1;
        char player = 'O';
        boolean winner = false;
        int depth = 0;

        System.out.print("Enter the search depth: ");
        depth = in.nextInt();

        //play a turn
        while (winner == false && turn <= 42){
            boolean validPlay;
            int play;
            do {
                display(grid);

                if(player == 'X'){
                    play = CreateTree.main(grid, depth, originalPrintStream);
                } else{
                    System.out.print("Player " + player + ", choose a column: ");
                    play = in.nextInt();
                }

                //check play
                validPlay = validate(play,grid);

            }while (validPlay == false);

            //put empty sign
            for (int row = grid.length-1; row >= 0; row--){
                if(grid[row][play] == '#'){
                    grid[row][play] = player;
                    break;
                }
            }

            //is there a winner ?
            winner = isWinner(player,grid);

            //switch players
            if (player == 'X'){
                player = 'O';
            }else{
                player = 'X';
            }

            turn++;
        }
        display(grid);

        if (winner){
            if (player=='X'){
                System.out.println("O won");
            }else{
                System.out.println("X won");
            }
        }else{
            System.out.println("Tie game");
        }

    }

    public static void display(char[][] grid){
        System.out.println("0 1 2 3 4 5 6");
        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                System.out.print(grid[row][col]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean validate(int column, char[][] grid){
        if (column < 0 || column > grid[0].length){
            return false;
        }

        if (grid[0][column] != '#'){
            return false;
        }

        return true;
    }

    public static boolean isWinner(char player, char[][] grid){
        //check for 4 across
        for(int row = 0; row<grid.length; row++){
            for (int col = 0;col < grid[0].length - 3;col++){
                if (grid[row][col] == player   &&
                        grid[row][col+1] == player &&
                        grid[row][col+2] == player &&
                        grid[row][col+3] == player){
                    return true;
                }
            }
        }
        //check for 4 up and down
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col] == player &&
                        grid[row+2][col] == player &&
                        grid[row+3][col] == player){
                    return true;
                }
            }
        }
        //check upward diagonal
        for(int row = 3; row < grid.length; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row-1][col+1] == player &&
                        grid[row-2][col+2] == player &&
                        grid[row-3][col+3] == player){
                    return true;
                }
            }
        }
        //check downward diagonal
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col+1] == player &&
                        grid[row+2][col+2] == player &&
                        grid[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }
}
