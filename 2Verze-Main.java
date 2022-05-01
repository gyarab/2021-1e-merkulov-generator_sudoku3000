package com.company;

public class Main {

    public static void main(String[] args) {
        // Vytvorim instaci sudoku generatoru
        SudokuRandomSolutionGenerator srsg = new SudokuRandomSolutionGenerator();
        // Vygeneruji sudoku
        srsg.generate();
        // Vytisknu cele sudoku
        srsg.print();
    }
}
