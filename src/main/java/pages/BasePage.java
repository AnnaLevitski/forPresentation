package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage   {
    static WebDriver driver = Driver.getDriver();
    public static BlogPage blogPage = pages.BlogPage.getBlogPage();

    @FindBy(id = "nav-icon") static WebElement hamburger;

    public static void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static <T extends BasePage> T openHeaderMenuItem(HeaderMenuItems headerMenuItems){
        List<String> list = new ArrayList<>();
        driver.findElement(By.xpath("//a//div | //span[text()='"+headerMenuItems.toString()+"']")).click();
        pause(10000);
            switch (headerMenuItems){
                case Blog: return (T) blogPage;
                case Home: return (T) HomePage.getHomePage();
                default: throw new IllegalArgumentException("BasePage openHeaderMenuItem legal argument");
            }


        //return null;
    }
    public BasePage navigationHamburgerMenu(String page){
        if(hamburger.isDisplayed())
            hamburger.click();
        switch (page){
            case "blog", "Blog", "blogPage" -> {
                driver.findElement(By.xpath("//a//div | //span[text()='Blog']")).click();
                pause(1000);
                return BlogPage.getBlogPage();
            }
            default -> {
                driver.findElement(By.xpath("//a//div | //span[text()='Home']")).click();
                return HomePage.getHomePage();
            }
        }
    }

    public static void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
