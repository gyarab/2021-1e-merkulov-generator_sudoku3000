package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * Vytvari nahodne sudoku 4x4
 * Parametry: matrix - 2D pole
 *            ssg4 - SudokuSolutionGenerator4
 *            Random
 * Konstruktory: trida ma jeden bezparametricky konstruktor,
 *               ktery nastavi velikost pole a vytvori instaci generatoru reseni sudoku 4x4
 * Metody:
 *        remove - odstranuje cisla z nahodnych policek sudoku
 *        generateLevel - urcuje kolik cisel mame vymazat ze sudoku
 *        generate4 - vygeneruje sudoku 4x4
 *        print - vypise cele sudoku 4x4 do graficke sceny
 */
public class SudokuGameGenerator4 {
    Random r = new Random();
    public int matrix[][];
    SudokuSolutionGenerator4 ssg4;

    // Konstruktor
    SudokuGameGenerator4() {
        this.matrix = new int[6][6];
        ssg4 = new SudokuSolutionGenerator4();
    }

    /*
     * Funkce odstranuje cisla z nahodnych policek sudoku
     * Funkce na vstupu dostane cislo,ktere urcuje pocet cislic,
     * ktere odstranime
     * Vygeneruje se nahodne cislo od 0-16 a to cislo je cislo policka v 2D poli (cellNumber),
     * potom zjisti radek (rowNumber) vygenerovaneho cisla pomoci deleni nahodneho cisla 4 (11/4 = 2),
     * pak pomoci operace modulo zjisti sloupec (columnNumber) nahodneho cisla (11 % 4 = 3)
     * policko, na souradnicich rowNumber a columnNumber, se prepise na 0
     */
    public void remove(int Number) {
        // Urcuje pocet cislic, ktere vymazeme z pole s resenim sudoku
        int RemovedNumber = Number;
        // Dokud nebude pocet vymazanych cislic 0
        while (RemovedNumber != 0) {
            // Vygeneruji nahodne cislo od 0-16
            int CellNumber = this.r.nextInt(16);
            // Zjistim radek vygenerovaneho cisla
            int RowNumber = CellNumber / 4;
            // Zjistim sloupec vygenerovaneho cisla
            int ColumnNumber = CellNumber % 4;
            if (matrix[RowNumber][ColumnNumber] != 0) {
                matrix[RowNumber][ColumnNumber] = 0;
                RemovedNumber--;
            }
        }
    }

    /*
     * Funkce dostane na vstupu textovy retezec, ktery urcuje obtiznost
     * Funkce urcuje kolik cisel mame vymazat ze sudoku
     */
    private int generateLevel(String difficulty) {
        if (difficulty.equals("Easy")) {
            // Vygeneruje cislo v rozmezi 8 - 9
            return 8 + this.r.nextInt(2);
        } else if (difficulty.equals("Hard")) {
            // Vygeneruje cislo v rozmezi 10 - 11
            return 10 + this.r.nextInt(2);
        } else {
            return 0;
        }
    }

    /*
     * Funkce dostane na vstupu textovy retezec, ktery urcuje obtiznost
     * Funkce vygeneruje sudoku 4x4
     */
    public void generate4(String difficulty) {
        // Vygeneruji reseni 4x4 sudoku
        ssg4.generate4();
        // Nastavim pole s resenim sudoku do pole teto tridy
        this.matrix = ssg4.matrix;
        System.out.println(difficulty);
        int level = generateLevel(difficulty);
        remove(level);
        print();
    }

    /*
     * Funkce vypise cele sudoku 4x4 do graficke sceny
     */
    public void print() {
        // Pojmenuji si grafickou scenu
        JFrame f = new JFrame("Sudoku");
        // Vytvorim si graficke textove pole 4x4
        JLabel board[][] = new JLabel[4][4];
        // Vytvorim si mrizkovanou tabulku
        JPanel Board = new JPanel(new GridLayout(4, 4));
        // Prochazim pole od leveho horniho rohu
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
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
