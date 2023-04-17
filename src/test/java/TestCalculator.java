import java.net.URI;
import java.net.URISyntaxException;

import com.calculator.ConfigCalculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigCalculator.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestCalculator {

  @LocalServerPort
  int randomServerPort;

  private ResponseEntity<String> calculator(final int firstNumber, final int secondNumber, final String action) throws URISyntaxException {
    final RestTemplate restTemplate = new RestTemplate();

    final String baseUrl = "http://localhost:" + randomServerPort +
        "/calculator/" + action + "?firstNumber=" + firstNumber +
        "&secondNumber=" + secondNumber;
    final URI uri = new URI(baseUrl);

    return restTemplate.getForEntity(uri, String.class);
  }

  @Test
  public void additionOK() throws URISyntaxException {

    final ResponseEntity<String> result = calculator(5, 7, "addition");

    Assert.assertEquals(200, result.getStatusCodeValue());
    Assert.assertEquals("Suma: 5 + 7 = 12", result.getBody());
  }

  @Test
  public void subtractOK() throws URISyntaxException {

    final ResponseEntity<String> result = calculator(5, 7, "subtract");

    Assert.assertEquals(200, result.getStatusCodeValue());
    Assert.assertEquals("Resta: 5 - 7 = -2", result.getBody());
  }

}
