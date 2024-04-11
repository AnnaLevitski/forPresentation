package pages;

import config.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public final class HomePage extends BasePage {
    private static HomePage homePage;

    private HomePage() {

    }
    public static HomePage getHomePage(){
        if(homePage==null){
            return new HomePage();
        }
        return homePage;
    }

    @FindBy(xpath = "//h1/span/span/span[1]") WebElement h1;

    public HomePage openHomePage(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("url");
        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
        return this;
    }
    public String openHomePageOutputH1Str(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("url");
        driver.navigate().to(url);
        PageFactory.initElements(driver, this);
        return h1.getText();
    }
    public HomePage assertHomePageIsOpenCheckH1() {
        Assert.assertEquals(h1.getText(), "Tune");
        return this;
    }



}
