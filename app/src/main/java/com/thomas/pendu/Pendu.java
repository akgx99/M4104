package com.thomas.pendu;

import android.content.Context;

public class Pendu {

    private String motATrouver;
    private boolean[] trouve;
    private Dictionnaire dictionnaire;

    private int erreurs = 0;
    private final int NB_ERREUR_MAX = 6;
    private int coups = 0;

    /**
     * Constructeur de la classe pendu
     * @param context
     * @param nbLettres
     *          le nombre de lettre
     */
    public Pendu(Context context, int nbLettres) {
        dictionnaire = new Dictionnaire(context);
        erreurs = 0;
        motATrouver = dictionnaire.trouverMotAvec(nbLettres);
        System.out.println(motATrouver);
        trouve = new boolean[motATrouver.length()];
    }

    /**
     * Test la lettre sur le mot
     * @param lettreATester
     *          la lettre à tester sur le mot
     */
    public void essayerLettre(String lettreATester) {
        boolean valide = false;
        coups++;
        for (int i = 0; i < motATrouver.length(); i++) {
            if (motATrouver.substring(i, i+1).equals(lettreATester)) {
                trouve[i] = true;
                valide = true;
            }
        }
        if (!valide) erreurs++;
    }

    /**
     * Donne le nombre d'erreurs
     * @return
     *          le nombre d'erreur
     */
    public int getErreurs() {
        return erreurs;
    }

    /**
     * Determine le mot à trouver
     * @return
     *          le mot à trouver avec des "_" pour les lettres encore manquantes
     */
    public String getMotATrouver() {
        String resultat = "";
        for (int i = 0; i < motATrouver.length()-1; i++) {
            if (trouve[i]) resultat += motATrouver.substring(i, i+1);
            else resultat = resultat+="_";
            resultat+=" ";
        }
        return resultat;
    }

    /**
     * Donne le mot a trouver
     * @return
     *          Le mot à trouver
     *
     */
    public String getMotATrouverClair() {
        return motATrouver;
    }

    /**
     * Donne le nombre de coups
     * @return
     *          Le nombre de coups
     */
    public int getCoups() {
        return coups;
    }

    /**
     * Determine si le mot est trouvé
     * @return
     *          un booleén
     */
    public boolean aGagne() {
        for (int i = 0; i < trouve.length; i++) {
            if (!trouve[i]) return false;
        }
        return true;
    }

    /**
     * Retourne que la partie est perdu lorsque le nombre d'erreurs max est atteint
     *
     * @return
     *          un booleén
     */
    public boolean aPerdu() {
        return erreurs >= NB_ERREUR_MAX;
    }

}
