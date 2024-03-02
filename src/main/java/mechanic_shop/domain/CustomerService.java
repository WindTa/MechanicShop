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
}
