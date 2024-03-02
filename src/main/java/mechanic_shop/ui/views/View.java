package mechanic_shop.ui.views;

import mechanic_shop.domain.Result;
import mechanic_shop.models.Customer;
import mechanic_shop.ui.ConsoleIO;
import mechanic_shop.ui.menus.CustomerMenu;
import mechanic_shop.ui.menus.MainMenu;
import mechanic_shop.ui.menus.MechanicMenu;

public class View {
    private final ConsoleIO io;

    public View(ConsoleIO io) {
        this.io = io;
    }

    public int selectOption(Enum<?>[] MenuOptions) {
        for (int i = 0; i < MenuOptions.length; i++) {
            io.printf("%s. %s%n", i, MenuOptions[i]);
        }

        String msg = String.format("Select [0-%s]: ", MenuOptions.length - 1);
        int index = io.readInt(msg, 0, MenuOptions.length - 1);
        io.println();
        return index;
    }

    public MainMenu selectMainMenuOption() {
        displayHeader("Main Menu");
        MainMenu[] values = MainMenu.values();
        return values[selectOption(MainMenu.values())];
    }

    public CustomerMenu selectCustomerMenuOption() {
        displayHeader("Customer Menu");
        CustomerMenu[] values = CustomerMenu.values();
        return values[selectOption(CustomerMenu.values())];
    }

    public MechanicMenu selectMechanicMenuOption() {
        displayHeader("Mechanic Menu");
        MechanicMenu[] values = MechanicMenu.values();
        return values[selectOption(MechanicMenu.values())];
    }

    public String readRequiredString(String prompt) {
        return io.readRequiredString(prompt);
    }

    public Customer addCustomer() {
        String licenseId = io.readRequiredString("Driver's License ID: ");
        String name = io.readRequiredString("Name: ");
        int age = io.readInt("Age: ");
        String phone = io.readRequiredString("Phone: ");
        String email = io.readRequiredString("Email: ");

        return new Customer(0, licenseId, name, age, phone, email);
    }

    public void displayHeader(String message) {
        io.println("");
        io.println(message);
        io.println("=".repeat(message.length()));
    }

    public void displayCustomer(Customer customer) {
        io.printf("%s: %s | Name: %s | Age: %d | Phone: %s | Email: %s\n",
                customer.getCustomerId(), customer.getLicenseId(),
                customer.getName(), customer.getAge(),
                customer.getPhone(), customer.getEmail());
    }

    public void displayResult(Result<?> result) {
        if (result.isSuccess()) {
            io.println("Success!");
        } else {
            io.println("Err:");
            for (String message : result.getErrorMessages()) {
                io.println(message);
            }
        }
    }

    public void displayErr(String err) {
        io.printf("Err: %s%n", err);
    }

    public void displayException(Exception ex) {
        displayHeader("A critical error occurred:");
        io.println(ex.getMessage());
    }
}
