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
        Button btnConfirmar_02 = (Button) findViewById(R.id.btnConfirmar_02);


        btnBack05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack05();

            }
        });

        btnConfirmar_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cConfirmar_02();

            }
        });

        setUpCategoryModels();

        AA_RecyclerViewAdapterNormal adapter = new AA_RecyclerViewAdapterNormal(this, carritoModel);
        rvCarrito.setAdapter(adapter);
        rvCarrito.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        // Aquí colocamos el código que queremos que se ejecute al presionar el botón de retroceso
        // En este caso, llamaremos al método super.onBackPressed() para mantener el comportamiento predeterminado
        // y simplemente regresar a la actividad anterior si existe, o cerrar la actividad actual si no hay actividad anterior.
        super.onBackPressed();
        Intent intent = new Intent(aCarrito.this, cPedidos.class);
        startActivity(intent);
        finish();
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

    public void cConfirmar_02() {

        Intent intent = new Intent(aCarrito.this, MetodoPago.class);
        startActivity(intent);
        finish();

    }

}