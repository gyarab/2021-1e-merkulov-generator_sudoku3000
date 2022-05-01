package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Vytvorim instaci generatoru sudoku 9x9
        SudokuGameGenerator9 sgg9 = new SudokuGameGenerator9();
        // Vytvorim instaci generatoru sudoku 6x6
        SudokuGameGenerator6 sgg6 = new SudokuGameGenerator6();
        // Vytvorim instaci generatoru sudoku 4x4
        SudokuGameGenerator4 sgg4 = new SudokuGameGenerator4();

        Scanner sc = new Scanner(System.in);
        System.out.println("What size of sudoku do you prefer?");
        System.out.println("4x4 (type 4)     6x6 (type 6)    9x9 (type 9)");
        int size = sc.nextInt();
        sc.nextLine();
        if (size == 4) {
            // Vypise sudoku 4x4
            System.out.println("Witch difficulty do you prefer?");
            System.out.println("Easy    Hard");
            String difficulty = sc.nextLine();
            sgg4.generate4(difficulty);
        }
        // Vypise sudoku 6x6
        else if (size == 6) {
            System.out.println("Witch difficulty do you prefer?");
            System.out.println("Easy    Medium    Hard");
            String difficulty = sc.nextLine();
            sgg6.generate6(difficulty);
        }
        // Vypise sudoku 9x9
        else if (size == 9) {
            System.out.println("Witch difficulty do you prefer?");
            System.out.println("Easy    Medium    Hard");
            String difficulty = sc.nextLine();
            sgg9.generate9(difficulty);
        }
        System.out.println("Enjoy your sudoku!");
    }
}
