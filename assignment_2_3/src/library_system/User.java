package library_system;



import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Book> borrowedBooks;

    // Constructor
    public User(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    // Borrow a book
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Return a book //
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
