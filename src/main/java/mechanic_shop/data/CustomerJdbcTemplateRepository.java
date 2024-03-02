package mechanic_shop.data;

import mechanic_shop.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJdbcTemplateRepository implements CustomerRepository {
    private final JdbcTemplate jdbcTemplate;

    public CustomerJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer findByLID(String LID) {
        String sql = """
                select *
                from customer c
                where c.customer_lid = ?;
                """;
        return jdbcTemplate.query(sql, new CustomerMapper(), LID)
                .stream().findFirst().orElse(null);
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
