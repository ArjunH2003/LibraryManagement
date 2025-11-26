package lib_Managemet_HashMap;


public class Book implements Comparable<Book> {
    private int bookId;
    private String title;
    private String author;
    private double price;

    public Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Getters & Setters
    public int getBookId() { return bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public int compareTo(Book o) {
        return Integer.compare(this.bookId, o.bookId); // Default sorting by ID
    }

    @Override
    public String toString() {
        return bookId + " - " + title + " - " + author + " - $" + price;
    }
}
