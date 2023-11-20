package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransaccionAprobada {

    public  static final Target MENSAJE_EXITOSO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[contains(text(),'aprobada')]"));

    //*[contains(text(),'Continuar')]
    private TransaccionAprobada()
    {

    }
}
