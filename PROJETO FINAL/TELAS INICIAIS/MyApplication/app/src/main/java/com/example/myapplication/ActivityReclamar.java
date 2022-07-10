package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.model.FabricaQuentinha;
import com.example.myapplication.model.Pedido;

/*
 * Sera carregado uma foto juntamente com a reclamação
 *
 *
 * */
public class ActivityReclamar extends AppCompatActivity {

    static final int codeReclamar = 5;

    private EditText editTextReclamacao;
    private Button buttonTirarFoto;
    private Button buttonReclamar;
    private FabricaQuentinha fabricaQuentinha;
    private Pedido pedido;
    private Intent intentReturn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reclamar);

        init();

        click();

    }


    public void init(){
        editTextReclamacao = (EditText) findViewById(R.id.editTextReclamacao);
        buttonReclamar = (Button) findViewById(R.id.buttonEnviarReclamacao);
        buttonTirarFoto = (Button) findViewById(R.id.buttonTirarFoto);

        Bundle bundle = getIntent().getExtras();

        fabricaQuentinha = (FabricaQuentinha) bundle.getSerializable("fabrica");
        pedido = (Pedido) bundle.getSerializable("pedido");

    }

    public void click(){
        buttonReclamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pedido.setReclamacao(editTextReclamacao.getText().toString());
                fabricaQuentinha.editar(pedido);

                intentReturn = new Intent();
                intentReturn.putExtra("pedido", pedido);
                intentReturn.putExtra("fabrica", fabricaQuentinha);

                setResult(codeReclamar, intentReturn);

                finish();


            }
        });

    }
}