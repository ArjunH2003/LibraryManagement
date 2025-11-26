package lib_Managemet_HashMap;


import java.util.*;

public class LibraryService {

    private HashMap<Integer, Book> bookMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    // Add Book
    public void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        if(bookMap.containsKey(id)) {
            System.out.println("Book already exists!");
            return;
        }
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Price: ");
        double price = sc.nextDouble();
        bookMap.put(id, new Book(id, title, author, price));
        System.out.println("Book added successfully!");
    }

    // Display All Books
    public void displayAllBooks() {
        if(bookMap.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for(Map.Entry<Integer, Book> entry : bookMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    // Search by ID
    public void searchById() {
        System.out.print("Enter Book ID to search: ");
        int id = sc.nextInt();
        Book b = bookMap.get(id);
        if(b != null) System.out.println(b);
        else System.out.println("Book not found!");
    }

    // Search by Author
    public void searchByAuthor() {
        System.out.print("Enter Author name: ");
        sc.nextLine();
        String author = sc.nextLine();
        boolean found = false;
        for(Book b : bookMap.values()) {
            if(b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                found = true;
            }
        }
        if(!found) System.out.println("No books found for this author.");
    }

    // Update Book
    public void updateBook() {
        System.out.print("Enter Book ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        Book b = bookMap.get(id);
        if(b == null) {
            System.out.println("Book not found!");
            return;
        }
        System.out.print("Enter new Title: ");
        String title = sc.nextLine();
        System.out.print("Enter new Author: ");
        String author = sc.nextLine();
        System.out.print("Enter new Price: ");
        double price = sc.nextDouble();
        b.setTitle(title);
        b.setAuthor(author);
        b.setPrice(price);
        System.out.println("Book updated successfully!");
    }

    // Delete Book
    public void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        int id = sc.nextInt();
        if(bookMap.remove(id) != null)
            System.out.println("Book deleted successfully!");
        else
            System.out.println("Book not found!");
    }

    // Sort by ID (Comparable)
    public void sortById() {
        List<Book> list = new ArrayList<>(bookMap.values());
        Collections.sort(list);
        for(Book b : list) System.out.println(b);
    }

    // Sort by Title (Comparator)
    public void sortByTitle() {
        List<Book> list = new ArrayList<>(bookMap.values());
        Collections.sort(list, new TitleComparator());
        for(Book b : list) System.out.println(b);
    }

    // Sort by Price (Comparator)
    public void sortByPrice() {
        List<Book> list = new ArrayList<>(bookMap.values());
        Collections.sort(list, new PriceComparator());
        for(Book b : list) System.out.println(b);
    }
}
