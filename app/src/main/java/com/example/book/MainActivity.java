package com.example.book;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editBookName, editAuthor, editIsbn, editPrice;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editBookName = findViewById(R.id.editBookName);
        editAuthor = findViewById(R.id.editAuthor);
        editIsbn = findViewById(R.id.editIsbn);
        editPrice = findViewById(R.id.editPrice);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = editBookName.getText().toString();
            String author = editAuthor.getText().toString();
            String isbn = editIsbn.getText().toString();
            String price = editPrice.getText().toString();

            SharedPreferences sharedPref = getSharedPreferences("BookInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("name", name);
            editor.putString("author", author);
            editor.putString("isbn", isbn);
            editor.putString("price", price);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
            startActivity(intent);
        });
    }
}