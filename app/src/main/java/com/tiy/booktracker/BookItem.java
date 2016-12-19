package com.tiy.booktracker;

/**
 * Created by RdDvls on 12/16/16.
 */

public class BookItem {
    String bookTitle;
    String bookPossessor;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookPossessor() {
        return bookPossessor;
    }

    public void setBookPossessor(String bookPossessor) {
        this.bookPossessor = bookPossessor;
    }

    public BookItem() {
    }

    public BookItem(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookItem(String bookTitle, String bookPossessor) {
        this.bookTitle = bookTitle;
        this.bookPossessor = bookPossessor;
    }
}
