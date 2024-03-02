package mechanic_shop.data;

import mechanic_shop.TestData;
import mechanic_shop.data.CustomerRepository;
import mechanic_shop.models.Customer;

public class CustomerRepositoryDouble implements CustomerRepository {

    @Override
    public Customer findByLID(String LID) {
        if (LID.equals("Y333333")) return null;
        return TestData.CUSTOMER1;
    }

    @Override
    public Customer add(Customer customer) {
        if (customer != null) {
            customer.setCustomerId(3);
        }
        return customer;
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
