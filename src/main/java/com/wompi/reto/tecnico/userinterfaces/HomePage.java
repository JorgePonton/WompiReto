package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage {

    public  static final Target INGRESO_MONTO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@name='amount']"));
    public  static final Target BOTON_CONTINUAR = Target.the("BOTON CONTINUAR ").located(By.xpath("//*[contains(text(),'Continuar')]"));


    private HomePage()
    {

    }
}
