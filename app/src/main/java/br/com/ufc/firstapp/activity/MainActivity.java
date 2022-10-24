package br.com.ufc.firstapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import br.com.ufc.firstapp.R;

public class MainActivity extends AppCompatActivity {

    private EditText  nome, telefone, email;
    private RadioButton masculino, feminino;
    private TextView resNome, resTelefone, resEmail,resSexo;
    private Button mudarTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Cadastro");

        inicializacaoDosCampos();
        mudarTela();
        ConfigurandoBtn();
    }

    private void mudarTela() {
        mudarTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mt = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(mt);
            }
        });
    }

    private void ConfigurandoBtn() {
        Button btnCadastrar = findViewById(R.id.activity_main_btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editNome = nome.getText().toString();
                String editTelefone = telefone.getText().toString();
                String editEmail = email.getText().toString();

                if (editNome.isEmpty() || editTelefone.isEmpty() || editEmail.isEmpty()) {
                    Snackbar.make(v, "Preencha todos os campos", Snackbar.LENGTH_LONG).show();
                } else {
                    btnRadio(v);
                }
            }
        });
    }

    private void inicializacaoDosCampos() {
        nome = findViewById(R.id.activity_main_nome);
        telefone = findViewById(R.id.activity_main_telefone);
        email = findViewById(R.id.activity_main_email);

        masculino = findViewById(R.id.activity_main_masculino);
        feminino = findViewById(R.id.activity_main_feminino);

        resNome = findViewById(R.id.activity_main_resNome);
        resTelefone = findViewById(R.id.activity_main_resTelefone);
        resEmail = findViewById(R.id.activity_main_resEmail);
        resSexo = findViewById(R.id.activity_main_resSexo);

        mudarTela = findViewById(R.id.activity_main_buttonTela);
    }

    private void btnRadio(View view){

        String editNome = nome.getText().toString();
        String editTelefone = telefone.getText().toString();
        String editEmail = email.getText().toString();

        if(masculino.isChecked()){
            resNome.setText(editNome);
            resTelefone.setText(editTelefone);
            resEmail.setText(editEmail);
            resSexo.setText("Masculino");
        }else if(feminino.isChecked()){
            resNome.setText(editNome);
            resTelefone.setText(editTelefone);
            resEmail.setText(editEmail);
            resSexo.setText("Feminino");
        }else{
            Snackbar.make(view, "Preencha o sexo", Snackbar.LENGTH_SHORT).show();
        }
    }

}