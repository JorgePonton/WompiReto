package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class InformationClient {

    public  static final Target CORREO_ELECTRONICO = Target.the("CAMPO CORRESPONDIENTE AL CORREO").located(By.xpath("//*[@name='email']"));

    public  static final Target NOMBRES_Y_APELLIDOS = Target.the("CAMPO INGRESO NOMBRES Y APELLIDOS").located(By.xpath("//*[@id='fullName']"));

    public  static final Target NUMERO = Target.the("CAMPO PARA INGRESAR NUMERO").located(By.xpath("//*[@id='number']"));

    public  static final Target CONTINUAR_CON_TU_PAGO_PRIMERO = Target.the("BOTON CONTINUAR CON EL PAGO").located(By.xpath("//*[@class='submit-button button-main padding_button']"));


    private InformationClient()
    {}
}
