package com.rinawkw.fp_imk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView tMasuk = (TextView) findViewById(R.id.masuk);
        Button bDaftar = (Button) findViewById(R.id.email_sign_up_button) ;
        tMasuk.setOnClickListener(operasi);
        bDaftar.setOnClickListener(operasi);
    }
    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.email_sign_up_button:bukaLogin();break;
                case R.id.masuk:bukaLogin();break;
            }
        }
    };
    void bukaLogin() {
        Intent intentku = new Intent(getBaseContext(), LoginActivity.class);
        startActivityForResult(intentku, 0);
    }
}
