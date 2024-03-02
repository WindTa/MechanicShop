package mechanic_shop.ui.menus;

public enum MechanicMenu {
    RETURN_TO_MAIN_MENU("Return to main menu"),
    FIND_MECHANIC_BY_ID("Find mechanic by license ID"),
    CREATE_MECHANIC("Create mechanic"),
    EDIT_MECHANIC("Edit mechanic"),
    DELETE_MECHANIC("Delete mechanic");

    private String message;

    private MechanicMenu(String message) {
        this.message = message;
    }

    public String toString() {
        return message;
    }
}
