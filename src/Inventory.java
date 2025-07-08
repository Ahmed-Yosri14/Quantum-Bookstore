import java.time.Year;
import java.util.*;

public class Inventory {
    private Map<String,Book> books =  new HashMap<>();
    public void addBook(Book book) {
        Book existing = books.get(book.getIsbn());

        if (existing != null && existing instanceof PaperBook && book instanceof PaperBook) {
            PaperBook existingPaper = (PaperBook) existing;
            PaperBook newPaper = (PaperBook) book;
            existingPaper.addStock(newPaper.getStock());
            System.out.println("Stock updated: More copies of the paper book with ISBN " + book.getIsbn() + " are now available.");
        }
        else if (existing != null) {
            books.put(book.getIsbn(), book);
            System.out.println("A book with ISBN " + book.getIsbn() + " was already in our collection. Details have been updated.");
        }
        else{
            books.put(book.getIsbn(), book);
            System.out.println("Book added successfully! ISBN: " + book.getIsbn());
        }

    }

    public Book removeBook(String isbn) {
        return books.remove(isbn);
    }

    public List<Book> removeOutdatedBooks(int maxYearsOld) {
        int currentYear = Year.now().getValue();
        List<Book> removed = new ArrayList<>();
        for (Iterator<Book> it = books.values().iterator(); it.hasNext(); ) {
            Book book = it.next();
            if (currentYear - book.getYearOfPublication() > maxYearsOld) {
                removed.add(book);
                it.remove();
            }
        }
        return removed;
    }

    public double buyBook(String isbn, Customer customer, int quantity) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalStateException("Book not available.");
        }
        return book.purchase(customer, quantity);
    }
}
