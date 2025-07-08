public class EBook extends Book {
    private String filetype;

    public EBook(String title, double price, int yearOfPublication, String ISBN, String author, String filetype) {
        super(title, price, yearOfPublication, ISBN, author);
        this.filetype = filetype;
    }

    public String getFiletype() {
        return filetype;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void deliver(Customer customer) {
        MailService.getInstance().send(this, customer.getEmail());
        System.out.println("Your eBook (type: " + filetype + ") has been sent to " + customer.getEmail() + ". Enjoy your reading!");
    }

    @Override
    public double purchase(Customer customer, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        double totalPrice = getPrice() * quantity;
        if (customer.getBalance() < totalPrice) {
            throw new IllegalStateException("Unfortunately, you do not have enough balance to complete this purchase.");
        }
        customer.setBalance(customer.getBalance() - totalPrice);
        for (int i = 0; i < quantity; i++) {
            deliver(customer);
        }
        return totalPrice;
    }
}
