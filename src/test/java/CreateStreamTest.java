import Selectors.Dashboard;
import Selectors.Ingestion;
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

import static Selectors.Ingestion.deleteButton;
import static org.junit.Assert.assertEquals;

/**
 * Created by Flaviu on 6/28/2016.
 */
public class CreateStreamTest {

    @Test
    public void CreateStream() throws InterruptedException {

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

        driver.findElement(By.xpath(Ingestion.ingestionSelector)).click();
        Assert.assertTrue("Title should be Streams", driver.findElement(By.xpath(Ingestion.streamsTitle)).isDisplayed());

        driver.findElement(By.xpath(Ingestion.ingestionCreateNew)).click();
        driver.findElement(By.xpath(Ingestion.streamName)).sendKeys("Test Stream Selenium");
        driver.findElement(By.xpath(Ingestion.streamDescription)).sendKeys("Selenium Stream Description");
        //driver.findElement(By.xpath(Ingestion.getStreamDropdown)).click();
        driver.findElement(By.xpath(Ingestion.streamTypeEmailArchive)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Ingestion.streamCancel)));

        driver.findElement(By.xpath(Ingestion.streamCancel)).click();
        //Assert that the Stream was not created

        driver.findElement(By.xpath(Ingestion.ingestionCreateNew)).click();
        driver.findElement(By.xpath(Ingestion.streamName)).sendKeys("Test Stream Selenium");
        driver.findElement(By.xpath(Ingestion.streamDescription)).sendKeys("Selenium Stream Description");
        //driver.findElement(By.xpath(Ingestion.getStreamDropdown)).click();
        driver.findElement(By.xpath(Ingestion.streamTypeEmailArchive)).click();

        driver.findElement(By.xpath(Ingestion.streamSave)).click();
        //assert that the Stream was created
        driver.findElement(By.xpath(Ingestion.ingestionRefresh)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Ingestion.deleteButton)));
        Assert.assertTrue("Stream name should be 'Test Stream Selenium'", driver.findElement(By.xpath("//span[text()='Test Stream Selenium']")).isDisplayed());
        Assert.assertTrue("Stream name should be 'Selenium Stream Description'", driver.findElement(By.xpath("//span[text()='Selenium Stream Description']")).isDisplayed());


        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*=ingestion]")));
        driver.findElement(By.xpath(Ingestion.ingestionSelector)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Test Stream Selenium']")));
        WebElement element = driver.findElement(By.xpath("//span[text()='Test Stream Selenium']"));

        String element2 = Tools.generateXPATH(element, "");

        char firstEl = element2.charAt(98);

        StringBuilder secondEl = new StringBuilder(deleteButton);
        secondEl.setCharAt(71, firstEl);
        String finalEl = secondEl.toString();

        driver.findElement(By.xpath(finalEl)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Ingestion.confirmationYes)));
        driver.findElement(By.xpath(Ingestion.confirmationYes)).click();
        driver.findElement(By.cssSelector(Dashboard.dashboardSelector)).click();
        driver.findElement(By.xpath(Ingestion.ingestionSelector)).click();
        driver.findElement(By.xpath(Ingestion.ingestionRefresh)).click();

        delay.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[text()='Test Stream Selenium']")));
        Assert.assertEquals(0, driver.findElements(By.xpath("//span[text()='Test Stream Selenium']")).size());
        Assert.assertEquals(0, driver.findElements(By.xpath("//span[text()='Selenium Stream Description']")).size());

        driver.close();
        driver.quit();

    }


}
