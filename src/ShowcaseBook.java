public class ShowcaseBook extends Book {
    public ShowcaseBook(String title, double price, int yearOfPublication, String ISBN, String author) {
        super(title, price, yearOfPublication, ISBN, author);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void deliver(Customer customer) {
        throw new IllegalStateException("This book is for display only and cannot be purchased. Please check our other available books!");
    }

    @Override
    public double purchase(Customer customer) {
        throw new IllegalStateException("This book is for display only and cannot be purchased. Please check our other available books!");
    }
}
