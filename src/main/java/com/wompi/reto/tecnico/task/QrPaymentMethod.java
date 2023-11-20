package com.wompi.reto.tecnico.task;

import com.wompi.reto.tecnico.model.ClientDataModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.wompi.reto.tecnico.userinterfaces.InformationClient.*;
import static com.wompi.reto.tecnico.userinterfaces.PaymentMethods.PAGO_CON_PSE;
import static com.wompi.reto.tecnico.userinterfaces.PaymentMethods.PAGO_CON_QR;
import static com.wompi.reto.tecnico.userinterfaces.PaymentStatus.*;
import static com.wompi.reto.tecnico.userinterfaces.PsePayment.*;
import static com.wompi.reto.tecnico.userinterfaces.PsePayment.CONTINUAR_CON_EL_PAGO_PSE;
import static com.wompi.reto.tecnico.userinterfaces.QrPaymentInterface.*;
import static com.wompi.reto.tecnico.utils.Constant.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class QrPaymentMethod implements Task {

    private ClientDataModel data;
    private String banco;
    public QrPaymentMethod(ClientDataModel data, String banco)
    {
        this.data=data;
        this.banco=banco;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PAGO_CON_QR),
                Enter.theValue(data.getStrCorreo()).into(CORREO_ELECTRONICO),
                Enter.theValue(data.getStrNameAndLastName()).into(NOMBRES_Y_APELLIDOS),
                Enter.theValue(data.getPhoneNumber()).into(NUMERO),
                Click.on(TERMINOS_Y_CONDICIONES_QR)
        );

        switch (banco) {
            case TRANSACCION_APRUEBA:
                actor.attemptsTo(
                        Click.on(TRANSACCION_OPCIONES_QR),
                        Click.on(TRANSACCION_APROBADA_QR)

                );
                actor.attemptsTo(WaitUntil.the(CONTINUAR_CON_EL_PAGO_QR, isClickable()).forNoMoreThan(50).seconds());
                actor.attemptsTo(Click.on(CONTINUAR_CON_EL_PAGO_QR));
                actor.attemptsTo(WaitUntil.the(TRANSACCION_APROBADA_PAGO_, isVisible()).forNoMoreThan(60).seconds());

                break;

            case TRANSACCION_RECHAZA:
                actor.attemptsTo(
                        Click.on(TRANSACCION_OPCIONES_QR),
                        Click.on(TRANSACCION_DECLINADA_QR)

                );
                actor.attemptsTo(WaitUntil.the(CONTINUAR_CON_EL_PAGO_QR, isVisible()).forNoMoreThan(50).seconds());
                actor.attemptsTo(Click.on(CONTINUAR_CON_EL_PAGO_QR));
                actor.attemptsTo(WaitUntil.the(TRANSACCION_DECLINADA_PAGO, isVisible()).forNoMoreThan(60).seconds());

                break;


            case TRANSACCION_ERROR:
                actor.attemptsTo(
                        Click.on(TRANSACCION_OPCIONES_QR),
                        Click.on(TRANSACCION_ERROR_QR)
                );
                actor.attemptsTo(WaitUntil.the(CONTINUAR_CON_EL_PAGO_QR, isVisible()).forNoMoreThan(50).seconds());
                actor.attemptsTo(Click.on(CONTINUAR_CON_EL_PAGO_QR));
                actor.attemptsTo(WaitUntil.the(TRANSACCION_FALLIDA_PAGO, isVisible()).forNoMoreThan(60).seconds());

                break;


            default:
                System.out.println("no existe ese banco");

        }

        }

    public  static QrPaymentMethod qrPaymentMethod(ClientDataModel data, String banco)
    {
        return instrumented(QrPaymentMethod.class, data, banco);
    }
}
