package com.wompi.reto.tecnico.stepdefinitions;

import com.wompi.reto.tecnico.model.ClientDataModel;
import com.wompi.reto.tecnico.questions.PaymentStatusQuestion;
import com.wompi.reto.tecnico.task.PsePaymentMethod;
import com.wompi.reto.tecnico.task.QrPaymentMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.wompi.reto.tecnico.userinterfaces.PaymentStatus.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MetodoDePagoQrStepDefinition {


    private String Banco_Error = "Error";
    private String Banco_Aprueba ="Aprobada";
    private String Banco_Rechaza = "Rechazada";
    @When("el usaurio elige la opcion de qr e ingresa los siguientes datos")
    public void elUsaurioEligeLaOpcionDeQrEIngresaLosSiguientesDatos(DataTable data) {

        theActorInTheSpotlight().attemptsTo(QrPaymentMethod.qrPaymentMethod(ClientDataModel.setData(data).get(0),Banco_Aprueba));

    }


    @When("el usaurio elige la opcion de qr e ingresa los siguientes datos ademas selecciona banco error")
    public void elUsaurioEligeLaOpcionDeQrEIngresaLosSiguientesDatosAdemasSeleccionaBancoError(DataTable data) {

        theActorInTheSpotlight().attemptsTo(QrPaymentMethod.qrPaymentMethod(ClientDataModel.setData(data).get(0),Banco_Error));

    }


    @When("el usaurio elige la opcion de qr e ingresa los siguientes datos ademas selecciona banco declina")
    public void elUsaurioEligeLaOpcionDeQrEIngresaLosSiguientesDatosAdemasSeleccionaBancoErrorAdemasSeleccionaBancoDeclina(DataTable data) {

        theActorInTheSpotlight().attemptsTo(QrPaymentMethod.qrPaymentMethod(ClientDataModel.setData(data).get(0),Banco_Rechaza));

    }

    @Then("deberia existir un mensaje de transaccion qr con error {string}")
    public void deberiaExistirUnMensajeDeTransaccionQrConError(String string) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(string,TRANSACCION_FALLIDA_PAGO)));

    }

    @Then("deberia existir un mensaje de transaccion qr declinada {string}")
    public void deberiaExistirUnMensajeDeTransaccionQrDeclinada(String string) {
        theActorInTheSpotlight().should(seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(string,TRANSACCION_DECLINADA_PAGO)));

    }



    @Then("deberia existir un mensaje de transaccion qr aprobada que diga {string}")
    public void deberiaExistirUnMensajeDeTransaccionQrQueDiga(String string) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(string,TRANSACCION_APROBADA_PAGO_)));

    }



}
