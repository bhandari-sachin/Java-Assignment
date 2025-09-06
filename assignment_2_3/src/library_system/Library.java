package library_system;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>(); // Task 6: track users

    // Task 6: Add a user
    public void addUser(User user) {
        users.add(user);
    }

    // Task 1: Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Task 1: Method to display all books in the library
    public void displayBooks() {
        System.out.println("Library Catalog.");
        int count = 1;
        for (Book book : books) {
            System.out.println(count + ". " + book);
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
    public Book borrowBook(String title) {
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
    public void returnBook(Book book) {
        if (book != null) {
            books.add(book);
            System.out.println("Book \"" + book.getTitle() + "\" returned.");
        }
    }

    // Task 3: Method to check if book is available of a specific title

    public boolean isBookAvailable(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return true;
            }
        }
        return false;
    }

    // Task 5: Calculate the average rating of all books in the library
    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0;
        }
        double totalRating = 0.0;
        for (Book book : books) {
            totalRating += book.getRating();
        }
        return totalRating / books.size();
    }

    // Task 5: Find the book with the most reviews //
    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null; // No books in library
        }

        Book mostReviewedBook = books.get(0);
        int maxReviews = mostReviewedBook.getReviews().size();

        for (Book book : books) {
            int reviewCount = book.getReviews().size();
            if (reviewCount > maxReviews) {
                mostReviewedBook = book;
                maxReviews = reviewCount;
            }
        }

        return mostReviewedBook;
    }

    // Task 6: Borrow a book for a specific user
    public void borrowBook(String title, User user) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                user.borrowBook(book);
                System.out.println("Book \"" + book.getTitle() + "\" borrowed by " + user.getName() + ".");
                return;
            }
        }
        System.out.println("Book \"" + title + "\" is not available.");
    }

    // Return a book from a user
    public void returnBook(Book book, User user) {
        if (user.getBorrowedBooks().contains(book)) {
            user.returnBook(book);
            books.add(book);
            System.out.println("Book \"" + book.getTitle() + "\" returned by " + user.getName() + ".");
        } else {
            System.out.println(user.getName() + " did not borrow \"" + book.getTitle() + "\".");
        }
    }


}
