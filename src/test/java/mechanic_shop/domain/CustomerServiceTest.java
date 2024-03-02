package mechanic_shop.domain;

import data.CustomerRepositoryDouble;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    CustomerService service = new CustomerService(
            new CustomerRepositoryDouble()
    );


}