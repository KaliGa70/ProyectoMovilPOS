package com.proyect_app.proyectomovilpos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

public class aCategoria extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<CategoryModel> categoryModels = new ArrayList<>();
    FirebaseFirestore db;
    FirebaseStorage storage;
    RecyclerView mrecyclerView01;
    AA_RecyclerViewAdapter adapter;

    private Context context = null;

    private String name, categoryNa = "", id;

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

        db = FirebaseFirestore.getInstance();
        storage = FirebaseStorage.getInstance();

        Button btnBack02 = (Button) findViewById(R.id.btnBack02);
        //Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar_02);

        /**tvCategoria_02.setText(name);
         categoryNa = getIntent().getStringExtra("CATEGORY1");
         int image = getIntent().getIntExtra("IMAGE", 0);**/

        name = getIntent().getStringExtra("CATEGORY_NAME");
        categoryNa = getIntent().getStringExtra("CATEGORY1");;
        id = getIntent().getStringExtra("CATEGORY_ID");

        TextView tvCategoria_02 = findViewById(R.id.tvControl_01);
        mrecyclerView01 = findViewById(R.id.mRecyclerView01);

        //tvCategoria_02.setText(name);

        if(categoryNa == null){
         tvCategoria_02.setText(name);
         } else {
         tvCategoria_02.setText(categoryNa);
         }

        adapter = new AA_RecyclerViewAdapter(this, categoryModels, this);
        mrecyclerView01.setAdapter(adapter);
        mrecyclerView01.setLayoutManager(new LinearLayoutManager(this));

        btnBack02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack02();

            }
        });

        // Obtener categorías de Firebase
        obtenerCategoriasDesdeFirebase();

    }

    @Override
    public void onBackPressed() {
        // Aquí colocamos el código que queremos que se ejecute al presionar el botón de retroceso
        // En este caso, llamaremos al método super.onBackPressed() para mantener el comportamiento predeterminado
        // y simplemente regresar a la actividad anterior si existe, o cerrar la actividad actual si no hay actividad anterior.
        super.onBackPressed();
        Intent intent = new Intent(aCategoria.this, cPedidos.class);
        startActivity(intent);
        finish();
    }

   /** private void setUpCategoryModels() {
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
    }**/



   private void obtenerCategoriasDesdeFirebase() {
       db.collection("Categorias").document(id).collection("Articulos")
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

/*
        if(categoryNa == null){
            intent.putExtra("CATEGORY", name);
        } else {
            intent.putExtra("CATEGORY", categoryNa);
        }

        intent.putExtra("NAME", categoryModels.get(position).getCategoryName());
        intent.putExtra("IMAGE", categoryModels.get(position).getImage());*/

        intent.putExtra("CATEGORY_NAME", name);
        intent.putExtra("PRODUCO_ID",  categoryModels.get(position).getCategoryId());

        startActivity(intent);
        finish();
    }

}