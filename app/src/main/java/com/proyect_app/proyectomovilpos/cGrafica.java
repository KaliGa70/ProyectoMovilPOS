package com.proyect_app.proyectomovilpos;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import java.util.ArrayList;
import java.util.List;

public class cGrafica extends AppCompatActivity {

    private BarChart barChart;
    private String[] categories = {"Categoría 1", "Categoría 2", "Categoría 3", "Categoría 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgrafica);

        barChart = findViewById(R.id.barChart);

        // Datos
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(1, 50)); // Barra 1
        entries.add(new BarEntry(2, 70)); // Barra 2
        entries.add(new BarEntry(3, 90)); // Barra 3
        entries.add(new BarEntry(4, 30)); // Barra 4

        BarDataSet barDataSet = new BarDataSet(entries, "Art Chart");

        // Personalización
        barDataSet.setColor(Color.rgb(255, 69, 0)); // Color naranja

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        // Personalización del eje X
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);

        // Crear un objeto de formateador de eje X
        MyXAxisValueFormatter formatter = new MyXAxisValueFormatter(categories);
        xAxis.setValueFormatter(formatter);

        // Personalización del eje Y
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawAxisLine(true);

        YAxis rightAxis = barChart.getAxisRight();
        rightAxis.setEnabled(false);

        // Animación
        barChart.animateY(2000);
        barChart.invalidate(); // Refrescar gráfico

        // Agregar clic a las barras
        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                int categoryIndex = (int) e.getX() - 1;
                String category = categories[categoryIndex];
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

    // Clase de formateador de eje X
    class MyXAxisValueFormatter extends IndexAxisValueFormatter {
        private final String[] categories;

        public MyXAxisValueFormatter(String[] categories) {
            this.categories = categories;
        }

        @Override
        public String getFormattedValue(float value) {
            int index = (int) value;
            if (index >= 0 && index < categories.length) {
                return categories[index];
            }
            return "";
        }
    }
}
