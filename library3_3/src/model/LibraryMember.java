package model;

import java.util.ArrayList;
import java.util.List;

public class LibraryMember {
    private static int nextId = 1;

    private final String name; // Should be private and final
    private final int memberId;
    private final List<Book> borrowedBooks;
    private final List<Book> reservedBooks;

    // Constructor that takes name only (auto-generates ID)
    public LibraryMember(String name) {
        this.name = name;
        this.memberId = nextId++;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }

    // Constructor that takes both name and ID (for compatibility with existing tests)
    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();

        // Update nextId to avoid conflicts if this constructor is used
        if (memberId >= nextId) {
            nextId = memberId + 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<Book> getBorrowedBooks() {
        // Return a copy to prevent external modification
        return new ArrayList<>(borrowedBooks);
    }

    public void borrowBook(Book book) {
        if (book != null && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Reservation methods
    public void addReservedBook(Book book) {
        if (book != null && !reservedBooks.contains(book)) {
            reservedBooks.add(book);
        }
    }

    public void removeReservedBook(Book book) {
        reservedBooks.remove(book);
    }

    public boolean hasReservedBook(Book book) {
        return reservedBooks.contains(book);
    }

    public List<Book> getReservedBooks() {
        // Return a copy to prevent external modification
        return new ArrayList<>(reservedBooks);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Member: ").append(name).append(" (ID: ").append(memberId).append(")");

        if (!borrowedBooks.isEmpty()) {
            sb.append(" - Borrowed: ").append(borrowedBooks.size()).append(" book(s)");
        }

        if (!reservedBooks.isEmpty()) {
            sb.append(" - Reserved: ").append(reservedBooks.size()).append(" book(s)");
        }

        return sb.toString();
    }
}