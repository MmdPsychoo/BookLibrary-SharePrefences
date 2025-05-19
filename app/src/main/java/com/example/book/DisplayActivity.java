package com.example.book;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txtInfo = findViewById(R.id.txtInfo);

        SharedPreferences sharedPref = getSharedPreferences("BookInfo", MODE_PRIVATE);
        String name = sharedPref.getString("name", "N/A");
        String author = sharedPref.getString("author", "N/A");
        String isbn = sharedPref.getString("isbn", "N/A");
        String price = sharedPref.getString("price", "N/A");

        String result = "Book Information:\n\n" +
                "Name: " + name + "\n" +
                "Author: " + author + "\n" +
                "ISBN: " + isbn + "\n" +
                "Price: $" + price;

        txtInfo.setText(result);
    }
}