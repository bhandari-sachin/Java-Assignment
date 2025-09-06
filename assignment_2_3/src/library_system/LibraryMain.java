package library_system;


public class LibraryMain {
    public static void main(String[] args) {

        // === Task 1: Create Books and Library, demonstrate association ===
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();
        library.findBooksByAuthor("Jane Doe");

        // === Task 2: Borrowing System ===
        System.out.println("=== Borrowing Books ===");
        Book borrowedBook = library.borrowBook("Data Structures and Algorithms");
        library.borrowBook("Unknown Book");

        library.displayBooks();

        System.out.println("=== Returning Books ===");
        library.returnBook(borrowedBook);
        library.displayBooks();

        // Task 3: Check availability
        System.out.println("=== Check Availability ===");
        System.out.println("Is 'Data Structures and Algorithms' available? " +
                library.isBookAvailable("Data Structures and Algorithms"));

        System.out.println("Is 'Unknown Book' available? " +
                library.isBookAvailable("Unknown Book"));

    }
}


