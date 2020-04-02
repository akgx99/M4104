package com.thomas.pendu;

public interface IDictionnaire {

    String trouverMotAvec(int nbLettres);
    boolean contient(String mot);
    String getDefinitionMot(String mot);

    int getTailleDictionnaire();
}
