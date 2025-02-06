package com.nttdata.screens;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class ProductsScreen extends PageObject {

    @AndroidFindBy(accessibility = "Sauce Labs Backpack")
    private WebElement sectionTitle;

    public boolean isSectionTitleDisplayed(){
        return sectionTitle.isDisplayed();
    }

}
