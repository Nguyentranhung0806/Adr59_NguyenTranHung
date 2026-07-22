package vn.devpro.fragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button btnA, btnB, btnC, btnD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);

        loadFragment(new FragmentA());

        btnA.setOnClickListener(v -> loadFragment(new FragmentA()));
        btnB.setOnClickListener(v -> loadFragment(new FragmentB()));
        btnC.setOnClickListener(v -> loadFragment(new FragmentC()));
        btnD.setOnClickListener(v -> loadFragment(new FragmentD()));
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}