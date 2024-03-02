package mechanic_shop;

import mechanic_shop.data.CustomerJdbcTemplateRepository;
import mechanic_shop.data.CustomerRepository;
import mechanic_shop.domain.CustomerService;
import mechanic_shop.ui.ConsoleIO;
import mechanic_shop.ui.controllers.CustomerController;
import mechanic_shop.ui.controllers.FrontController;
import mechanic_shop.ui.controllers.MechanicController;
import mechanic_shop.ui.views.View;
import org.springframework.jdbc.core.JdbcTemplate;

public class App {
    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = DataHelper.getJdbcTemplate();
        ConsoleIO io = new ConsoleIO();
        View view = new View(io);

        CustomerJdbcTemplateRepository customerRepository = new CustomerJdbcTemplateRepository(jdbcTemplate);
        CustomerService customerService = new CustomerService(customerRepository);
        CustomerController customerController = new CustomerController(customerService, view);

        MechanicController mechanicController = new MechanicController();

        FrontController frontController = new FrontController(view, customerController, mechanicController);
        frontController.run();
    }
}
