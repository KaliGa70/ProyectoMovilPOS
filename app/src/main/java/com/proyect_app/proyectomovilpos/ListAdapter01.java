package com.proyect_app.proyectomovilpos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter01 extends RecyclerView.Adapter<ListAdapter01.ViewHolder> {
    private List<ListElement01> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter01(List<ListElement01> itemList, Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @Override
    public ListAdapter01.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View view = mInflater.inflate(R.layout.list_element01, null);
        return new ListAdapter01.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ListAdapter01.ViewHolder holder, final int position) {
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement01> items) { mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconCaVw01;
        TextView Categoria;

        ViewHolder(View itemView) {
            super(itemView);
            iconCaVw01 = itemView.findViewById(R.id.iconCaVw01);
            Categoria = itemView.findViewById(R.id.Categoria);
        }

        void bindData(final ListElement01 item) {
            Categoria.setText(item.getCategoria());
        }
    }
}
