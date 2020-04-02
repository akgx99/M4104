package com.thomas.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Jeu extends AppCompatActivity {

    Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    Pendu pendu;
    TextView penduTV;
    TextView motATrouverTV;

    /***
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jeu_layout);

        Intent intent = getIntent();
        int nbLettres = intent.getIntExtra("lettres", 0);

        pendu = new Pendu(this, nbLettres);

        motATrouverTV = findViewById(R.id.motATrouver);
        motATrouverTV.setText(pendu.getMotATrouver());

        penduTV = findViewById(R.id.textePendu);
        afficherPendu();

    }

    /**
     * Permet de memtionner la victoire pour le joueur
     */
    private void gagne() {
        Toast.makeText(this, "Gagné en "+pendu.getCoups()+" !", Toast.LENGTH_LONG).show();
        finish();
    }

    /**
     * Permet de mentionner la défaite du joueur
     */
    private void perdu() {
        Toast.makeText(this, "Vous avez perdu.. le mot était "+pendu.getMotATrouverClair(), Toast.LENGTH_LONG).show();
        finish();
    }

    /**
     * Traite les boutons appuyé par l'utilisateur
     * @param view
     */
    public void clicBouton(View view) {
        pendu.essayerLettre( ((TextView)view).getText().toString() );
        if (pendu.aGagne()) gagne();
        if (pendu.aPerdu()) perdu();

        afficherPendu();
        motATrouverTV.setText(pendu.getMotATrouver());

        view.setEnabled(false);
    }

    /**
     * Dessinne à l'écran le pendu
     */
    public void afficherPendu() {
        penduTV.setText(penduAscii[pendu.getErreurs()]);
    }

    public String[] penduAscii = new String[] {
            "  --------------\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "              |\n" +
                    "    |         |\n" +
                    "    |         |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "    |      __|__\n" +
                    "    |         |\n" +
                    "    |         |\n" +
                    "    |\n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            "  --------------\n" +
                    "    |        |\n" +
                    "    |        |\n" +
                    "    |       / \\\n" +
                    "    |       \\_/\n" +
                    "    |      __|__\n" +
                    "    |         |\n" +
                    "    |         |\n" +
                    "    |        / \\ \n" +
                    "   /|\\\n" +
                    "  / | \\\n" +
                    " /  |  \\\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~\n" +
                    "~~~~~~~~~~~~~~~~~~~~~",
            ""
    };
}
