package com.company;

import java.util.Random;

/*
 * Vytvari permutaci urcite delky
 * Parametry:
 *          permutation - pole
 *          Random
 * Konstruktory:
 *              trida ma jeden konstruktor bez parametru
 * Metody:
 *         generate9 - vygeneruje permutaci o delce 9 poli a vlozi ji do pole
 *         generate6 - vygeneruje permutaci o delce 6 poli a vlozi ji do pole
 *         generate4 - vygeneruje permutaci o delce 4 poli a vlozi ji do pole
 */
public class PermutationGenerator {
    Random r = new Random();
    public int permutation[];

    // Konstruktor
    PermutationGenerator () {
    }

    /*
     * Funkce vygeneruje permutaci o delce 9 policek (rada cisel, ve ktere je kazde cislo prave jednou)
     * Funkce vytvori cislo od 1 do 9 pomoci Random a dosadi ho do pole,
     * potom zkontroluje jesli se vygenerovane cislo nerovna nejakemu jinemu v poli
     */
    public void generate9 () {
        // Nastavim delku pole
        this.permutation = new int [9];
        int newNumber = 0;
        // Prochazim kazde policko v poli
        for(int i = 0; i < 9; i++) {
            boolean notNewNumber = true;
            // Dokud nemame vhodne cislo
            while (notNewNumber) {
                // Vytvarim nove cislo
                newNumber = this.r.nextInt(9) + 1;
                notNewNumber = false;
                // Prochazim policka v poli ktera jsou pred policem kam dosazuji nove cislo (newNumber)
                for(int j = 0; j < i; j++) {
                    // Zkontroluje jestli se cisla v polickach nerovnaji novemu cislu (newNumber)
                    if(newNumber == permutation[j])
                        notNewNumber = true;
                }
            }
            // Vyplnim policko vybranym cislem
            this.permutation[i] = newNumber;
        }
    }

    /*
     * Funkce vygeneruje permutaci o delce 6 policek (rada cisel, ve ktere je kazde cislo prave jednou)
     * Funkce vytvori cislo od 1 do 6 pomoci Random a dosadi ho do pole,
     * potom zkontroluje jesli se vygenerovane cislo nerovna nejakemu jinemu v poli
     */
    public void generate6 () {
        // Nastavim delku pole
        this.permutation = new int [6];
        int newNumber = 0;
        // Prochazim kazde policko v poli
        for(int i = 0; i < 6; i++) {
            boolean notNewNumber = true;
            // Dokud nemame vhodne cislo
            while (notNewNumber) {
                // Vytvarim nove cislo
                newNumber = this.r.nextInt(6) + 1;
                notNewNumber = false;
                // Prochazim policka v poli ktera jsou pred policem kam dosazuji nove cislo (newNumber)
                for(int j = 0; j < i; j++) {
                    // Zkontroluje jestli se cisla v polickach nerovnaji novemu cislu (newNumber)
                    if(newNumber == permutation[j])
                        notNewNumber = true;
                }
            }
            // Vyplnim policko vybranym cislem
            this.permutation[i] = newNumber;
        }
    }

    /*
     * Funkce vygeneruje permutaci o delce 4 policek (rada cisel, ve ktere je kazde cislo prave jednou)
     * Funkce vytvori cislo od 1 do 4 pomoci Random a dosadi ho do pole,
     * potom zkontroluje jesli se vygenerovane cislo nerovna nejakemu jinemu v poli
     */
    public void generate4 () {
        // Nastavim delku pole
        this.permutation = new int [4];
        int newNumber = 0;
        // Prochazim kazde policko v poli
        for(int i = 0; i < 4; i++) {
            boolean notNewNumber = true;
            // Dokud nemame vhodne cislo
            while (notNewNumber) {
                // Vytvarim nove cislo
                newNumber = this.r.nextInt(4) + 1;
                notNewNumber = false;
                // Prochazim policka v poli ktera jsou pred policem kam dosazuji nove cislo (newNumber)
                for(int j = 0; j < i; j++) {
                    // Zkontroluje jestli se cisla v polickach nerovnaji novemu cislu (newNumber)
                    if(newNumber == permutation[j])
                        notNewNumber = true;
                }
            }
            // Vyplnim policko vybranym cislem
            this.permutation[i] = newNumber;
        }
    }
}
