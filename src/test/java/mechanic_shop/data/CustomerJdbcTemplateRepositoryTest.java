package mechanic_shop.data;

import mechanic_shop.TestData;
import mechanic_shop.data.CustomerJdbcTemplateRepository;
import mechanic_shop.DataHelper;
import mechanic_shop.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerJdbcTemplateRepositoryTest {
    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    CustomerJdbcTemplateRepository repository = new CustomerJdbcTemplateRepository(jdbcTemplate);

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindByLID() {
        Customer expected = TestData.CUSTOMER1;
        Customer actual = repository.findByLID("Y111111");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAdd() {
        Customer newCustomer = TestData.NEW_CUSTOMER;
        Customer actual = repository.add(newCustomer);

        assertNotNull(actual);
        assertEquals(newCustomer.getLicenseId(), actual.getLicenseId());
    }

}