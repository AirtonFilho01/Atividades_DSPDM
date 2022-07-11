package com.example.myapplication.network;

import android.util.Log;

import com.example.myapplication.MainActivity;
import com.example.myapplication.model.FabricaQuentinha;
import com.google.gson.Gson;

public class QuentinhaNetwork extends Thread{

    MainActivity mainActivity;
    Servidor servidor = new Servidor();
    String response;

    FabricaQuentinha fabricaQuentinha;

    Gson gson = new Gson();


    int opc = 0;

    public QuentinhaNetwork(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }



    @Override
    public void run() {
        switch (opc) {
            case 0: // receber dados
                response = servidor.list();

               FabricaQuentinha fq = gson.fromJson(response, FabricaQuentinha.class);

                mainActivity.atualizarFabric(fq);

                break;

            case 1: // enviar dados

                String json = gson.toJson(fabricaQuentinha);
                servidor.enviar(json);
                break;


            case 2:
                response = servidor.status();

                while (response != "ok"){
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    response = servidor.status();
                }

                Log.e("TESTE", response);

        }
    }

    public int getOpc() {
        return opc;
    }

    public void setOpc(int opc) {
        this.opc = opc;
    }

    public FabricaQuentinha getFabricaQuentinha() {
        return fabricaQuentinha;
    }

    public void setFabricaQuentinha(FabricaQuentinha fabricaQuentinha) {
        this.fabricaQuentinha = fabricaQuentinha;
    }
}
