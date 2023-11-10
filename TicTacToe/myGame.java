
/**
 * Angela Chen
 * Nov. 9, 2023
 * 1-2
 */

import java.util.Scanner;

public class myGame {

    static Scanner input = new Scanner(System.in);
    static String[][] grid = new String[3][3];
    static int XorO = 1;
    static int round = 2;
    static boolean noWinners = true;         

    public static void main(String[] args) {
        System.out.println("Round 1:");
        printGrid();
        while (noWinners) {
            playRound();
            round++;
            checkWin();
        }
        resetGrid();
        playAgain();

    }

    public static String[][] printGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col] = "[" + playerSymbol + "]");
            }
            System.out.println();
        }
        return grid;
    }

    public static void playRound() {
        if (XorO == 1) { 
            System.out.print("X, make your move (row,col): "); 
            XorO *= -1;
        } else if (XorO == -1) {
            System.out.print("O, make your move (row,col): ");
            XorO *= -1;
        }

        String getMove = input.nextLine();
        System.out.println();
        System.out.println("Round " + round + ": ");

        int row1 = Integer.parseInt(getMove.substring(0, 1));
        int col1 = Integer.parseInt(getMove.substring(2));
        grid[row1][col1] = playerSymbol;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (row == row1 && col == col1 && XorO == 1) {
                    System.out.print(grid[row1][col1] = "[X]");
                } else if (row == row1 && col == col1 && XorO == -1) {
                    System.out.print(grid[row1][col1] = "[O]");
                } else {
                    System.out.print(grid[row][col] = "[ ]");
                }
            }
            System.out.println();
        }

    }
    
    public static void checkWin() {
        
    }

    public static void resetGrid() {
    }

    public static void playAgain(){
        //System.out.println("Play Again? Y/N");
        //String answer = input.nextLine();
    }
}
