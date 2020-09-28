package tictactoe;

import java.util.Scanner;

public class Main {
    public static char[][] field;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        field = createFieldArray();
        printField(field);
        boolean isGameFinished = true;
        char symbol = 'X';
        char winner = 0;

        while (isGameFinished) {
            System.out.print("Enter coordinates: ");

            if (scanner.hasNextInt()) {
                int nextMove1 = scanner.nextInt();
                int nextMove2 = scanner.nextInt();

                if (nextMove1 > 3 || nextMove2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {

                    if (enterSymbol(nextMove1, nextMove2, symbol, field)) {
                        printField(field);
                        winner = checkWinner(field);
                        if (winner == 'I') {
                            System.out.println("Impossible");
                            isGameFinished = false;
                            break;
                        } else if (winner != 0) {
                            System.out.println(winner + " wins");
                            isGameFinished = false;
                            break;
                        } else if (checkField(field)) {
                            System.out.println("Draw");
                            isGameFinished = false;
                            break;
                        }
                        isGameFinished = !checkField(field);
                        symbol = switchSymbol(symbol);
                    }
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }

    private static char switchSymbol(char symbol) {
        switch (symbol) {
            case 'X':
                return 'O';
            case 'O':
                return 'X';
        }
        return 0;
    }


    private static boolean enterSymbol(int nextMove1, int nextMove2, char symbol, char[][] field) {
        int coordinate1 = 0;
        int coordinate2 = 0;

        if (nextMove1 == 1 && nextMove2 == 1) {
            coordinate1 = 2;
        } else if (nextMove1 == 1 && nextMove2 == 2) {
            coordinate1 = 1;
        } else if (nextMove1 == 2 && nextMove2 == 1) {
            coordinate1 = 2;
            coordinate2 = 1;
        } else if (nextMove1 == 2 && nextMove2 == 2) {
            coordinate1 = 1;
            coordinate2 = 1;
        } else if (nextMove1 == 2 && nextMove2 == 3) {
            coordinate2 = 1;
        } else if (nextMove1 == 3 && nextMove2 == 1) {
            coordinate1 = 2;
            coordinate2 = 2;
        } else if (nextMove1 == 3 && nextMove2 == 2) {
            coordinate1 = 1;
            coordinate2 = 2;
        } else if (nextMove1 == 3 && nextMove2 == 3) {
            coordinate2 = 2;

        }
        if (field[coordinate1][coordinate2] == ' ' || field[coordinate1][coordinate2] == '_') {
            field[coordinate1][coordinate2] = symbol;
            symbol = 'O';
            return true;
        }
        System.out.println("This cell is occupied! Choose another one!");
        return false;
    }

    private static boolean checkField(char[][] fieldArray) {
        int charXCount = 0;
        int charOCount = 0;
        int empty = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            for (int j = 0; j < fieldArray.length; j++) {
                if (fieldArray[i][j] == 'X') {
                    charXCount++;
                } else if (fieldArray[i][j] == 'O') {
                    charOCount++;
                } else if (fieldArray[i][j] == ' ' || fieldArray[i][j] == '_') {
                    empty++;
                }
            }
        }
        if (charXCount >= charOCount + 2 || charOCount >= charXCount + 2) {
            System.out.println("Impossible");
            return false;
        } else return empty <= 0;
    }

    private static char[][] createFieldArray() {
        char[][] chars = new char[3][3];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                chars[i][j] = ' ';
                count++;
            }
        }
        return chars;
    }

    private static char checkWinner(char[][] field) {
        char winner = 0;
        if (checkRows(field) == 'X') {
            return winner = 'X';
        } else if (checkRows(field) == 'O') {
            return winner = 'O';
        } else if (checkRows(field) == 'I') {
            return winner = 'I';
        } else if (checkColumns(field) == 'X') {
            return winner = 'X';
        } else if (checkColumns(field) == 'O') {
            return winner = 'O';
        } else if (checkColumns(field) == 'I') {
            return winner = 'I';
        } else if (checkDiagonal(field) == 'X') {
            return winner = 'X';
        } else if (checkDiagonal(field) == 'O') {
            return winner = 'O';
        }
        return winner;
    }

    private static char checkDiagonal(char[][] fieldArray) {
        char leftDiagonal = fieldArray[0][0];
        char rightDiagonal = fieldArray[0][fieldArray.length - 1];
        if (leftDiagonal == fieldArray[1][1] && leftDiagonal == fieldArray[2][2])
            return leftDiagonal;
        else if (rightDiagonal == fieldArray[1][1] && rightDiagonal == fieldArray[fieldArray.length - 1][0]) {
            return rightDiagonal;
        }
        return 0;
    }

    private static char checkColumns(char[][] fieldArray) {
        char winnerX = 0;
        char winnerO = 0;
        for (int i = 0; i < fieldArray.length; i++) {

            int xCount = 0;
            int oCount = 0;

            for (int j = 0; j < fieldArray.length; j++) {
                if (fieldArray[j][i] == 'X') {
                    xCount++;
                    if (xCount == 3) {
                        winnerX = 'X';
                    }
                } else if (fieldArray[j][i] == 'O') {
                    oCount++;
                    if (oCount == 3) {
                        winnerO = 'O';
                    }
                }

            }
        }
        return isPossible(winnerO, winnerX);
    }


    private static char checkRows(char[][] fieldArray) {
        char winnerO = 0;
        char winnerX = 0;
        for (char[] chars : fieldArray) {
            int xCount = 0;
            int oCount = 0;

            for (int j = 0; j < fieldArray.length; j++) {
                if (chars[j] == 'X') {
                    xCount++;
                    if (xCount == 3) {
                        winnerX = 'X';
                    }
                } else if (chars[j] == 'O') {
                    oCount++;
                    if (oCount == 3) {
                        winnerO = 'O';
                    }
                }
            }
        }
        return isPossible(winnerO, winnerX);
    }

    private static char isPossible(char winnerO, char winnerX) {
        if (winnerO == 'O' && winnerX == 'X') {
            return 'I';
        }
        if (winnerO == 'O') {
            return 'O';
        }

        if (winnerX == 'X') {
            return 'X';
        }

        return 0;
    }


    private static void printField(char[][] field) {
        System.out.print("---------\n");
        for (int i = 0; i < field.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < field.length; j++) {

                switch (field[i][j]) {
                    case 'X':
                        System.out.print("X ");
                        break;
                    case 'O':
                        System.out.print("O ");
                        break;
                    case '_':
                        System.out.print("_ ");
                        break;
                    default:
                        System.out.print("  ");
                }
            }
            System.out.print("|\n");
        }
        System.out.println("---------");

    }
}

