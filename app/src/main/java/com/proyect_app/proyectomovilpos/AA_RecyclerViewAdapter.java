package com.proyect_app.proyectomovilpos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AA_RecyclerViewAdapter extends RecyclerView.Adapter<AA_RecyclerViewAdapter.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;
    private Context context;
    private ArrayList<CategoryModel> categoryModels;

    public AA_RecyclerViewAdapter(Context context, ArrayList<CategoryModel> categoryModels,
                                  RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.categoryModels = categoryModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view, recyclerViewInterface);
    }

    // Inside onBindViewHolder method
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Calculamos el índice base para los datos de esta fila (izquierda)
        int leftIndex = position * 2;

        // Configuramos los datos para la fila izquierda
        CategoryModel categoryModelLeft = categoryModels.get(leftIndex);
        holder.tvNameLeft.setText(categoryModelLeft.getCategoryName());
        Glide.with(context)
                .load(categoryModelLeft.getImage()) // Assuming getImage() returns the image URL or path
                .into(holder.imageViewLeft);

        // Verificamos si hay una categoría disponible para la fila derecha
        int rightIndex = leftIndex + 1;
        if (rightIndex < categoryModels.size()) {
            // Configuramos los datos para la fila derecha
            CategoryModel categoryModelRight = categoryModels.get(rightIndex);
            holder.tvNameRight.setText(categoryModelRight.getCategoryName());
            Glide.with(context)
                    .load(categoryModelRight.getImage()) // Assuming getImage() returns the image URL or path
                    .into(holder.imageViewRight);

            // Hacemos visible la fila derecha
            holder.itemViewRight.setVisibility(View.VISIBLE);
        } else {
            // Si no hay una categoría disponible para la fila derecha, la ocultamos
            holder.itemViewRight.setVisibility(View.INVISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        // Como ahora estamos mostrando dos categorías por fila, dividimos el tamaño de la lista por 2
        return (int) Math.ceil(categoryModels.size() / 2.0);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewLeft, imageViewRight;
        TextView tvNameLeft, tvNameRight;
        View itemViewRight; // View para la fila derecha

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            // Inicializamos los elementos de la fila izquierda
            imageViewLeft = itemView.findViewById(R.id.imageView_01_left);
            tvNameLeft = itemView.findViewById(R.id.tvName_01_left);

            // Inicializamos los elementos de la fila derecha
            imageViewRight = itemView.findViewById(R.id.imageView_01_right);
            tvNameRight = itemView.findViewById(R.id.tvName_01_right);
            itemViewRight = itemView.findViewById(R.id.cardViewRight);

            // Asignamos el listener para la fila izquierda
            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos * 2); // Multiplicamos por 2 para obtener la posición correcta
                    }
                }
            });

            // Asignamos el listener para la fila derecha
            itemViewRight.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos * 2 + 1); // Multiplicamos por 2 y sumamos 1 para obtener la posición correcta
                    }
                }
            });
        }
    }
}
