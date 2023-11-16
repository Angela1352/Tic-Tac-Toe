
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
        while (noWinners && round <= 9) {
            playRound();
            checkWin();
            round++;
        }
        if (round > 9 && noWinners) {
            System.out.println("It's a tie!");
        }
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

        boolean validInput = false;

        while (!validInput) {
            if (XorO == 1) System.out.print("X, make your move (row,col): "); 
            else System.out.print("O, make your move (row,col): ");

            String getMove = input.nextLine();
            System.out.println();

            int row1 = Integer.parseInt(getMove.substring(0, 1));
            int col1 = Integer.parseInt(getMove.substring(2, 3));

            if (row1 < 3 && col1 < 3 && grid[row1][col1].equals("[ ]")) {
                grid[row1][col1] = "[" + playerSymbol + "]";
                XorO *= -1;

                if (XorO == 1) playerSymbol = "X"; 
                else if (XorO == -1) playerSymbol = "O";

                validInput = true;
            } else {
                System.out.println("Invalid move! Try again!");
            }
        }

    }

    public static void checkWin() {
        for (int i = 0; i < 3; i++) {
            if (grid[i][0].equals("[X]") && grid[i][1].equals("[X]") && grid[i][2].equals("[X]") ||
            grid[i][0].equals("[O]") && grid[i][1].equals("[O]") && grid[i][2].equals("[O]")) {
                displayWin(grid[i][0]);
            }
            if (grid[0][i].equals("[X]") && grid[1][i].equals("[X]") && grid[2][i].equals("[X]") ||
            grid[0][i].equals("[O]") && grid[1][i].equals("[O]") && grid[2][i].equals("[O]")) {
                displayWin(grid[0][i]);
            }
        }

        if ((grid[0][0].equals("[X]") && grid[1][1].equals("[X]") && grid[2][2].equals("[X]")) ||
        (grid[0][0].equals("[O]") && grid[1][1].equals("[O]") && grid[2][2].equals("[O]")) ||
        (grid[0][2].equals("[X]") && grid[1][1].equals("[X]") && grid[2][0].equals("[X]")) ||
        (grid[0][2].equals("[O]") && grid[1][1].equals("[O]") && grid[2][0].equals("[O]"))) {
            displayWin(grid[1][1]);
        }
    }

    public static void displayWin(String symbol) {
        printGrid();
        if (symbol.equals("[X]")) System.out.println("Player X wins! \n");
        else System.out.println("Player O wins! \n");
        noWinners = false;
    }

    public static void playAgain(){
        System.out.println("Play Again? Y/N");
        String answer = input.nextLine();
        System.out.println();

        if (answer.equalsIgnoreCase("Y")) {
            noWinners = true;
            makeGrid();
            round = 1;

            while (noWinners && round <= 9) {
                playRound();
                checkWin();
                round++;
            }
            if (round > 9 && noWinners) System.out.println("It's a tie!");
            playAgain();
        } else System.out.println("Thanks for playing!");
    }
}
