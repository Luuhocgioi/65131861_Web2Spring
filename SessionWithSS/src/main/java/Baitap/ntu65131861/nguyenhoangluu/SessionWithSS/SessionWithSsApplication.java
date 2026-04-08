package Baitap.ntu65131861.nguyenhoangluu.SessionWithSS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SessionWithSsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionWithSsApplication.class, args);
	}

}
