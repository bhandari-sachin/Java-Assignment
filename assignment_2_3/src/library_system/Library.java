package library_system;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void displayBooks() {
        System.out.println("Library Catalog.");
        int count = 1;
        for (Book book : books) {
            System.out.println(count + ". " + book.toString());
            count++;
        }
        System.out.println();
    }

    // Method to find books by a specific author

    public void findBookByAuthor(String author) {
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


}
