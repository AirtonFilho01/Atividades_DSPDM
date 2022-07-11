package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.model.FabricaQuentinha;
import com.example.myapplication.model.Pedido;

import java.io.ByteArrayOutputStream;

/*
 * Sera carregado uma foto juntamente com a reclamação
 *
 *
 * */
public class ActivityReclamar extends AppCompatActivity {

    static final int codeReclamar = 5;

    static final int codeImageCapture = 1;


    private EditText editTextReclamacao;
    private Button buttonTirarFoto;
    private Button buttonReclamar;
    private FabricaQuentinha fabricaQuentinha;
    private Pedido pedido;
    private Intent intentReturn;
    private ImageView imageView;
    private Bitmap bitmap;


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
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();

        fabricaQuentinha = (FabricaQuentinha) bundle.getSerializable("fabrica");
        pedido = (Pedido) bundle.getSerializable("pedido");



    }

    public void click(){

        buttonTirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamera();
            }
        });

        buttonReclamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //adicionando o comentario
                pedido.setReclamacao(editTextReclamacao.getText().toString());
                //fabricaQuentinha.editar(pedido);

                //adicionando a foto
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,0, outputStream);
                pedido.setFotoReclamacao(outputStream.toByteArray());


                fabricaQuentinha.editar(pedido);

                intentReturn = new Intent();
                intentReturn.putExtra("pedido", pedido);
                intentReturn.putExtra("fabrica", fabricaQuentinha);

                setResult(codeReclamar, intentReturn);

                finish();


            }
        });

    }

    private void abrirCamera(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intentCamera, codeImageCapture);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle bundle = data.getExtras();

        bitmap = (Bitmap) bundle.get("data");

        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(View.VISIBLE);
}


    @Override
    public void onBackPressed() {

        intentReturn = new Intent();
        intentReturn.putExtra("pedido", pedido);
        intentReturn.putExtra("fabrica", fabricaQuentinha);

        setResult(codeReclamar, intentReturn);
        finish();
    }
}