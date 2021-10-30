package com.techruch.tests;

import com.techruch.Pages.ContentPage;
import com.techruch.Pages.HomePage;
import com.techruch.Pages.TestBase;
import com.techruch.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class commencisTest extends TestBase {

    HomePage homePage = new HomePage();

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

        int articleSize = homePage.getArticles.size();

        if (articleSize > 0){
            for (int i = 1; i<=articleSize; i++){
                String eachAuthorPath = homePage.articleTitlePath + "[" + i + "]" + homePage.authorsPath;
                Assert.assertTrue(driver.findElement(By.xpath(eachAuthorPath)).isDisplayed(),"author is displayed");
              //  System.out.println(driver.findElement(By.xpath(eachAuthorPath)).getText());

                String eachImagePath = homePage.articleTitlePath + "[" + i + "]" + homePage.imagePath;
                Assert.assertTrue(driver.findElement(By.xpath(eachImagePath)).isDisplayed(),"image is displayed");
            }
        } else {
            System.out.println(" article size must be higher than 0 ");
        }


    }





    /*
    3- Click one of news from “The Latest News” list to reach the full content and verify followings;
	a. the browser title is the same with the news title
	b. the links within the news content

     */

    @Test
    public void test2(){
        System.out.println(homePage.getArticles.size());
        homePage.getArticles.get(1).click();

        ContentPage contentPage =new ContentPage();

        Assert.assertEquals(contentPage.newsTitle.getText() + " | TechCrunch", driver.getTitle(),"verify titles");

        String newsUrl = driver.getCurrentUrl();

        int linkNumber =contentPage.contentLinks.size();

        System.out.println("Total links are "+linkNumber);

        for(int i=0;i<linkNumber;i++) {

            WebElement link = contentPage.contentLinks.get(i);

            String url=link.getAttribute("href");

            contentPage.verifyLink(url);

        }

    }

    @Test
    public void test20(){
        driver.get("https://www.lambdatest.com/blog/");
        ContentPage contentPage =new ContentPage();

        List<WebElement> links=driver.findElements(By.tagName("a"));
        int linkNumber =links.size();

        System.out.println("Total links are "+linkNumber);

        for(int i=0;i<linkNumber;i++) {

            WebElement link = links.get(i);

            String url=link.getAttribute("href");

            System.out.print(i+1 + ": ");
            contentPage.verifyLink(url);

        }

    }


    @Test
    public void test22(){

        System.out.println(homePage.getArticles.size());
        homePage.getArticles.get(1).click();

        Assert.assertEquals(homePage.newsTitle.getText() + " – TechCrunch", driver.getTitle(),"verify titles");

        String newsUrl = driver.getCurrentUrl();

        int linkNumber =homePage.contentLinks.size();
        if (linkNumber>0) {
            System.out.println(linkNumber);
            for (int i =0; i<linkNumber;i++) {
                WebElement link= homePage.contentLinks.get(i);
                if (!link.getAttribute("href").contains("twitter")){
                    System.out.println(link.getAttribute("href"));
                    link.click();
                 //   BrowserUtils.waitFor(2);
                    System.out.println( driver.getCurrentUrl() );
                    Assert.assertNotEquals(driver.getCurrentUrl(), newsUrl, "verify links");
                    driver.get(newsUrl);
                    BrowserUtils.waitFor(2);}
            }
        }
        BrowserUtils.waitFor(2);
    }


    @Test
    public void test3(){
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
     //   driver.get("https://www.srgresearch.com/articles/amazon-microsoft-google-grab-the-big-numbers-but-rest-of" +
      //          "-cloud-market-still-grows-by-27");
      //  homePage.getArticles.get(0).click();
    //    homePage.contentLinks.get(1).click();
        driver.get("https://techcrunch.com/2021/10/29/why-facebooks-angry-emoji-should-interest-the-us-sec/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
     //   driver.navigate().to("https://www.google.com/");
        driver.navigate().to("https://www.citizen.org/");
        System.out.println(driver.getTitle());
       System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
    }




//    @Test
//    public void test100(){
//
//        HomePage homePage = new HomePage();
//        //    BrowserUtils.waitFor(5);

        //   System.out.println("homePage.articles.size() = " + homePage.getArticles.size());


//        WebElement one = driver.findElement(By.xpath("(//div[@class='content']//header/h2/a)[1]"));
//        System.out.println("one.getText() = " + one.getText());
//
//        List<WebElement> elements = driver.findElements(By.xpath("(//div[@class='content']//header/h2/a)//span[@class='river-byline__authors']"));
//        System.out.println("elements.size() = " + elements.size());
//
//        List<WebElement> articles1 = driver.findElements(By.xpath("(//div[@class='content']//header/h2/a)"));
//        System.out.println("articles1.size() = " + articles1.size());
//        for (WebElement webElement : homePage.getArticles) {
//            System.out.println("articles = " + webElement.getText());
//        }

/*
        Assert.assertEquals(homePage.getAuthors.size(), homePage.getArticles.size(), "verify number of authors and " +
                "articles");
        System.out.println("homePage.getArticles.size() = " + homePage.getArticles.size());

        for (WebElement element : homePage.getAuthors) {
            System.out.println("element = " + element.getText());
            Assert.assertTrue(element.isDisplayed(),"verify author is displayed");
        }

        Assert.assertEquals(homePage.getImages.size(), homePage.getArticles.size(), "verify number of images and " +
                "articles");

        for (WebElement image : homePage.getImages) {
            Assert.assertTrue(image.isDisplayed(),"verify image is displayed");
        }




 */

        //   System.out.println("homePage.getArticles.size() = " + homePage.getArticles.size());
        //  homePage.getArticles.get(1).click();

        //       System.out.println(driver.findElements(By.xpath("(//h2/a[@class='post-block__title__link'])")).size());
        //       System.out.println(driver.findElement(By.partialLinkText("Chalo acquires")).getText());
//        System.out.println("homePage = " + driver.getCurrentUrl());
//        System.out.println(driver.getTitle());
//        System.out.println(driver.findElement(By.xpath("(//h3/a)[2]")).getText());
//        System.out.println(driver.findElements(By.xpath("(//h2/a[@class='post-block__title__link'])")).size());
//        for (WebElement element : homePage.articles) {
//            System.out.println(element);
//        }
//    }


}
