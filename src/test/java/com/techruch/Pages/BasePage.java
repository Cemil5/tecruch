package com.techruch.Pages;

import com.techruch.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//div[@class='content']//header/h2/a)")
    public List<WebElement> getArticles;

    String articleTitlePath = "(//div[@class='content']//header/h2/a)";
  //  public List<WebElement> getArticles = Driver.get().findElements(By.xpath(articleTitlePath));
    
    String authorsPath = articleTitlePath + "/../..//span[@class='river-byline__authors']";
    public List<WebElement> getAuthors = Driver.get().findElements(By.xpath(authorsPath));

    String imagePath = articleTitlePath + "/../../..//img";
    public List<WebElement> getImages = Driver.get().findElements(By.xpath(imagePath));


    // content page locators

    @FindBy(tagName = "h1")
    public WebElement newsTitle;

    @FindBy(xpath = "//div[@class='article-content']//a")
    public List<WebElement> contentLinks;


}
