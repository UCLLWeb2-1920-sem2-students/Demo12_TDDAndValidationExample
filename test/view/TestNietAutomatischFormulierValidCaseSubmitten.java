package view;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNietAutomatischFormulierValidCaseSubmitten {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/Demo12_TDDAndValidationExample_war_exploded/add.jsp");

        WebElement naam = driver.findElement(By.id("naam"));
        naam.clear();
        naam.sendKeys("Mia");

        WebElement soort = driver.findElement(By.id("soort"));
        soort.clear();
        soort.sendKeys("kat");

        WebElement voedsel = driver.findElement(By.id("voedsel"));
        voedsel.clear();
        voedsel.sendKeys("7");

        WebElement button = driver.findElement(By.id("submit"));
        button.click();
    }
}
