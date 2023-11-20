package com.wompi.reto.tecnico.stepdefinitions;

import com.wompi.reto.tecnico.model.ClientDataModel;
import com.wompi.reto.tecnico.questions.PaymentStatusQuestion;
import com.wompi.reto.tecnico.task.PsePaymentMethod;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.wompi.reto.tecnico.userinterfaces.PaymentStatus.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class MetodoDePagoPseStepDefinition {

    private String Banco_Error = "Error";
    private String Banco_Aprueba ="Aprobada";
    private String Banco_Rechaza = "Rechazada";
    @When("el usuario elije la opcion de Pse e ingresa los siguientes datos ademas elije la opcion que aprueba")
    public void elUsuarioElijeLaOpcionDePseEIngresaLosSiguientesDatosAdemasElijeLaOpcionQueAprueba(DataTable data) {

         theActorInTheSpotlight().attemptsTo(PsePaymentMethod.psePaymentMethod(ClientDataModel.setData(data).get(0),Banco_Aprueba));
    }

    @Then("deberia existir un mensaje de pse transaccion aprobada que diga {string}")
    public void deberiaExistirUnMensajeDePseTransaccionAprobada(String string) {
        // Write code here that turns the phrase above into concrete actions
        theActorInTheSpotlight().should(seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(string,TRANSACCION_APROBADA_PAGO_)));

    }



    @When("el usuario elije la opcion de Pse e ingresa los siguientes datos ademas elije la opcion que da error")
    public void elUsuarioElijeLaOpcionDePseEIngresaLosSiguientesDatosAdemasElijeLaOpcionQueDaError(io.cucumber.datatable.DataTable data) {
        theActorInTheSpotlight().attemptsTo(PsePaymentMethod.psePaymentMethod(ClientDataModel.setData(data).get(0),Banco_Error));

    }
    @Then("deberia existir un mensaje de pse transaccion erronea {string}")
    public void deberiaExistirUnMensajeDePseTransaccionErronea(String string) {
        theActorInTheSpotlight().should(seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(string,TRANSACCION_FALLIDA_PAGO)));
    }


    @When("el usuario elije la opcion de Pse e ingresa los siguientes datos ademas elije la opcion que declina")
    public void elUsuarioElijeLaOpcionDePseEIngresaLosSiguientesDatosAdemasElijeLaOpcionQueDeclina(io.cucumber.datatable.DataTable data) {

        theActorInTheSpotlight().attemptsTo(PsePaymentMethod.psePaymentMethod(ClientDataModel.setData(data).get(0),Banco_Rechaza));

    }

    @Then("deberia existir un mensaje de pse transaccion declinada {string}")
    public void deberiaExistirUnMensajeDePseTransaccionDeclinada(String string) {
        theActorInTheSpotlight().should(seeThat(PaymentStatusQuestion.conTextoEsperadoYElemento(string,TRANSACCION_DECLINADA_PAGO)));
    }


}
