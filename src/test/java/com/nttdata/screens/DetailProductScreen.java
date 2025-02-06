package com.nttdata.screens;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailProductScreen extends PageObject {

    private static final Log log = LogFactory.getLog(DetailProductScreen.class);

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/productTV\"]")
    private WebElement productTitle;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement carritoButton;

    public boolean isProductTitleDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.isDisplayed();
    }

    public void setProductQuantity(int quantity){
        for(int i = 1; i < quantity; i++){
            increaseQuantityButton.click();
            waitABit(1000);
        }
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public void clickCarritoButton(){
        carritoButton.click();
    }

}
