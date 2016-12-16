package com.tiy.booktracker;

import android.content.Intent;
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
        String bookItem = textField.getText().toString();
//        BookItem bookItem = new BookItem(textField.getText().toString());
        bookContainer.add(bookItem);
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
        String book = bookContainer.getItem(position);
        intent.putExtra(EXTRA_MESSAGE,book);
        startActivity(intent);
    }
}
