public class EBook extends Book {

    public EBook(String title, double price, int yearOfPublication, String ISBN, String author) {
        super(title, price, yearOfPublication, ISBN, author);
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void deliver() {
        //MAIL Service
    }
}
