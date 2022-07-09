package com.example.atv02.network;


import android.util.JsonReader;
import android.util.Log;
import android.widget.ListView;

import com.example.atv02.MainActivity;
import com.example.atv02.model.Cliente;
import com.example.atv02.model.Dados;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ClientesNetwork extends Thread{
    MainActivity mainActivity;
    Servidor servidor = new Servidor();
    String response;
    Gson gson = new Gson();
    ArrayList<Cliente> clienteArrayList;


    Dados dados;
    /*
    *  0 = listar
    *  1 = cadastrar
    *  2 = editar
    *  3 = deletar
    * */



    int opc = 0;

    public ClientesNetwork(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        Log.e("TESTE","network inciado");
    }

    @Override
    public void run() {
        Log.e("TESTE","thread iniado");

        switch (opc) {
            case 0: // receber dados
                response = servidor.list();

                Dados dados1 = gson.fromJson(response, Dados.class);

                mainActivity.atualizarClientes(dados1);

                break;
            case 1: // enviar dados
                String json = gson.toJson(dados);
                Log.e("TESTE", "CL: " + json);
                servidor.enviar(json);
                break;

        }
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }


    public Dados getDados() {
        return dados;
    }

    public void setDados(Dados dados) {
        this.dados = dados;
    }

}
