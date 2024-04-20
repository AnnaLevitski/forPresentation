package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class BlogPage extends BasePage {

    @FindBy(className = "filter-chip") List<WebElement> blogFilterList;

    private static BlogPage blogPage;

    private BlogPage() {
        PageFactory.initElements(driver, this);
    }


    public static BlogPage getBlogPage(){
        if(blogPage==null){
            return new BlogPage();
        }
        return blogPage;
    }

    public BlogPage assertBlogPageIsOpenCheckFilterList(){
        List<String> namesBlogFilterList = blogFilterList.stream().map(WebElement :: getText).collect(Collectors.toList());
        List<String> actualResult = Arrays.asList ("Tech", "Updates","Guides","News", "Trends");
        Assert.assertEquals(namesBlogFilterList, actualResult);
        namesBlogFilterList.forEach(System.out::println);
        return this;
    }


}
