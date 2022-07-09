package com.example.atv02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.atv02.Model.Cliente;

public class Main3Activity extends AppCompatActivity {

    static final int codeACTV02 = 2;

    EditText editTextid;
    EditText editTextNome;
    EditText editTextApelido;
    Button buttonSalvar;
    Intent intentreturn;

    Boolean opt;
    Cliente cliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("TESTE", "D");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Log.d("TESTE", "A");
        init();
        click();
    }

    public void init(){
        editTextid =   (EditText) findViewById(R.id.editTextIDACT02);
        editTextNome = (EditText) findViewById(R.id.editTextNomeACT02);
        editTextApelido = (EditText) findViewById(R.id.editTextApelidoACT02);
        buttonSalvar = (Button) findViewById(R.id.buttonSalvarACT02);
        intentreturn = new Intent();

        Bundle bundle = getIntent().getExtras();

        opt = bundle.getBoolean("opt");
        cliente = (Cliente) bundle.getSerializable("cliente");

        editTextid.setText(Integer.toString(cliente.getId()));
        editTextNome.setText(cliente.getNome());
        editTextApelido.setText(cliente.getApelido());
    }

    public void click(){
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cliente.setNome(editTextNome.getText().toString());
                cliente.setApelido(editTextApelido.getText().toString());

                Log.d("TESTE", "AAAA");

                intentreturn.putExtra("opt", opt);
                intentreturn.putExtra("cliente", cliente);
                Log.d("TESTE", "AAAA");

                setResult(codeACTV02, intentreturn);

                finish();

            }
        });
    }

}