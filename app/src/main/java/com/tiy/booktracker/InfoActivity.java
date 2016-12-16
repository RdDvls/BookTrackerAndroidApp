package com.tiy.booktracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{
    TextView bookInfoTextView;
    EditText bookInfoEdit;
    Button addInfoButton;
    BookItem userBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        String book = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText("Book Info");

//        TextView bookInfoTextView = new TextView(this);
//        bookInfoTextView.setTextSize(25);
//        bookInfoTextView.setText(book);

        bookInfoTextView = (TextView) findViewById(R.id.textView3);
        bookInfoTextView.setTextSize(25);
        bookInfoTextView.setText(book);

//        addInfoButton.setOnClickListener(this);

        /*Didn't need another view group. Using one built in activity_info and the fields inherited from such.
        Declared bookInfoTextView to be textView in builder specified by id.
        Instantiate the views and fields programatically. Add buttons and fields via builder; denote the id's
         */
//        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_info);
//        layout.addView(bookInfoTextView);
    }

    @Override
    public void onClick(View v) {

    }
}
