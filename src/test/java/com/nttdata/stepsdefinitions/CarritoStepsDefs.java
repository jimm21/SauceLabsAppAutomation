package com.nttdata.stepsdefinitions;

import com.nttdata.steps.CarritoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CarritoStepsDefs {

    @Steps
    CarritoSteps carritoSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoy_en_la_aplicación_de_sauce_labs() {
        carritoSteps.validateProductsScreenDisplay();
    }
    @And("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {

    }
    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(Integer unidades, String producto) {

    }
    @Then("valido el carrito de compra actualice correctamente")
    public void valido_el_carrito_de_compra_actualice_correctamente() {

    }
}
