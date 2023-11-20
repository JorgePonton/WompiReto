package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class QrPaymentInterface {

    public  static final Target TRANSACCION_OPCIONES_QR = Target.the("Transacciones Opciones").located(By.xpath("//*[@name='sandboxStatusQR']"));

    public  static final Target TRANSACCION_APROBADA_QR = Target.the("TRANSACCION APROBADA QR").located(By.xpath("//*[@id='sandboxStatusQR']/option[1]"));

    public  static final Target TRANSACCION_DECLINADA_QR = Target.the("TRANSACCION DECLINADA QR").located(By.xpath("//*[@id='sandboxStatusQR']/option[2]"));

    public  static final Target TRANSACCION_ERROR_QR = Target.the("TRANSACCION ERROR QR").located(By.xpath("//*[@id='sandboxStatusQR']/option[3]"));

    public  static final Target TERMINOS_Y_CONDICIONES_QR = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id='acceptance']"));

    public  static final Target CONTINUAR_CON_EL_PAGO_QR = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/form/div[5]/button"));


    public QrPaymentInterface()
    {}
}
