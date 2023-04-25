package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Mouse hover on Gear menu
        mouseHoverToElement(By.linkText("Gear"));
        // click on Bags
        mouseHoverToElementAndClick(By.linkText("Bags"));
        // click on product name Overnight Duffle
        clickOnElement(By.linkText("Overnight Duffle"));
        //verify  the text Overnight Duffle
        isTextDisplayed(By.xpath("//span[contains(text(),'Overnight Duffle')]"), "Overnight Duffle");
        // change Qty 3
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        // click on Add to cart
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        Thread.sleep(1000);
        // verify the text You added Overnight Duffle to your shopping cart
        isTextDisplayed(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"), "You added Overnight Duffle to your shopping cart");
        // click on shopping cart link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the product name ‘Overnight Duffle’
        isTextDisplayed(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"), "Overnight Duffle");
        // verify the Qty is 3
        isTextDisplayed(By.xpath("//input[@id='cart-item-103032-qty']"), "3");
        // verify the product price '$135.00'
        isTextDisplayed(By.xpath("//span[contains(text(),'$135.00')]"), "$135.00");
        // change Qty to '5'
        sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");
        // click on Update shopping Cart button
        clickOnElement(By.xpath("//span[contains(text(),'Update')]"));
        Thread.sleep(1000);
        // verify the product price '$225.00'
        isTextDisplayed(By.xpath("//span[contains(text(),'$225.00')]"), "$225.00");
    }
}
