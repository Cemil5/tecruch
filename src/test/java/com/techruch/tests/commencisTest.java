package com.techruch.tests;

import com.techruch.Pages.BasePage;
import com.techruch.Pages.TestBase;
import com.techruch.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class commencisTest extends TestBase {


/*
Selenium Test Automation Task From commencis.com
Tech Blog Website
Using any test automation framework, Java language (except record/play tools) and Maven
dependency management, please do following:
1- Go to https://techcrunch.com/
2- For “The Latest News” list, verify followings;
	a. each news has an author
	b. each news has an image

 */
    @Test
    public void test1(){

        BasePage basePage = new BasePage();
    //    BrowserUtils.waitFor(5);

     //   System.out.println("basePage.articles.size() = " + basePage.getArticles.size());


//        WebElement one = driver.findElement(By.xpath("(//div[@class='content']//header/h2/a)[1]"));
//        System.out.println("one.getText() = " + one.getText());
//
//        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='content']//header/h2/a)//span[@class='river-byline__authors']"));
//        System.out.println("elements.size() = " + elements.size());
//
//        List<WebElement> articles1 = driver.findElements(By.xpath("(//div[@class='content']//header/h2/a)"));
//        System.out.println("articles1.size() = " + articles1.size());
//        for (WebElement webElement : basePage.getArticles) {
//            System.out.println("articles = " + webElement.getText());
//        }

        Assert.assertEquals(basePage.getAuthors.size(), basePage.getArticles.size(), "verify number of authors and " +
                "articles");
        System.out.println("basePage.getArticles.size() = " + basePage.getArticles.size());

        for (WebElement element : basePage.getAuthors) {
            System.out.println("element = " + element.getText());
            Assert.assertTrue(element.isDisplayed(),"verify author is displayed");
        }

        Assert.assertEquals(basePage.getImages.size(), basePage.getArticles.size(), "verify number of images and " +
                "articles");

        for (WebElement image : basePage.getImages) {
            Assert.assertTrue(image.isDisplayed(),"verify image is displayed");
        }

     //   System.out.println("basePage.getArticles.size() = " + basePage.getArticles.size());
        //  basePage.getArticles.get(1).click();

        //       System.out.println(driver.findElements(By.xpath("(//h2/a[@class='post-block__title__link'])")).size());
 //       System.out.println(driver.findElement(By.partialLinkText("Chalo acquires")).getText());
//        System.out.println("basePage = " + driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        System.out.println(driver.findElement(By.xpath("(//h3/a)[2]")).getText());
//        System.out.println(driver.findElements(By.xpath("(//h2/a[@class='post-block__title__link'])")).size());
//        for (WebElement element : basePage.articles) {
//            System.out.println(element);
//        }
    }


    /*
    3- Click one of news from “The Latest News” list to reach the full content and verify followings;
	a. the browser title is the same with the news title
	b. the links within the news content

     */
    @Test
    public void test2(){
        BasePage basePage = new BasePage();
      //  BrowserUtils.waitFor(5);
      //  System.out.println("basePage.getArticles.size() = " + basePage.getArticles.size());

//        int i=0;
//        for (WebElement each : basePage.getArticles) {
//            System.out.println(i++ +" each.getText() = " + each.getText());
//        }

        basePage.getArticles.get(0).click();

        Assert.assertEquals(basePage.newsTitle.getText() + " | TechCrunch", driver.getTitle(),"verify titles");

        String newsUrl = driver.getCurrentUrl();

        int linkNumber =basePage.contentLinks.size();
        if (linkNumber>0) {
            int i =0;
            for (WebElement link : basePage.contentLinks) {
                basePage.contentLinks.get(i++).click();
                BrowserUtils.waitFor(2);
                Assert.assertNotEquals(driver.getCurrentUrl(), newsUrl, "verify links");
                BrowserUtils.waitFor(2);
                driver.navigate().back();
                BrowserUtils.waitFor(2);
            }
        }
        BrowserUtils.waitFor(2);
    }

}
