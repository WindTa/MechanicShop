package mechanic_shop.ui.controllers;

import mechanic_shop.domain.CustomerService;
import mechanic_shop.domain.Result;
import mechanic_shop.models.Customer;
import mechanic_shop.ui.menus.CustomerMenu;
import mechanic_shop.ui.views.View;

public class CustomerController {
    private CustomerService service;
    private View view;

    public CustomerController(CustomerService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void findByLID() {
        view.displayHeader(CustomerMenu.FIND_CUSTOMER_BY_LID.toString());

        String LID = view.readRequiredString("Search by license ID: ");
        Customer customer = service.findByLID(LID);

        if (customer == null) {
            view.displayErr("Customer not found");
            return;
        }

        view.displayCustomer(customer);
    }

    public void add() {
        view.displayHeader(CustomerMenu.CREATE_CUSTOMER.toString());

        Customer customer = view.addCustomer();
        if (customer == null) {
            return;
        }

        Result<Customer> result = service.add(customer);
        view.displayResult(result);

    }

    public void update() {
        System.out.println("update customer");
    }

    public void deleteById() {
        System.out.println("delete customer by id");
    }
}
