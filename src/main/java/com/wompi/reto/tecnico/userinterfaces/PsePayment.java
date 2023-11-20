package com.wompi.reto.tecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PsePayment {

    public  static final Target ESCOGE_TU_BANCO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"financialInstitutionCode\"]"));

    public  static final Target BANCO_APRUEBA = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"financialInstitutionCode\"]/option[2]"));



    public  static final Target BANCO_DECLINA = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"financialInstitutionCode\"]/option[3]"));



    public  static final Target BANCO_ERROR = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"financialInstitutionCode\"]/option[4]"));


    public  static final Target TIPO_DOCUMENTO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"userLegalIdType\"]"));

    public  static final Target CC = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"userLegalIdType\"]/option[2]"));


    public  static final Target DOCUMENTO = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id=\"userLegalId\"]"));


    public  static final Target ACEPTAR = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id='acceptance']"));


    public  static final Target CONTINUAR_CON_EL_PAGO_PSE = Target.the("Campo para ingresar el monto a pagar").located(By.xpath("//*[@id='app']/div[2]/div/div[2]/div/form/div[4]/button"));



    private  PsePayment(){
    }

}
