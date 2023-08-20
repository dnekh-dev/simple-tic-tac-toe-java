package tictactoe;

import java.util.Scanner;

public class Main {

    public static char[][] gameField = new char[3][3];

    public static void main(String[] args) {
        // write your code here

        Scanner sc = new Scanner(System.in);
        String input = "_________";

        printInitialGameField();
        initializeGameField(input);

        int stepOf = 0;

        boolean isValid = false;
        while (!isValid) {
            String str = sc.nextLine();
            if (!checkForNumbers(str)) {
                System.out.println("You should enter numbers!");
            } else if (!checkForDiapason(str)) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else {
                int[] coords = getCoordinates(str);
                if (gameField[coords[0]][coords[1]] != 'X' && gameField[coords[0]][coords[1]] != 'O' && stepOf % 2 == 0) {
                    gameField[coords[0]][coords[1]] = 'X';
                    stepOf++;
                } else if (gameField[coords[0]][coords[1]] != 'X' && gameField[coords[0]][coords[1]] != 'O' && stepOf % 2 != 0) {
                    gameField[coords[0]][coords[1]] = 'O';
                    stepOf++;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }

            printGameField();

            if (winnerIs('X')) {
                System.out.println("X wins");
                break;
            } else if (winnerIs('O')) {
                System.out.println("O wins");
                break;
            } else if (stepOf == 9) {
                System.out.println("Draw");
                break;
            }
        }
    }


    public static void initializeGameField(String input) {
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameField[i][j] = input.charAt(index);
                index++;
            }
        }
    }

    public static int[] getCoordinates(String str) {
        String[] parts = str.split(" ");
        return new int[]{Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[1]) - 1};
    }

    public static boolean checkForDiapason(String str) {
        String[] parts = str.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        return x >= 1 && x <= 3 && y >= 1 && y <= 3;
    }

    public static boolean checkForNumbers(String str) {
        String[] parts = str.split(" ");
        if (parts.length != 2) {
            return false;
        }

        try {
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void printInitialGameField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print("_ ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static void printGameField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(gameField[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean winnerIs(char ch) {
        for (int i = 0; i < 3; i++) {
            if (gameField[i][0] == ch && gameField[i][1] == ch && gameField[i][2] == ch) return true;
            if (gameField[0][i] == ch && gameField[1][i] == ch && gameField[2][i] == ch) return true;
        }

        if (gameField[0][0] == ch && gameField[1][1] == ch && gameField[2][2] == ch) return true;
        if (gameField[0][2] == ch && gameField[1][1] == ch && gameField[2][0] == ch) return true;

        return false;
    }
}
