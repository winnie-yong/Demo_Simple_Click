package sg.edu.rp.c346.id20013783.demosimpleclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    Button btnDisplay;
    EditText etInput;
    ToggleButton etData;
    RadioGroup rgGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.textViewDisplay);
        btnDisplay = findViewById(R.id.buttonDisplay);
        etInput = findViewById(R.id.editTextInput);
        etData = findViewById(R.id.toggleButton);
        rgGender = findViewById(R.id.radioGroupGender);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringResponse = etInput.getText().toString();
                if (stringResponse.isEmpty()) {
                    tvDisplay.setText("Nothing has been entered");
                    Toast.makeText(MainActivity.this,
                            "Please  input something",
                            Toast.LENGTH_SHORT).show();
                } else {
                    tvDisplay.setText(stringResponse);
                }
            }

        });

        etData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(etData.isChecked()) {
                    etData.setEnabled(true);
                    etData.setBackgroundColor(Color.TRANSPARENT);
                }else{
                    etData.setEnabled(false);
                    etData.setBackgroundColor(Color.GRAY);
                }
            }
        });
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringResponse = etInput.getText().toString();
                int checkedRadioId = rgGender.getCheckedRadioButtonId();
                if(checkedRadioId == R.id.radioButtonGenderMale){
                    // Write the code when male selected
                    stringResponse = "He says " + stringResponse;
                }
                else{
                    // Write the code when female selected
                    stringResponse = "She says " + stringResponse;

                }
                tvDisplay.setText(stringResponse);
            }
        });


    }

}



