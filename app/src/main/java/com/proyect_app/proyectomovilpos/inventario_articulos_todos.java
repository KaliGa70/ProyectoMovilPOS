package com.proyect_app.proyectomovilpos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class inventario_articulos_todos extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private ImageView imageAdd_02;
    private Button btnSelectImage_03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inventario_articulos_todos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageAdd_02 = findViewById(R.id.imageAdd_02);
        btnSelectImage_03 = findViewById(R.id.btnSelectImage_03);

        btnSelectImage_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre la galería de imágenes para que el usuario seleccione una imagen
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Seleccionar imagen"), PICK_IMAGE);
            }
        });

        Button btnBack01 = (Button) findViewById(R.id.btnBack08);
        Button btnConfirmar_04 = (Button) findViewById(R.id.btnConfirmar_04);

        ImageButton imageBtnMinus = (ImageButton) findViewById(R.id.imageBtnPlus);

        ImageButton imageBtnPlus = (ImageButton) findViewById(R.id.imageBtnMinus);

        TextView tvnNumberCantidadProductos = findViewById(R.id.tvPantalla_02);



        imageBtnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView

                int textoActual;

                if ((tvnNumberCantidadProductos.getText().toString()) == null || (tvnNumberCantidadProductos.getText().toString()).isEmpty()) {
                    tvnNumberCantidadProductos.setText("0");
                    textoActual = Integer.parseInt(tvnNumberCantidadProductos.getText().toString());
                } else {
                    textoActual = Integer.parseInt(tvnNumberCantidadProductos.getText().toString());
                }


                // Concatenar el nuevo texto con el texto actua
                int textoConcatenado = textoActual + 1;

                // Establecer el texto concatenado en el TextView
                tvnNumberCantidadProductos.setText("" + textoConcatenado);
            }
        });

        imageBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int textoActual;

                if ((tvnNumberCantidadProductos.getText().toString()) == null || (tvnNumberCantidadProductos.getText().toString()).isEmpty()) {
                    tvnNumberCantidadProductos.setText("0");
                    textoActual = Integer.parseInt(tvnNumberCantidadProductos.getText().toString());
                } else {
                    textoActual = Integer.parseInt(tvnNumberCantidadProductos.getText().toString());
                }


                // Concatenar el nuevo texto con el texto actua
                int textoConcatenado = textoActual - 1;

                // Establecer el texto concatenado en el TextView
                tvnNumberCantidadProductos.setText("" + textoConcatenado);

            }
        });

        Spinner spinner_01 = findViewById(R.id.spinner_01);

        // Array de opciones
        String[] opciones_01 = {"Opción 1", "Opción 2", "Opción 3"};

        // Adaptador para el spinner
        ArrayAdapter<String> adapter_01 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_01);
        adapter_01.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Configuración del adaptador
        spinner_01.setAdapter(adapter_01);

        Spinner spinner_02 = findViewById(R.id.spinner_02);

        // Array de opciones
        String[] opciones_02 = {"Opción 1", "Opción 2", "Opción 3"};

        // Adaptador para el spinner
        ArrayAdapter<String> adapter_02 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones_02);
        adapter_02.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Configuración del adaptador
        spinner_02.setAdapter(adapter_02);

        btnConfirmar_04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventario_articulos_todos.this, confirmarCategoriaProductoAdd.class);
                startActivity(intent);
                finish();

            }
        });

        btnBack01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(inventario_articulos_todos.this, inventario_articulos.class);
                startActivity(intent);
                finish();

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }

            try {
                // Obtiene la URI de la imagen seleccionada
                Uri imageUri = data.getData();

                // Convierte la URI a un Bitmap y lo muestra en el ImageView
                InputStream inputStream = getContentResolver().openInputStream(imageUri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageAdd_02.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}