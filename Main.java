import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Add Book\n2. Remove Book\n3. Register Member\n4. Remove Member\n5. Borrow Book\n6. Return Book\n7. Search Book\n8. Report\n9. Undo\n10. Redo\n0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch(choice){
                case 1:
                        System.out.print("Enter Book ID, Title, Author: ");
                        library.addBook(new Book(sc.next(), sc.next(), sc.next()));
                        break;
                case 2:
                        System.out.print("Enter Book ID to remove: ");
                        library.removeBook(sc.next());
                        break;
                case 3:
                        System.out.print("Enter Member ID, Name: ");
                        library.registerMember(new Member(sc.next(), sc.next()));
                        break;
                case 4:
                        System.out.print("Enter Member ID to remove: ");
                        library.removeMember(sc.next());
                        break;
                case 5:
                        System.out.print("Enter Book ID and Member ID: ");
                        library.borrowBook(sc.next(), sc.next());
                        break;
                case 6:
                        System.out.print("Enter Book ID to return: ");
                        library.returnBook(sc.next());
                        break;
                case 7:
                        System.out.print("Enter keyword to search: ");
                        for (Book book : library.searchBooks(sc.next())) {
                            System.out.println(book);
                        }
                        break;
                case 8:
                        library.generateReport();
                        break;
                case 9:
                        library.undo();
                        break;
                case 10:
                    library.redo();
                    break;
                case 0:
                    exit = true;
                    break;
            }
        }
        sc.close();
    }
}
