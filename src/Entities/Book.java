/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author LENOVO
 */
public class Book {
    private int bookId,bookQuantity;
    private String bookTitle,bookAuthor,bookCategory,bookAddDate,bookImage;
    private Boolean bookAvail;

    public Book() {
    }

    public Book(int bookId, int bookQuantity, String bookTitle, String bookAuthor, String bookCategory, String bookAddDate, String bookImage, Boolean bookAvail) {
        this.bookId = bookId;
        this.bookQuantity = bookQuantity;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookAddDate = bookAddDate;
        this.bookImage = bookImage;
        this.bookAvail = bookAvail;
    }

    public Book(int bookQuantity, String bookTitle, String bookAuthor, String bookCategory, String bookAddDate, String bookImage, Boolean bookAvail) {
        this.bookQuantity = bookQuantity;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookCategory = bookCategory;
        this.bookAddDate = bookAddDate;
        this.bookImage = bookImage;
        this.bookAvail = bookAvail;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public String getBookAddDate() {
        return bookAddDate;
    }

    public void setBookAddDate(String bookAddDate) {
        this.bookAddDate = bookAddDate;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public Boolean getBookAvail() {
        return bookAvail;
    }

    public void setBookAvail(Boolean bookAvail) {
        this.bookAvail = bookAvail;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookQuantity=" + bookQuantity + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookCategory=" + bookCategory + ", bookAddDate=" + bookAddDate + ", bookImage=" + bookImage + ", bookAvail=" + bookAvail + '}';
    }    
}
