package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentMethods
{

    public  static final Target PAGO_CON_NEQUI = Target.the("PAGA CON TU CUENTA NEQUI").located(By.xpath("//*[contains(text(),'Paga con tu cuenta Nequi')]"));


    public  static final Target PAGO_CON_PSE = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[contains(text(),'Transfiere con tu cuenta de ahorros o corriente')]"));

    public  static final Target PAGO_CON_QR = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[contains(text(),'Paga con QR Bancolombia')]"));

    private PaymentMethods ()
    {

    }
}
