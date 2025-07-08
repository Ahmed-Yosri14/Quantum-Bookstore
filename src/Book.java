public abstract class Book {
    private String ISBN;
    private String title;
    private int yearOfPublication;
    private double price;
    private String author;
    public Book(String title, double price, int yearOfPublication, String ISBN, String author) {
        this.title = title;
        this.price = price;
        this.yearOfPublication = yearOfPublication;
        this.ISBN = ISBN;
        this.author = author;
    }

    public abstract boolean isAvailable();
    public abstract void deliver(Customer customer);
    public abstract double purchase(Customer customer, int quantity);
    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public String getIsbn() {
        return ISBN;
    }
    public double getPrice() {
        return price;
    }
}
