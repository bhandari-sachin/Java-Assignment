package system;

import model.Book;
import model.LibraryMember;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private final List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added book: " + book);
    }

    public void addMember(LibraryMember member) {
        members.add(member);
        System.out.println("Added member: " + member);
    }

    public void borrowBook(LibraryMember member, Book book) {
        // Book can be borrowed if it's NOT borrowed and NOT reserved
        if (!book.isBorrowed() && !book.isReserved()) {
            book.setBorrowed(true);
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        }
        // Book can also be borrowed if it's reserved by the same member
        else if (book.isReserved() && member.hasReservedBook(book)) {
            book.setBorrowed(true);
            book.setReserved(false); // Clear reservation when borrowed
            member.removeReservedBook(book); // Remove from reserved list
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle() + " (from reservation)");
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is unavailable.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setBorrowed(false);
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println(member.getName() + " doesn't have this book.");
        }
    }

    // Reservation methods
    public void reserveBook(LibraryMember member, Book book) {
        // Book can be reserved if it's borrowed (by someone else) and not already reserved
        if (book.isBorrowed() && !book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println(member.getName() + " reserved " + book.getTitle());
        }
        // Cannot reserve a book that's available (should borrow instead)
        else if (!book.isBorrowed()) {
            System.out.println("Sorry, " + book.getTitle() + " is available for borrowing. No need to reserve.");
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is already reserved.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println(member.getName() + " canceled reservation for " + book.getTitle());
        } else {
            System.out.println("Reservation not found for " + book.getTitle());
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("\nReserved books for " + member.getName() + ":");
        List<Book> reservedBooks = member.getReservedBooks();
        if (reservedBooks.isEmpty()) {
            System.out.println("No reserved books.");
        } else {
            for (Book book : reservedBooks) {
                System.out.println(book);
            }
        }
    }

    // Utility methods
    public void showAllBooks() {
        System.out.println("\nLibrary Books:");
        if (books.isEmpty()) {
            System.out.println("No books in library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void showAllMembers() {
        System.out.println("\nLibrary Members:");
        if (members.isEmpty()) {
            System.out.println("No members registered.");
        } else {
            for (LibraryMember member : members) {
                System.out.println(member);
            }
        }
    }
}