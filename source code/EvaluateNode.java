package Utku_Celebioven_S017965;

import java.io.PrintStream;

public class EvaluateNode {


    public static int main(char[][] i_Board) {

        char player = 'O';
        char comp = 'X';
        int points = 0;

        for(int i = 0; i < i_Board.length; i++){
            for(int j = 0; j < i_Board[i].length; j++){

                // check horizontal
                try{
                    // computer
                    if (i_Board[i][j] == comp && i_Board[i + 1][j] == comp)
                        points += 10;
                    if (i_Board[i][j] == comp && i_Board[i + 1][j] == comp && i_Board[i + 2][j] == comp)
                        points += 100;
                    if (i_Board[i][j] == comp && i_Board[i + 1][j] == comp && i_Board[i + 2][j] == comp && i_Board[i+3][j] == comp)
                        points += 10000;

                    // human
                    if (i_Board[i][j] == player && i_Board[i + 1][j] == player)
                        points -= 10;
                    if (i_Board[i][j] == player && i_Board[i + 1][j] == player && i_Board[i + 2][j] == player)
                        points -= 100;
                    if (i_Board[i][j] == player && i_Board[i + 1][j] == player && i_Board[i + 2][j] == player && i_Board[i+3][j] == player)
                        points -= 10000;
                }catch (ArrayIndexOutOfBoundsException exception){

                }

                // check vertical
                try{
                    // computer
                    if(i_Board[i][j] == comp && i_Board[i][j + 1] == comp)
                        points += 10;
                    if(i_Board[i][j] == comp && i_Board[i][j + 1] == comp && i_Board[i][j + 2] == comp)
                        points += 100;
                    if(i_Board[i][j] == comp && i_Board[i][j + 1] == comp && i_Board[i][j + 2] == comp && i_Board[i][j+3] == comp)
                        points += 10000;

                    // human
                    if(i_Board[i][j] == player && i_Board[i][j + 1] == player)
                        points -= 10;
                    if(i_Board[i][j] == player && i_Board[i][j + 1] == player && i_Board[i][j + 2] == player)
                        points -= 100;
                    if(i_Board[i][j] == player && i_Board[i][j + 1] == player && i_Board[i][j + 2] == player && i_Board[i][j+3] == player)
                        points -= 10000;
                }catch (ArrayIndexOutOfBoundsException exception){

                }


                // check upward diagonal
                try{
                    // computer
                    if(j + 3 <= 6 && i_Board[i][j] == comp && i_Board[i + 1][j + 1] == comp)
                        points += 100;
                    if (j + 3 <= 6 && i_Board[i][j] == comp && i_Board[i + 1][j + 1] == comp && i_Board[i + 2][j + 2] == 0)
                        points += 100;
                    if (j + 3 <= 6 && i_Board[i][j] == comp && i_Board[i + 1][j + 1] == comp && i_Board[i + 2][j + 2] == 0 && i_Board[i+3][j + 3] == 0)
                        points += 10000;

                    // human
                    if(j + 3 <= 6 && i_Board[i][j] == player && i_Board[i + 1][j + 1] == player)
                        points -= 100;
                    if (j + 3 <= 6 && i_Board[i][j] == player && i_Board[i + 1][j + 1] == player && i_Board[i + 2][j + 2] == 0)
                        points -= 100;
                    if (j + 3 <= 6 && i_Board[i][j] == player && i_Board[i + 1][j + 1] == player && i_Board[i + 2][j + 2] == 0 && i_Board[i+3][j + 3] == 0)
                        points -= 10000;
                }catch (ArrayIndexOutOfBoundsException exception){

                }


                // check downward diagonal
                try{
                    // computer
                    if(j - 3 >= 0 && i_Board[i][j] == comp && i_Board[i+1][j - 1] == comp)
                        points += 10;
                    if(j - 3 >= 0 && i_Board[i][j] == comp && i_Board[i+1][j - 1] == comp && i_Board[i+2][j - 2] == 0)
                        points += 100;
                    if(j - 3 >= 0 && i_Board[i][j] == comp && i_Board[i+1][j - 1] == comp && i_Board[i+2][j - 2] == 0 && i_Board[i+3][j - 3] == 0)
                        points += 10000;

                    // human
                    if(j - 3 >= 0 && i_Board[i][j] == player && i_Board[i+1][j - 1] == player)
                        points -= 10;
                    if(j - 3 >= 0 && i_Board[i][j] == player && i_Board[i+1][j - 1] == player && i_Board[i+2][j - 2] == 0)
                        points -= 100;
                    if(j - 3 >= 0 && i_Board[i][j] == player && i_Board[i+1][j - 1] == player && i_Board[i+2][j - 2] == 0 && i_Board[i+3][j - 3] == 0)
                        points -= 10000;
                }catch (ArrayIndexOutOfBoundsException exception){

                }
            }
        }

        return points;

    }

}
