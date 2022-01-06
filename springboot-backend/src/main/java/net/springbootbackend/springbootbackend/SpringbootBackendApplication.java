package net.springbootbackend.springbootbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.springbootbackend.springbootbackend.repository.EmployeeRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner{

	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void run(String... args) throws Exception{
		// Employee employee1=new Employee();
		// employee1.setFirstName("Jagmeet");
		// employee1.setLastName("Singh");
		// employee1.setEmailId("jagmeet@gmail.com");
		// employeeRepository.save(employee1);

		// Employee employee2=new Employee();
		// employee2.setFirstName("Amrit");
		// employee2.setLastName("Kaur");
		// employee2.setEmailId("amrit@gmail.com");
		// employeeRepository.save(employee2);

	}

}
