public class ShippingService {
    private static final ShippingService instance = new ShippingService();
    private ShippingService() {}
    public static ShippingService getInstance() {
        return instance;
    }
    void send(Book book, String address) {
        System.out.println("Shipping Book with ISBN : " + book.getIsbn() +  " to address : " + address);
    }
}
