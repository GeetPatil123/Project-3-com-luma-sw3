package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {

        String baseUrl ="https://magento.softwaretestingboard.com/";

        @Before
        public void setUp(){
            openBrowser(baseUrl);
        }
        @Test
        public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException{
            //Mouse hover on men menu
            mouseHoverToElement(By.linkText("Men"));
            // MouseHover on Bottoms
            mouseHoverToElement(By.linkText("Bottoms"));
            //Click on Pants
            mouseHoverToElementAndClick(By.linkText("Pants"));
            //Mouse Hover on Product Name Cronus Yoga Pant and click on size 32
            mouseHoverToElement(By.xpath("//a[normalize-space()='Cronus Yoga Pant']"));
            mouseHoverToElementAndClick(By.xpath("(//div[@class='swatch-option text'])[1]"));
            //Mouse Hover on Product Name Cronus Yoga Pant and click on colour Black
            mouseHoverToElementAndClick(By.linkText("Black"));
            //Mouse Hover on Product Name Cronus Yoga Pant and click on colour Black
            mouseHoverToElement(By.linkText("Cronus Yoga Pant"));
            mouseHoverToElementAndClick(By.linkText("Add To Cart"));
            Thread.sleep(1000);
            //verify the text You added Cronus Yoga Pant to your shopping cart.
            isTextDisplayed(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"),"You added Cronus Yoga Pant to your shopping cart.");
            // click on shopping cart link in to message
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
            // verify the text shopping cart.
            isTextDisplayed(By.xpath("//span[@class='base']"),"Shopping Cart");
            // verify the text Cronus Yoga Pant
            isTextDisplayed(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");
            // verify the text '32'.
            isTextDisplayed(By.xpath("//dd[contains(text(),'32')]"),"32");
            // verify the text Black
            isTextDisplayed(By.xpath("//dd[contains(text(),'Black')]"),"Black");
        }
        @After
        public void tearClose(){
            closeBrowser();}
    }


