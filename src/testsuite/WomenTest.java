package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {

    String baseUrl = " https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        // Mouse hover on women menu
        mouseHoverToElement(By.linkText("Women"));
        //Mouse hover on tops
        mouseHoverToElement(By.linkText("Tops"));
        // click on Jackets
        mouseHoverToElementAndClick(By.linkText("Jackets"));
        Thread.sleep(1000);
        // Storing jackets names in list for Sorting
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> beforeSortJacketsValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortJacketsValue.add(value.getText());
        }
        // Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Product Name");
        Thread.sleep(1000);
        // After Sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//strong[@class='product name product-item-name']//a"));
        List<String> afterSortJacketsValue1 = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterSortValue) {
            afterSortJacketsValue1.add(value1.getText());
        }
        // Sort value for comparison
        beforeSortJacketsValue.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        // Verify the products name display in alphabetical order
        Assert.assertEquals(beforeSortJacketsValue, afterSortJacketsValue1);
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        // Mouse hover on women menu
        mouseHoverToElement(By.linkText("Women"));
        //Mouse hover on tops
        mouseHoverToElement(By.linkText("Tops"));
        // click on Jackets
        mouseHoverToElementAndClick(By.linkText("Jackets"));
        Thread.sleep(1000);
        // Storing jackets names in list for Sorting
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> beforeSortJacketsValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortJacketsValue.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='sorter'])[1]"), "Price");
        Thread.sleep(1000);
        // After Sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span"));
        List<Double> afterSortJacketsValue2 = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterSortValue) {
            afterSortJacketsValue2.add(Double.valueOf(value1.getText().replace("$", "")));
        }
        Collections.sort(beforeSortJacketsValue);// Ascending order
        // Verify the products price display in Low to High
        Assert.assertEquals(beforeSortJacketsValue, afterSortJacketsValue2);
    }

    @After
    public void tearClose() {
        closeBrowser();
    }

}

