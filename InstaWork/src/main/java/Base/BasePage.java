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

    public  void sendKeys(WebElement element,String param){
        element.sendKeys(param);
    }

}
