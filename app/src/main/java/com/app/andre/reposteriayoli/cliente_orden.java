package com.app.andre.reposteriayoli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class cliente_orden extends AppCompatActivity {

    public TextView combo;
    public TextView desc;
    public TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_orden);

        combo = (TextView) findViewById(R.id.tvInfo);
        desc = (TextView) findViewById(R.id.tvDet);
        precio = (TextView) findViewById(R.id.tvPre);
        Intent intent = getIntent();

        combo.setText(intent.getStringExtra("combo"));
        desc.setText(intent.getStringExtra("desc"));
        precio.setText(intent.getStringExtra("pre"));

    }
}
