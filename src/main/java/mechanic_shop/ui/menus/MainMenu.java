package mechanic_shop.ui.menus;

public enum MainMenu {
    EXIT("Exit"),
    CUSTOMER_MENU("Customer Menu"),
    MECHANIC_MENU("Mechanic Menu");

    private String message;

    private MainMenu(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
