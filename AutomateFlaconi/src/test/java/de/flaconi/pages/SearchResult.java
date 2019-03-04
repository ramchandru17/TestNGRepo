package de.flaconi.pages;

import de.flaconi.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchResult extends Base {
public SearchResult(){
    PageFactory.initElements(driver, this);

}
    @FindBy(xpath="(//div[@class='product-item-box']/div/a)[1]")
    WebElement firstItem;

    public void verifySearchPage(){
        Assert.assertTrue(firstItem.isDisplayed(),"Search Result Page is not loaded successfully");

    }
    public void selectProduct(){
        firstItem.click();

    }


}
