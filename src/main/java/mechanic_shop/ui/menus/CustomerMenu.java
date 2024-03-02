package mechanic_shop.ui.menus;

public enum CustomerMenu {
    RETURN_TO_MAIN_MENU("Return to Home"),
    FIND_CUSTOMER_BY_LID("Find Customer by License ID"),
    CREATE_CUSTOMER("Create Customer"),
    EDIT_CUSTOMER("Edit Customer"),
    DELETE_CUSTOMER("Delete Customer");

    private String message;

    private CustomerMenu(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
