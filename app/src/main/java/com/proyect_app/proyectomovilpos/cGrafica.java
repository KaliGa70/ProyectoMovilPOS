package com.proyect_app.proyectomovilpos;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import java.util.ArrayList;
import java.util.List;

public class cGrafica extends AppCompatActivity {

    private PieChart pieChart;
    private String[] categories = {"Categoría 1", "Categoría 2", "Categoría 3", "Categoría 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgrafica);

        pieChart = findViewById(R.id.pieChart);

        // Datos
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(50f, "Categoría 1")); // Categoría 1
        entries.add(new PieEntry(70f, "Categoría 2")); // Categoría 2
        entries.add(new PieEntry(90f, "Categoría 3")); // Categoría 3
        entries.add(new PieEntry(30f, "Categoría 4")); // Categoría 4

        PieDataSet dataSet = new PieDataSet(entries, "Art Chart");

        // Personalización
        dataSet.setColors(Color.rgb(255, 69, 0), Color.rgb(0, 191, 255), Color.rgb(255, 215, 0), Color.rgb(255, 99, 71)); // Colores
        dataSet.setValueTextColor(Color.BLACK); // Color del texto
        dataSet.setValueTextSize(12f); // Tamaño del texto

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.setEntryLabelColor(Color.BLACK); // Color de las etiquetas
        pieChart.setEntryLabelTextSize(12f); // Tamaño de las etiquetas

        pieChart.getDescription().setEnabled(false); // Deshabilitar descripción
        pieChart.setDrawEntryLabels(false); // No mostrar etiquetas dentro de las piezas
        pieChart.setUsePercentValues(true); // Usar porcentajes en lugar de valores absolutos

        // Animación
        pieChart.animateY(2000);
        pieChart.invalidate(); // Refrescar gráfico

        // Agregar clic a las secciones del pastel
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                if (e == null) return;
                String category = categories[(int) e.getX()];
                float value = e.getY();
                Toast.makeText(cGrafica.this, category + ": " + value, Toast.LENGTH_SHORT).show();
                // Aquí puedes agregar lógica adicional para mostrar información detallada según la categoría seleccionada
            }

            @Override
            public void onNothingSelected() {
                // No se seleccionó nada
            }
        });
    }
}
