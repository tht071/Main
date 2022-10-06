package com.example.nongsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nongsan.ui.constract.LoginConstract;
import com.example.nongsan.ui.constract.LoginPresenter;

public class LoginActivity extends BaseActivity implements LoginConstract.IView {
    private LoginConstract.IPresenter mPreseneter;

    private EditText edPhone;
    private EditText edPassword;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initGUI();
        initData();

    }

    private void initGUI() {
        edPhone = findViewById(R.id.ed_phone);
        edPassword = findViewById(R.id.ed_password);
        btnSubmit = findViewById(R.id.btn_submit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = edPhone.getText().toString();
                String password = edPassword.getText().toString();

                mPreseneter.login(phone, password);
            }
        });
    }

    private void initData() {
        mPreseneter = new LoginPresenter(this);
        mPreseneter.setView(this);
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
    }
}