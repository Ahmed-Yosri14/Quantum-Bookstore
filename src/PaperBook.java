public class PaperBook extends Book{
    int stock=0;

    public PaperBook(String title, double price, int yearOfPublication, String ISBN, String author,int stock) {
        super(title, price, yearOfPublication, ISBN, author);
        this.stock=stock;
    }

    @Override
    public boolean isAvailable() {
        return stock>0;
    }

    @Override
    public void deliver(Customer customer) {
        ShippingService.getInstance().send(this, customer.getAddress());
        System.out.println("Your paper book '" + this.getIsbn() + "' is on its way to " + customer.getAddress() + ". Thank you for shopping with us!");
    }

    @Override
    public double purchase(Customer customer, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (stock < quantity) {
            throw new IllegalStateException("Sorry, not enough stock available.");
        }
        double totalPrice = getPrice() * quantity;
        if (customer.getBalance() < totalPrice) {
            throw new IllegalStateException("Unfortunately, you do not have enough balance to complete this purchase.");
        }
        reduceStock(quantity);
        customer.setBalance(customer.getBalance() - totalPrice);
        for (int i = 0; i < quantity; i++) {
            deliver(customer);
        }
        return totalPrice;
    }

    public void addStock(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        stock += quantity;
    }
    public void reduceStock(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        stock -= quantity;
    }

    public int getStock() {
        return stock;
    }

}
