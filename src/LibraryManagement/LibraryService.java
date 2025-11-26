package LibraryManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryService {

    ArrayList<Book> books = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addBook() {
        System.out.println("Enter Book ID:");
        int id = sc.nextInt();

        // duplicate check
        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println("❌ Book with this ID already exists!");
                return;
            }
        }

        System.out.println("Enter Title:");
        String title = sc.next();

        System.out.println("Enter Author:");
        String author = sc.next();

        System.out.println("Enter Price:");
        double price = sc.nextDouble();

        books.add(new Book(id, title, author, price));
        System.out.println("✔ Book Added Successfully!");
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchById(int id) {
        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println("Book Found: " + b);
                return;
            }
        }
        System.out.println("❌ Book ID Not Found!");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found)
            System.out.println("❌ No books by this author!");
    }

    public void updateBook(int id) {
        for (Book b : books) {
            if (b.getBookId() == id) {
                System.out.println("Enter New Title:");
                b.setTitle(sc.next());

                System.out.println("Enter New Author:");
                b.setAuthor(sc.next());

                System.out.println("Enter New Price:");
                b.setPrice(sc.nextDouble());

                System.out.println("✔ Book Updated Successfully!");
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }

    public void deleteBook(int id) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getBookId() == id) {
                it.remove();
                System.out.println("✔ Book Deleted Successfully!");
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }

    public void sortById() {
        Collections.sort(books);
        System.out.println("✔ Sorted by Book ID.");
    }

    public void sortByTitle() {
        Collections.sort(books, new SortByTitle());
        System.out.println("✔ Sorted by Title.");
    }

    public void sortByPrice() {
        Collections.sort(books, new SortByPrice());
        System.out.println("✔ Sorted by Price.");
    }
}
