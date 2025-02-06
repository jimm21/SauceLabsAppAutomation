package com.nttdata.screens;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;

import java.util.List;

public class ProductsScreen extends PageObject {

    private static final Log log = LogFactory.getLog(ProductsScreen.class);

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement sectionTitle;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement productsContainer;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/titleTV\" and @text=\"Sauce Labs Backpack\"]")
    private WebElement productName;

    List<WebElement> products = getDriver().findElements(By.xpath("//android.widget.ImageView[@content-desc]"));
    private WebElement product;

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

    private void findProductByName(String productName){
        for(WebElement product : products){
            if(product.getAttribute("content-desc").equals(productName)){
                this.product = product;
                break;
            }
        }
    }

    public void selectProduct(String producto){
        findProductByName(producto);
        if (product != null) {
            product.click();
        } else {
            throw new RuntimeException("Product not found: " + producto);
        }
    }

}
