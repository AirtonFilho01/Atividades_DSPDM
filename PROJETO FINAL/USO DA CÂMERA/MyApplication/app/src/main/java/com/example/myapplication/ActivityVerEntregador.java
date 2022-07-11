package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.model.FabricaQuentinha;
import com.example.myapplication.model.Pedido;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityVerEntregador extends AppCompatActivity implements OnMapReadyCallback {
    static final int codeVerEntregador = 4;

    private GoogleMap map;
    private FabricaQuentinha fabricaQuentinha;
    LatLng entregador;
    LatLng lngPedido;
    Pedido pedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ver_entregador);

        init();

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);

        supportMapFragment.getMapAsync(this);
    }

    public void init(){
        Bundle bundle = getIntent().getExtras();

        fabricaQuentinha = (FabricaQuentinha) bundle.getSerializable("fabrica");
        pedido = (Pedido) bundle.getSerializable("pedido");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;

        entregador = new LatLng( fabricaQuentinha.getEntregador().getLat(),
                fabricaQuentinha.getEntregador().getLog());

        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        map.addMarker(new MarkerOptions()
                .position(entregador)
                .title("Entregador"));

        Pedido p;
        for (int i = 0; i < fabricaQuentinha.getPedidos().size(); i++) {
            p = fabricaQuentinha.getPedidos().get(i);
            lngPedido = new LatLng(p.getLat(), p.getLog());

            map.addMarker(new MarkerOptions()
                    .position(lngPedido)
                    .title(Integer.toString(p.getId()))
            );

        }

        map.moveCamera(CameraUpdateFactory.newLatLng(entregador));
        map.moveCamera(CameraUpdateFactory.zoomTo(11));

        googleMap.setTrafficEnabled(true);

    }
}