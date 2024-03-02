package data;

import mechanic_shop.data.CustomerRepository;
import mechanic_shop.models.Customer;

public class CustomerRepositoryDouble implements CustomerRepository {

    @Override
    public Customer findByLID(String LID) {
        return new Customer(1, "Y111111", "Customer1", 26, "111-111-1111", "Customer1@gmail.com");
    }

    @Override
    public Customer add(Customer customer) {
        return null;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteByLID(String LID) {
        return false;
    }
}
