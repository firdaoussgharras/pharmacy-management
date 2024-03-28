package fr.sup.galilee.pharmacy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBoot.webEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-IT.properties")
class PharmacyManagmentApplicationTests {
	@LocalServlet
	@Test
	void contextLoads() {
	}

}
