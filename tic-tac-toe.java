package tictactoe;

import java.util.Scanner;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static char[][] board;
    public static boolean complete = false;

    public static void main(String[] args) {
        createBoard();
        printBoard();
        //enterCells();
        //printBoard();
        while (true) {
            if (complete) {
                break;
            }
            takeTurnX();
            printBoard();
            checkWinner();
            if (complete) {
                break;
            }
            takeTurnO();
            printBoard();
            checkWinner();
        }
    }


    public static void createBoard() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    public static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    public static void enterCells() {
        System.out.print("Enter cells: ");
        String enteredGame = scan.nextLine();
        int next = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = enteredGame.charAt(next);
                next++;
            }
        }
    }

    public static void takeTurnX() {
        boolean coordinates = false;
        int x = 0;
        int y = 0;

        while (!coordinates) {
            System.out.println("Enter the coordinates: ");
            x = scan.nextInt();
            y = scan.nextInt();

            if ((x < 1 || x > 3) || (y < 1 || y > 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board[3 - y][x - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                coordinates = true;
            }
        }
        board[3 - y][x - 1] = 'X';
    }

    public static void takeTurnO() {
        boolean coordinates = false;
        int x = 0;
        int y = 0;

        while (!coordinates) {
            System.out.println("Enter the coordinates: ");
            x = scan.nextInt();
            y = scan.nextInt();

            if ((x < 1 || x > 3) || (y < 1 || y > 3)) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (board[3 - y][x - 1] != '_') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                coordinates = true;
            }
        }
        board[3 - y][x - 1] = 'O';
    }

    public static void checkWinner() {
        if (!complete) {
            checkImpossible();
        }
        if (!complete) {
            checkRows();
        }
        if (!complete) {
            checkColumns();
        }
        if (!complete) {
            checkDiagonalRight();
        }
        if (!complete) {
            checkDiagonalLeft();
        }
        if (!complete) {
            checkDraw();
        }
        //if (!complete) {
        //    System.out.println("Game not finished");
        //}
    }

    public static void checkRows() {
        int xWin = 0;
        int oWin = 0;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum = sum + (int) (board[i][j]);
            }
            if (sum == 264) {
                xWin++;
            }
            if (sum == 237) {
                oWin++;
            }
        }
        if (xWin + oWin == 2) {
            System.out.println("Impossible");
            complete = true;
        } else if (xWin == 1) {
            System.out.println("X wins");
            complete = true;
        } else if (oWin == 1) {
            System.out.println("O wins");
            complete = true;
        }

    }

    public static void checkColumns() {
        int xWin = 0;
        int oWin = 0;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum = sum + (int) (board[j][i]);
            }
            if (sum == 264) {
                xWin++;
            }
            if (sum == 237) {
                oWin++;
            }
        }
        if (xWin + oWin == 2) {
            System.out.println("Impossible");
            complete = true;
        } else if (xWin == 1) {
            System.out.println("X wins");
            complete = true;
        } else if (oWin == 1) {
            System.out.println("O wins");
            complete = true;
        }
    }

    public static void checkDiagonalRight() {
        int i = 0;
        int sum = 0;
        for (int j = 0; j < 3; j++) {
            sum = sum + (int) (board[j][i]);
            i++;
        }
        if (sum == 264) {
            System.out.println("X wins");
            complete = true;
        }
        if (sum == 237) {
            System.out.println("O wins");
            complete = true;
        }
    }

    public static void checkDiagonalLeft() {
        int i = 2;
        int sum = 0;
        for (int j = 0; j < 3; j++) {
            sum = sum + (int) (board[j][i]);
            i--;
        }
        if (sum == 264) {
            System.out.println("X wins");
            complete = true;
        }
        if (sum == 237) {
            System.out.println("O wins");
            complete = true;
        }
    }

    public static void checkDraw() {
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    x++;
                }
                if (board[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (x + o == 9) {
            System.out.println("Draw");
            complete = true;
        }
    }

    public static void checkImpossible() {
        int x = 0;
        int o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    x++;
                }
                if (board[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (Math.abs(x - o) > 1) {
            System.out.println("Impossible");
            complete = true;
        }
    }
}
