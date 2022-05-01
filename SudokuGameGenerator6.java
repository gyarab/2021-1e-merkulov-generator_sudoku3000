package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/*
 * Vytvari nahodne sudoku 6x6
 * Parametry: matrix - 2D pole
 *            ssg6 - SudokuSolutionGenerator6
 *            Random
 * Konstruktory: trida ma jeden bezparametricky konstruktor,
 *               ktery nastavi velikost pole a vytvori instaci generatoru reseni sudoku 6x6
 * Metody:
 *        remove - odstranuje cisla z nahodnych policek sudoku
 *        generateLevel - urcuje kolik cisel mame vymazat ze sudoku
 *        generate6 - vygeneruje sudoku 6x6
 *        print - vypise cele sudoku 6x6 do graficke sceny
 */
public class SudokuGameGenerator6 {
    Random r = new Random();
    public int matrix[][];
    SudokuSolutionGenerator6 ssg6;

    // Konstruktor
    SudokuGameGenerator6() {
        this.matrix = new int[6][6];
        ssg6 = new SudokuSolutionGenerator6();
    }

    /*
     * Funkce odstranuje cisla z nahodnych policek sudoku
     * Funkce na vstupu dostane cislo,ktere urcuje pocet cislic,
     * ktere odstranime
     * Vygeneruje se nahodne cislo od 0-36 a to cislo je cislo policka v 2D poli (cellNumber),
     * potom zjisti radek (rowNumber) vygenerovaneho cisla pomoci deleni nahodneho cisla 6 (20/6 = 3),
     * pak pomoci operace modulo zjisti sloupec (columnNumber) nahodneho cisla (20 % 6 = 2)
     * policko, na souradnicich rowNumber a columnNumber, se prepise na 0
     */
    public void remove(int Number) {
        // Urcuje pocet cislic, ktere vymazeme z pole s resenim sudoku
        int RemovedNumber = Number;
        // Dokud nebude pocet vymazanych cislic 0
        while (RemovedNumber != 0) {
            // Vygeneruji nahodne cislo od 0-36
            int CellNumber = this.r.nextInt(36);
            // Zjistim radek vygenerovaneho cisla
            int RowNumber = CellNumber / 6;
            // Zjistim sloupec vygenerovaneho cisla
            int ColumnNumber = CellNumber % 6;
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
            // Vygeneruje cislo v rozmezi 12 - 17
            return 12 + this.r.nextInt(5);
        } else if (difficulty.equals("Medium")) {
            // Vygeneruje cislo v rozmezi 18 - 23
            return 18 + this.r.nextInt(5);
        } else if (difficulty.equals("Hard")) {
            // Vygeneruje cislo v rozmezi 24 - 29
            return 24 + this.r.nextInt(5);
        } else {
            return 0;
        }
    }

    /*
     * Funkce dostane na vstupu textovy retezec, ktery urcuje obtiznost
     * Funkce vygeneruje sudoku 6x6
     */
    public void generate6(String difficulty) {
        // Vygeneruji reseni 6x6 sudoku
        ssg6.generate6();
        // Nastavim pole s resenim sudoku do pole teto tridy
        this.matrix = ssg6.matrix;
        System.out.println(difficulty);
        int level = generateLevel(difficulty);
        remove(level);
        print();
    }

    /*
     * Funkce vypise cele sudoku 6x6 do graficke sceny
     */
    public void print() {
        // Pojmenuji si grafickou scenu
        JFrame f = new JFrame("Sudoku");
        // Vytvorim si graficke textove pole 6x6
        JLabel board[][] = new JLabel[6][6];
        // Vytvorim si mrizkovanou tabulku
        JPanel Board = new JPanel(new GridLayout(6, 6));
        // Prochazim pole od leveho horniho rohu
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
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
