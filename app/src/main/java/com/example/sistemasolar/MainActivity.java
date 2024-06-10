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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> nombresPlanetas;
    private List<Integer> idsImagens;
    private List<String> descripcionesPlanetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombresPlanetas = new ArrayList<>();
        nombresPlanetas.add(getString(R.string.planeta_mercurio));
        nombresPlanetas.add(getString(R.string.planeta_venus));
        nombresPlanetas.add(getString(R.string.planeta_tierra));
        nombresPlanetas.add(getString(R.string.planeta_marte));
        nombresPlanetas.add(getString(R.string.planeta_jupiter));
        nombresPlanetas.add(getString(R.string.planeta_saturno));
        nombresPlanetas.add(getString(R.string.planeta_urano));
        nombresPlanetas.add(getString(R.string.planeta_neptuno));


        descripcionesPlanetas = new ArrayList<>();
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_mercurio));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_venus));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_tierra));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_marte));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_jupiter));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_saturno));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_urano));
        descripcionesPlanetas.add(getString(R.string.descripcion_planeta_neptuno));


        idsImagens = Arrays.asList(
                R.drawable.mercurio, R.drawable.venus,
                R.drawable.tierra, R.drawable.marte,
                R.drawable.jupiter, R.drawable.saturno,
                R.drawable.urano, R.drawable.neptuno
        );

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
