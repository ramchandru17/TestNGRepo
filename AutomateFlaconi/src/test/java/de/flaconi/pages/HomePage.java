package de.flaconi.pages;

import de.flaconi.common.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Base {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='main-navigation']//a[@title='Marken']")
    WebElement brandMenu;
    @FindBy(xpath="(//*[@id='main-navigation']//a[@title='Parfum'])[1]")
    WebElement perfumeMenu;
    @FindBy(className="cookie-box__close")
    WebElement cookieClose;
    @FindBy(xpath="//*[@id='autosuggest-form-header']/input")
    WebElement searchBar;


    public void verifyHomePage(){
        Assert.assertTrue(brandMenu.isDisplayed()&&perfumeMenu.isDisplayed(),"Flaconi Home Page is not loaded successfully");
    }
    public void searchProduct(String productName){
        cookieClose.click();
        searchBar.click();
        searchBar.sendKeys(productName+ Keys.ENTER);
    }

}
