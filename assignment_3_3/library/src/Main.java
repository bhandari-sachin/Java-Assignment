import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Create books
        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", "12345");
        Book b2 = new Book("1984", "George Orwell", "67890");

        // Add books to library
        library.addBook(b1);
        library.addBook(b2);

        // Create members
        LibraryMember m1 = new LibraryMember("Alice", 1);
        LibraryMember m2 = new LibraryMember("Bob", 2);

        // Add members to library
        library.addMember(m1);
        library.addMember(m2);

        // Borrow and return books
        library.borrowBook(m1, b1);
        library.borrowBook(m2, b1); // already borrowed
        library.returnBook(m1, b1);
        library.borrowBook(m2, b1); // now available

        // Display info
        library.showAllBooks();
        library.showAllMembers();
    }
}
