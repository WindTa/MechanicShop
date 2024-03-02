package mechanic_shop.data;

import mechanic_shop.models.Customer;

public interface CustomerRepository {
    Customer findByLID(String LID);
    Customer add(Customer customer);
    boolean update(Customer customer);
    boolean deleteByLID(String LID);
}
