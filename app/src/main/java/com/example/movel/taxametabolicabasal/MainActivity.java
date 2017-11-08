package com.example.movel.taxametabolicabasal;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    protected double result, alt, pes, ida, af, taxaM, resultSemanal, resultMensal;
    protected EditText altura, peso, idade;
    protected RadioButton mas, fem, leve, moderado, intenso;
    private CheckBox semanal, mensal;
    DecimalFormat convete = new DecimalFormat(".##");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        altura = (EditText) findViewById(R.id.altura);
        peso   = (EditText) findViewById(R.id.peso);
        idade  = (EditText) findViewById(R.id.idade);

        Button calc = (Button) findViewById(R.id.calcular);

        mas = (RadioButton) findViewById(R.id.radioMasc);
        fem = (RadioButton) findViewById(R.id.radioFerm);

        leve     = (RadioButton) findViewById(R.id.leve);
        moderado = (RadioButton) findViewById(R.id.moderado);
        intenso  = (RadioButton) findViewById(R.id.intenso);

        semanal = (CheckBox) findViewById(R.id.resultadoSemana);
        mensal  = (CheckBox) findViewById(R.id.resultadoMes);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(altura.getText().length() == 0 ) {
                    altura.setError("Campo Vazio");
                    return;
                }

                if(peso.getText().length() == 0) {
                    peso.setError("Campo Vazio");
                    return;
                }

                if(idade.getText().length() == 0) {
                    idade.setError("Campo Vazio");
                    return;
                }

                alt = Double.parseDouble(altura.getText().toString());
                pes = Double.parseDouble(peso.getText().toString());
                ida = Double.parseDouble(idade.getText().toString());


                if (mas.isChecked()) {

                    if ( leve.isChecked() ) {
                        af = 1.55;
                    } else if( moderado.isChecked() ) {
                        af = 1.78;
                    } else {
                        af = 2.10;
                    }

                    result = 66.5 + (14 *pes) + (5*alt) - ( 6.7*ida);
                    taxaM = result * af;
                    resultSemanal = taxaM*7;
                    resultMensal  = taxaM*30;

                    if( semanal.isChecked() && mensal.isChecked() ) {
                        Toast.makeText(MainActivity.this,
                                " Sua TBM é "+ convete.format(taxaM)+" kcal diárias \n " +
                                " Sua TBM semanal é de "+convete.format(resultSemanal)+
                                " kcal \n Sua TBM Mensal é de "+convete.format(resultMensal)+" kcal", Toast.LENGTH_LONG).show();
                    } else if(mensal.isChecked()) {
                        Toast.makeText(MainActivity.this, "" +
                                " Sua TBM é "+convete.format(taxaM)+" kcal diárias \n " +
                                " Sua TBM mensal é de "+convete.format(resultMensal)+" kcal", Toast.LENGTH_LONG).show();
                    } else if ( semanal.isChecked() ) {
                        Toast.makeText(MainActivity.this,
                                " Sua TBM é "+convete.format(taxaM)+" kcal diárias \n " +
                                " Sua TBM semanal é de "+convete.format(resultSemanal)+" kcal", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Sua TBM é "+convete.format(taxaM)+" kcal diárias ", Toast.LENGTH_LONG).show();
                    }

                } else {

                    if ( leve.isChecked() ) {
                        af = 1.56;
                    } else if( moderado.isChecked() ) {
                        af = 1.64;
                    } else {
                        af = 1.82;
                    }

                    result = 655 + (9.6 *pes) + (1.8*alt) - ( 4.7*ida);
                    taxaM = result * af;
                    resultSemanal = taxaM*7;
                    resultMensal  = taxaM*30;

                    if( semanal.isChecked() && mensal.isChecked() ) {
                        Toast.makeText(MainActivity.this,
                                " Sua TBM é "+convete.format(taxaM)+" kcal diárias \n " +
                                        " Sua TBM semanal é de "+convete.format(resultSemanal)+
                                        "kcal \n Sua TBM Mensal é de "+convete.format(resultMensal)+" kcal", Toast.LENGTH_LONG).show();
                    } else if(mensal.isChecked()) {
                        Toast.makeText(MainActivity.this, "" +
                                " Sua TBM é "+convete.format(taxaM)+" kcal diárias \n " +
                                " Sua TBM mensal é de "+convete.format(resultMensal)+" kcal", Toast.LENGTH_LONG).show();
                    } else if ( semanal.isChecked() ) {
                        Toast.makeText(MainActivity.this,
                                " Sua TBM é "+convete.format(taxaM)+" kcal diárias \n " +
                                " Sua TBM semanal é de "+convete.format(resultSemanal)+" kcal", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Sua TBM é "+convete.format(taxaM)+" kcal diárias ", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });
    }
}
