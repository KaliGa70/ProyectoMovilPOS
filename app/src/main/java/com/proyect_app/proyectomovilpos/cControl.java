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

public class cControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ccontrol);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack12 = (Button) findViewById(R.id.btnBack12);
        //Button btnGastos = (Button) findViewById(R.id.btnGastos);
        //Button btnVentas = (Button) findViewById(R.id.btnVentas);
        Button btnReporteGral = (Button) findViewById(R.id.btnReporteGral);

        btnBack12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(cControl.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

        /*btnGastos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(cControl.this, cGrafica.class);
                startActivity(intent);
                finish();

            }
        });

        btnVentas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(cControl.this, cVentas.class);
                startActivity(intent);
                finish();

            }
        });*/

        btnReporteGral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(cControl.this, cReporteGeneral.class);
                startActivity(intent);
                finish();

            }
        });


    }

    @Override
    public void onBackPressed() {
        // Aquí colocamos el código que queremos que se ejecute al presionar el botón de retroceso
        // En este caso, llamaremos al método super.onBackPressed() para mantener el comportamiento predeterminado
        // y simplemente regresar a la actividad anterior si existe, o cerrar la actividad actual si no hay actividad anterior.
        super.onBackPressed();
        Intent intent = new Intent(cControl.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}