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

public class cPendientes extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<CarritoModel> carritoModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cpendientes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack06 = (Button) findViewById(R.id.btnBack06);
        btnBack06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack06();

            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvPedidosPendientes);

        setUpCategoryModels();

        AA_RecyclerViewAdpterPedidos adapter = new AA_RecyclerViewAdpterPedidos(this, carritoModel, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpCategoryModels() {
        String[] NumeroTicket = getResources().getStringArray(R.array.NumeroTicket);
        String[] PagadoNoPagado = getResources().getStringArray(R.array.PagadoNoPagado);

        for (int i = 0; i < NumeroTicket.length; i++) {
            carritoModel.add(new CarritoModel(NumeroTicket[i], PagadoNoPagado[i]));
        }
    }

    @Override
    public void onBackPressed() {
        // Aquí colocamos el código que queremos que se ejecute al presionar el botón de retroceso
        // En este caso, llamaremos al método super.onBackPressed() para mantener el comportamiento predeterminado
        // y simplemente regresar a la actividad anterior si existe, o cerrar la actividad actual si no hay actividad anterior.
        super.onBackPressed();
        Intent intent = new Intent(cPendientes.this, NuevoPendiente.class);
        startActivity(intent);
        finish();
    }

    public void cBack06() {

        Intent intent = new Intent(cPendientes.this, NuevoPendiente.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(cPendientes.this, cTicket.class);

        intent.putExtra("numeroPedido", carritoModel.get(position).getNameProducto());
        intent.putExtra("EstadoPedido", carritoModel.get(position).getPrecioProducto());

        startActivity(intent);
        finish();
    }
}