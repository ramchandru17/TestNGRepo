package de.flaconi.pages;

import de.flaconi.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductPage extends Base {
    public ProductPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//button[@title='In den Warenkorb']")
    WebElement addToCart;
    @FindBy(linkText="Warenkorb Ansehen")
    WebElement goToCart;

    public void verifyProductPage(){
        Assert.assertTrue(addToCart.isDisplayed(),"Product Page is not loaded successfully");
    }
    public void addProductToCart(){
        addToCart.click();
        goToCart.click();

    }

}
