package com.example.myapplication.network;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Servidor {

    String endereco = "http://192.168.0.133:8080/";
    HttpURLConnection connection;
    BufferedReader bufferedReader;
    String response = "";

    public String list(){
        try {
            URL url = new URL(endereco+"listar");


            connection = (HttpURLConnection) url.openConnection();


            connection.setRequestMethod("GET");

            connection.setDoOutput(true);

            connection.connect();

            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String input = "";

            while ((input = bufferedReader.readLine()) != null){
                response += input;
            }

            return response;

        } catch( MalformedURLException ex ){
            ex.printStackTrace();
        } catch( IOException ex ){
            ex.printStackTrace();
        }

        return "ERRO";
    }

    public void enviar(String json){
        try {
            URL url = new URL(endereco + "receber");

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");


            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            connection.setDoOutput(true);



            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = json.getBytes("utf-8");
                os.write(input, 0, input.length);
                os.flush();
            }

            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }

        } catch( MalformedURLException ex ){
            ex.printStackTrace();
        } catch( IOException ex ){
            ex.printStackTrace();
        }

        //return "ERRO";
    }

    public String status(){
        try {
            URL url = new URL(endereco+"status");


            connection = (HttpURLConnection) url.openConnection();


            connection.setRequestMethod("GET");

            connection.setDoOutput(true);

            connection.connect();

            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String input = "";

            while ((input = bufferedReader.readLine()) != null){
                response += input;
            }

            return response;

        } catch( MalformedURLException ex ){
            ex.printStackTrace();
        } catch( IOException ex ){
            ex.printStackTrace();
        }

        return "ERRO";
    }
}
