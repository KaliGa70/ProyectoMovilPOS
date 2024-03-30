package com.proyect_app.proyectomovilpos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class aCategoria extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    int[] categoryImages ={R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background};

    private String name, categoryNa = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acategoria);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack02 = (Button) findViewById(R.id.btnBack02);
        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);

        name = getIntent().getStringExtra("NAME");
        categoryNa = getIntent().getStringExtra("CATEGORY1");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView tvCategoria_02 = findViewById(R.id.tvCategoria_02);
        RecyclerView mrecyclerView01 = findViewById(R.id.mRecyclerView01);


        if(categoryNa == null){
            tvCategoria_02.setText(name);
        } else {
            tvCategoria_02.setText(categoryNa);
        }

        setUpCategoryModels();

        AA_RecyclerViewAdapter adapter = new AA_RecyclerViewAdapter(this, categoryModels, this);
        mrecyclerView01.setAdapter(adapter);
        mrecyclerView01.setLayoutManager(new LinearLayoutManager(this));

        btnBack02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack02();

            }
        });
    }

    private void setUpCategoryModels() {
        // Construyes el identificador del recurso R.array utilizando la variable 'name'

        int resId;

        if(categoryNa == null){
            resId = getResources().getIdentifier(name, "array", getPackageName());
        } else {
            resId = getResources().getIdentifier(categoryNa, "array", getPackageName());
        }

        // Accedes al array de recursos utilizando el identificador
        String[] CategoryNames = getResources().getStringArray(resId);

        for (int i = 0; i < CategoryNames.length; i++) {
            categoryModels.add(new CategoryModel(CategoryNames[i], categoryImages[i]));
        }
    }

    public void cBack02() {

        Intent intent = new Intent(aCategoria.this, cPedidos.class);
        startActivity(intent);
        finish();

    }

    public void cConfirmar() {

        Intent intent = new Intent(aCategoria.this, cGuardado.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(aCategoria.this, pedidos_categoria_producto_teclado.class);


        if(categoryNa == null){
            intent.putExtra("CATEGORY", name);
        } else {
            intent.putExtra("CATEGORY", categoryNa);
        }

        intent.putExtra("NAME", categoryModels.get(position).getCategoryName());
        intent.putExtra("IMAGE", categoryModels.get(position).getImage());

        startActivity(intent);
        finish();
    }

}