package com.proyect_app.proyectomovilpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cTicket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cticket);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvTicket_01 = findViewById(R.id.tvTicket_01);

        String numberPedido = getIntent().getStringExtra("numeroPedido");

        tvTicket_01.setText("Pedido → " + numberPedido);

        Button btnBack07 = (Button) findViewById(R.id.btnBack07);
        btnBack07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack07();

            }
        });

    }

    public void cBack07() {

        Intent intent = new Intent(cTicket.this, cPendientes.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        // Aquí colocamos el código que queremos que se ejecute al presionar el botón de retroceso
        // En este caso, llamaremos al método super.onBackPressed() para mantener el comportamiento predeterminado
        // y simplemente regresar a la actividad anterior si existe, o cerrar la actividad actual si no hay actividad anterior.
        super.onBackPressed();
        Intent intent = new Intent(cTicket.this, cPendientes.class);
        startActivity(intent);
        finish();
    }

}