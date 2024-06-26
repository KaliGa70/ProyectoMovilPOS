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

public class inventarioDelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inventario_delete);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack09 = (Button) findViewById(R.id.btnBack09);
        Button btnProductos_02 = (Button) findViewById(R.id.btnProductos_02);
        Button btncat_02 = (Button) findViewById(R.id.btncat_02);

        btnProductos_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventarioDelete.this, inventarioDeleteProductos.class);
                startActivity(intent);
                finish();

            }
        });

        btncat_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventarioDelete.this, inventarioDeleteCategoria.class);
                startActivity(intent);
                finish();

            }
        });

        btnBack09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventarioDelete.this, cInventario.class);
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
        Intent intent = new Intent(inventarioDelete.this, cInventario.class);
        startActivity(intent);
        finish();
    }
}