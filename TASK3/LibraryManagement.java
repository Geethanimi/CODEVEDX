package library;

import java.util.Scanner;

public class LibraryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookDAO dao = new BookDAO();

        int choice;

        do {

            System.out.println("\n========= Library Management =========");
            System.out.println("1. Add Book");
            System.out.println("2. View Available Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter Book Title : ");
                String title = sc.nextLine();

                System.out.print("Enter Author Name : ");
                String author = sc.nextLine();

                Book book = new Book(title, author);

                dao.addBook(book);

                break;

            case 2:

                dao.viewAvailableBooks();

                break;

            case 3:

                System.out.print("Enter Book ID : ");
                int issueId = sc.nextInt();

                dao.issueBook(issueId);

                break;

            case 4:

                System.out.print("Enter Book ID : ");
                int returnId = sc.nextInt();

                dao.returnBook(returnId);

                break;

            case 5:

                System.out.println("Thank You!");

                break;

            default:

                System.out.println("Invalid Choice");

            }

        } while (choice != 5);

        sc.close();

    }

}