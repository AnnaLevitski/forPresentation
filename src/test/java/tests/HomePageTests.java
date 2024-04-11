package tests;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.BlogPage;
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
    public void openHomePageTest_success(){
//        try {
//            HomePage.getHomePage().openHomePage().navigationHamburgerMenu("blog").getClass()
//                    .getDeclaredMethod("assertBlogPageIsOpenCheckFilterList").invoke(BlogPage.getBlogPage());
//        } catch (NoSuchMethodException | InvocationTargetException | SecurityException | IllegalAccessException e){
//            System.out.println("catch HPT "+ e.getMessage());
//        }

        ((BlogPage)  HomePage.getHomePage().openHomePage().navigationHamburgerMenu("blog")).assertBlogPageIsOpenCheckFilterList();
    }

    @AfterSuite
    public void as(){
        HomePage.getHomePage().tearDown();
    }
}

