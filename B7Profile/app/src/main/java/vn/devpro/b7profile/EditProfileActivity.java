package vn.devpro.b7profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtEmail;
    EditText edtPhone;
    EditText edtAddress;

    Spinner spinnerGender;

    Button btnSave;

    TextView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_profile);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        edtAddress = findViewById(R.id.edtAddress);

        spinnerGender = findViewById(R.id.spinnerGender);

        btnSave = findViewById(R.id.btnSave);
        btnBack = findViewById(R.id.btnBack);

        // Gender
        String[] genders = {
                "Male",
                "Female"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        genders
                );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerGender.setAdapter(adapter);

        // Nhận dữ liệu từ Profile
        Intent intent = getIntent();

        String name =
                intent.getStringExtra("name");

        String email =
                intent.getStringExtra("email");

        edtName.setText(name);
        edtEmail.setText(email);

        // Dữ liệu mặc định
        edtPhone.setText("+44 1632 960860");

        edtAddress.setText(
                "314, St No 22 - Dwalington Street"
        );

        // Back
        btnBack.setOnClickListener(v -> {
            finish();
        });

        // Save
        btnSave.setOnClickListener(v -> {

            String newName =
                    edtName.getText().toString();

            String newEmail =
                    edtEmail.getText().toString();

            Intent result =
                    new Intent();

            result.putExtra(
                    "name",
                    newName
            );

            result.putExtra(
                    "email",
                    newEmail
            );

            setResult(
                    RESULT_OK,
                    result
            );

            finish();
        });
    }
}