package Test;

import Base.BaseTest;
import Pages.GoogleLandingPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchListingTest extends BaseTest {

    @Test
    public void searchListingTest() throws InterruptedException {
        GoogleLandingPage googleLandingPage = PageFactory.initElements(driver,GoogleLandingPage.class);

        googleLandingPage.sendSearchKeys("instawork");
        googleLandingPage.findIndexOfSearchKeyword("www.instawork.com");
    }
}