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

import java.util.ArrayList;
import java.util.List;

public class inventario_articulos extends AppCompatActivity {

    int n = 90;
    List<Producto09> productos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inventario_articulos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack01 = (Button) findViewById(R.id.btnBack08);
        Button btnProductos = (Button) findViewById(R.id.btnProductos);
        Button btncat = (Button) findViewById(R.id.btncat);
        Button imprime = (Button) findViewById(R.id.imprime);

        btnProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventario_articulos.this, inventario_articulos_todos.class);
                startActivity(intent);
                finish();

            }
        });

        btncat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventario_articulos.this, inventario_articulos_categorias.class);
                startActivity(intent);
                finish();

            }
        });

        btnBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventario_articulos.this, cInventario.class);
                startActivity(intent);
                finish();

            }
        });

        imprime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_SEND);

                intent.setType("text/plain");

                productos.add(new Producto09(1, "Coca", 4, 70.0));
                productos.add(new Producto09(2, "Agua - Jamaica", 2, 60.0));
                productos.add(new Producto09(3, "Tacos", 6, 90.0));

                String aux = null;

                for(Producto09 produc : productos ){

                    if(aux == null){

                        aux = String.valueOf(produc.getId() + " " + produc.getNombre() + " " + produc.getCantidad() + " " + produc.getPrecio() + "\n");

                    }
                    else{

                        aux += String.valueOf(produc.getId() + " " + produc.getNombre() + " " + produc.getCantidad() + " " + produc.getPrecio() + "\n");

                    }

                }

                intent.putExtra(Intent.EXTRA_TEXT, aux);

                startActivity(Intent.createChooser(intent, "Enviar texto a traves de:"));

            }
        });



    }
}