package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ActivityVerEntregador extends AppCompatActivity {
    static final int codeVerEntregador = 4;

    /**
     * SERA EXIBIDO NO MAPA A LOCALIZAÇÃO DO ENTREGADOR
     * **/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ver_entregador);
    }
}