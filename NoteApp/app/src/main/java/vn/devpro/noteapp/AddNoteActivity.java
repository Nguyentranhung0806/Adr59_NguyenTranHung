package vn.devpro.noteapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.room.Room;

import vn.devpro.noteapp.database.Note;
import vn.devpro.noteapp.database.NoteDatabase;

public class AddNoteActivity extends AppCompatActivity {

    EditText edtContent;
    Button btnSave;

    NoteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        edtContent = findViewById(R.id.edtContent);
        btnSave = findViewById(R.id.btnSave);

        database = Room.databaseBuilder(
                getApplicationContext(),
                NoteDatabase.class,
                "note_database"
        ).build();

        btnSave.setOnClickListener(v -> {

            String content = edtContent.getText().toString().trim();

            if (content.isEmpty()) {
                Toast.makeText(
                        AddNoteActivity.this,
                        "Vui lòng nhập ghi chú",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            new Thread(() -> {

                Note note = new Note(content);

                database.noteDao().insert(note);

                runOnUiThread(() -> {
                    Toast.makeText(
                            AddNoteActivity.this,
                            "Đã lưu ghi chú",
                            Toast.LENGTH_SHORT
                    ).show();

                    finish();
                });

            }).start();
        });
    }
}