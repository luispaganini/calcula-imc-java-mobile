package com.example.calculaimc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText etPeso;
    private EditText etAltura;
    private TextView tvResultado;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = findViewById(R.id.etPeso);
        etAltura = findViewById(R.id.etAltura);
        tvResultado = findViewById(R.id.tvResultado);
        btLimpar = findViewById(R.id.btLimpar);

        etPeso.requestFocus();
        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btLimparOnClick();
            }
        });
    }

    public void btCalcularOnClick( View v) {
        if (etPeso.getText().toString().isEmpty() ) {
            etPeso.setError("Campo Peso deve ser preenchido.");
            etPeso.requestFocus();
            return;
        }

        if (etAltura.getText().toString().isEmpty()) {
            etAltura.setError("Campo altura deve ser preenchido.");
            return;
        }
        double peso = Double.parseDouble(etPeso.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());

        DecimalFormat df = new DecimalFormat( "0.00");
        tvResultado.setText( df.format(peso / (altura * altura)  ));
    }

    private void btLimparOnClick() {
        etPeso.setText("");
        etAltura.setText("");
        tvResultado.setText("0.0");
        etPeso.requestFocus();
    }
}