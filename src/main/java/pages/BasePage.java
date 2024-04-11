package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BasePage   {
    static WebDriver driver = Driver.getDriver();

    @FindBy(id = "nav-icon") static WebElement hamburger;

    public static void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
