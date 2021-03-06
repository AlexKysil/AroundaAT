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


import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class seleniumSiteTest extends fixtureClass {

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

    @Test
    @Ignore // Just for test
    public void checkLaptopIMG() {
        driver.findElement(By.xpath("//img[@class='creed_laptop_screen']")).isDisplayed();
    }

    @Test // Should be separeted
    @Ignore //Just for test
    public void checkOurProcess() {
        String expectedResult = "Our process\n" +
                "Beautiful mobile apps & websites";
        String actualResult = driver.findElement(By.xpath("//div[@class='section_cont process_cont']")).getText();
        if (!actualResult.equals(expectedResult)) {
            Assert.fail("Error, actual result is: " + actualResult);
        } else {
            System.out.println("Expected result is: " + expectedResult);
            System.out.println("Actual result is: " + actualResult);
        }

        driver.findElement(By.xpath("//div[@class='section_divider_wrap process_divider']")).isDisplayed();
    }

    @Test
    @Ignore //Just for Test
    public void checkProcessPictures(){
        driver.findElement(By.xpath("//img[@src='assets/icons/index/startegy.svg']")).isDisplayed();
        driver.findElement(By.xpath("//img[@src='assets/icons/index/user_experience.svg']")).isDisplayed();
        driver.findElement(By.xpath("//img[@src='assets/icons/index/design.svg']")).isDisplayed();
        driver.findElement(By.xpath("//img[@src='assets/icons/index/development.svg']")).isDisplayed();
    }

    @Test
    @Ignore //Just for test
    public void checkProcessTitles(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='process_single_title' and contains(text(), \"Development\")]")));
        String[] expectedtResult = {"Strategy","UX Design","Design","Development"};
        ArrayList<WebElement> blocks = new ArrayList<WebElement>((driver.findElements(By.xpath("//div[@class='process_group']//h3"))));

        for(int i = 0; i<4; i++) {
            for (WebElement elem : blocks) {
                if (!elem.getText().equals(expectedtResult[i]) && i >= 3){
                    Assert.fail("Error, actual result: " + elem.getText());
                }else if(elem.getText().equals(expectedtResult[i])){
                    System.out.println("Expected result is: " + expectedtResult[i]);
                    System.out.println("Actual result is: " + elem.getText());
                    i++;
                }else{
                    i++;
                    continue;
                }
            }
        }
    }

    @Test
    @Ignore // Just for test
    public void checkProcessText() {
        String[] expectedTexts = {"We start the project by searching for a basically possible understanding of how and where we need to move.",
                "Understanding the logic and structure of the product lays the foundation for the product’s interaction with the environment",
                "The visual component creates a unique perception of the product by users, evokes interest in interaction",
                "The most competent implementation of the visual result with the help of the latest technologies for a simpler perception of the product"};
        ArrayList<WebElement> blocks = new ArrayList<WebElement>(driver.findElements(By.xpath("//div[@class='process_group']//p")));
        for(int i = 0; i<4; i++) {
            for (WebElement elem : blocks) {
                if (!elem.getText().equals(expectedTexts[i]) && i >= 3){
                    Assert.fail("Error, actual result: " + elem.getText());
                }else if(elem.getText().equals(expectedTexts[i])){
                    System.out.println("Expected result is: " + expectedTexts[i]);
                    System.out.println("Actual result is: " + elem.getText());
                    i++;
                }else{
                    i++;
                    continue;
                }
            }
        }
    }

    @Test
    @Ignore //Just for test
    public void checkWantWork(){
    String expectedResult = "Want to work with us? Let's start!";
    String actualResult = driver.findElement(By.xpath("//p[@class = 'help_text']")).getText();
    if(!actualResult.equals(expectedResult)){
        Assert.fail("Wrong actual text: " + actualResult);
    }else
    {
        System.out.println("Expected result is: " + expectedResult);
        System.out.println("Actual result is: " + actualResult);
    }
}

    @Test
    @Ignore //Just for test
    public void checkHelpMail() {
        String expectedResult = "info@arounda.agency";
        String actualResult = driver.findElement(By.xpath("//a[@class='help_mail']")).getText();
        if(!actualResult.equals(expectedResult)){
            Assert.fail("Wrind actual result is: " + actualResult);
        }else  {
            System.out.println("Expected result is: " + expectedResult);
            System.out.println("Actual result is " + actualResult);
        }
    }

    @Test
    public void checkhireUsBTN() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), \"HIRE US\")]")));
        String mainPageURl = driver.getCurrentUrl();
        String expectedURL = "https://arounda.agency/contact.html";
        driver.findElement(By.xpath("//button[contains(text(), \"HIRE US\")]")).click();
        String actualResult = driver.getCurrentUrl();
        if(actualResult.equals(mainPageURl)){
            Assert.fail("BTN doesn`t work, still main page " + mainPageURl);
        }else if(!actualResult.equals(expectedURL)){
            Assert.fail("Expected one page, get: " +  actualResult);
        }else {
            System.out.println("BTN works");
        }

        driver.navigate().back();
        System.out.println(driver.getCurrentUrl());
    }

}
