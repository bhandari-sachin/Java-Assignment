package model;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean isBorrowed;
    private boolean isReserved;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
        this.isReserved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        String status;

        if (isBorrowed && isReserved) {
            status = " [Borrowed, Reserved]";
        } else if (isBorrowed) {
            status = " [Borrowed]";
        } else if (isReserved) {
            status = " [Reserved for pickup]";
        } else {
            status = " [Available]";
        }

        return title + " by " + author + " (ISBN: " + isbn + ")" + status;
    }
}