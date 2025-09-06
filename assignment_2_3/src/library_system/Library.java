package library_system;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Task 1: Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Task 1: Method to display all books in the library
    public void displayBooks() {
        System.out.println("Library Catalog.");
        int count = 1;
        for (Book book : books) {
            System.out.println(count + ". " + book.toString());
            count++;
        }
        System.out.println();
    }

    // Task 1: Method to find books by a specific author

    public void findBooksByAuthor(String author) {
        System.out.println("Books by Author \"" + author + "\":");
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Title: \"" + book.getTitle() + "\", Year: " + book.getPublicationYear());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }

        System.out.println();
    }

    // Task 2: Borrow a book by title
    public Book borrowBook(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Book \"" + title + "\" borrowed.");
                return book;
            }
        }
        System.out.println("Book \"" + title + "\" is not available.");
        return null;
    }

    // Task 2: Return a book to the library
    public void returnBook(Book book){
        if (book != null) {
            books.add(book);
            System.out.println("Book \"" + book.getTitle() + "\" returned.");
        }
    }

    // Task 3: Method to check if book is available of a specific title

    public boolean isBookAvailable(String title){
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }



}
