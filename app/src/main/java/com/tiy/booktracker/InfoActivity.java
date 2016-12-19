package com.tiy.booktracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity implements View.OnClickListener{
    TextView bookTitleTextView;
    TextView bookPossessorTextView;
    EditText editText5BookTitle;
    EditText editText7Possessor;

    Button editTitleText;
    Button editPossessorText;
    BookItem userBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

//        String book = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        /*Trying send the userBook as a package and manipulate its data in this view.
        -->FAILED
        Trying to send string of book title to user in constructor parameter to create a book on activity info page.
        -->PASS
        Will work to ensure the book is saved.
        Seek to make DB after ensuring book creation.
        OnClick(userBook.title) open prompt to edit text and bookItem title data.
        OnClick(userBook.possessor) open prompt to edit text and bookItem possessor data.
        Crashed.
         */
        Intent intent = getIntent();
        final BookItem userBook = new BookItem(intent.getStringExtra(MainActivity.EXTRA_MESSAGE));
//        TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText("Book Info");

//          This creates a text view programatically. Easier to add using GUI and ID the components

//        TextView bookTitleTextView = new TextView(this);
//        bookTitleTextView.setTextSize(25);
//        bookTitleTextView.setText(book);

        bookTitleTextView = (TextView) findViewById(R.id.textView3);
        bookTitleTextView.setTextSize(25);
        bookPossessorTextView = (TextView) findViewById(R.id.bookPossessor);
        bookPossessorTextView.setTextSize(25);

        /*Works for hardCoded message.
        After adding onClick eiditing ability, link the bookPossessorTextField with userBook.possessor
         */
//        bookPossessorTextView.setText(userBook.bookPossessor);

//        addInfoButton.setOnClickListener(this);

        /*Didn't need another view group. Using one built in activity_info and the fields inherited from such.
        Declared bookTitleTextView to be textView in builder specified by id.
        Instantiate the views and fields programatically. Add buttons and fields via builder; denote the id's
         */
//        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_info);
//        layout.addView(bookTitleTextView);


        editTitleText = (Button) findViewById(R.id.editTitleText);
        editTitleText.setOnClickListener(this);
        editPossessorText = (Button) findViewById(R.id.button4);
        editPossessorText.setOnClickListener(this);



        editText5BookTitle = (EditText) findViewById(R.id.editText5);
        editText5BookTitle.setText(userBook.bookTitle);
        editText7Possessor = (EditText) findViewById(R.id.editText7);
        editText7Possessor.setText(userBook.bookPossessor);






    }


    @Override
    public void onClick(View v) {

    }
}
