package de.flaconi.pages;

import de.flaconi.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage extends Base {

    public CartPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@class='cart-details']//div[@class='details']//a")
    WebElement cartProduct;

    public void verifyProductInCart(String productName){
        String tmpStr=cartProduct.getText();
        Assert.assertTrue(tmpStr.contains(productName),"Wrong Product is added to the Cart");
    }

}
