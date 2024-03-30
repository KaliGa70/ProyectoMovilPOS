package com.proyect_app.proyectomovilpos;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /** Botones **/
        ImageButton btnInventario = (ImageButton) findViewById(R.id.btnInventario);
        Button btnSalir = (Button) findViewById(R.id.btnSalir);
        ImageButton btnPedidos = (ImageButton) findViewById(R.id.btnPedidos);
        ImageButton btnMarketPlace = (ImageButton) findViewById(R.id.btnMarketPlace);
        ImageButton btnControl = (ImageButton) findViewById(R.id.btnControl);
        /** Botones **/

        /** Acciones de los botones **/
        btnPedidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cPedidos();

            }
        });

        btnInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cInventario();

            }
        });

        btnControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cControl();

            }
        });

        btnMarketPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cMarketPlace();

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cSalir();

            }
        });
        /** Acciones de los botones **/

    }

    /** Inicio de las funciones **/

    private void cPedidos() {

        Intent intent = new Intent(MainActivity.this, NuevoPendiente.class);
        startActivity(intent);
        finish();

    }

    private void cInventario() {

        Intent intent = new Intent(MainActivity.this, cInventario.class);
        startActivity(intent);
        finish();

    }

    private void cControl() {

        Intent intent = new Intent(MainActivity.this, cControl.class);
        startActivity(intent);
        finish();

    }

    private void cMarketPlace() {

        Intent intent = new Intent(MainActivity.this, cMarketPlace.class);
        startActivity(intent);
        finish();

    }

    private void cSalir() {

        /** Animación de saliendo **/
        Handler handler;
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 200);
        /** Fin animación de saliendo **/

    }

    /** Fin de la funciones **/


}