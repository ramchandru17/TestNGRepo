package de.flaconi.tests;

import de.flaconi.common.Base;

import de.flaconi.pages.CartPage;
import de.flaconi.pages.HomePage;
import de.flaconi.pages.ProductPage;
import de.flaconi.pages.SearchResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;

public class PurchasePerfume extends Base {
    @BeforeTest
    public void startTest() throws MalformedURLException {
        startBrowser();
    }

    @Test
    public void addPerfumeToCart() throws Exception {
        HomePage homePage = new HomePage();
        SearchResult searchResult = new SearchResult();
        ProductPage productPage=new ProductPage();
        CartPage cartPage=new CartPage();

        openFlaconi();
        homePage.verifyHomePage();
        homePage.searchProduct(product);
        searchResult.verifySearchPage();
        searchResult.selectProduct();
        productPage.verifyProductPage();
        productPage.addProductToCart();
        cartPage.verifyProductInCart(product);
    }
    @AfterTest
    public void endTest()throws IOException {
        exitBrowser();
    }
}
