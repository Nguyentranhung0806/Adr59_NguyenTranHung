package vn.devpro.noteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.noteapp.database.Note;
import vn.devpro.noteapp.database.NoteDatabase;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnAdd;

    NoteAdapter noteAdapter;
    NoteDatabase database;

    List<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);


        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );


        noteAdapter = new NoteAdapter(noteList);


        recyclerView.setAdapter(noteAdapter);


        database = Room.databaseBuilder(
                getApplicationContext(),
                NoteDatabase.class,
                "note_database"
        ).build();


        loadNotes();


        btnAdd.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddNoteActivity.class
            );

            startActivity(intent);
        });
    }

    private void loadNotes() {

        new Thread(() -> {

            List<Note> notes = database
                    .noteDao()
                    .getAllNotes();

            runOnUiThread(() -> {

                noteList.clear();
                noteList.addAll(notes);

                noteAdapter.notifyDataSetChanged();

            });

        }).start();
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (database != null) {
            loadNotes();
        }
    }
}