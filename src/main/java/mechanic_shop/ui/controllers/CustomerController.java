package mechanic_shop.ui.controllers;

import mechanic_shop.domain.CustomerService;
import mechanic_shop.models.Customer;
import mechanic_shop.ui.views.View;

public class CustomerController {
    private CustomerService service;
    private View view;

    public CustomerController(CustomerService service, View view) {
        this.service = service;
        this.view = view;
    }

    public void findByLID() {
        String LID = view.readRequiredString("Search by license ID: ");
        Customer customer = service.findByLID(LID);

        if (customer == null) {
            view.displayErr("Customer not found");
            return;
        }

        view.displayCustomer(customer);
    }

    public void add() {
        System.out.println("add customer");
    }

    public void update() {
        System.out.println("update customer");
    }

    public void deleteById() {
        System.out.println("delete customer by id");
    }
}
