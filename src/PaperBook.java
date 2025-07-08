public class PaperBook extends Book{
    int stock=0;

    public PaperBook(String title, double price, int yearOfPublication, String ISBN, String author) {
        super(title, price, yearOfPublication, ISBN, author);
    }

    @Override
    public boolean isAvailable() {
        return stock>0;
    }

    @Override
    public void deliver() {
        //Shipping Service
    }
}
