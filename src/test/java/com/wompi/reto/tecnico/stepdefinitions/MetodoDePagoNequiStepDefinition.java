package com.wompi.reto.tecnico.stepdefinitions;

import com.wompi.reto.tecnico.model.ClientDataModel;
import com.wompi.reto.tecnico.questions.PaymentStatusQuestion;
import com.wompi.reto.tecnico.task.NequiPaymentMethod;
import com.wompi.reto.tecnico.task.PaymentValue;
import com.wompi.reto.tecnico.utils.MyChromeDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.wompi.reto.tecnico.userinterfaces.PaymentStatus.*;
import static com.wompi.reto.tecnico.utils.Constant.ACTOR;
import static com.wompi.reto.tecnico.utils.Constant.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MetodoDePagoNequiStepDefinition {
    @Before
    public void SetUp(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("el usuario abre la pagina del reto")
    public void elUsuarioAbreLaPaginaDelReto() {
        theActorCalled(ACTOR);
        theActorInTheSpotlight().can(BrowseTheWeb.with(MyChromeDriver.chromeHisBrowserWeb().onTheUrl(URL)));

    }


    @Given("el usuario ingresa el monto de {string} pesos y procede a continuar con el pago")
    public void elUsuarioIngresaElMontoDePesosYProcedeAContinuarConElPago(String valor) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(PaymentValue.paymentValue(valor));
    }


    @When("el usaurio elige la opcion de nequi e ingresa los siguientes datos")
    public void elUsaurioEligeLaOpcionDeNequiEIngresaLosSiguientesDatos(DataTable data) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().attemptsTo(NequiPaymentMethod.nequiTest(ClientDataModel.setData(data).get(0)));

    }

    @Then("deberia existir un mensaje que diga {string}")
    public void deberiaExistirUnMensajeQueDiga(String esperado) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(
                seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(esperado,TRANSACCION_APROBADA_PAGO_))
        );
    }


    @Then("deberia existir un mensaje de transaccion con error {string}")
    public void deberiaExistirUnMensajeDeTransaccionConError(String error) {
        // Write code here that turns the phrase above into concrete actions
       theActorInTheSpotlight().should(
               seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(error,TRANSACCION_FALLIDA_PAGO))
       );
    }

    @Then("deberia existir un mensaje de transaccion declinada {string}")
    public void deberiaExistirUnMensajeDeTransaccionDeclinada(String declinada) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(
                seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(declinada,TRANSACCION_DECLINADA_PAGO))
        );
    }





}
