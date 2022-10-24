package br.com.ufc.firstapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.ufc.firstapp.R;

public class GridV extends AppCompatActivity {
    private GridView grid;
    private String[] gridValue = new String[]{
            "Chico","Maria","Jose",
            "Joao","Pedro","Monika"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        grid = findViewById(R.id.activity_grid_Grid);

        ArrayAdapter<String> adp = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line,gridValue);
        grid.setAdapter(adp);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),((TextView)view).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}