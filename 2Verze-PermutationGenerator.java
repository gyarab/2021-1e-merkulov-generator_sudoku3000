package com.company;

import java.util.Random;

/*
 * Vytvari permutaci
 * Parametry:
 *          permutation - pole
 *          Random
 * Konstruktory:
 *              trida ma  jeden konstruktor bez parametru,
 *              ktery urcuje velikost pole
 * Metody:
 *         generate - vygeneruje permutaci a vlozi ji do pole
 */
public class PermutationGenerator {
    Random r = new Random();
    public int permutation[];

    //Konstruktor
    PermutationGenerator() {
        this.permutation = new int[9];
    }

    /*
     * Funkce vygeneruje permutaci (rada cisel, ve ktere je kazde cislo prave jednou)
     * Funkce vytvori cislo od 1 do 9 pomoci Random a dosadi ho do pole,
     * potom zkontroluje jesli se vygenerovane cislo nerovna nejakemu jinemu v poli
     */
    public void generate() {
        int newNumber = 0;
        // Prochazim kazde policko v poli
        for (int i = 0; i < 9; i++) {
            boolean notNewNumber = true;
            // Dokud nemame vhodne cislo
            while (notNewNumber) {
                // Vytvarim nove cislo
                newNumber = this.r.nextInt(9) + 1;
                notNewNumber = false;
                // Prochazim policka v poli ktera jsou pred policem kam dosazuji nove cislo (newNumber)
                for (int j = 0; j < i; j++) {
                    // Zkontroluje jestli se cisla v polickach nerovnaji novemu cislu (newNumber)
                    if (newNumber == permutation[j])
                        notNewNumber = true;
                }
            }
            // Vyplnim policko vybranym cislem
            this.permutation[i] = newNumber;
        }
    }
}
