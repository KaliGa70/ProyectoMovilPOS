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

public class NuevoPendiente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nuevo_pendiente);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack03 = (Button) findViewById(R.id.btnBack03);
        Button btnNuevos = (Button) findViewById(R.id.btnNuevos);
        Button btnPendientes = (Button) findViewById(R.id.btnPendientes);

        /** Regresar **/
        btnBack03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack03();

            }
        });

        /** Nuevos **/
        btnNuevos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cNuevos();

            }
        });

        /** Pendientes **/
        btnPendientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cPendiente();

            }
        });

    }

    public void cBack03() {

        Intent intent = new Intent(NuevoPendiente.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    public void cNuevos() {

        Intent intent = new Intent(NuevoPendiente.this, cPedidos.class);
        startActivity(intent);
        finish();

    }

    public void cPendiente() {

        Intent intent = new Intent(NuevoPendiente.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

}