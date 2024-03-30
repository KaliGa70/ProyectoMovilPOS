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

public class aCarrito extends AppCompatActivity {

    ArrayList<CarritoModel> carritoModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acarrito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView rvCarrito = findViewById(R.id.rvCarrito);



        Button btnBack05 = (Button) findViewById(R.id.btnBack04);

        btnBack05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack05();

            }
        });

        setUpCategoryModels();

        AA_RecyclerViewAdapterNormal adapter = new AA_RecyclerViewAdapterNormal(this, carritoModel);
        rvCarrito.setAdapter(adapter);
        rvCarrito.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpCategoryModels() {
        String[] CarritoNames = getResources().getStringArray(R.array.Agua);
        String[] CarritoPrecio = getResources().getStringArray(R.array.Precio);

        for (int i = 0; i < CarritoNames.length; i++) {
            carritoModel.add(new CarritoModel(CarritoNames[i], CarritoPrecio[i]));
        }
    }

    public void cBack05() {

        Intent intent = new Intent(aCarrito.this, cPedidos.class);
        startActivity(intent);
        finish();

    }

}