package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.model.FabricaQuentinha;
import com.example.myapplication.model.Pedido;

public class ActivityPedirQuentinha extends AppCompatActivity {
    static final int codePedirQuentinha = 2;


    private TextView textViewPratodoDia;
    private Button buttonPedirQuentinha;

    private FabricaQuentinha fabricaQuentinha;
    private Pedido pedido;
    private Intent intentReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedir_quentinha);

        init();

        click();
    }

    public void init(){
        textViewPratodoDia = (TextView) findViewById(R.id.textViewQuentinha);
        buttonPedirQuentinha = (Button) findViewById(R.id.buttonPedirQuentinha);

        Bundle bundle = getIntent().getExtras();

        fabricaQuentinha = (FabricaQuentinha) bundle.getSerializable("fabrica");
        pedido = (Pedido) bundle.getSerializable("pedido");

        textViewPratodoDia.setText(fabricaQuentinha.getPratoDoDia());
    }

    public void click(){

        buttonPedirQuentinha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                intentReturn = new Intent();
                intentReturn.putExtra("pedido", pedido);
                intentReturn.putExtra("fabrica", fabricaQuentinha);

                setResult(codePedirQuentinha, intentReturn);

                finish();
            }
        });
    }


    @Override
    public void onBackPressed() {

        intentReturn = new Intent();
        intentReturn.putExtra("pedido", pedido);
        intentReturn.putExtra("fabrica", fabricaQuentinha);

        setResult(codePedirQuentinha, intentReturn);
        finish();
    }
}