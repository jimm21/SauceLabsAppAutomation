package com.nttdata.screens;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarritoScreen extends PageObject {

    private static final Log log = LogFactory.getLog(CarritoScreen.class);

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement carritoTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productName;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement productQuantity;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private WebElement noItemsTextElement;

    public boolean isCarritoTitleDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(carritoTitle));
        return carritoTitle.isDisplayed();
    }

    public boolean isNoItemsTextDisplayed(){
        return noItemsTextElement.isDisplayed();
    }

    public String getProductNameText(){
        return productName.getText();
    }

    public String getProductQuantityText(){
        return productQuantity.getText();
    }



}
