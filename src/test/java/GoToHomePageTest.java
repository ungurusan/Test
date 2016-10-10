import Selectors.Dashboard;
import Selectors.Index;
import Selectors.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by Alin on 10/5/2016.
 */
public class GoToHomePageTest {

    @Test
    public void goToHomePageTest(){

        WebDriver driver = new FirefoxDriver();
        WebDriverWait delay = new WebDriverWait(driver, 5);

        driver.navigate().to(Constants.LoginPage.loginPage);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.LoginPage.username)));
        Assert.assertTrue("Title should be Archive2Azure", driver.getTitle().contains("Archive2Azure"));

        driver.findElement(By.cssSelector(LoginPage.username)).sendKeys(Constants.LoginPage.loginUsername);
        driver.findElement(By.cssSelector(LoginPage.password)).sendKeys(Constants.LoginPage.loginPassword);
        driver.findElement(By.cssSelector(LoginPage.loginButton)).click();

        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        Assert.assertTrue("Dashboard link should be present", driver.findElement((By.cssSelector(Dashboard.dashboardSelector))).isDisplayed());

        WebElement myElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Index.indexSelector)));
        driver.findElement(By.xpath(Index.indexSelector)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Index.indexTitle)));
        Assert.assertTrue("Index page title should be present", driver.findElement(By.xpath(Index.indexTitle)).isDisplayed());

        driver.findElement(By.xpath(Dashboard.homepageButton)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.dashboardTitle)));
        Assert.assertTrue("Index page title should be present", driver.findElement(By.xpath(Dashboard.dashboardTitle)).isDisplayed());

        driver.close();
        driver.quit();


    }

}
