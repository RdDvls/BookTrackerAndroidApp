package com.tiy.booktracker;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener,AdapterView.OnItemClickListener{
    ListView bookList;
    Button addButton;
    EditText textField;
    ArrayAdapter <String> bookContainer;
    public final static String EXTRA_MESSAGE = "com.tiy.booktracker.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.button);
        textField = (EditText) findViewById(R.id.editText);
        bookList = (ListView) findViewById(R.id.listView);

        bookContainer = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        bookList.setAdapter(bookContainer);

        addButton.setOnClickListener(this);
        bookList.setOnItemLongClickListener(this);
        bookList.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view){
        /*Let user enter book title as string here. Create a book when clicked to add info.*/
//        BookItem bookItem = new BookItem(textField.getText().toString());
//        bookContainer.add(bookItem.bookTitle);

        String bookString = textField.getText().toString();
        bookContainer.add(bookString);
        textField.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent,View view,int position, long id) {
        String item = bookContainer.getItem(position);
        bookContainer.remove(item);
        return true;

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, InfoActivity.class);

        /* If I pass a book to the next view, the app crashes. Seems to only work when passing strings and the "extra_message (possible confirmation message for package data transfer (hack-a-thon and final proj packaging); why won't it pass an object?
        How to ensure correct book is being manipulated or that changes will remain after transition?
        Ask Dom and/or TJ
         */

//        FAILED:
//        BookItem userBook = new BookItem(bookContainer.getItem(position));
//        intent.putExtra(EXTRA_MESSAGE, (Parcelable) userBook);


        String book = bookContainer.getItem(position);
        intent.putExtra(EXTRA_MESSAGE,book);
        startActivity(intent);
    }
}
