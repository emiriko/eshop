package cs.ui.ac.id.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @LocalServerPort
    private int serverPort;

    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String subDirectory = "/product/create";
    private String baseUrl;


    @BeforeEach
    void setupTest(){
        baseUrl = String.format("%s:%d%s", testBaseUrl, serverPort, subDirectory);
        System.out.println(baseUrl);
    }

    @Test
    void createProduct_Success(EdgeDriver driver) {
        driver.get(baseUrl);
        WebElement nameInput = driver.findElement(By.name("productName"));

        String name="Alvaro";
        nameInput.sendKeys(name);

        WebElement quantityInput = driver.findElement(By.name("productQuantity"));

        String quantity = "40";
        quantityInput.sendKeys(quantity);

        WebElement submit = driver.findElement(By.tagName("button"));
        submit.click();

        List<WebElement> tdElements = driver.findElements(By.tagName("td"));

        WebElement nameElement = tdElements.getFirst();
        WebElement quantityElement = tdElements.getLast();

        assertEquals("Alvaro", nameElement.getText());
        assertEquals("40", quantityElement.getText());
    }
}
