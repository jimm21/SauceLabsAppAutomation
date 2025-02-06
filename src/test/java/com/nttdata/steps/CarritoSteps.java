package com.nttdata.steps;

import com.nttdata.screens.ProductsScreen;
import org.junit.Assert;

public class CarritoSteps {

    ProductsScreen productsScreen;

    public void validateProductsScreenDisplay() {
        Assert.assertTrue(productsScreen.isSectionTitleDisplayed());
    }

}
