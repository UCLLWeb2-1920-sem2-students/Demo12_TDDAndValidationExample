package view;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddDier {

    private WebDriver driver;
    String url = "http://localhost:8080/Demo12_TDDAndValidationExample_war_exploded/";

    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\...\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        driver.get(url + "add.jsp");
    }

    @After
    public void clean() {
        driver.quit();
    }


    @Test
    public void test_Form_is_shown_again_with_error_messages_If_all_fields_are_empty() {
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("");

        WebElement soortInput = driver.findElement(By.id("soort"));
        soortInput.clear();
        soortInput.sendKeys("");

        WebElement voedselInput = driver.findElement(By.id("voedsel"));
        voedselInput.clear();
        voedselInput.sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Voeg een huisdier toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een naam in."));
        assertTrue(containsWebElementsWithText(lis, "Vul een soort in."));
        assertTrue(containsWebElementsWithText(lis, "Vul een nummer in voor voedsel."));
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_name_field_is_left_empty() {
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("");

        WebElement soortInput = driver.findElement(By.id("soort"));
        soortInput.clear();
        soortInput.sendKeys("hond");

        WebElement voedselInput = driver.findElement(By.id("voedsel"));
        voedselInput.clear();
        voedselInput.sendKeys("5");

        driver.findElement(By.id("submit")).click();

        assertEquals("Voeg een huisdier toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een naam in."));
        assertEquals("hond",driver.findElement(By.id("soort")).getAttribute("value"));
        assertEquals("5",driver.findElement(By.id("voedsel")).getAttribute("value"));
    }

    @Test
    public void test_Overview_is_shown_If_all_fields_are_filled_out_correctly() {
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Max");

        WebElement soortInput = driver.findElement(By.id("soort"));
        soortInput.clear();
        soortInput.sendKeys("hond");

        WebElement voedselInput = driver.findElement(By.id("voedsel"));
        voedselInput.clear();
        voedselInput.sendKeys("9");

        driver.findElement(By.id("submit")).click();

        assertEquals("Bekijk alle dieren", driver.getTitle());

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebElementsWithText(tds,"Max"));
    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

}
