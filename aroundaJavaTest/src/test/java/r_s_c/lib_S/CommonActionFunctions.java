package r_s_c.lib_S;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by Admin on 4/5/2018.
 */
public class CommonActionFunctions {


    public boolean testNextElement(String expectedResult,String textPArt, WebElement element) throws InterruptedException {
        boolean result = false;
        String actualResult = element.getText();

        boolean end = false;
        int iteratorCount = 0;
        while(true){
            if(actualResult.contains(textPArt)){
                System.out.println(actualResult);

                Thread.sleep(500);
                actualResult = element.getText();
                actualResult.equals(expectedResult);
                result = true;

                System.out.println(actualResult);
                    break;
            }else{
                if(iteratorCount == 20) {
                    Assert.fail("Wrong text result for 10 loops: " + actualResult);
                    result = false;
                   break;
                }

                actualResult = element.getText();
                Thread.sleep(1000);
                iteratorCount++;
                continue;
            }

        }

        return result;
    }
}
