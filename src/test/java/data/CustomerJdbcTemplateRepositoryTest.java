package data;

import mechanic_shop.data.CustomerJdbcTemplateRepository;
import mechanic_shop.DataHelper;
import mechanic_shop.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CustomerJdbcTemplateRepositoryTest {
    JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
    CustomerJdbcTemplateRepository repository = new CustomerJdbcTemplateRepository(jdbcTemplate);

    @BeforeEach
    void setup() {
        jdbcTemplate.execute("call set_known_good_state();");
    }

    @Test
    void shouldFindByLID() {
        Customer expected = new Customer(1, "Y111111", "Customer1", 26, "111-111-1111", "Customer1@gmail.com");
        Customer actual = repository.findByLID("Y111111");

        assertNotNull(actual);
        assertEquals(expected, actual);
    }

}