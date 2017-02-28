package demo;

/**
 * Created by sanre on 2/28/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("santosh", "yarava"));
        repository.save(new Customer("Navateja", "Munnaluri"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('santosh'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("santosh"));

        System.out.println("Customers found with findByLastName('Munnaluri'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Munnaluri")) {
            System.out.println(customer);
        }

    }

}