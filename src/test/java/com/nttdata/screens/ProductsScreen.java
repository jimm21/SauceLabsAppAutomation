package com.nttdata.screens;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

public class ProductsScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement sectionTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement productsContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement productName;

    private WebElement product;

    private void findProductByName(String productName){
        this.product =  getDriver().findElement(By.xpath("//android.widget.ImageView[@content-desc=\""+productName+"\"]"));
    }

    public boolean isSectionTitleDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(sectionTitle));
        return sectionTitle.isDisplayed();
    }

    public boolean isProductsContainerDisplayed(){
        return productsContainer.isDisplayed();
    }

    public boolean isProductNameDisplayed(){
        return productName.isDisplayed();
    }

    public String getProductaNameText(){
        return productName.getText();
    }

    public void selectProduct(String producto){
        findProductByName(producto);
        product.click();
    }

}
