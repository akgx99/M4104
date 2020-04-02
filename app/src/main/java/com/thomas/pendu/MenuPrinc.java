package com.thomas.pendu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuPrinc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        findViewById(R.id.facile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrer(3);
            }
        });
        findViewById(R.id.moyen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrer(5);
            }
        });
        findViewById(R.id.dur).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demarrer(8);
            }
        });
    }

    /**
     *  Lance le jeu
     * @param nblettres
     *          Le nombre de lettre à trouver
     */
    public void demarrer(int nblettres) {
        Intent intent = new Intent(this, Jeu.class);
        intent.putExtra("lettres", nblettres);
        startActivity(intent);
    }
}
