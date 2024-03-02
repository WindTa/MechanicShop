package mechanic_shop.data;

import mechanic_shop.models.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(rs.getInt("customer_id"));
        customer.setLicenseId(rs.getString("customer_lid"));
        customer.setName(rs.getString("name"));
        customer.setAge(rs.getInt("age"));
        customer.setPhone(rs.getString("phone"));
        customer.setEmail(rs.getString("email"));

        return customer;
    }
}
