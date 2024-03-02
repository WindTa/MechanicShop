package mechanic_shop.ui.controllers;

import mechanic_shop.ui.menus.CustomerMenu;
import mechanic_shop.ui.menus.MainMenu;
import mechanic_shop.ui.menus.MechanicMenu;
import mechanic_shop.ui.views.View;

public class FrontController {
    private final View view;
    private final CustomerController customerController;
    private final MechanicController mechanicController;

    public FrontController(View view, CustomerController customerController, MechanicController mechanicController) {
        this.view = view;
        this.customerController = customerController;
        this.mechanicController = mechanicController;
    }

    public void run() {
        view.displayHeader("Welcome to the Mechanic Shop!");


        try {
            runAppLoop();
        } catch (Exception ex) {
            view.displayException(ex);
        }

        view.displayHeader("Goodbye!");
    }

    private void runAppLoop() {
        MainMenu option;
        do {
            option = view.selectMainMenuOption();
            switch(option) {
                case CUSTOMER_MENU -> runCustomerMenu();
                case MECHANIC_MENU -> runMechanicMenu();
            }

        } while (option != MainMenu.EXIT);
    }

    private void runCustomerMenu() {
        CustomerMenu option;
        do {
            option = view.selectCustomerMenuOption();
            switch(option) {
                case FIND_CUSTOMER_BY_LID -> customerController.findByLID();
                case CREATE_CUSTOMER -> customerController.add();
                case EDIT_CUSTOMER -> customerController.update();
                case DELETE_CUSTOMER -> customerController.deleteById();
            }
        } while (option != CustomerMenu.RETURN_TO_MAIN_MENU);
    }

    private void runMechanicMenu() {
        MechanicMenu option;
        do {
            option = view.selectMechanicMenuOption();
            switch(option) {
                case FIND_MECHANIC_BY_ID -> mechanicController.findById();
                case CREATE_MECHANIC -> mechanicController.add();
                case EDIT_MECHANIC -> mechanicController.update();
                case DELETE_MECHANIC -> mechanicController.deleteById();
            }
        } while (option != MechanicMenu.RETURN_TO_MAIN_MENU);
    }

}
