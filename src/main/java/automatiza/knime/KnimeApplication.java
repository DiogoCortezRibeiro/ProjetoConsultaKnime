package automatiza.knime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KnimeApplication {
	public static void main(String[] args) {
		SpringApplication.run(KnimeApplication.class, args);
	}
}