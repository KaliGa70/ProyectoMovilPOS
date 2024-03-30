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

public class pedidos_categoria_producto_teclado extends AppCompatActivity {

    private String name, categoryName;
    private int image;

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

        name = getIntent().getStringExtra("NAME");
        categoryName = getIntent().getStringExtra("CATEGORY");

        TextView tvCategoria_03 = findViewById(R.id.tvCategoria_03);
        tvCategoria_03.setText(name);

        TextView tvPantalla = findViewById(R.id.tvPantalla);

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

    public void cBack03() {

        Intent intent = new Intent(pedidos_categoria_producto_teclado.this, aCategoria.class);

        intent.putExtra("CATEGORY1", categoryName);

        startActivity(intent);
        finish();

    }

    public void cConfirmar() {

        Intent intent = new Intent(pedidos_categoria_producto_teclado.this, cGuardado.class);
        startActivity(intent);
        finish();

    }
}