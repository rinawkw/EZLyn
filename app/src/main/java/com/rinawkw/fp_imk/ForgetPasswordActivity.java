package com.rinawkw.fp_imk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        Button bKirim = (Button) findViewById(R.id.sendPass);
        bKirim.setOnClickListener(operasi);
    }
    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sendPass:bukaLogin();break;
            }
        }
    };
    void bukaLogin() {
        Intent intentku = new Intent(getBaseContext(), LoginActivity.class);
        startActivityForResult(intentku, 0);
    }
}
