package com.example.sistemasolar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final List<String> nombresPlanetas;

    public PlanetaAdapter(@NonNull Context context, List<String> nombresPlanetas) {
        super(context, R.layout.planeta_item);
        this.context = context;
        this.nombresPlanetas = nombresPlanetas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.planeta_item, parent, false);

        TextView textViewNombrePlaneta = rowView.findViewById(R.id.nombrePlaneta);

        String nombrePlanetaActual = nombresPlanetas.get(position);

        textViewNombrePlaneta.setText(nombrePlanetaActual);

        return rowView;
    }

    @Override
    public int getCount() {
        return nombresPlanetas.size();
    }

    @Override
    public String getItem(int position) {
        return nombresPlanetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}






