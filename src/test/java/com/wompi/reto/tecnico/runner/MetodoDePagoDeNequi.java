package com.wompi.reto.tecnico.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/metodo_de_pago_de_nequi.feature",
        glue="com.wompi.reto.tecnico.stepdefinitions",
        snippets= CucumberOptions.SnippetType.CAMELCASE
)
public class MetodoDePagoDeNequi {
}
