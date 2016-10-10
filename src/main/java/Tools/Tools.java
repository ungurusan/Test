package Tools;

import Constants.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by A2AzureAdmin on 6/27/2016.
 */
public class Tools {

    public static void Login(String LoginUserName, String LoginPassword) {

        final WebDriver driver = new FirefoxDriver();
        WebDriverWait delay = new WebDriverWait(driver, 5);
        WebDriverWait delay10 = new WebDriverWait(driver, 10);


        driver.navigate().to(LoginPage.loginPage);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.LoginPage.username)));
        Assert.assertTrue("Title should be Archive2Azure", driver.getTitle().contains("Archive2Azure"));

        driver.findElement(By.cssSelector(Selectors.LoginPage.username)).sendKeys(LoginUserName);
        driver.findElement(By.cssSelector(Selectors.LoginPage.password)).sendKeys(LoginPassword);
        driver.findElement(By.cssSelector(Selectors.LoginPage.loginButton)).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue("Dashboard link should be present", driver.findElement((By.cssSelector("a[href*=dashboard]"))).isDisplayed());


    }
    public static String generateXPATH(WebElement childElement, String current) {
        String childTag = childElement.getTagName();
        if(childTag.equals("html")) {
            return "/html[1]"+current;
        }
        WebElement parentElement = childElement.findElement(By.xpath(".."));
        List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
        int count = 0;
        for(int i=0;i<childrenElements.size(); i++) {
            WebElement childrenElement = childrenElements.get(i);
            String childrenElementTag = childrenElement.getTagName();
            if(childTag.equals(childrenElementTag)) {
                count++;
            }
            if(childElement.equals(childrenElement)) {
                return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
            }
        }
        return null;
    }
}
