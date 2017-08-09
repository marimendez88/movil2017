package com.app.andre.reposteriayoli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class clientes_Activity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_);

        List<producto> items = new ArrayList<>();

        items.add(new producto(R.drawable.ic_reposteria, "Combo 1", "50 bocas saladas y 50 dulces","5000"));
        items.add(new producto(R.drawable.ic_appicon, "Combo 2", "100 bocas saladas y 100 dulces","10000"));
        items.add(new producto(R.drawable.ic_reposteria, "Combo 3", "100 bocas saladas y 100 dulces y queque mediano","15000"));
        items.add(new producto(R.drawable.ic_appicon, "Combo 4", "100 bocas saladas y 100 dulces y 3 leches", "23000"));
        items.add(new producto(R.drawable.ic_appicon, "Combo 5", "Tres leches mediano", "8000"));
        items.add(new producto(R.drawable.ic_appicon, "Combo 6", "Tres leches grande", "13000"));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new productoAdapter(items);
        recycler.setAdapter(adapter);
    }
}
