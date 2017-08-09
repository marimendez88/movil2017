package com.app.andre.reposteriayoli;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    String user = "admin";
    String pass = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    public void Admin(View view){

        final Dialog login = new Dialog(this);
        login.setTitle("Administracion");
        login.setContentView(R.layout.login_view);
        Button btnLogin = (Button) login.findViewById(R.id.btIngresar);
        Button btnCancel = (Button) login.findViewById(R.id.btCancelar);
        final EditText User = (EditText)login.findViewById(R.id.etUsuario);
        final EditText Pass = (EditText)login.findViewById(R.id.et_Pass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(User.getText().toString().length() == 0 )
                {
                    Toast.makeText(getApplicationContext(),
                            "Ingrese el Usuario", Toast.LENGTH_LONG).show();
                    return;
                }
                if(Pass.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(),
                            "Ingrese la Contraseña", Toast.LENGTH_LONG).show();
                    return;
                }
                if (User.getText().toString().equals(user)&& Pass.getText().toString().equals(pass)){

                    Intent intent = new Intent(getApplicationContext(),Administracion.class);
                    startActivity(intent);
                    login.dismiss();
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Usuario o Contraseña Incorrectos.", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.dismiss();
            }
        });

        login.show();

    }

    public void clientes(View view){
        Intent intent = new Intent(getApplicationContext(),clientes_Activity.class);
        startActivity(intent);
    }
}
