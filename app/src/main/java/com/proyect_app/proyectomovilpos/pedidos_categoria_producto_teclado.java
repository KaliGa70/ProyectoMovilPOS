package com.proyect_app.proyectomovilpos;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class pedidos_categoria_producto_teclado extends AppCompatActivity {

    private String name, categoryName, producto_id;
    private int image;
    FirebaseFirestore db;

    private TextView tvPantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedidos_categoria_producto_teclado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = FirebaseFirestore.getInstance();

        //name = getIntent().getStringExtra("NAME");
        categoryName = getIntent().getStringExtra("CATEGORY_NAME");
        producto_id = getIntent().getStringExtra("PRODUCO_ID");

        TextView tvCategoria_03 = findViewById(R.id.tvCategoria_03);
        tvCategoria_03.setText(name);

        tvPantalla = findViewById(R.id.tvPantalla);

        Button btnBack03 = (Button) findViewById(R.id.btnBack03);
        Button btnConfirmar = (Button) findViewById(R.id.btnConfirmar);

        btnBack03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cBack03();

            }
        });
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cConfirmar();

            }
        });

        Button btnOne = (Button) findViewById(R.id.btnOne);
        Button btnTwo = (Button) findViewById(R.id.btnTwo);
        Button btnThree = (Button) findViewById(R.id.btnThree);
        Button btnFour = (Button) findViewById(R.id.btnFour);
        Button btnFive = (Button) findViewById(R.id.btnFive);
        Button btnSix = (Button) findViewById(R.id.btnSix);
        Button btnSeven = (Button) findViewById(R.id.btnSeven);
        Button btnEight = (Button) findViewById(R.id.btnEight);
        Button btnNine = (Button) findViewById(R.id.btnNine);
        Button btnZero = (Button) findViewById(R.id.btnZero);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "1";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "2";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "3";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "4";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "5";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "6";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "7";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "8";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "9";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Concatenar el nuevo texto con el texto actua
                String textoConcatenado = textoActual + "0";

                // Establecer el texto concatenado en el TextView
                tvPantalla.setText(textoConcatenado);
            }
        });

        Button btnC = (Button) findViewById(R.id.btnC);
        Button btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPantalla.setText("");
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener el texto actual del TextView
                String textoActual = tvPantalla.getText().toString();

                // Verificar si el texto actual no está vacío y contiene al menos un carácter
                if (!textoActual.isEmpty()) {
                    // Obtener una subcadena del texto actual excluyendo el último valor agregado
                    String textoSinUltimoValor = textoActual.substring(0, textoActual.length() - 1);

                    // Establecer la subcadena resultante en el TextView
                    tvPantalla.setText(textoSinUltimoValor);
                }

            }
        });


    }

    @Override
    public void onBackPressed() {
        // Aquí colocamos el código que queremos que se ejecute al presionar el botón de retroceso
        // En este caso, llamaremos al método super.onBackPressed() para mantener el comportamiento predeterminado
        // y simplemente regresar a la actividad anterior si existe, o cerrar la actividad actual si no hay actividad anterior.
        super.onBackPressed();
        Intent intent = new Intent(pedidos_categoria_producto_teclado.this, aCategoria.class);

        intent.putExtra("CATEGORY1", categoryName);

        startActivity(intent);
        finish();
    }

    public void cBack03() {

        Intent intent = new Intent(pedidos_categoria_producto_teclado.this, aCategoria.class);

        intent.putExtra("CATEGORY1", categoryName);

        startActivity(intent);
        finish();

    }

    public void cConfirmar() {

        Toast.makeText(this, tvPantalla.getText().toString(), Toast.LENGTH_SHORT).show();

        if((tvPantalla.getText().toString()) == "" || (tvPantalla.getText().toString()) == null) {

            Toast.makeText(this, "No hay un cantidad valida.", Toast.LENGTH_SHORT).show();

        } else {

            String cantidad_vendidas = tvPantalla.getText().toString();
            int precio_total = Integer.parseInt(cantidad_vendidas) * 20;
            String price_total = precio_total + "";

            // Crear un objeto con los datos del nuevo usuario
            Map<String, Object> nuevoArticulo = new HashMap<>();
            nuevoArticulo.put("id", producto_id);
            nuevoArticulo.put("cantidad_vendidas", cantidad_vendidas);
            nuevoArticulo.put("total", price_total);

            // Agregar el nuevo usuario a la colección "usuarios"
            db.collection("Ventas")
                    .document() // Esto generará automáticamente un ID único para el nuevo documento
                    .collection("Articulos")
                    .add(nuevoArticulo) // Agregar el nuevo artículo a la colección "Articulos"
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Log.d("TAG", "Nuevo artículo agregado con ID: " + documentReference.getId());
                            // Aquí puedes realizar cualquier acción adicional después de agregar el artículo
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            // Manejar el error si la operación falla
                            Log.e("TAG", "Error al agregar nuevo artículo", e);
                        }
                    });



            Intent intent = new Intent(pedidos_categoria_producto_teclado.this, cGuardado.class);
            startActivity(intent);
            finish();

        }



    }
}