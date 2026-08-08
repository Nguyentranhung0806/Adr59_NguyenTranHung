package vn.devpro.b7profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    ImageView imgAvatar;
    ImageButton btnEditAvatar;

    TextView txtName;
    TextView txtEmail;

    LinearLayout layoutEditProfile;

    ActivityResultLauncher<Intent> galleryLauncher;
    ActivityResultLauncher<Intent> editProfileLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        imgAvatar = findViewById(R.id.imgAvatar);
        btnEditAvatar = findViewById(R.id.btnEditAvatar);

        txtName = findViewById(R.id.txtName);
        txtEmail = findViewById(R.id.txtEmail);

        layoutEditProfile = findViewById(R.id.layoutEditProfile);



        galleryLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {

                            if (result.getResultCode() == RESULT_OK
                                    && result.getData() != null) {

                                Uri imageUri =
                                        result.getData().getData();

                                imgAvatar.setImageURI(imageUri);
                            }
                        });

        btnEditAvatar.setOnClickListener(v -> {

            Intent intent =
                    new Intent(Intent.ACTION_OPEN_DOCUMENT);

            intent.setType("image/*");

            intent.addCategory(
                    Intent.CATEGORY_OPENABLE);

            galleryLauncher.launch(intent);
        });



        editProfileLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {

                            if (result.getResultCode() == RESULT_OK
                                    && result.getData() != null) {

                                Intent data = result.getData();

                                String name =
                                        data.getStringExtra("name");

                                String email =
                                        data.getStringExtra("email");

                                txtName.setText(name);
                                txtEmail.setText(email);
                            }
                        });

        layoutEditProfile.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            ProfileActivity.this,
                            EditProfileActivity.class
                    );

            intent.putExtra(
                    "name",
                    txtName.getText().toString()
            );

            intent.putExtra(
                    "email",
                    txtEmail.getText().toString()
            );

            editProfileLauncher.launch(intent);
        });
    }
}