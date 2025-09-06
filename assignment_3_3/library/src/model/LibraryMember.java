package model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {

    String name;
    private final int memberId;
    private final List<Book> borrowedBooks;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Member: " + name + " (ID: " + memberId + ")";
    }
}


