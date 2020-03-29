package Pages;

import Base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class GoogleLandingPage extends BasePage {

    public GoogleLandingPage(WebDriver driver) {super(driver);}


    @FindBy(xpath = "//input[@title='Search']")
    private WebElement searchfield;

    @FindBys({@FindBy(xpath = "//div/a/div//cite")})
    private List<WebElement> links;

    @FindBy(id="hdtb-msb-vis")
    private WebElement searchloader;

    public void sendSearchKeys(String searchKey){
        wait(searchfield);
        searchfield.sendKeys(searchKey);
        searchfield.sendKeys(Keys.ENTER);
        wait(searchloader);
    }

    public void findIndexOfSearchKeyword(String linkTitle) throws InterruptedException {
        wait(searchloader);
        Thread.sleep(2000);
        int pos = 0;
        boolean found = false;
        for (WebElement gLinks : links) {
            if (gLinks.getText().equalsIgnoreCase(linkTitle)) {
                pos = links.indexOf(gLinks);
                found = true;
                break;
            }
        }
        if(found && pos == 0){
            System.out.println("InstaWork displayed in First in Google Search ");
        }
       else if (found && pos !=0){
            System.out.println("InstaWork diapyed in " + pos + " Google Search ");
        }
       else
            System.out.println("InstaWork is not diaplyed in the google search");
    }
}

