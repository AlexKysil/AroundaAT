package unitTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

}
