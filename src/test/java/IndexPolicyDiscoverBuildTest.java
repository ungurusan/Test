import Selectors.Dashboard;
import Selectors.EDiscovery;
import Selectors.Index;
import Selectors.LoginPage;
import Tools.Tools;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class IndexPolicyDiscoverBuildTest {
    @Test
    public void IndexPolicyDiscoverBuild() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        WebDriverWait delay = new WebDriverWait(driver, 10);
        WebDriverWait delay100 = new WebDriverWait(driver, 100);

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

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Index.name))).isDisplayed();
        Assert.assertTrue("Test Automation Selenium Name Index Policy should be created", driver.findElement(By.xpath(Index.name)).isDisplayed());

        WebElement element = driver.findElement(By.xpath(Index.name));

        String element2 = Tools.generateXPATH(element, "");

        char firstEl = element2.charAt(98);
        StringBuilder secondEl = new StringBuilder(Index.discoverOption);
        secondEl.setCharAt(71, firstEl);
        String finalEl = secondEl.toString();


        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Index.statusIdle))).isDisplayed();



        //Assert.assertEquals(0, driver.findElements(By.cssSelector(Index.loadingWheel)).size());
        driver.findElement(By.xpath(finalEl)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Index.discover))).isDisplayed();
        driver.findElement(By.xpath(Index.discover)).click();

        boolean statusPending = driver.findElement(By.cssSelector(Index.statusPending)).isDisplayed();

        while(statusPending==true){

            driver.findElement(By.xpath(Index.refresh)).click();
            delay.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Index.loadingWheel)));
            if(driver.findElements(By.cssSelector(Index.statusPending)).size()==0){
                statusPending = false;
            }

        }

        boolean statusDiscovering = driver.findElement(By.cssSelector(Index.statusDiscovering)).isDisplayed();

        while(statusDiscovering==true){

            driver.findElement(By.xpath(Index.refresh)).click();
            delay.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Index.loadingWheel)));
            if(driver.findElements(By.cssSelector(Index.statusDiscovering)).size()==0){
                statusDiscovering = false;
            }


        }
        System.out.println(finalEl);


        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Index.statusReadyToBuild)));



            driver.findElement(By.xpath(finalEl)).click();
            driver.findElement(By.xpath(Index.build)).click();

        boolean statusPendingBuild = driver.findElement(By.cssSelector(Index.statusReadyToBuild)).isDisplayed();

        while(statusPendingBuild==true){

            driver.findElement(By.xpath(Index.refresh)).click();
            delay.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Index.loadingWheel)));
            if(driver.findElements(By.cssSelector(Index.statusPending)).size()==0){
                statusPendingBuild = false;
            }

        }

        boolean statusBuilding = driver.findElement(By.cssSelector(Index.statusBuilding)).isDisplayed();

        while(statusBuilding==true){

            driver.findElement(By.xpath(Index.refresh)).click();
            delay.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(Index.loadingWheel)));
            if(driver.findElements(By.cssSelector(Index.statusBuilding)).size()==0){
                statusBuilding = false;
            }


        }

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Index.statusFinished)));
        Assert.assertTrue("Status should be Finished", driver.findElement(By.cssSelector(Index.statusFinished)).isDisplayed());

        StringBuilder thirdEl = new StringBuilder(Index.delete);
        thirdEl.setCharAt(71, firstEl);
        String finalEldelete = thirdEl.toString();

        driver.findElement(By.xpath(finalEldelete)).click();
        driver.findElement(By.xpath(Index.deleteConfirmation)).click();

        delay.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Index.name)));
        Assert.assertEquals(0, driver.findElements(By.xpath(Index.name)).size());

        driver.close();
        driver.quit();

    }
}
