package Utku_Celebioven_S017965;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
    int id;
    int parent;
    String board[][] = new String[6][7];
    List<Integer> moves = new ArrayList<>();

    public Node(int i_id, int i_parent, String[][] i_board, List<Integer> i_moves) {
        this.id = i_id;
        this.parent = i_parent;
        for (int i = 0; i < i_board.length; ++i) {

            for (int j = 0; j < i_board[i].length; ++j) {
                this.board[i][j] = i_board[i][j];
            }
        }
        this.moves = i_moves;
    }

    public String[][] getBoard(){
        return this.board;
    }

    public List<Integer> getMoves(){
        return this.moves;
    }

    public void print() {
        System.out.println("id:" + this.id + "; parent:" + this.parent);
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }

    }

}
