package com.app.andre.reposteriayoli;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by ANDRES on 24/7/2017.
 */

public class productoAdapter extends RecyclerView.Adapter<productoAdapter.productoViewHolder> {


    private List<producto> items;

    public productoAdapter(List<producto> items) {
        this.items = items;
    }

    public static class productoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;
        public TextView descripcion;
        public TextView precio;
        public Button ordenar;
        public CardView cardView;


        public productoViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            descripcion = (TextView) v.findViewById(R.id.descripcion);
            precio = (TextView) v.findViewById(R.id.tvPrecio);
            ordenar = (Button)v.findViewById(R.id.btOrdenar);

            ordenar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    String combo = nombre.getText().toString();
                    String desc = descripcion.getText().toString();
                    String pre = precio.getText().toString();
                    Intent intent = new Intent(v.getContext(),cliente_orden.class);
                    intent.putExtra("combo",combo);
                    intent.putExtra("desc",desc);
                    intent.putExtra("pre",pre);
                    v.getContext().startActivity(intent);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    @Override
    public productoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview, viewGroup, false);
        return new productoViewHolder(v);
    }



    @Override
    public void onBindViewHolder(final productoViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.descripcion.setText(items.get(i).getDescripcion());
        viewHolder.precio.setText(items.get(i).getPrecio());
    }


}
