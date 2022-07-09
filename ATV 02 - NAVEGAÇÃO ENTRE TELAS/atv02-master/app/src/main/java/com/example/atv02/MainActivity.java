package com.example.atv02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.atv02.Model.Cliente;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int codeMain = 1;

    Intent segundaAct;
    Button buttonEditar;
    Button buttonCadastrar ;
    EditText editTextid;
    TextView textView;

    ArrayList <Cliente> clienteArrayList = new ArrayList<Cliente>();
    Cliente c;
    int id = 0;
    Boolean opt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitComponents();
        Click();
    }

    public void InitComponents(){

        segundaAct = new Intent(this, Main3Activity.class);

        buttonEditar = (Button) findViewById(R.id.buttonEditar);
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        textView = (TextView) findViewById(R.id.textView);
        editTextid = (EditText) findViewById(R.id.editTextid01);

        c = new Cliente( id++, "a", "a");
        clienteArrayList.add(c);
        c = new Cliente(id++, "b", "b");
        clienteArrayList.add(c);
        c = new Cliente(id++, "c", "d");
        clienteArrayList.add(c);

        textView.setText(clienteArrayList.toString());
    }

    public void Click(){

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c = new Cliente();
                c.setId(id++);
                irParaSegundaAct(true, c);

            }
        });

        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id2 = Integer.parseInt(editTextid.getText().toString());
                c = clienteArrayList.get(id2);

                irParaSegundaAct(false, c);
            }
        });

    }

    public void irParaSegundaAct(boolean opt, Cliente c){
        segundaAct = new Intent(this, Main3Activity.class);
        segundaAct.putExtra("opt", opt);
        segundaAct.putExtra("cliente", c);
        Log.d("TESTE", "D");
        //startActivity(segundaAct);
        startActivityForResult(segundaAct, codeMain);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();

        opt =  bundle.getBoolean("opt");
        c = (Cliente) bundle.getSerializable("cliente");

        Log.d("TESTE", "ESTOU AQ");


        //CADASTRAR
        if(opt){
            clienteArrayList.add(c);


        //EDITAR
        } else{
            clienteArrayList.set(c.getId(), c);
        }

        textView.setText(clienteArrayList.toString());

    }

}

