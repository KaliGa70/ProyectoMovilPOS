package com.proyect_app.proyectomovilpos;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

public class MyXAxisValueFormatter extends IndexAxisValueFormatter {
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

