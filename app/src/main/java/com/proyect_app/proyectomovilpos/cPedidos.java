package com.proyect_app.proyectomovilpos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FileDownloadTask;

import java.io.File;
import java.util.ArrayList;

public class cPedidos extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    FirebaseFirestore db;
    FirebaseStorage storage;
    RecyclerView recyclerView;
    AA_RecyclerViewAdapter adapter;

    private Context context = null;

    String categoriaa;

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

        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        Button btnBack01 = findViewById(R.id.btnBack08);
        ImageButton imageBtnCarrito_01 = findViewById(R.id.imageBtnCarrito_01);

        recyclerView = findViewById(R.id.mRecyclerView);
        adapter = new AA_RecyclerViewAdapter(this, categoryModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        btnBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cBack01();
            }
        });
        imageBtnCarrito_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cCarrito01();
            }
        });

        // Obtener categorías de Firebase
        obtenerCategoriasDesdeFirebase();
    }

    private void obtenerCategoriasDesdeFirebase() {
        db.collection("Categorias")
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot querySnapshot) {
                        categoryModels.clear(); // Limpiar la lista antes de agregar nuevas categorías
                        for (DocumentSnapshot document : querySnapshot) {
                            String nombre = document.getString("nombre");
                            String nombreImagen = document.getString("imagen");
                            String id = document.getId(); // Obtener el ID del documento
                            CategoryModel model = new CategoryModel(id, nombre, getRutaImagen(nombreImagen));
                            categoryModels.add(model);
                            if (!existeImagen(nombreImagen)) {
                                descargarImagen(nombreImagen);
                            }
                        }
                        adapter.notifyDataSetChanged(); // Notificar al adaptador sobre los cambios
                    }
                });
    }

    private boolean existeImagen(String nombreImagen) {
        File file = new File(getRutaImagen(nombreImagen));
        return file.exists();
    }

    private String getRutaImagen(String nombreImagen) {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/" + nombreImagen;
    }

    private void descargarImagen(String nombreImagen) {
        context = this.getApplicationContext();
        // Referencia al archivo en Storage
        StorageReference storageReference = storage.getReference().child(nombreImagen);

        // Descargar archivo
        File file = new File(getRutaImagen(nombreImagen));
        storageReference.getFile(file)
                .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(context, "Imagen descargada correctamente", Toast.LENGTH_SHORT).show();
                        // Notificar al adaptador de que los datos han cambiado
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(context, "Error al descargar la imagen: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(cPedidos.this, NuevoPendiente.class);
        startActivity(intent);
        finish();
    }

    public void cBack01() {
        Intent intent = new Intent(cPedidos.this, NuevoPendiente.class);
        startActivity(intent);
        finish();
    }

    public void cCarrito01() {


        Intent intent = new Intent(cPedidos.this, aCarrito.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(cPedidos.this, aCategoria.class);
        intent.putExtra("CATEGORY_NAME", categoryModels.get(position).getCategoryName());
        intent.putExtra("CATEGORY_ID", categoryModels.get(position).getCategoryId()); // Suponiendo que tengas un método getId() en tu modelo de categoría
        startActivity(intent);
        finish();
    }



}
