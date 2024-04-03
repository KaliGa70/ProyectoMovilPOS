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

        TextView tvSiEstadoOn_01 = findViewById(R.id.tvSiEstadoOn_01);

        Button btnPagoEfectivo_01 = (Button) findViewById(R.id.btnPagoEfectivo_01);
        Button btnPagoDigilal_01 = (Button) findViewById(R.id.btnPagoDigilal_01);
        Button btnEditarPedido_01 = (Button) findViewById(R.id.btnEditarPedido_01);
        Button btnConfirmarEntrega = (Button) findViewById(R.id.btnConfirmarEntrega);

        String numberPedido = getIntent().getStringExtra("numeroPedido");
        String EstadoPedido = getIntent().getStringExtra("EstadoPedido");

        if (EstadoPedido.equals("Pagado")) {
            tvSiEstadoOn_01.setVisibility(View.VISIBLE);
            btnConfirmarEntrega.setVisibility(View.VISIBLE);

            btnPagoEfectivo_01.setVisibility(View.GONE);
            btnPagoDigilal_01.setVisibility(View.GONE);
            btnEditarPedido_01.setVisibility(View.GONE);

        } else {
            tvSiEstadoOn_01.setVisibility(View.GONE);
            btnConfirmarEntrega.setVisibility(View.GONE);

            btnPagoEfectivo_01.setVisibility(View.VISIBLE);
            btnPagoDigilal_01.setVisibility(View.VISIBLE);
            btnEditarPedido_01.setVisibility(View.VISIBLE);
        }

        tvTicket_01.setText(numberPedido + " → " + EstadoPedido);

        Button btnBack07 = (Button) findViewById(R.id.btnBack07);
        btnBack07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack07();

            }
        });

        btnPagoEfectivo_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(cTicket.this, cYaTePago.class);
                startActivity(intent);
                finish();

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

    // Método para controlar la visibilidad de las vistas

}