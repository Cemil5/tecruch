package com.techruch.Pages;

import com.techruch.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//div[@class='content']//header/h2/a)")
    public List<WebElement> getArticles;

    public String articleTitlePath = "(//div[@class='content']//header/h2/a)";
  //  public List<WebElement> getArticles = Driver.get().findElements(By.xpath(articleTitlePath));
    
    public String authorsPath = "/../..//span[@class='river-byline__authors']";
  //  public List<WebElement> getAuthors = Driver.get().findElements(By.xpath(authorsPath));

    public String imagePath = "/../../..//img";
    public List<WebElement> getImages = Driver.get().findElements(By.xpath(imagePath));

/*
    int articleSize = homePage.getArticles.size();
        for (int i=0; i<articleSize;i++){
        homePage.getArticles.get(i)
    }
*/

    // content page locators

    @FindBy(tagName = "h1")
    public WebElement newsTitle;

    @FindBy(xpath = "//div[@class='article-content']//a")
    public List<WebElement> contentLinks;


}
