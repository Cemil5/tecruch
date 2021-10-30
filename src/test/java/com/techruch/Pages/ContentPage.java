package com.techruch.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ContentPage extends BasePage{
    @FindBy(tagName = "h1")
    public WebElement newsTitle;

    @FindBy(xpath = "//div[@class='article-content']//a")
    public List<WebElement> contentLinks;

    public static void verifyLink (String linkUrl) {

        try
        {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            int responseCode = httpURLConnect.getResponseCode();
            String responseMessage = httpURLConnect.getResponseMessage();

            if(responseCode==200) {
                System.out.println(linkUrl+" : " + responseMessage);
            } else if (responseCode==HttpURLConnection.HTTP_NOT_FOUND){
                System.out.println(linkUrl+" : "+ responseMessage + " : "+ HttpURLConnection.HTTP_NOT_FOUND);
            } else if (responseCode == 403){
                System.out.println(linkUrl + " : "+  responseCode + " : " + responseMessage);
            } else if (linkUrl.equals(null) || linkUrl.isEmpty()){
                System.out.println(linkUrl + ": This URL is either not configured for anchor tag or it is empty");
            } else {
                System.out.println("OTHER PROBLEM : " + linkUrl + " "+ responseCode + " : " + responseMessage);
            }
        } catch (Exception e) {
            System.out.println(" CATCH BLOCK : OTHER PROBLEM " + linkUrl);
        }
    }


}
