package unitTest;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.api.Screen;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import r_s_c.lib_S.CommonActionFunctions;
import r_s_c.lib_S.fixtureClass;
import r_s_c.lib_S.CommonActionFunctions.*;


import java.util.Set;
import java.util.concurrent.TimeUnit;

public class seleniumSiteTest extends fixtureClass {
    @Test
    @Ignore   // Have no idea
    public void openSiteMaximizeBrowser(){

    }

    @Test
    @Ignore // Just for test
    public void checkLogoHeader() throws InterruptedException {
        driver.findElement(By.xpath("//img[@class='main_loader_img']"));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='main-nav_logo']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@class='main_loader_img']"));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='main-nav_logo']")).click();
    }

    @Test
    @Ignore // Just for test
    public void checkWorksLinkHeader() throws InterruptedException {
        Thread.sleep(3000);
        String dribbleLink = "https://dribbble.com/arounda";
        String mainWindowHandler = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text() = 'Works']")).click();
        Set<String> allHandles = driver.getWindowHandles();
        for(String handle : allHandles){
            if(handle.equals(mainWindowHandler)){
                continue;
            }else{
                driver.switchTo().window(handle);
                System.out.println(driver.getCurrentUrl());
            }
        }
        String actualLink = driver.getCurrentUrl();
        if(!(dribbleLink.equals(actualLink))){
            Assert.fail("Current URL is: " + actualLink);
        }
        driver.close();
        driver.switchTo().window(mainWindowHandler);
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    @Ignore // Just for test
    public void checkServeceisLinkHeader() throws InterruptedException {
        Thread.sleep(5000);
        String mainPageURL = driver.getCurrentUrl();
        String expectedURL = "https://arounda.agency/services";
        driver.findElement(By.xpath("//a[text() = 'Services']")).click();
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equals(mainPageURL)){
            Assert.fail("Actual URL is: " + actualURL);
        }else if(!actualURL.equals(expectedURL)){
            Assert.fail("Actual URL is: " + actualURL);
        } else{
            System.out.println(actualURL);
            driver.navigate().back();
        }
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    @Ignore //Just for test
    public void checkContactBTNHEader() throws InterruptedException {
        Thread.sleep(5000);
        String mainPageURL = driver.getCurrentUrl();
        String expectedURL = "https://arounda.agency/contact";
        driver.findElement(By.xpath("//a[text() = 'Contact']")).click();
        String actualURL = driver.getCurrentUrl();
        if(actualURL.equals(mainPageURL)){
            Assert.fail("Actual URL is: " + actualURL);
        }else if(!actualURL.equals(expectedURL)){
            Assert.fail("Actual URL is: " + actualURL);
        } else{
            System.out.println(actualURL);
            driver.navigate().back();
        }
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    @Ignore // Just for test
    public void checkTitleExperience() throws InterruptedException {
        String test = driver.findElement(By.xpath("//div[@class='section_cont']")).getText();
        System.out.println(test);
        String expectedResult1 = "Our experience for your";
        String expectedResult2 = "Strategy, Design & Development";

        if(!test.contains(expectedResult1)){
            Assert.fail("Actual result is: " + test);
        }
        if(!test.contains(expectedResult2)){
            Assert.fail("Actual result is: " + test);
        }

        WebElement element = driver.findElement(By.xpath("//*[@class='section_title_light section_title_red']"));
        CommonActionFunctions a = new CommonActionFunctions();
        a.testNextElement("startup", "star", element);
        a.testNextElement("business", "bus", element);
        a.testNextElement("product", "pro", element);
    }

    @Test
    @Ignore    //Just for Test
    public void checkArrowDownUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='section_arrow_wrap']/img")).click();
        driver.findElement(By.xpath("//a[@class='main-nav_mobile-logo']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@class='main_loader_img']"));
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='section_arrow_wrap']/img")).click();
    }

    @Test
    @Ignore //Just for Test
    public void checkMobilePhoneImage() {
        driver.findElement(By.xpath("//img[@class='specialise_phone_screen phone_frame_vert']")).isDisplayed();
    }

    @Test
    @Ignore // Just for Test
    public void checkMoreCasesLink() throws InterruptedException {
        String expectedResult = "more cases⟶";
        String dribbleLink = "https://dribbble.com/arounda";
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@class='main_loader_img']")));
        Thread.sleep(500);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='section_arrow_wrap']/img")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='section_arrow_wrap']/img")));
        driver.findElement(By.xpath("//div[@class='section_arrow_wrap']/img")).click();

        String actualResult = driver.findElement(By.xpath("//div[@class='cases-arrow_wrap']")).getText();

        if(!actualResult.equals(expectedResult)){
            Assert.fail("This is actual result: " + actualResult);
        }

        String mainWindowHandler = driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='cases-arrow_wrap']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='cases-arrow_wrap']/a")));
        driver.findElement(By.xpath("//div[@class='cases-arrow_wrap']/a")).click();
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (handle.equals(mainWindowHandler)) {
                continue;
            } else {
                driver.switchTo().window(handle);
                System.out.println(driver.getCurrentUrl());
            }
        }
        String actualLink = driver.getCurrentUrl();
        if (!(dribbleLink.equals(actualLink))) {
            Assert.fail("Current URL is: " + actualLink);
        }
        driver.close();
        driver.switchTo().window(mainWindowHandler);
        System.out.println(driver.getCurrentUrl());

    }

    @Test
    @Ignore // Not done yet
    public void checkHumbergerMenu() throws InterruptedException {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='hamburger-box']")));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='section_arrow_wrap']/img")));
            // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='section_arrow_wrap']/img")));
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[@class='section_arrow_wrap']/img")).click();
        }catch(ElementNotVisibleException env){
            System.out.println("This element is invisible: arrowDown");
        }
        try {
            wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='hamburger-box']"))));
        } catch(ElementNotVisibleException env){
            System.out.println("This element is not visible: HumburgerMenu");

        }
    }

    @Test //Should be separeted to 3 different tests
    @Ignore //Just for test
    public void checkAgancyText() {

        String expectedTitle = "Agency specializes in\n" +
                "web & mobile apps";
        String actualTitle = driver.findElement(By.xpath("//div[@class='section_cont specialise_cont']/h2")).getText();

        if(!actualTitle.equals(expectedTitle)){
            Assert.fail("Error, actualResult is: " + actualTitle);
        }else{
            System.out.println("This is expected result: " + expectedTitle);
            System.out.println("This is actualResult: " + actualTitle);
        }

        driver.findElement(By.xpath("//div[@class='section_divider_wrap specialise_divider']")).isDisplayed();

        String expectedPText = "We are engaged in the creation products for startups, services and emerging business. " +
                "Agency has expertise in entertainment, dating, finance, education & healthcare spheres.";

        String actualPText = driver.findElement(By.xpath("//div[@class='section_cont specialise_cont']/p")).getText();

        if(!actualPText.equals(expectedPText)){
            Assert.fail("Error, the actual result is: " + actualPText);
        }else{
            System.out.println("Expected result: " + expectedPText);
            System.out.println("Actual result is: " + actualPText);
        }

        String expectedProjTeam = "89+ Completed projects 13+ People in team";
        String actualProjTeam = driver.findElement(By.xpath("//div[@class='section_cont specialise_cont']/ul")).getText();

        if(!actualProjTeam.equals(expectedProjTeam)){
            Assert.fail("Error, actual Result is: " + actualProjTeam);
        }else{
            System.out.println("Expected result is: " + expectedProjTeam);
            System.out.println("Actual result is: " + actualProjTeam);
        }
    }

    @Test // Should be separeted to 3 different test
    @Ignore // Just for test
    public void checkTeamTurnsText(){
        String expectedTitle = "Our team turns to the heart of the product";
        String actualTitle = driver.findElement(By.xpath("//div[@class='section_cont creed_cont']/h2")).getText();
        if(!actualTitle.equals(expectedTitle)){
            Assert.fail("Error, actual result is: " + actualTitle);
        }else{
            System.out.println("Expected resilt is: " + expectedTitle);
            System.out.println("Actual result is: " + actualTitle);
        }
        driver.findElement(By.xpath("//div[@class='section_divider_wrap creed_divider']")).isDisplayed();

        String expectedText = "Our mission is to set up the processes to reach the main business goals. " +
                "We pay special attention to the logic of the product and user interaction.";
        String actualText = driver.findElement(By.xpath("//p[@class='section_text creed_text']")).getText();
        if(!actualText.equals(expectedText)){
            Assert.fail("Error, actual result is: " + actualText);
        }else{
            System.out.println("Expected resilt is: " + expectedText);
            System.out.println("Actual result is: " + actualText);
        }

        String expectedQualities = "Creative, respectable & responsible";
        String actualQualities = driver.findElement(By.xpath("//p[@class='section_text creed_undertext']")).getText();
        if(!actualQualities.equals(expectedQualities)){
            Assert.fail("Error, actual result is: " + actualQualities);
        }else{
            System.out.println("Expected resilt is: " + expectedQualities);
            System.out.println("Actual result is: " + actualQualities);
        }
    }
}
