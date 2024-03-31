package com.proyect_app.proyectomovilpos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AA_RecyclerViewAdpterPedidos extends
        RecyclerView.Adapter<AA_RecyclerViewAdpterPedidos.MyViewHolder> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<CarritoModel> CarritoModel;

    public AA_RecyclerViewAdpterPedidos(Context context, ArrayList<CarritoModel> CarritoModel,
                                        RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.CarritoModel = CarritoModel;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AA_RecyclerViewAdpterPedidos.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                        int viewType) {
        /** This is where you inflate the layout (giving a look to our rows) **/
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_pedidos_pendientes_a_ser_atendidos, parent, false); // Pass 'false' to attachToRoot
        return new AA_RecyclerViewAdpterPedidos.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AA_RecyclerViewAdpterPedidos.MyViewHolder holder,
                                 int position) {
        /** Assigning values to the view we created in the recycler_view_row layout file
         * base on the position of the recycler view **/
        holder.tvNumeroPedido.setText(CarritoModel.get(position).getNameProducto());
        holder.tvEstadoPedido.setText(CarritoModel.get(position).getPrecioProducto());
    }

    @Override
    public int getItemCount() {
        /** The recycler view just wants to know the number of items you want displayed **/
        return CarritoModel.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        /** Grabbing the views from our recycler_view_row layout file
         * Kinda like in the onCreate method **/

        TextView tvNumeroPedido, tvEstadoPedido;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            tvNumeroPedido = itemView.findViewById(R.id.tvNumeroPedido);
            tvEstadoPedido = itemView.findViewById(R.id.tvEstadoPedido);

            itemView.setOnClickListener(view -> {
                if (recyclerViewInterface != null) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            });

        }
    }
}
