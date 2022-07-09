package com.example.atv02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.atv02.model.Cliente;
import com.example.atv02.model.Dados;
import com.example.atv02.network.ClientesNetwork;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int codeMain = 1;

    Intent segundaAct;
    Button buttonEditar;
    Button buttonCadastrar ;
    Button buttonDeletar;
    EditText editTextid;
    TextView textView;
    Dados dados;

    ClientesNetwork clientesNetwork = new ClientesNetwork(this
    );

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
        Log.d("TESTE","iniciando componentes");
        segundaAct = new Intent(this, Main3Activity.class);

        buttonEditar = (Button) findViewById(R.id.buttonEditar);
        buttonCadastrar = (Button) findViewById(R.id.buttonCadastrar);
        buttonDeletar = (Button) findViewById(R.id.buttonDeletar);
        textView = (TextView) findViewById(R.id.textView);
        editTextid = (EditText) findViewById(R.id.editTextid01);

        clientesNetwork.setOpc(0);
        clientesNetwork.start();

    }


    public void atualizarClientes(Dados dados){
        this.dados = dados;
        this.id = dados.getClientes().size();
        textView.setText(dados.getClientes().toString());
    }

    public void enviardados(){
        clientesNetwork = new ClientesNetwork(this);
        clientesNetwork.setOpc(1);
        clientesNetwork.setDados(this.dados);
        clientesNetwork.start();
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

        buttonDeletar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.e("TESTE","NO REMOVE 1");

                Integer id2 = Integer.parseInt(editTextid.getText().toString());
                dados.delete(id2);

                textView.setText(dados.getClientes().toString());
                enviardados();

            }
        });

        buttonEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer id2 = Integer.parseInt(editTextid.getText().toString());
                c = dados.getClientes().get(id2);

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
            dados.add(c.getId(),c.getNome(),c.getApelido());
            //clienteArrayList.add(c);


        //EDITAR
        } else{
            dados.editar(c.getId(),c.getNome(),c.getApelido());
            //clienteArrayList.set(c.getId(), c);
        }

        textView.setText(dados.getClientes().toString());
        enviardados();

    }



}

