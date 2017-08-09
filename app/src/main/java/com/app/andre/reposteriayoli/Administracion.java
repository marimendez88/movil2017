package com.app.andre.reposteriayoli;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class Administracion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //variables para funcionamiento del menu
        private DrawerLayout Dlayout;
        private ActionBarDrawerToggle mtoggle;
        private Toolbar mtool;


    //......................................

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Asignado variables para funcionamiento del menu
            mtool = (Toolbar)findViewById(R.id.nav_action);
            setSupportActionBar(mtool);

            Dlayout = (DrawerLayout)findViewById(R.id.drawerLayout);
            mtoggle = new ActionBarDrawerToggle(this, Dlayout, R.string.Open, R.string.Close);

            Dlayout.addDrawerListener(mtoggle);
            mtoggle.syncState();

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //............................................................
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.mAdmin) {
            Toast.makeText(this, "Configuracion", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.mProductos) {
            Toast.makeText(this, "Productos", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.mPedidos) {
            Toast.makeText(this, "Pedidos", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
