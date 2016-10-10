import Constants.LoginPage;
import Selectors.Dashboard;
import Selectors.EDiscovery;
import Tools.Tools;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class NewMatterTest {

    @Test
    public void NewMatter() {
        FirefoxDriver driver = new FirefoxDriver();
        WebDriverWait delay = new WebDriverWait(driver, 10);

        driver.navigate().to(LoginPage.loginPage);
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selectors.LoginPage.username)));
        Assert.assertTrue("Title should be Archive2Azure", driver.getTitle().contains("Archive2Azure"));

        driver.findElement(By.cssSelector(Selectors.LoginPage.username)).sendKeys(LoginPage.loginUsername);
        driver.findElement(By.cssSelector(Selectors.LoginPage.password)).sendKeys(LoginPage.loginPassword);
        driver.findElement(By.cssSelector(Selectors.LoginPage.loginButton)).click();

        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        Assert.assertTrue("Dashboard link should be present", driver.findElement(By.cssSelector(Dashboard.dashboardSelector)).isDisplayed());
        driver.findElement(By.xpath(EDiscovery.eDiscoveryTab)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.eDiscoveryTitle)));
        Assert.assertTrue("eDiscovery tab title should be displayed", driver.findElement(By.xpath(EDiscovery.eDiscoveryTitle)).isDisplayed());
        driver.findElement(By.xpath(EDiscovery.createNewMatter)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.matterName)));
        Assert.assertTrue("eDiscovery tab title should be displayed", driver.findElement(By.xpath(EDiscovery.matterName)).isDisplayed());

        driver.findElement(By.xpath(EDiscovery.matterName)).sendKeys("Selenium Test Matter");
        driver.findElement(By.xpath(EDiscovery.matterDescription)).sendKeys("Selenium Matter Description");
        driver.findElement(By.xpath(EDiscovery.firstIndexCheckbox)).click();
        driver.findElement(By.xpath(EDiscovery.batesCheckbox)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.batesMask)));
        driver.findElement(By.xpath(EDiscovery.batesMask)).sendKeys("Selenium Bates Mask");
        driver.findElement(By.xpath(EDiscovery.batesLocation)).click();
        driver.findElement(By.xpath(EDiscovery.batesColor)).click();
        driver.findElement(By.xpath(EDiscovery.batesFont)).click();

        driver.findElement(By.xpath(EDiscovery.batesSave)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.matterNameString)));
        Assert.assertTrue("Selenium Test Matter should be created", driver.findElement(By.xpath(EDiscovery.matterNameString)).isDisplayed());

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.matterNameString)));

        WebElement element = driver.findElement(By.xpath(EDiscovery.matterNameString));
        String element2 = Tools.generateXPATH(element, "");
        char firstEl = element2.charAt(91);

        StringBuilder secondEl = new StringBuilder(EDiscovery.matterDeleteButton);
        StringBuilder editButtonTemp = new StringBuilder(EDiscovery.matterEditButton);

        editButtonTemp.setCharAt(67, firstEl);
        secondEl.setCharAt(67, firstEl);

        String editEl = editButtonTemp.toString();
        String finalEl = secondEl.toString();

        driver.findElement(By.xpath(editEl)).click();
        driver.findElement(By.xpath(EDiscovery.matterName)).sendKeys("Edited");
        driver.findElement(By.xpath(EDiscovery.matterDescription)).sendKeys("Edited");
        driver.findElement(By.xpath(EDiscovery.batesCheckbox)).click();
        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.batesMask)));
        driver.findElement(By.xpath(EDiscovery.batesMask)).sendKeys("Selenium Bates Mask Edit");
        driver.findElement(By.xpath(EDiscovery.batesLocationEdit)).click();
        driver.findElement(By.xpath(EDiscovery.batesColorEdit)).click();
        driver.findElement(By.xpath(EDiscovery.batesFontEdit)).click();
        driver.findElement(By.xpath(EDiscovery.batesSave)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.matterNameStringEdit)));
        Assert.assertTrue("Selenium Test Matter should be created", driver.findElement(By.xpath(EDiscovery.matterNameStringEdit)).isDisplayed());


        driver.findElement(By.xpath(finalEl)).click();

        delay.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(EDiscovery.batesDeleteYes)));
        driver.findElement(By.xpath(EDiscovery.batesDeleteYes)).click();

        delay.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(EDiscovery.matterNameStringEdit)));
        Assert.assertEquals(0, driver.findElements(By.xpath(EDiscovery.matterNameStringEdit)).size());

        driver.close();
        driver.quit();
    }
    
}
