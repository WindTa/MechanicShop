package ui.controllers;

import ui.menus.CustomerMenu;
import ui.menus.MainMenu;
import ui.menus.MechanicMenu;
import ui.views.View;

public class Controller {
    private final View view;

    public Controller(View view) {
        this.view = view;
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
                case FIND_CUSTOMER_BY_ID -> System.out.println("find customer by id");
                case CREATE_CUSTOMER -> System.out.println("create customer");
                case EDIT_CUSTOMER -> System.out.println("edit customer");
                case DELETE_CUSTOMER -> System.out.println("delete customer");
            }
        } while (option != CustomerMenu.RETURN_TO_MAIN_MENU);
    }

    private void runMechanicMenu() {
        MechanicMenu option;
        do {
            option = view.selectMechanicMenuOption();
            switch(option) {
                case FIND_MECHANIC_BY_ID -> System.out.println("find mechanic by id");
                case CREATE_MECHANIC -> System.out.println("create mechanic");
                case EDIT_MECHANIC -> System.out.println("edit mechanic");
                case DELETE_MECHANIC -> System.out.println("delete mechanic");
            }
        } while (option != MechanicMenu.RETURN_TO_MAIN_MENU);
    }

}
