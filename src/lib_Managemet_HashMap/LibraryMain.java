package lib_Managemet_HashMap;

import java.util.Scanner;

public class LibraryMain {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search by ID");
            System.out.println("4. Search by Author");
            System.out.println("5. Update Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Sort by ID");
            System.out.println("8. Sort by Title");
            System.out.println("9. Sort by Price");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {
                case 1: service.addBook(); break;
                case 2: service.displayAllBooks(); break;
                case 3: service.searchById(); break;
                case 4: service.searchByAuthor(); break;
                case 5: service.updateBook(); break;
                case 6: service.deleteBook(); break;
                case 7: service.sortById(); break;
                case 8: service.sortByTitle(); break;
                case 9: service.sortByPrice(); break;
                case 10: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
