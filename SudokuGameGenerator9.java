package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * Vytvari nahodne sudoku 9x9
 * Parametry: matrix - 2D pole
 *            ssg9 - SudokuSolutionGenerator9
 *            Random
 * Konstruktory: trida ma jeden bezparametricky konstruktor,
 *               ktery nastavi velikost pole a vytvori instaci generatoru reseni sudoku 9x9
 * Metody:
 *        remove - odstranuje cisla z nahodnych policek sudoku
 *        generateLevel - urcuje kolik cisel mame vymazat ze sudoku
 *        generate9 - vygeneruje sudoku 9x9
 *        print - vypise cele sudoku 9x9 do graficke sceny
 */
public class SudokuGameGenerator9 {
    Random r = new Random();
    public int matrix[][];
    SudokuSolutionGenerator9 ssg9;

    // Konstruktor
    SudokuGameGenerator9() {
        this.matrix = new int[9][9];
        ssg9 = new SudokuSolutionGenerator9();
    }

    /*
     * Funkce odstranuje cisla z nahodnych policek sudoku
     * Funkce na vstupu dostane cislo,ktere urcuje pocet cislic,
     * ktere odstranime
     * Vygeneruje se nahodne cislo od 0-81 a to cislo je cislo policka v 2D poli (cellNumber),
     * potom zjisti radek (rowNumber) vygenerovaneho cisla pomoci deleni nahodneho cisla 9 (51/9 = 5),
     * pak pomoci operace modulo zjisti sloupec (columnNumber) nahodneho cisla (51 % 9 = 6)
     * policko, na souradnicich rowNumber a columnNumber, se prepise na 0
     */
    public void remove(int Number) {
        // Urcuje pocet cislic, ktere vymazeme z pole s resenim sudoku
        int removedNumber = Number;
        // Dokud nebude pocet vymazanych cislic 0
        while (removedNumber != 0) {
            // Vygeneruji nahodne cislo od 0-81
            int cellNumber = this.r.nextInt(81);
            // Zjistim radek vygenerovaneho cisla
            int rowNumber = cellNumber / 9;
            // Zjistim sloupec vygenerovaneho cisla
            int columnNumber = cellNumber % 9;
            if (matrix[rowNumber][columnNumber] != 0) {
                matrix[rowNumber][columnNumber] = 0;
                removedNumber--;
            }
        }
    }

    /*
     * Funkce dostane na vstupu textovy retezec, ktery urcuje obtiznost
     * Funkce urcuje kolik cisel mame vymazat ze sudoku
     */
    private int generateLevel(String difficulty) {
        if (difficulty.equals("Easy")) {
            // Vygeneruje cislo v rozmezi 41 - 48
            return 41 + this.r.nextInt(8);
        } else if (difficulty.equals("Medium")) {
            // Vygeneruje cislo v rozmezi 49 - 56
            return 49 + this.r.nextInt(8);
        } else if (difficulty.equals("Hard")) {
            // Vygeneruje cislo v rozmezi 57 - 64
            return 57 + this.r.nextInt(8);
        } else {
            return 0;
        }
    }

    /*
     * Funkce dostane na vstupu textovy retezec, ktery urcuje obtiznost
     * Funkce vygeneruje sudoku 9x9
     */
    public void generate9(String difficulty) {
        // Vygeneruji reseni 9x9 sudoku
        ssg9.generate9();
        // Nastavim pole s resenim sudoku do pole teto tridy
        this.matrix = ssg9.matrix;
        System.out.println(difficulty);
        int level = generateLevel(difficulty);
        remove(level);
        print();
    }

    /*
     * Funkce vypise cele sudoku 9x9 do graficke sceny
     */
    public void print() {
        // Pojmenuji si grafickou scenu
        JFrame f = new JFrame("Sudoku");
        // Vytvorim si graficke textove pole 9x9
        JLabel board[][] = new JLabel[9][9];
        // Vytvorim si mrizkovanou tabulku
        JPanel Board = new JPanel(new GridLayout(9, 9));
        // Prochazim pole od leveho horniho rohu
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Pokud se policko rovna 0 v grafickem poli se na tomto policku nezobrazi nic
                if (this.matrix[i][j] == 0) {
                    board[i][j] = new JLabel("");
                }
                else {
                    // String.valueOf(arr[i][j]) - nastavim int z policka na hodnotu String
                    // Vlozim int v hodnote String do grafickeho policka
                    board[i][j] = new JLabel(String.valueOf(this.matrix[i][j]));
                }
                    // Nastavim si barvu mrizky
                    board[i][j].setBorder(BorderFactory.createLineBorder(Color.PINK));
                    // Nastavim si styl a velikost pisma
                    Font font = new Font("Arial", Font.PLAIN, 20);
                    board[i][j].setFont(font);
                    // Nastavim barvu popredi
                    board[i][j].setForeground(Color.BLACK);
                    // Nastavim barvu pozadi
                    board[i][j].setBackground(Color.BLACK);
                    // Vycentruji graficke pole
                    board[i][j].setHorizontalAlignment(JTextField.CENTER);
                    // Pridam graficke pole do grafickeho okna
                    Board.add(board[i][j]);
            }
        }
        // Pridam graficke okno na grafickou scenu
        f.add(Board);
        // Nastavim rozmery graficke sceny
        f.setSize(400, 400);
        // Nastavim viditelnou scenu
        f.setVisible(true);
    }
}