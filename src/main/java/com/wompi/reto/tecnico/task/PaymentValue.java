package com.wompi.reto.tecnico.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.wompi.reto.tecnico.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaymentValue implements Task {
    private final String montoAPagar;

    public PaymentValue(String montoAPagar) {
        this.montoAPagar = montoAPagar;

    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Click.on(INGRESO_MONTO),
                Enter.theValue(montoAPagar).into(INGRESO_MONTO),

                Click.on(BOTON_CONTINUAR)
        );
    }
    public  static PaymentValue paymentValue(String montoAPagar)
    {
        return instrumented(PaymentValue.class,montoAPagar);
    }
}
