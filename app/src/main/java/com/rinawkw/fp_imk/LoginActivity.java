package com.rinawkw.fp_imk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = (EditText)findViewById(R.id.email);
        etPassword = (EditText)findViewById(R.id.password);
        Button bMasuk = (Button) findViewById(R.id.signin);
        TextView tDaftar = (TextView) findViewById(R.id.tvDaftar) ;
        TextView tLP = (TextView) findViewById(R.id.tvLP);
        bMasuk.setOnClickListener(operasi);
        tDaftar.setOnClickListener(operasi);
        tLP.setOnClickListener(operasi);
    }
    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.signin:bukaHome();break;
                case R.id.tvDaftar:bukaRegis();break;
                case R.id.tvLP:bukaLP();break;
            }
        }
    };
    void bukaHome()
    {
        if(etEmail.getText().toString().equals("rina")){
            Toast.makeText(LoginActivity.this,"Login Berhasil", Toast.LENGTH_LONG).show();
            Intent intentku = new Intent(getBaseContext(),MapsActivity.class);
            startActivityForResult(intentku,0);
        }
        else if(etEmail.getText().toString().equals("rafiar")){
            Toast.makeText(LoginActivity.this,"Login Berhasil", Toast.LENGTH_LONG).show();
            Intent intentku = new Intent(getBaseContext(),MapsActivity.class);
            startActivityForResult(intentku,0);
        }
        else if(etEmail.getText().toString().equals("risma")) {
            Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_LONG).show();
            Intent intentku = new Intent(getBaseContext(), MapsActivity.class);
            startActivityForResult(intentku, 0);
        }
        else{
            Toast.makeText(LoginActivity.this,"Login Gagal", Toast.LENGTH_LONG).show();
            Intent intentku = new Intent(getBaseContext(),LoginActivity.class);
            startActivityForResult(intentku,0);
        }

    }
    void bukaRegis()
    {
        Intent intentku = new Intent(getBaseContext(),RegisterActivity.class);
        startActivityForResult(intentku,0);
    }
    void bukaLP(){
        Intent intentku = new Intent(getBaseContext(),ForgetPasswordActivity.class);
        startActivityForResult(intentku,0);
    }
}
