package library_system;





public class LibraryMain {
    public static void main(String[] args) {
        // === Create Book instances ===
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        // === Create Library instance ===
        Library library = new Library();

        // === Add books to the library ===
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // === Display all books in the library ===
        library.displayBooks();

        // === Search for books by a specific author ===
        library.findBookByAuthor("Jane Doe");
        library.findBookByAuthor("Alice Johnson");
        library.findBookByAuthor("Unknown Author"); // Optional test: no books
    }
}

