package mechanic_shop.domain;

import mechanic_shop.data.CustomerRepository;
import mechanic_shop.models.Customer;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer findByLID(String LID) {
        return repository.findByLID(LID);
    }

    public Result<Customer> add(Customer customer) {
        Result<Customer> result = validate(customer);
        if (!result.isSuccess()) {
            return result;
        }

        if (customer.getCustomerId() != 0) {
            result.addErrorMessage("Customer ID cannot be set for `add` operation");
            return result;
        }

        customer = repository.add(customer);
        result.setPayload(customer);
        return result;
    }

    public Result<Customer> validate(Customer customer) {
        Result<Customer> result = new Result<>();

        validateNulls(customer, result);
        if (!result.isSuccess()) {
            return result;
        }

        validateFields(customer, result);
        if (!result.isSuccess()) {
            return result;
        }

        return result;
    }

    public void validateNulls(Customer customer, Result<Customer> result) {
        if (customer == null) {
            result.addErrorMessage("No customer to save.");
            return;
        }

        if (customer.getLicenseId() == null) {
            result.addErrorMessage("License ID is required");
            return;
        }

        if (customer.getName() == null) {
            result.addErrorMessage("Name is required");
            return;
        }

        if (customer.getPhone() == null) {
            result.addErrorMessage("Phone ID is required");
            return;
        }

        if (customer.getEmail() == null) {
            result.addErrorMessage("Email is required");
        }
    }

    public void validateFields(Customer customer, Result<Customer> result) {
        if (repository.findByLID(customer.getLicenseId()) != null) {
            result.addErrorMessage("Customer License ID %s already in use.");
        }
    }

}
