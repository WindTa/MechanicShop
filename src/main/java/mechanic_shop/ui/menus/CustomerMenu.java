package mechanic_shop.ui.menus;

public enum CustomerMenu {
    RETURN_TO_MAIN_MENU("Return to main menu"),
    FIND_CUSTOMER_BY_LID("Find customer by license ID"),
    CREATE_CUSTOMER("Create customer"),
    EDIT_CUSTOMER("Edit customer"),
    DELETE_CUSTOMER("Delete customer");

    private String message;

    private CustomerMenu(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
