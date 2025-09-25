package library_system;

import java.util.ArrayList;

public class Book {

    private final String title;
    private final String author;
    private final int publicationYear;

    // Task 4: New attributes
    private double rating;
    private final ArrayList<String> reviews;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0.0;
        this.reviews = new ArrayList<>();

    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // Task 4: Set the rating of the book //
    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        }
        else {
            System.out.println("Invalid rating. Please enter a value between 0.0 and 5.0");
        }
    }
    // Task 4: Add a review
    public void addReview(String review) {
        this.reviews.add(review);
    }

    // Task 5: Getters for rating and reviews
    public double getRating() {return rating;}
    public ArrayList<String> getReviews() {return reviews;}

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear;
    }

}
