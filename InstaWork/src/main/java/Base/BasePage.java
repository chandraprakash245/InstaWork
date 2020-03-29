package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;

public class BasePage {
    private static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void wait(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForLoaderToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text('step details are being uploaded')]")));
        waitFor(2000); // TODO revisit
    }

    private void waitFor(int pollingDuration) {
        try {
            Thread.sleep(pollingDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void sendKeys(WebElement element,String param){
        element.sendKeys(param);
    }

}
