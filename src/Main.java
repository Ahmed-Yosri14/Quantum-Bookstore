import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        PaperBook pb = new PaperBook("First PaperBook", 50.0, 2015, "001", "Ahmed", 10);
        inventory.addBook(pb);
        EBook eb = new EBook("First EBook", 30.0, 2020, "002", "Mohamed", "pdf");
        inventory.addBook(eb);
        ShowcaseBook sb = new ShowcaseBook("First Showcase Book", 0.0, 1990, "003", "Mahmoud");
        inventory.addBook(sb);

        Customer customer1 = new Customer("Mostafa", 25, "October", "1234567890", "mostafa@email.com", 100.0);
        Customer customer2 = new Customer("Sherif", 30, "Ramses", "0987654321", "sherif@email.com", 20.0);
        Customer customer3 = new Customer("Hesham", 40, "ElMaady", "5555555555", "hesham@email.com", 30.0);
        Customer customer4 = new Customer("Usama", 22, "Dar El Salam", "4444444444", "usama@email.com", 0.0);

        try {
            double paid = inventory.buyBook("001", customer1, 1);
            System.out.println("Thank you, " + customer1.getName() + "! You have successfully purchased a paper book. Amount paid: " + paid + " EGP. Your new balance: " + customer1.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("001", customer2, 1);
            System.out.println("Thank you, " + customer2.getName() + "! You have successfully purchased a paper book. Amount paid: " + paid + " EGP. Your new balance: " + customer2.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("001", customer1, 2);
            System.out.println("Thank you, " + customer1.getName() + "! You have successfully purchased 2 paper books. Amount paid: " + paid + " EGP. Your new balance: " + customer1.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("001", customer1, 100);
            System.out.println("Thank you, " + customer1.getName() + "! You have successfully purchased 100 paper books. Amount paid: " + paid + " EGP. Your new balance: " + customer1.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("001", customer2, 2);
            System.out.println("Thank you, " + customer2.getName() + "! You have successfully purchased 2 paper books. Amount paid: " + paid + " EGP. Your new balance: " + customer2.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("001", customer1, 0);
            System.out.println("Thank you, " + customer1.getName() + "! You have successfully purchased 0 paper books. Amount paid: " + paid + " EGP. Your new balance: " + customer1.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("001", customer1, -1);
            System.out.println("Thank you, " + customer1.getName() + "! You have successfully purchased -1 paper books. Amount paid: " + paid + " EGP. Your new balance: " + customer1.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("002", customer3, 1);
            System.out.println("Thank you, " + customer3.getName() + "! You have successfully purchased an eBook. Amount paid: " + paid + " EGP. Your new balance: " + customer3.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("002", customer3, 2);
            System.out.println("Thank you, " + customer3.getName() + "! You have successfully purchased 2 eBooks. Amount paid: " + paid + " EGP. Your new balance: " + customer3.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("002", customer4, 1);
            System.out.println("Thank you, " + customer4.getName() + "! You have successfully purchased an eBook. Amount paid: " + paid + " EGP. Your new balance: " + customer4.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            double paid = inventory.buyBook("003", customer1, 1);
            System.out.println("Thank you, " + customer1.getName() + "! You have successfully purchased a showcase book. Amount paid: " + paid + " EGP. Your new balance: " + customer1.getBalance() + " EGP.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}