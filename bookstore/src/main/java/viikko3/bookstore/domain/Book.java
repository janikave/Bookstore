package viikko3.bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;
    private String title;
    private String author;
    private long publicationYear;
    private String isbn;
    private double price;

    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
        this.title = null;
        this.author = null;
        this.publicationYear = 0;
        this.isbn = "";
        this.price = 0;
    }

    public Book(String title, String author, long publicationYear, String isbn, double price, Category category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(long publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book [bookid=" + bookid + ", title=" + title + ", author=" + author + ", publicationYear="
                + publicationYear + ", isbn=" + isbn + ", price=" + price + ", category=" + category + "]";
    }

}
