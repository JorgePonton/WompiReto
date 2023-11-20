package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentStatus {

    public  static final Target TRANSACCION_APROBADA_PAGO_ = Target.the("TRANSACCION APROBADA ").located(By.xpath("//*[contains(text(),'aprobada')]"));
    public  static final Target TRANSACCION_DECLINADA_PAGO = Target.the("MENSAJE TRANSACCION DECLINADA").located(By.xpath("//*[contains(text(),'declinada')]"));
    public static final  Target TRANSACCION_FALLIDA_PAGO = Target.the("MENSAJE TRANSACCION CON ERROR").located(By.xpath("//*[contains(text(),'con error')]"));


}
