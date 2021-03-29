package Lesson4;

import java.util.Scanner;
import java.util.Random;

public class HomeWork4 {
    private static final int SIZE = 3;

    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_Y = 'Y';
    private static final char DOT_T = 'T';
    private static final char DOT_EMPTY = '.';

    private static char[][] map = new char[SIZE][SIZE];

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        do {
            humanTurn();
            printMap();
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            } else if (isWin(DOT_X)) {
                System.out.println("Вы выйграли!");
                break;
            }


            cpuTurn(DOT_O);
            printMap();
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            } else if (isWin(DOT_O)) {
                System.out.println("Вы проиграли!");
                break;
            }

            if (SIZE > 3) {

                cpuTurn(DOT_Y);
                printMap();
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                } else if (isWin(DOT_Y)) {
                    System.out.println("Вы проиграли");
                    break;
                }

                cpuTurn(DOT_T);
                printMap();
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                } else if (isWin(DOT_T)) {
                    System.out.println("Вы проиграли");
                    break;
                }
            }
        } while (true);
    }

    private static void initMap() {
        int size_j = map.length;
        for (int j = 0; j < size_j; j++) {
            int size_i = map[j].length;
            for (int i = 0; i < size_i; i++) {
                map[j][i] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int size_j = map.length;
        for (int j = 0; j < size_j; j++) {
            System.out.print((j + 1) + " ");
            int size_i = map[j].length;
            for (int i = 0; i < size_i; i++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.print("Введите координату X = ");
            x = scanner.nextInt() - 1;

            System.out.print("Введите координату Y = ");
            y = scanner.nextInt() - 1;

            System.out.println();

        } while (!isPointValid(x, y));
        map[y][x] = DOT_X;
    }

    private static void cpuTurn(char symbol) {
        int x;
        int y;
        do {
            int[] coords = isHumanWinSoon();
            if (coords[0] == -1 || !isPointValid(coords[0], coords[1])) {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } else {
                x = coords[0];
                y = coords[1];
            }

            System.out.println();
        } while (!isPointValid(x, y));

        map[y][x] = symbol;
    }

    private static boolean isPointValid(int x, int y) {
        boolean result = map[y][x] == DOT_EMPTY;
        result &= x >= 0 && x < SIZE;
        result &= y >= 0 && y < SIZE;

        return result;
    }

    static private boolean isMapFull() {
        int size_j = map.length;

        for (int j = 0; j < size_j; j++) {
            int size_i = map[j].length;
            for (int i = 0; i < size_i; i++) {
                if (map[j][i] == DOT_EMPTY) {
                    return false;
                }
            }
        }

        return true;
    }


    static private boolean isWin(char symbol) {

        for (int j = 0; j < SIZE; j++) {
            boolean isWinHor = true;
            boolean isWinVert = true;
            for (int i = 0; i < SIZE; i++) {
                isWinHor &= map[j][i] == symbol;
                isWinVert &= map[i][j] == symbol;
            }

            if (isWinHor || isWinVert) {
                return true;
            }
        }

        boolean isWinDiagMain = true;
        boolean isWinDiagSide = true;

        for (int i = 0; i < SIZE; i++) {
            isWinDiagMain &= map[i][i] == symbol;
            isWinDiagSide &= map[i][SIZE - i - 1] == symbol;
        }

        return isWinDiagMain || isWinDiagSide;
    }

    private static int[] isHumanWinSoon() {
        //Анализ горизонталей
        for (int j = 0; j < SIZE; j++) {

            if (map[j][0] == DOT_X && map[j][1] == DOT_X) {
                int[] res = {2, j};
                return res;
            }

            if (map[j][1] == DOT_X && map[j][2] == DOT_X) {
                int[] res = {0, j};
                return res;
            }

            if (map[j][0] == DOT_X && map[j][2] == DOT_X) {
                int[] res = {1, j};
                return res;
            }
        }

        //Анализ вертикалей
        for (int i = 0; i < SIZE; i++) {

            if (map[0][i] == DOT_X && map[1][i] == DOT_X) {
                int[] res = {i, 2};
                return res;
            }

            if (map[1][i] == DOT_X && map[2][i] == DOT_X) {
                int[] res = {i, 0};
                return res;
            }

            if (map[0][i] == DOT_X && map[2][i] == DOT_X) {
                int[] res = {i, 1};
                return res;
            }
        }

        //Анализ диагоналей

        if (map[0][0] == DOT_X && map[1][1] == DOT_X) {
            int[] res = {2, 2};
            return res;
        }

        if (map[0][0] == DOT_X && map[2][2] == DOT_X) {
            int[] res = {1, 1};
            return res;
        }

        if (map[1][1] == DOT_X && map[2][2] == DOT_X) {
            int[] res = {0, 0};
            return res;
        }


        if (map[0][2] == DOT_X && map[1][1] == DOT_X) {
            int[] res = {0, 2};
            return res;
        }

        if (map[0][2] == DOT_X && map[2][0] == DOT_X) {
            int[] res = {1, 1};
            return res;
        }

        if (map[1][1] == DOT_X && map[2][0] == DOT_X) {
            int[] res = {2, 0};
            return res;
        }

        int[] res = {-1, -1};
        return res;
    }
}
