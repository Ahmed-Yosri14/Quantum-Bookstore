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
    public double purchase(Customer customer) {
        if (customer.getBalance() < getPrice()) {
            throw new IllegalStateException("Unfortunately, you do not have enough balance to complete this purchase.");
        }
        customer.setBalance(customer.getBalance() - getPrice());
        deliver(customer);
        return getPrice();
    }
}
