package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.model.FabricaQuentinha;
import com.example.myapplication.model.Pedido;

public class ActivityVerFila extends AppCompatActivity {

    static final int codeVerFila = 3;

    private TextView textViewFila;
    private Button buttonCancelarPedido;
    private FabricaQuentinha fabricaQuentinha;
    private Pedido pedido;
    private Intent intentReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_fila);

        init();

        click();
    }

    public void init(){
        textViewFila = (TextView) findViewById(R.id.textViewVerFila);
        buttonCancelarPedido = (Button) findViewById(R.id.buttonCancelarPedido);

        Bundle bundle = getIntent().getExtras();

        fabricaQuentinha = (FabricaQuentinha) bundle.getSerializable("fabrica");
        pedido = (Pedido) bundle.getSerializable("pedido");


        textViewFila.setText(fabricaQuentinha.getPedidos().toString());
    }

    public void click(){
        buttonCancelarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fabricaQuentinha.remover(pedido);
                textViewFila.setText(fabricaQuentinha.getPedidos().toString());

                intentReturn = new Intent();
                intentReturn.putExtra("pedido", pedido);

                intentReturn.putExtra("fabrica", fabricaQuentinha);

                setResult(codeVerFila, intentReturn);

                finish();
            }
        });
    }


}