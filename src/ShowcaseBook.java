public class ShowcaseBook extends Book {
    public ShowcaseBook(String title, double price, int yearOfPublication, String ISBN, String author) {
        super(title, price, yearOfPublication, ISBN, author);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void deliver() {

    }
}
