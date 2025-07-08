public class MailService {
    private static final MailService instance = new MailService();
    private MailService() {}
    public static MailService getInstance() {
        return instance;
    }
    void send(Book book, String email) {
        System.out.println("Sending Book with ISBN : " + book.getIsbn() +  " to email address : " + email);
    }
}
