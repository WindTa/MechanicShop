package mechanic_shop.domain;

import mechanic_shop.TestData;
import mechanic_shop.data.CustomerRepository;
import mechanic_shop.data.CustomerRepositoryDouble;
import mechanic_shop.models.Customer;
import org.junit.jupiter.api.Test;

import static mechanic_shop.TestHelper.makeResult;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerServiceTest {

    CustomerRepository repository = new CustomerRepositoryDouble();
    CustomerService service = new CustomerService(repository);

    @Test
    void shouldAdd() {
        Customer customer = TestData.NEW_CUSTOMER;
        Result<Customer> actual = service.add(customer);

        customer.setCustomerId(3);
        Result<Customer> expected = makeResult(null, customer);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddWhenNull() {
        // Null customer
        Customer customer = null;
        Result<Customer> expected = makeResult("No customer to save.", null);
        Result<Customer> actual = service.add(customer);
        assertEquals(expected, actual);

        // Null license id
        customer = new Customer();
        expected = makeResult("License ID is required", null);
        actual = service.add(customer);
        assertEquals(expected, actual);

        // Null name
        customer.setLicenseId("Y333333");
        expected = makeResult("Name is required", null);
        actual = service.add(customer);
        assertEquals(expected, actual);

        // Null phone
        customer.setName("Customer3");
        expected = makeResult("Phone ID is required", null);
        actual = service.add(customer);
        assertEquals(expected, actual);

        // Null email
        customer.setPhone("111-111-1111");
        expected = makeResult("Email is required", null);
        actual = service.add(customer);
        assertEquals(expected, actual);

    }

    @Test
    void shouldNotAddWhenSetForUpdate() {
        Customer customer = TestData.NEW_CUSTOMER;
        customer.setCustomerId(1);

        Result<Customer> expected = makeResult("Customer ID cannot be set for `add` operation", null);
        Result<Customer> actual = service.add(customer);
        assertEquals(expected, actual);
    }

    @Test
    void shouldNotAddDuplicate() {
        Customer customer = TestData.CUSTOMER1;

        Result<Customer> expected = makeResult("Customer License ID %s already in use.", null);
        Result<Customer> actual = service.add(customer);
        assertEquals(expected, actual);
    }
}