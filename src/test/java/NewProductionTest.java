import Selectors.Dashboard;
import Selectors.EDiscovery;
import Selectors.Index;
import Selectors.LoginPage;
import Tools.Tools;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class NewProductionTest {

    @Test
    public void NewProduction() {
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait delay = new WebDriverWait(driver, 10);

        driver.navigate().to(Constants.LoginPage.loginPage);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.LoginPage.username)));
        Assert.assertTrue("Title should be Archive2Azure", driver.getTitle().contains("Archive2Azure"));

        driver.findElement(By.cssSelector(Selectors.LoginPage.username)).sendKeys(Constants.LoginPage.loginUsername);
        driver.findElement(By.cssSelector(Selectors.LoginPage.password)).sendKeys(Constants.LoginPage.loginPassword);
        driver.findElement(By.cssSelector(Selectors.LoginPage.loginButton)).click();

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        Assert.assertTrue("Dashboard link should be present", driver.findElement(By.cssSelector(Dashboard.dashboardSelector)).isDisplayed());
        driver.findElement(By.xpath(EDiscovery.eDiscoveryTab)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.eDiscoveryTitle)));
        Assert.assertTrue("eDiscovery tab title should be displayed", driver.findElement(By.xpath(EDiscovery.eDiscoveryTitle)).isDisplayed());
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.production))).isDisplayed();
        driver.findElement(By.xpath(EDiscovery.production)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(EDiscovery.newProduction))).isDisplayed();

        driver.findElement(By.cssSelector(EDiscovery.newProduction)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.xButton))).isDisplayed();

        driver.findElement(By.cssSelector(EDiscovery.newProductionMatterDropdown)).click();
        driver.findElement(By.xpath(EDiscovery.newProductionName)).sendKeys("Test New Production Selenium");
        driver.findElement(By.xpath(EDiscovery.newProductionDescription)).sendKeys("Test New Production Description Selenium");

        driver.findElement(By.xpath(EDiscovery.newProductionSave)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.productionNameCheck))).isDisplayed();
        Assert.assertTrue("New Production should be added", driver.findElement(By.xpath(EDiscovery.productionNameCheck)).isDisplayed());
        driver.findElement(By.xpath(EDiscovery.expandProduction)).click();

        driver.findElement(By.xpath(EDiscovery.delete)).click();
        driver.findElement(By.xpath(EDiscovery.deleteConfirmation)).click();
        delay.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EDiscovery.productionNameCheck)));
        driver.findElement(By.cssSelector(EDiscovery.refresh)).click();
        Assert.assertEquals(0, driver.findElements(By.xpath(EDiscovery.productionNameCheck)).size());


        driver.close();
        driver.quit();
    }
}
