package vn.devpro.loginui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    TextView tvError, btnEye;
    Button btnLogin;


    String correctPassword = "123456";


    boolean isPasswordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        tvError = findViewById(R.id.tvError);
        btnEye = findViewById(R.id.btnEye);
        btnLogin = findViewById(R.id.btnLogin);


        tvError.setVisibility(View.GONE);


        btnLogin.setOnClickListener(v -> {

            String password =
                    edtPassword.getText().toString().trim();


            if (password.equals(correctPassword)) {


                tvError.setVisibility(View.GONE);


                Toast.makeText(
                        MainActivity.this,
                        "Đăng nhập thành công!",
                        Toast.LENGTH_SHORT
                ).show();

            } else {


                tvError.setText("Mật khẩu không đúng!");
                tvError.setVisibility(View.VISIBLE);
            }
        });



        edtPassword.setOnFocusChangeListener(
                (v, hasFocus) -> {

                    if (hasFocus) {
                        tvError.setVisibility(View.GONE);
                    }
                }
        );



        edtPassword.addTextChangedListener(
                new TextWatcher() {

                    @Override
                    public void beforeTextChanged(
                            CharSequence s,
                            int start,
                            int count,
                            int after
                    ) {
                    }

                    @Override
                    public void onTextChanged(
                            CharSequence s,
                            int start,
                            int before,
                            int count
                    ) {

                        tvError.setVisibility(View.GONE);
                    }

                    @Override
                    public void afterTextChanged(
                            Editable s
                    ) {
                    }
                }
        );


        btnEye.setOnClickListener(v -> {

            if (isPasswordVisible) {


                edtPassword.setTransformationMethod(
                        PasswordTransformationMethod
                                .getInstance()
                );


                btnEye.setText("◉");

                isPasswordVisible = false;

            } else {


                edtPassword.setTransformationMethod(
                        HideReturnsTransformationMethod
                                .getInstance()
                );


                btnEye.setText("◉");

                isPasswordVisible = true;
            }


            edtPassword.setSelection(
                    edtPassword.getText().length()
            );
        });
    }
}