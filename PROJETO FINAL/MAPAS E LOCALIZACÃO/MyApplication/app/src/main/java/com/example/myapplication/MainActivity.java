package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.model.FabricaQuentinha;
import com.example.myapplication.model.Pedido;
import com.example.myapplication.network.QuentinhaNetwork;
import com.example.myapplication.network.RunLocation;
import com.google.android.gms.maps.model.LatLng;


public class MainActivity extends AppCompatActivity {

    static final int codeMain = 1;


    private Button buttonRealizarPedido;
    private Button buttonVerFila;
    private Button buttonVerEntregador;
    private Button buttonReclarmar;

    private Intent intentSegundaAct;

    private int opcAct;
    private Pedido pedido;
    private FabricaQuentinha fabricaQuentinha;
    private QuentinhaNetwork quentinhaNetwork;

    private RunLocation runLocation = new RunLocation(this);
    private Location locationUltima;


    public void atualizarFabric(FabricaQuentinha fq){
        this.fabricaQuentinha = fq;
    }

    public void enviarDados() {
        quentinhaNetwork = new QuentinhaNetwork(this);
        quentinhaNetwork.setOpc(1);
        quentinhaNetwork.setFabricaQuentinha(fabricaQuentinha);
        quentinhaNetwork.start();
    }

    public void setUltimaLocalizacao(Location location){
        locationUltima = location;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        click();

        intentSegundaAct = new Intent(this , ActivityPedirQuentinha.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void init(){
        buttonRealizarPedido = (Button) findViewById(R.id.buttonRealizarPedidos);
        buttonReclarmar = (Button) findViewById(R.id.buttonReclamar);
        buttonVerEntregador = (Button) findViewById(R.id.buttonVerEntregador);
        buttonVerFila = (Button) findViewById(R.id.buttonVerFila);

        //THREAD PARA CARREGAR DADOS
        quentinhaNetwork = new QuentinhaNetwork(this);
        quentinhaNetwork.setOpc(0);
        quentinhaNetwork.start();

        //THREAD PARA FICAR ESCUTANDO STATUS DA ENTREGA
        quentinhaNetwork = new QuentinhaNetwork(this);
        quentinhaNetwork.setOpc(2);
        quentinhaNetwork.start();

        //THREAD PARA FICAR ESCUANDO A LOCALIZACAO
        runLocation = new RunLocation(this);
        runLocation.start();


    }

    public void click(){

        buttonRealizarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pedido = fabricaQuentinha.add(new Pedido());
                pedido.setLat(locationUltima.getLatitude());
                pedido.setLog(locationUltima.getLongitude());
                opcAct = 1;
                irParaSegundaAct(opcAct);
            }
        });

       buttonVerFila.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               opcAct = 2;
               irParaSegundaAct(opcAct);
           }
       });

       buttonVerEntregador.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               opcAct = 3;
               irParaSegundaAct(opcAct);
           }
       });

       buttonReclarmar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               opcAct = 4;
               irParaSegundaAct(opcAct);
           }
       });

    }

    public void irParaSegundaAct (int opcac){
        switch (opcac) {
            case 1: // realizar pedido
                intentSegundaAct = new Intent(this, ActivityPedirQuentinha.class);
                break;

            case 2: // ver fila de entrega
                intentSegundaAct = new Intent(this, ActivityVerFila.class);
                break;

            case 3: //ver entregador
                intentSegundaAct = new Intent(this, ActivityVerEntregador.class);
                break;

            case 4: //realizar reclamação
                intentSegundaAct = new Intent(this, ActivityReclamar.class);
                break;

            default:
                intentSegundaAct = new Intent(this, ActivityPedirQuentinha.class);
                break;
        }


        intentSegundaAct.putExtra("pedido", pedido);
        intentSegundaAct.putExtra("fabrica", fabricaQuentinha);
        startActivityForResult(intentSegundaAct, codeMain);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();

        fabricaQuentinha = (FabricaQuentinha) bundle.getSerializable("fabrica");
        pedido = (Pedido) bundle.getSerializable("pedido");
        enviarDados();
    }



}