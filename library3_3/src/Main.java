import model.Book;
import model.LibraryMember;
import system.Library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien", "12345");
        Book b2 = new Book("1984", "George Orwell", "67890");
        library.addBook(b1);
        library.addBook(b2);

        LibraryMember m1 = new LibraryMember("Alice");
        LibraryMember m2 = new LibraryMember("Bob");

        library.addMember(m1);
        library.addMember(m2);

        System.out.println("\n=== Initial State ===");
        library.showAllBooks();
        library.showAllMembers();

        System.out.println("\n=== Step 1: Try to reserve available books (will fail) ===");
        library.reserveBook(m1, b1);
        library.displayReservedBooks(m1);

        System.out.println("\n=== Step 2: Alice borrows The Hobbit ===");
        library.borrowBook(m1, b1);
        library.showAllBooks();

        System.out.println("\n=== Step 3: Bob reserves The Hobbit  ===");
        library.reserveBook(m2, b1);
        library.displayReservedBooks(m2);

        System.out.println("\n=== Step 4: Try to cancel non-existent reservation ===");
        library.cancelReservation(m1, b1);

        System.out.println("\n=== Step 5: Bob cancels his reservation ===");
        library.cancelReservation(m2, b1);
        library.displayReservedBooks(m2);

        System.out.println("\n=== Step 6: Bob reserves again ===");
        library.reserveBook(m2, b1);
        library.displayReservedBooks(m2);

        System.out.println("\n=== Step 7: Alice returns The Hobbit ===");
        library.returnBook(m1, b1);
        library.showAllBooks();

        System.out.println("\n=== Step 8: Bob borrows his reserved book ===");
        library.borrowBook(m2, b1);
        library.displayReservedBooks(m2);
        library.showAllBooks();

        System.out.println("\n=== Step 9: Bob returns the book ===");
        library.returnBook(m2, b1);

        System.out.println("\n=== Final State ===");
        library.showAllBooks();
        library.showAllMembers();
    }
}