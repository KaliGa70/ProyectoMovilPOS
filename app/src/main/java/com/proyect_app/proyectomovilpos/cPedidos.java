package com.proyect_app.proyectomovilpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.dpalacios803gmail.com.proyectomovilpos.R;

public class cPedidos extends AppCompatActivity {

    List<ListElement01> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cpedidos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack01 = (Button) findViewById(R.id.btnBack01);

        init();

        btnBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack01();

            }
        });
    }

    public void init() {
        elements = new ArrayList<>();
        elements.add(new ListElement01("Pozole"));
        elements.add(new ListElement01("Mixtas"));
        elements.add(new ListElement01("Refrescos"));
        elements.add(new ListElement01("Sopes"));
        elements.add(new ListElement01("Tacos"));
        elements.add(new ListElement01("Agua"));

        ListAdapter01 listAdapter01 = new ListAdapter01(elements, this);
        RecyclerView recyclerView = findViewById(R.id.ListRV01);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter01);
    }

    public void cBack01() {

        Intent intent = new Intent(cPedidos.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}