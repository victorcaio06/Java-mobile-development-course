package br.com.ufc.firstapp.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import br.com.ufc.firstapp.R;

public class MainActivity2 extends AppCompatActivity {

    MediaPlayer audio;
    ToggleButton verificar;
    TextView resNomeMusica;
    AutoCompleteTextView auto;
    Button btnT3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Musica");

        inicializacaoDosCampos();
        autoComplete();
        nomeAudio();
        mudarTela();
    }

    private void mudarTela() {
        btnT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tela3 = new Intent(getApplicationContext(), ListV.class);
                startActivity(tela3);
            }
        });
    }

    private void autoComplete() {
        String str[]={"Sim","Não"};
        auto = findViewById(R.id.activity_main_autoCompleteTextView);
        ArrayAdapter<String> adp = new ArrayAdapter<>(this,android.R.layout.simple_dropdown_item_1line,str);
        auto.setThreshold(1);
        auto.setAdapter(adp);
    }

    private void inicializacaoDosCampos() {
        audio = MediaPlayer.create(this,R.raw.audio);
        resNomeMusica = findViewById(R.id.activity_main_resMusica);
        verificar = findViewById(R.id.toggleButton);
        btnT3 = findViewById(R.id.activity_main2_btn_Tela3);

    }

    private void nomeAudio() {
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificar.isChecked()){
                   resNomeMusica.setText("Nome audio");
                }else {

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }
    public void PlayMusica(View view) {
        audio.start();
    }


}