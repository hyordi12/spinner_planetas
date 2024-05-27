package com.example.sistemasolar;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> nombresPlanetas = Arrays.asList(
            "Mercúrio", "Vênus", "Tierra", "Marte",
            "Júpiter", "Saturno", "Urano", "Neptuno"
    );
    private List<Integer> idsImagens = Arrays.asList(
            R.drawable.mercurio, R.drawable.venus,
            R.drawable.tierra, R.drawable.marte,
            R.drawable.jupiter, R.drawable.saturno,
            R.drawable.urano, R.drawable.neptuno
    );
    private List<String> descripcionesPlanetas = Arrays.asList(
            "Mercúrio es el planeta más cercano al Sol.",
            "Vênus es el segundo planeta más cercano al Sol y el más caliente.",
            "Tierra es el tercer planeta desde el Sol y el único conocido que tiene vida.",
            "Marte es el cuarto planeta desde el Sol y el más rojo.",
            "Júpiter es el quinto planeta desde el Sol y el más grande.",
            "Saturno es el sexto planeta desde el Sol y el más grande después de Júpiter.",
            "Urano es el séptimo planeta desde el Sol y el más frío.",
            "Neptuno es el octavo y último planeta desde el Sol."
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerPlanetas = findViewById(R.id.spinnerPlanetas);

        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresPlanetas);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerPlanetas.setAdapter(adaptador);

        LinearLayout vistaPersonalizada = findViewById(R.id.vistaPersonalizada);
        vistaPersonalizada.setVisibility(View.GONE);


        spinnerPlanetas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nombrePlanetaSeleccionado = parent.getItemAtPosition(position).toString();

                ImageView imagenPlaneta = findViewById(R.id.imagenPlaneta);
                TextView descripcionPlaneta = findViewById(R.id.descripcionPlaneta);

                imagenPlaneta.setImageResource(idsImagens.get(position));
                descripcionPlaneta.setText(descripcionesPlanetas.get(position));

                vistaPersonalizada.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                vistaPersonalizada.setVisibility(View.GONE);
            }
        });
    }
}



