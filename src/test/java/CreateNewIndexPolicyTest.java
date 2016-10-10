import Selectors.Dashboard;
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

/**
 * Created by Flaviu on 6/30/2016.
 */
public class CreateNewIndexPolicyTest {
    @Test
    public void CreateIndexPolicy() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait delay = new WebDriverWait(driver, 10);

        driver.navigate().to(Constants.LoginPage.loginPage);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.LoginPage.username)));
        Assert.assertTrue("Title should be Archive2Azure", driver.getTitle().contains("Archive2Azure"));

        driver.findElement(By.cssSelector(LoginPage.username)).sendKeys(Constants.LoginPage.loginUsername);
        driver.findElement(By.cssSelector(LoginPage.password)).sendKeys(Constants.LoginPage.loginPassword);
        driver.findElement(By.cssSelector(LoginPage.loginButton)).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue("Dashboard link should be present", driver.findElement((By.cssSelector(Dashboard.dashboardSelector))).isDisplayed());

        driver.findElement(By.xpath(Index.indexSelector)).click();
        Assert.assertTrue("Title should be Custom Templates", driver.findElement(By.xpath(Index.indexTitle)).isDisplayed());
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Index.indexPolicies))).isDisplayed();
        driver.findElement(By.xpath(Index.indexPolicies)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Index.indexPoliciesCreateNew))).isDisplayed();
        driver.findElement(By.cssSelector(Index.indexPoliciesCreateNew)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Index.streamDropdown))).isDisplayed();
        driver.findElement(By.xpath(Index.streamTypeEVUserArchive)).click();

        driver.findElement(By.xpath(Index.streamTypeEVUserEmailTemplate)).click();
        driver.findElement(By.xpath(Index.indexStreamPolicySave)).click();

        driver.findElement(By.xpath(Index.indexName)).sendKeys("Test Automation Selenium Name");
        driver.findElement(By.xpath(Index.indexStreamPolicySave)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Test Automation Selenium Name']"))).isDisplayed();
        Assert.assertTrue("Test Automation Selenium Name Index Policy should be created", driver.findElement(By.xpath("//span[text()='Test Automation Selenium Name']")).isDisplayed());

        WebElement element = driver.findElement(By.xpath("//span[text()='Test Automation Selenium Name']"));

        String element2 = Tools.generateXPATH(element, "");
        System.out.println(element2);
        char firstEl = element2.charAt(98);
        StringBuilder secondEl = new StringBuilder(Index.delete);
        secondEl.setCharAt(71, firstEl);
        String finalEl = secondEl.toString();

        driver.findElement(By.xpath(finalEl)).click();

        driver.findElement(By.xpath(Index.deleteConfirmation)).click();
        driver.findElement(By.xpath(Index.refresh)).click();
        delay.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Test Automation Selenium Name']")));
        Assert.assertEquals(0, driver.findElements(By.xpath("//span[text()='Test Automation Selenium Name']")).size());

        driver.close();
        driver.quit();
    }
}


