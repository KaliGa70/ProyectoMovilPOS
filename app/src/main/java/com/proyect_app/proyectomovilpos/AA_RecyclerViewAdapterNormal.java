package com.proyect_app.proyectomovilpos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AA_RecyclerViewAdapterNormal extends
        RecyclerView.Adapter<AA_RecyclerViewAdapterNormal.MyViewHolder> {

    Context context;
    ArrayList<CarritoModel> CarritoModel;

    public AA_RecyclerViewAdapterNormal(Context context, ArrayList<CarritoModel> CarritoModel) {
        this.context = context;
        this.CarritoModel = CarritoModel;
    }

    @NonNull
    @Override
    public AA_RecyclerViewAdapterNormal.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                  int viewType) {
        /** This is where you inflate the layout (giving a look to our rows) **/
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_pedidos_gral, parent, false); // Pass 'false' to attachToRoot
        return new AA_RecyclerViewAdapterNormal.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AA_RecyclerViewAdapterNormal.MyViewHolder holder,
                                 int position) {
        /** Assigning values to the view we created in the recycler_view_row layout file
         * base on the position of the recycler view **/
        holder.tvNameProducto.setText(CarritoModel.get(position).getNameProducto());
        holder.tvPrecioProducto.setText(CarritoModel.get(position).getPrecioProducto());
    }

    @Override
    public int getItemCount() {
        /** The recycler view just wants to know the number of items you want displayed **/
        return CarritoModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        /** Grabbing the views from our recycler_view_row layout file
         * Kinda like in the onCreate method **/

        TextView tvNameProducto, tvPrecioProducto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNameProducto = itemView.findViewById(R.id.tvNameProducto);
            tvPrecioProducto = itemView.findViewById(R.id.tvPrecioProducto);

        }
    }
}