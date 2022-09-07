package lucrare.dizertatie.administrativ;

import lucrare.dizertatie.common.exception.MessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
@EnableDiscoveryClient
public class AdministrativApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministrativApplication.class, args);
//		receiveEvents();
	}

	private static void receiveEvents(){
		URI uri;
		try {
			uri = new URI("http://localhost:3333/simulator/subscribe");
			var client = HttpClient.newHttpClient();
			var request = HttpRequest.newBuilder(uri).GET().build();
			var lines = client.send(request, HttpResponse.BodyHandlers.ofLines()).body();
			lines.forEach(System.out::println);
		} catch (URISyntaxException | IOException | InterruptedException e) {
			e.printStackTrace();
			throw new MessagingException("Failed to receive event", e);
		}

	}

}
