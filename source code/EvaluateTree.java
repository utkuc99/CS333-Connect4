package Utku_Celebioven_S017965;

import java.io.PrintStream;
import java.util.List;

public class EvaluateTree {

    public static int main(List<Node> tree, PrintStream originalPrintStream) {

        int maxpoint = 0;
        int maxnode = 0;

        for(int i = 0; i < tree.size(); i++){
            Node inspecting = tree.get(i);
            String[][] board = inspecting.getBoard();
            char[][] cboard = new char[6][7];
            for(int x = 0; x < cboard.length; x++){
                for(int y = 0; y < cboard[x].length ; y++){
                    cboard[x][y] = board[x][y].charAt(0);
                }
            }

            int point_of_node = EvaluateNode.main(cboard);
            //System.out.println("Node:" + i + ", p:" + point_of_node + ", max: " + maxpoint);
            if(point_of_node > maxpoint) {
                maxpoint = point_of_node;
                maxnode = i;
            }

        }
        return maxnode;
    }
}
