package lesson1;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class java_hw4_nasirov_m {
    static final int SIZE = 3;
    static final int DOTS_TO_WIN = 3;

    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '.';

    static char[][] map;

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        checkWin(DOT_X);
        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if(checkWin(DOT_X)){
                System.out.println("Вы победитель!");
                sc.close();
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                sc.close();
                break;
            }

            aiTurn();
            printMap();
            if(checkWin(DOT_O)){
                System.out.println("Комьютер победил!");
                sc.close();
                break;
            }
            if (isFull()) {
                System.out.println("Ничья!");
                sc.close();
                break;
            }
        }


    }


    static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Input coordinates X");
            x = sc.nextInt() - 1;
            System.out.println("Input coordinates Y");
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));

        map[y][x] = DOT_X;
    }

    static void aiTurn() {
        int x;
        int y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));

        map[y][x] = DOT_O;
    }


    static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char c) {
        int count =0;
        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(map[i][j]==c){
                    count++;
                }
                if(count==SIZE){
                    return true;
                }
            }
            count =0;
        }

        for(int i=0;i<SIZE;i++){
            for(int j=0;j<SIZE;j++){
                if(map[j][i]==c){
                    count++;
                }
                if(count==SIZE){
                    return true;
                }
            }
            count =0;
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == j) {
                    if(map[i][j] ==c);{
                        count++;
                    }
                    if(count==SIZE){
                        return true;
                    }
                }
            }
            count =0;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i + j == (SIZE - 1)) {
                    if(map[i][j] ==c);{
                        count++;
                    }
                    if(count==SIZE){
                        return true;
                    }
                }
            }
            count =0;
        }
        return false;
    }
}
