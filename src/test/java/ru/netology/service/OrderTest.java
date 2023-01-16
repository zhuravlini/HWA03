package ru.netology.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {
    private WebDriver driver;


    @BeforeAll
    static void setUpAll() {
// убедитесь, что файл chromedriver.exe расположен именно в каталоге C:\tmp
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--headless");
//        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

//        @Test
//    void shouldTestSomething() {
//        throw new UnsupportedOperationException();
//    }

    @Test
    public void shouldTest() throws InterruptedException {


        driver.get("http://localhost:9999/");
        List<WebElement> Inputs = driver.findElements(By.tagName("Input"));
        Inputs.get(0).sendKeys("Иванов Иван");
        Inputs.get(1).sendKeys("+79854443322");

//        driver.findElement("by.").sendKeys("Иванов Иван");
//        driver.findElement("phone").sendKeys("+79854443322");

        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("Success_successBlock__2L3Cw")).getText();
        assertEquals(expected, actual);
    }
}