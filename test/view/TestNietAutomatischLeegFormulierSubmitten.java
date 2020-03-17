package view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNietAutomatischLeegFormulierSubmitten {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/Demo12_TDDAndValidationExample_war_exploded/add.jsp");
        WebElement button = driver.findElement(By.id("submit"));
        button.click();

        driver.close();
    }


}
