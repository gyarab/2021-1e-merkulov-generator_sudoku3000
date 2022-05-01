package com.company;

/*
 * Vytvari nahodne reseni sudoku 9x9
 * Prametry: matrix - 2D pole
 *           pg - PermutationGenerator
 * Konstruktory: trida ma jeden bezparametricky konstruktor,
 *               ktery nastavi velikost pole a vytvori instaci generatoru permutaci
 * Metody:
 *        placePermutation - zapise permutaci do prvniho radku 2D pole
 *        copyArraySegment - kopiruje casti permutace a vlozi zkopirovanou cast na nove misto v poli
 *        rowPermutation - rovna za sebou v urcitem poradi zkopirovane casti o delce 3 policek permutace
 *                         a pak je vklada na urcity radek podle pravidel sudoku
 *        movePermutation - presune permutaci krome jejiho prvniho cisla z pocatecniho radku na jiny radek
 *                          a potom dosadi prvni cislo na posledni pozici v radku
 *        generate9 - vygeneruje reseni sudoku 9x9
 */
public class SudokuSolutionGenerator9 {
    public int matrix [][];
    PermutationGenerator pg;

    // Konstruktor
    SudokuSolutionGenerator9() {
        this.matrix = new int [9][9];
        pg = new PermutationGenerator();
    }

    /*
     * Funkce zapise permutaci do prvniho radku 2D pole
     */
    public void placePermutation() {
        // Vytvorim permutaci o delce 9 policek
        pg.generate9();
        // Vlozim permutaci do prvniho radku 2D pole
        for(int i = 0; i < pg.permutation.length; i++) {
            this.matrix[0][i] = pg.permutation[i];
        }
    }

    /*
     * Funkce na vstupu dostane cislo radku, ze ktereho bude kopirovat cast permutace (resourceRow),
     * cislo sloupce, ze ktereho bude kopirovat cast permutace (resourceColumn),
     * cislo radku, do ktereho bude vlkadat zkopirovanou cast permutace (resultRow),
     * cislo sloupce, do ktereho bude vlkadat zkopirovanou cast permutace (resultColumn) a
     * delku casti permutace, kterou bude kopirovat (segmentLength)
     * Funkce kopiruje casti permutace a vlozi zkopirovanou cast na nove misto v poli
     */
    private void copyArraySegment(int resourceRow, int resourceColumn, int resultRow, int resultColumn, int segmentLength) {
        for (int i = 0; i < segmentLength; i++) {
            // Vlozim cast permutace na jine misto
            this.matrix[resultRow][resultColumn + i] = this.matrix[resourceRow][resourceColumn + i];
        }
    }

    /*
     * Funkce na vstupu dostane cislo radku, odkud ma zkopirovat cast permutace a potom cislo radku,
     * do ktereho zkopirovanou cast vlozi
     * Funkce rovna za sebou v urcitem poradi zkopirovane casti o delce 3 policek permutace
     * a pak je vklada na urcity radek podle pravidel sudoku
     * Napriklad: 1 2 3 | 4 5 6 | 7 8 9
     *            4 5 6 | 7 8 9 | 1 2 3 atd.
     */
    private void rowPermutation(int resourceRow, int resultRow) {
        copyArraySegment(resourceRow, 0, resultRow, 6, 3);
        copyArraySegment(resourceRow, 6, resultRow, 3, 3);
        copyArraySegment(resourceRow, 3, resultRow, 0, 3);
    }

    /*
     * Funkce na vstupu dostane cislo radku, ze ktereho bude presouvat cast permutace (resourceRow)
     * a cislo radku, do ktereho bude cast permutace presouvat (resultRow)
     * Funkce presune permutaci krome jejiho prvniho cisla z pocatecniho radku (resultRow) na jiny radek (resultRow)
     * a potom dosadi prvni cislo na posledni pozici v radku
     * Priklad:  1 2 3 4 5 6 7 8 9
     *           2 3 4 5 6 7 8 9 1
     *           3 4 5 6 7 8 9 1 2 atd.
     */
    private void movePermutation(int resourceRow, int resultRow) {
        for(int i = 0; i < matrix[resultRow].length - 1; i++) {
            matrix[resultRow][i] = matrix[resourceRow][i + 1];
        }
        matrix[resultRow][8] = matrix[resourceRow][0];
    }

    /*
     * Funkce vygeneruje reseni sudoku 9x9
     */
    public void generate9() {
        // Vlozim permutaci do prvniho radku pole 9x9
        placePermutation();
        rowPermutation(0, 1);
        rowPermutation(1, 2);
        movePermutation(0,3);
        rowPermutation(3, 4);
        rowPermutation(4, 5);
        movePermutation(3, 6);
        rowPermutation(6, 7);
        rowPermutation(7, 8);
    }
}
