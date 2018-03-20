package mytranslator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for spring boot
 * 
 * @author pborsoni
 *
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("Starting server!");
		SpringApplication.run(App.class, args);
	}
}
