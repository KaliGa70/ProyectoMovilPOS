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
import java.util.List;


public class cPedidos extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    int[] categoryImages ={R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background, R.drawable.ic_launcher_background
            , R.drawable.ic_launcher_background};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cpedidos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnBack01 = (Button) findViewById(R.id.btnBack01);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpCategoryModels();

        AA_RecyclerViewAdapter adapter = new AA_RecyclerViewAdapter(this, categoryModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack01();

            }
        });
    }

    private void setUpCategoryModels() {
        String[] CategoryNames = getResources().getStringArray(R.array.category);

        for (int i = 0; i < CategoryNames.length; i++) {
            categoryModels.add(new CategoryModel(CategoryNames[i], categoryImages[i]));
        }
    }

    public void cBack01() {

        Intent intent = new Intent(cPedidos.this, NuevoPendiente.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(cPedidos.this, aCategoria.class);

        intent.putExtra("NAME", categoryModels.get(position).getCategoryName());
        intent.putExtra("IMAGE", categoryModels.get(position).getImage());

        startActivity(intent);
        finish();
    }
}