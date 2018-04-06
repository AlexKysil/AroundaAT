package r_s_c.lib_S;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class fixtureClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void initBrowserChrome(){
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 15);
        driver.navigate().to("https://arounda.agency/");
        driver.manage().window().fullscreen();

    }

    @AfterClass
    public void finishTestCloseBrowser(){driver.quit();}
}
