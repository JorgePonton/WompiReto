package com.wompi.reto.tecnico.task;


import com.wompi.reto.tecnico.model.ClientDataModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.wompi.reto.tecnico.userinterfaces.InformationClient.*;
import static com.wompi.reto.tecnico.userinterfaces.NequiInterface.*;
import static com.wompi.reto.tecnico.userinterfaces.PaymentMethods.PAGO_CON_NEQUI;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NequiPaymentMethod implements Task {

    private ClientDataModel data;

    public NequiPaymentMethod(ClientDataModel data)
    {
        this.data=data;
    }



    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(PAGO_CON_NEQUI),
                Enter.theValue(data.getStrCorreo()).into(CORREO_ELECTRONICO),
                Enter.theValue(data.getStrNameAndLastName()).into(NOMBRES_Y_APELLIDOS),
                Enter.theValue(data.getPhoneNumber()).into(NUMERO),
                Click.on(CONTINUAR_CON_TU_PAGO_PRIMERO),
                Click.on(USAR_EL_MISMO),
                Click.on(ACEPTAR_TERMINOS));

        actor.attemptsTo(WaitUntil.the(CONTINUAR_CON_ELPAGO, isVisible()).forNoMoreThan(50).seconds());


        actor.attemptsTo(
                Click.on((CONTINUAR_CON_ELPAGO))
        );
    }


    public  static NequiPaymentMethod nequiTest(ClientDataModel data)
    {
        return instrumented(NequiPaymentMethod.class, data);
    }
}

