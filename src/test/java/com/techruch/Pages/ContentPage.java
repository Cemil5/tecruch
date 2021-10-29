package com.techruch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContentPage extends BasePage{
    @FindBy(tagName = "h1")
    public WebElement newsTitle;

    @FindBy(xpath = "//div[@class='article-content']//a")
    public List<WebElement> contentLinks;

}
