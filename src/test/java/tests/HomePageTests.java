package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.BlogPage;
import pages.HeaderMenuItems;
import pages.HomePage;

import java.lang.reflect.InvocationTargetException;


public class HomePageTests {

    @BeforeSuite
    public void bc(){

    }
    @Test
    public void openHomePageTest_success_assertInside(){
        HomePage.getHomePage().openHomePage().assertHomePageIsOpenCheckH1();
    }
    @Test
    public void openHomePageTest_success_assertOutside(){
        String h1 = HomePage.getHomePage().openHomePageOutputH1Str();
        Assert.assertEquals(h1, "Tune");
    }
    @Test
    public void openHomePageTest_success_invoke(){
        try {
            HomePage.getHomePage().openHomePage().navigationHamburgerMenu("blog").getClass()
                    .getDeclaredMethod("assertBlogPageIsOpenCheckFilterList").invoke(BlogPage.getBlogPage());
        } catch (NoSuchMethodException | InvocationTargetException | SecurityException | IllegalAccessException e){
            System.out.println("catch HPT "+ e.getMessage());
        }

    }
    @Test
    public void openHomePageTest_success_casting(){
        ((BlogPage)  HomePage.getHomePage().openHomePage().navigationHamburgerMenu("blog")).assertBlogPageIsOpenCheckFilterList();
    }
    @Test
    public void openHomePageTest_success_enum() {
        HomePage.getHomePage().openHomePage().openHeaderMenuItem(HeaderMenuItems.Blog).blogPage.assertBlogPageIsOpenCheckFilterList();
    }

    @AfterSuite
    public void as(){
        HomePage.getHomePage().tearDown();
    }
}

