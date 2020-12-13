package org.sid.customerservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;

}
@RepositoryRestResource
interface CustomerRepository extends JpaRepository<Customer,Long> {

}

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerRepository.save(new Customer(null,"youssef","ucef.stg@gmail.com"));
		customerRepository.save(new Customer(null,"zakaria","zak.stg@gmail.com"));
		customerRepository.save(new Customer(null,"mustafa","must.stg@gmail.com"));
		customerRepository.save(new Customer(null,"hamza","hamz.stg@gmail.com"));

		customerRepository.findAll().forEach(System.out::println);



	}
}
