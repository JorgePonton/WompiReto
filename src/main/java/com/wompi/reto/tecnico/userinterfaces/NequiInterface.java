package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class NequiInterface {


    public  static final Target USAR_EL_MISMO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id='phoneNumber']"));



    public  static final Target ACEPTAR_TERMINOS = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id='acceptance']"));


    public  static final Target CONTINUAR_CON_ELPAGO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div/form/div[2]/button"));






    private NequiInterface ()
    {

    }
}
