



import java.util.*;

public class Library {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, Member> members = new HashMap<>();
    private Queue<String> requests = new LinkedList<>();
    private ArrayList<Book> bookList = new ArrayList<>();
    private UndoRedoManager history = new UndoRedoManager();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        bookList.add(book);
        history.record("Added book: " + book);
    }

    public void removeBook(String id) {
        if (books.containsKey(id)) {
            Book removed = books.remove(id);
            bookList.remove(removed);
            history.record("Removed book: " + removed);
        }
    }

    public void registerMember(Member member) {
        members.put(member.getId(), member);
        history.record("Registered member: " + member);
    }

    public void removeMember(String id) {
        if (members.containsKey(id)) {
            Member removed = members.remove(id);
            history.record("Removed member: " + removed);
        }
    }

    public void borrowBook(String bookId, String memberId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            history.record("Book borrowed: " + book + " by " + members.get(memberId));
        } else {
            requests.add(bookId);
            history.record("Book requested (unavailable): " + bookId);
        }
    }

    public void returnBook(String bookId) {
        Book book = books.get(bookId);
        if (book != null) {
            book.setAvailable(true);
            history.record("Book returned: " + book);
        }
    }

    public List<Book> searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public void generateReport() {
        System.out.println("Library Report:");
        System.out.println("Books:");
        for (Book book : bookList) {
            System.out.println(" - " + book + " | Available: " + book.isAvailable());
        }
        System.out.println("Members:");
        for (Member member : members.values()) {
            System.out.println(" - " + member);
        }
        System.out.println("Pending Requests: " + requests);
    }

    public void undo() {
        System.out.println(history.undo());
    }

    public void redo() {
        System.out.println(history.redo());
    }
}
