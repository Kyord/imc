package com.android.phantom.imc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ImcScreen extends AppCompatActivity {
    private EditText et_peso;
    private EditText et_altura;
    private Button btn_calcular;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imc_screen);

        et_peso = (EditText) findViewById(R.id.et_peso);
        et_altura = (EditText) findViewById(R.id.et_altura);
        btn_calcular = (Button) findViewById(R.id.btn_calcular);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);

        btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int peso = Integer.parseInt(et_peso.getText().toString());
                float altura = Float.parseFloat(et_altura.getText().toString());
                float resultado = peso / (altura * altura);
                String toastResultado = String.format("%.1f", resultado);

                if(resultado <= 18.5)
                    tv_resultado.setText("Abaixo do peso!");
                else if(resultado <= 24.9)
                    tv_resultado.setText("Peso ideal, parabéns!");
                else if(resultado <= 29.9)
                    tv_resultado.setText("Levemente acima do peso!");
                else if(resultado <= 34.9)
                    tv_resultado.setText("Obesidade grau I");
                else if(resultado <= 39.9)
                    tv_resultado.setText("Obesidade grau II (Severa)");
                else
                    tv_resultado.setText("Obesidade grau III (Mórbida)");



                Toast.makeText(getBaseContext(), toastResultado,Toast.LENGTH_LONG).show();
            }
        });
    }
}
