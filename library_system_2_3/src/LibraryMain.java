package library_system;

public class LibraryMain {
    public static void main(String[] args) {

        // === TASK 1: Create Books and Library ===
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();
        library.findBooksByAuthor("Jane Doe");
        System.out.println();

        // === TASK 2: Borrowing System ====
        System.out.println("=== Borrowing Books ===\n");
        Book borrowedBook = library.borrowBook("Data Structures and Algorithms");
        library.borrowBook("Unknown Book");
        library.displayBooks();

        System.out.println("=== Returning Books ===\n");
        library.returnBook(borrowedBook);
        library.displayBooks();

        // === TASK 3: Check Availability ===
        System.out.println("=== Check Availability ===\n");
        System.out.printf("'Data Structures and Algorithms' available? %b%n",
                library.isBookAvailable("Data Structures and Algorithms"));
        System.out.printf("'Unknown Book' available? %b%n%n",
                library.isBookAvailable("Unknown Book"));

        // === TASK 4: Ratings and Reviews ===
        System.out.println("=== Adding Ratings and Reviews ===\n");
        book1.setRating(4.5);
        book1.addReview("Great for beginners!");
        book1.addReview("Very detailed explanations.");

        book2.setRating(4.0);
        book2.addReview("Good coverage of algorithms.");

        book3.setRating(3.8);
        book3.addReview("Interesting storytelling.");

        library.displayBooks();

        // === TASK 5: Library Statistics ===
        System.out.println("=== Library Statistics ===\n");
        System.out.printf("Average Book Rating: %.1f%n", library.getAverageBookRating());

        Book mostReviewed = library.getMostReviewedBook();
        if (mostReviewed != null) {
            System.out.printf("Most Reviewed Book: \"%s\" with %d reviews.%n",
                    mostReviewed.getTitle(), mostReviewed.getReviews().size());
        }
        System.out.println();

        // === TASK 6: Library Users ===
        System.out.println("=== Library Users ===\n");
        User alice = new User("Alice");
        User bob = new User("Bob");

        library.addUser(alice);
        library.addUser(bob);

        // Users borrow books
        library.borrowBook("Introduction to Java Programming", alice);
        library.borrowBook("The Art of Fiction", bob);

        // Display borrowed books
        System.out.println("Alice borrowed: ");
        for (Book b : alice.getBorrowedBooks()) {
            System.out.printf("- \"%s\" by %s%n", b.getTitle(), b.getAuthor());
        }

        System.out.println("Bob borrowed: ");
        for (Book b : bob.getBorrowedBooks()) {
            System.out.printf("- \"%s\" by %s%n", b.getTitle(), b.getAuthor());
        }

        // Users return books
        library.returnBook(alice.getBorrowedBooks().get(0), alice);
        library.returnBook(bob.getBorrowedBooks().get(0), bob);

        // Final library catalog
        System.out.println("\nFinal Library Catalog:");
        library.displayBooks();
    }
}
