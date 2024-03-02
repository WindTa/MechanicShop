package mechanic_shop.data;

import mechanic_shop.models.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;

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
        final String sql = """
                insert into 
                customer (customer_lid, `name`, age, phone, email) 
                values (?, ?, ?, ?, ?);
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getLicenseId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getEmail());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        customer.setCustomerId(keyHolder.getKey().intValue());
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
