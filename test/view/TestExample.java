package view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestExample {

    private WebDriver driver;

    @Test
    public void testAddingName() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        driver = new ChromeDriver();
        String url = "http://localhost:8080/Demo12_TDDAndValidationExample_war_exploded/";
        driver.get(url+"add.jsp");

        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Max");

        driver.findElement(By.id("submit")).click();

        assertEquals("Voeg een huisdier toe", driver.getTitle());
        ArrayList<WebElement> lis =
                (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Vul een soort in."));
        assertEquals("Voeg een huisdier toe", driver.getTitle());
        assertEquals("Voeg je huisdier toe", driver.findElement(By.tagName("h2")).getText());
        driver.quit();
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
