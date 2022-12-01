package Utku_Celebioven_S017965;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class CreateTree {

    public static int main(char[][] i_Board, int depth, PrintStream originalPrintStream) {

        System.setOut(originalPrintStream);

        int lastnodeid = -1;
        int lastparentid = 0;
        String player = "X";

        String[][] newboard = new String[6][7];
        List<Node> tree = new ArrayList<>();
        List<Integer> parent_moves = new ArrayList<>();

        for(int i = 0; i < depth+1; i++){
            //System.out.println("DEPTH: " + i);
            if(player == "X")
                player = "O";
            else
                player = "X";
            for(int j = 0; j < Math.pow(7,i); j++){
                lastnodeid++;
                if(i == 0){
                    for (int x = 0; x < i_Board.length; ++x) {
                        for (int y = 0; y < i_Board[x].length; ++y) {
                            if(i_Board[x][y] == 'X')
                                newboard[x][y] = "X";
                            else if(i_Board[x][y] == 'O')
                                newboard[x][y] = "O";
                            else if(i_Board[x][y] == '#')
                                newboard[x][y] = "#";
                        }
                    }

                    Node new_node = new Node(lastnodeid,lastparentid+j/7, newboard, parent_moves);
                    tree.add(new_node);
                    //new_node.print();
                    //System.out.println();
                }

                if(i != 0) {
                    newboard = new String[6][7];
                    String[][] parent_board = tree.get(lastparentid+j/7).getBoard();

                    for (int x = 0; x < parent_board.length; ++x) {
                        for (int y = 0; y < parent_board[x].length; ++y) {
                            newboard[x][y] = parent_board[x][y];
                        }
                    }

                    parent_moves = new ArrayList<>();
                    for(int x = 0; x < tree.get(lastparentid+j/7).getMoves().size(); x++){
                        parent_moves.add(tree.get(lastparentid+j/7).getMoves().get(x));
                        //System.out.println("copied:" + x);
                    }

                    int a = 5;
                    while((newboard[a][j % 7] == "X" || newboard[a][j % 7] == "O") && a > 0)
                        a--;
                    newboard[a][j % 7] = player;
                    parent_moves.add(j % 7);

                    if(a!=0){
                        Node new_node = new Node(lastnodeid,lastparentid+j/7, newboard, parent_moves);
                        tree.add(new_node);
                        //new_node.print();
                        //System.out.println();
                    }
                }
            }
            lastparentid = (int) (lastparentid + Math.pow(7,i)/7);
        }

        //System.out.println("Tree Size:" + tree.size());
        //Evaluate childs and chose one

        int chosenchild = EvaluateTree.main(tree, originalPrintStream);
        //System.out.println("BFS chose this node: " + chosenchild);

        return tree.get(chosenchild).moves.get(0);

    }


}
