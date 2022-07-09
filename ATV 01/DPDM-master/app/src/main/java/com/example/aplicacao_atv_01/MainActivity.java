package com.example.aplicacao_atv_01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.aplicacao_atv_01.model.Pessoa;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList <Pessoa> pessoasArray = new ArrayList<Pessoa>();
    private ArrayList <String> cidadesArray = new ArrayList<String>();
    private ArrayList <String> doseArray = new ArrayList<String>();


    private EditText editTextSalvar;
    private Button buttonSalvar;
    private ListView listViewPessoas;
    private AutoCompleteTextView autoCompleteTextView;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private Menu menu;
    private Button botaoopc;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponentes();

        inflarAutoComplet();

        inflarSpinner();

        click();

        clickOpc();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_opc, menu);
        return true;
    }

    public void initComponentes(){
        editTextSalvar = (EditText) findViewById(R.id.edittext);
        buttonSalvar = (Button) findViewById(R.id.button);
        listViewPessoas = (ListView) findViewById(R.id.listview);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        spinner = (Spinner) findViewById(R.id.spinner);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        botaoopc = (Button) findViewById(R.id.veropcoes);
        mediaPlayer = MediaPlayer.create(this, R.raw.salamisound);
    }

    public void click(){
        
        //adicionar pessoa
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPessoa();

                Log.e("ADICIONAR", "NOVA PESSOA");

                inflarLista();

                mediaPlayer.start();

            }

        });
    }

    public void clickOpc(){
        botaoopc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(), "Click Looongo", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        botaoopc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, botaoopc);
                popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
                popupMenu.show();
            }
        });
    }
    public void addPessoa(){
        Pessoa p = new Pessoa();
        p.setNome(editTextSalvar.getText().toString());
        p.setCidade(autoCompleteTextView.getText().toString());
        p.setDose(spinner.getSelectedItem().toString());

        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radioButton1:
                p.setVacinado(true);
                break;
            default:
                p.setVacinado(false);
                break;

        }

        pessoasArray.add(p);
        Log.e("ADICIONAR", p.getNome());

        editTextSalvar.setText("");
    }

    public void inflarLista(){

        ArrayAdapter<Pessoa> arrayAdapter = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1, pessoasArray);
        Log.e("TAMANHO", Integer.toString(pessoasArray.size()));

        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, testeArray);

        listViewPessoas.setAdapter(arrayAdapter);
    }

    public void inflarAutoComplet(){

        cidadesArray.add("Quixadá");
        cidadesArray.add("Fortaleza");
        cidadesArray.add("Forquilha");
        cidadesArray.add("Quixeramobim");

        ArrayAdapter<String> adapterTextV = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cidadesArray);
        autoCompleteTextView.setAdapter(adapterTextV);

    }

    public void inflarSpinner(){
        doseArray.add("Primeira Dose");
        doseArray.add("Segunda Dose");
        doseArray.add("Terceira Dose");
        doseArray.add("Quarta Dose");

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, doseArray);
        spinner.setAdapter(adapterSpinner);
    }


}
