
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
    static int round = 1;
    static boolean noWinners = true;    
    static String playerSymbol = "X";

    public static void main(String[] args) {
        makeGrid();
        while (noWinners) {
            playRound();
            round++;
            checkWin();
        }
        //resetGrid();
        playAgain();
    }

    public static void makeGrid() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = "[ ]";
            }
            round = 1;
        }
    }

    private static void printGrid() {
        System.out.println("Round " + round + ": ");

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
            }
            System.out.println();
        }
    }

    public static void playRound() {
        printGrid();

        if (XorO == 1) { 
            System.out.print("X, make your move (row,col): "); 
            XorO *= -1;
        } else if (XorO == -1) {
            System.out.print("O, make your move (row,col): ");
            XorO *= -1;
        }

        String getMove = input.nextLine();
        System.out.println();

        int row1 = Integer.parseInt(getMove.substring(0, 1));
        int col1 = Integer.parseInt(getMove.substring(2));
        checkValid(row1, col1);

        //if (checkValid) {
            grid[row1][col1] = "[" + playerSymbol + "]";
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (row == row1 && col == col1 && XorO == 1) { //&& grid[row1][col1] == "[ ]"
                        playerSymbol = "X"; 
                    } else if (row == row1 && col == col1 && XorO == -1) { //&& grid[row1][col1] == "[ ]"
                        playerSymbol = "O"; 
                    }
                }
            }
        //}
    }

    public static boolean checkValid(int r, int c) { 
        boolean moveIsValid = true;

        if (r >= 3 || c >= 3) {
            moveIsValid = false;
        }
        return moveIsValid;
    }

    public static void checkWin() {

    }

    public static void resetGrid() {
        grid = new String[3][3];
        round = 1;
    }

    public static void playAgain(){
        System.out.println("Play Again? Y/N");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("Y")) {
            noWinners = true;
            resetGrid();
        } else System.out.println("Thanks for playing!");
    }
}

//Do not allow the user to make invalid moves. If a player tries to place their symbol on a spot that has 
//already been taken, or if they enter a row or column beyond the bounds of a 3x3 grid, then force them 
//to make another move.

//After making a move, evaluate if the game has been won or not. If a player has won, display the winning 
//board and congratulate the winning player. If not, continue to the next round.
