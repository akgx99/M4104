package com.thomas.pendu;

import android.content.Context;
import android.content.res.Resources;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Thomas
 */
public class Dictionnaire implements IDictionnaire {

    private ArrayList<String> mots = new ArrayList<>();

    /**
     * Constructeur de la classe Dictionnaire
     *
     * @param context
     */
    public Dictionnaire(Context context) {
        String contenuFichier = "";
        try {
            Resources res = context.getResources();
            InputStream in_s = res.openRawResource(R.raw.liste_mots);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            contenuFichier = new String(b);
        } catch (Exception e) { }
        mots.addAll(Arrays.asList(contenuFichier.split("\n")));
    }

    /**
     * Trouver un mot avec un nombre de lettre donné
     * @param nbLettres
     *          Le nombre de lettre du mot à fournir
     * @return
     *          un mot correspondant au critère de taille
     */
    @Override
    public String trouverMotAvec(int nbLettres) {
        ArrayList<String> motsChoix = new ArrayList<>();
        for (String s: mots) {
            if (s.length() == nbLettres+1) {
                motsChoix.add(s);
            }
        }
        return motsChoix.get(new Random().nextInt(motsChoix.size()));
    }

    /**
     * Permet de savoir si oui ou non un mot existe dans la base de connaissance
     * @param mot
     *          Le mot dont il faut définir l'existance
     * @return
     *          un booléen
     */
    @Override
    public boolean contient(String mot) {
        return false;
    }

    @Override
    public String getDefinitionMot(String mot) {
        return null;
    }

    /**
     * Permet de connaître la taille du dictionnaire (nombre de mots)
     *
     * @return
     *      La taille du dictionnaire
     */
    public int getTailleDictionnaire() {
        return mots.size();
    }
}
