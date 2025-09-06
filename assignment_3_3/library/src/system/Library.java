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
        if (!book.isBorrowed()) {
            book.setBorrowed(true);
            member.borrowBook(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Sorry, " + book.getTitle() + " is already borrowed.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setBorrowed(false);
            member.returnBook(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println(member.getName() + " doesn’t have this book.");
        }
    }

    public void showAllBooks() {
        System.out.println("\nLibrary Books:");
        for (Book book : books) {
            System.out.println(book + (book.isBorrowed() ? " (Borrowed)" : " (Available)"));
        }
    }

    public void showAllMembers() {
        System.out.println("\nLibrary Members:");
        for (LibraryMember member : members) {
            System.out.println(member);
        }
    }
}
