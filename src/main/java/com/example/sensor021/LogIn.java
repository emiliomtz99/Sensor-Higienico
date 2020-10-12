package com.example.sensor021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sensor021.Edificios;
import com.example.sensor021.R;
import com.example.sensor021.Registro;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class LogIn extends AppCompatActivity implements View.OnClickListener {
    public EditText TextEmail;
    private EditText TextPassword;
    private Button btnLogin;
    private ProgressDialog progressDialog;


    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);



        firebaseAuth = FirebaseAuth.getInstance();

        //Referenciamos los views
        TextEmail = (EditText) findViewById(R.id.LoginEmail);
        TextPassword = (EditText) findViewById(R.id.LoginPass);
        progressDialog = new ProgressDialog(this);



        btnLogin = (Button)findViewById(R.id.loginButton);

        //attaching listener to button
        btnLogin.setOnClickListener(this);

        Button registroButton = (Button)findViewById(R.id.registroButton);

        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(LogIn.this, Registro.class);
                startActivity(int3);
            }
        });
    }
    private void LoginUsuario(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        String email = TextEmail.getText().toString().trim();
        String password  = TextPassword.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Must enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Password missing",Toast.LENGTH_LONG).show();
            return;
        }


        progressDialog.setMessage("Login...");
        progressDialog.show();

        //creating a new user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(LogIn.this,"Welcome "+ TextEmail.getText(),Toast.LENGTH_SHORT).show();
                            Intent int2 = new Intent(LogIn.this, Edificios.class);
                            startActivity(int2);
                        }else{
                            Toast.makeText(LogIn.this,"Error", Toast.LENGTH_LONG).show();

                        }
                        progressDialog.dismiss();
                    }
                });

    }

    @Override
    public void onClick(View view) {
        //Invocamos al método:
        LoginUsuario();
    }



}








