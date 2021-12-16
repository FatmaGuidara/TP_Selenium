package tp2qualite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.List;

public class Main {
    public static void takeScreenshot(WebDriver webdriver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);

    }
    public static void main (String args[]) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String email ="guidarafatma87@gmail.com";
        String password = "Tymip!u3uXH+S+.";
        String productName = "PC portable MacBook M1 13.3";

        driver.get("https://www.tunisianet.com.tn/");
        Thread.sleep(2000);
        WebElement userIcon = driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg"));
        userIcon.click();

        Thread.sleep(2000);
        WebElement connexion = driver.findElement(By.cssSelector(".user-down > li > a > span"));
        connexion.click();

        Thread.sleep(500);
        WebElement userEmail = driver.findElement(By.name("email"));
        userEmail.sendKeys(email);
        Thread.sleep(500);
        WebElement userPassword = driver.findElement(By.name("password"));
        userPassword.sendKeys(password);

        Thread.sleep(2000);
        WebElement buttonConnexion = driver.findElement(By.id("submit-login"));
        buttonConnexion.click();

        Thread.sleep(2000);
        WebElement searchName = driver.findElement(By.name("s"));
        searchName.sendKeys(productName);

        Thread.sleep(2000);
        WebElement buttonSearch = driver.findElement(By.cssSelector(".button-search > svg "));
        buttonSearch.click();


        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.className("product-title"));
        products.get(0).click();

        Thread.sleep(2000);
        WebElement addToCartBtn = driver.findElement(By.cssSelector(".add-to-cart"));
        addToCartBtn.click();

        Thread.sleep(2000);
        WebElement commandBtn = driver.findElement(By.cssSelector(".cart-content-btn > a"));
        commandBtn.click();

        Thread.sleep(3500);
        takeScreenshot(driver, "D:\\GL4\\2021-2022\\Qualite\\TP\\TP2 - Selenium\\Screenshots\\screenshot.png");
        Thread.sleep(2000);

        driver.quit();
    }
}
