package br.ufc.quixada.basiccomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private ToggleButton tgButton;
    private Switch btnSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tgButton = findViewById(R.id.btnToggle);
        btnSwitch = findViewById(R.id.btnSwitchActivity);

        tgButton.setOnCheckedChangeListener(this);
        btnSwitch.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        switch (compoundButton.getId()){
            case R.id.btnSwitchActivity:
                if(isChecked){
                    showMessage("Switch is on");
                } else
                    showMessage("Switch is off");
                break;
            case R.id.btnToggle:
                if(isChecked){
                    showMessage("Button toggle is on");
                } else
                    showMessage("Button toggle is off");
                break;
        }
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}