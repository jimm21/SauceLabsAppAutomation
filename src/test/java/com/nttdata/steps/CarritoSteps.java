package com.nttdata.steps;

import com.nttdata.screens.CarritoScreen;
import com.nttdata.screens.DetailProductScreen;
import com.nttdata.screens.ProductsScreen;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

public class CarritoSteps {

    ProductsScreen productsScreen;
    DetailProductScreen deatilProductScreen;
    CarritoScreen carritoScreen;

    private static final Log log = LogFactory.getLog(CarritoSteps.class);

    public String producto;
    public int unidades;

    public void validateProductsScreenDisplay() {
        Assert.assertTrue("No se cargó la pantalla de productos",
                productsScreen.isSectionTitleDisplayed());
    }

    public void validateCargaProductos() {
        Assert.assertTrue("No se cargaron los productos correctamente",
                productsScreen.isProductsContainerDisplayed() &&
                productsScreen.isProductNameDisplayed());
        Assert.assertEquals("El nombre del 1er producto no es el esperado",
                "Sauce Labs Backpack",
                productsScreen.getProductaNameText());
    }

    public void agregarProductoAlCarrito(int unidades, String producto) {
        this.producto = producto;
        this.unidades = unidades;
        productsScreen.selectProduct(producto);
        Assert.assertTrue("Detalle del producto no cargo", deatilProductScreen.isProductTitleDisplayed());
        deatilProductScreen.setProductQuantity(unidades);
        deatilProductScreen.clickAddToCartButton();
        deatilProductScreen.clickCarritoButton();
    }

    public void validarCarritoActualizado() {
        Assert.assertTrue("No se cargo la seccion del carrito o el producto no se agrego correctamente", carritoScreen.isCarritoTitleDisplayed());

        log.info("Producto: "+this.producto);
        log.info("Unidades: "+this.unidades);
        log.info("Nombre del producto en el carrito: "+carritoScreen.getProductNameText());
        log.info("Cantidad del producto en el carrito: "+carritoScreen.getProductQuantityText());

        Assert.assertEquals("El producto no se agrego correctamente al carrito",
                this.producto+String.valueOf(this.unidades),
                carritoScreen.getProductNameText()+carritoScreen.getProductQuantityText());

        // Timer para visualizar el carrito
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
