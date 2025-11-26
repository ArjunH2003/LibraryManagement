package LibraryManagement;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All");
            System.out.println("3. Search By ID");
            System.out.println("4. Search By Author");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Sort by ID");
            System.out.println("8. Sort by Title");
            System.out.println("9. Sort by Price");
            System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: service.addBook(); break;
                case 2: service.displayAllBooks(); break;
                case 3:
                    System.out.println("Enter Book ID:");
                    service.searchById(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter Author:");
                    service.searchByAuthor(sc.next());
                    break;
                case 5:
                    System.out.println("Enter Book ID to update:");
                    service.updateBook(sc.nextInt());
                    break;
                case 6:
                    System.out.println("Enter Book ID to delete:");
                    service.deleteBook(sc.nextInt());
                    break;
                case 7: service.sortById(); break;
                case 8: service.sortByTitle(); break;
                case 9: service.sortByPrice(); break;
                case 10:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
