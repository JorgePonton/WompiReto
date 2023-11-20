package com.wompi.reto.tecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class PaymentStatusQuestion implements Question<Boolean> {

    private final String textoEsperado;
    private final Target elemento;

    public PaymentStatusQuestion(String textoEsperado, Target elemento) {
        this.textoEsperado = textoEsperado;
        this.elemento = elemento;
    }

    public static PaymentStatusQuestion conTextoEsperadoYElemento(String textoEsperado, Target elemento) {
        return new PaymentStatusQuestion(textoEsperado, elemento);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(elemento, isVisible()).forNoMoreThan(60).seconds());
        String textoActual = elemento.resolveFor(actor).getText();
        System.out.println("Hola mundoaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(textoActual);
        System.out.println(textoEsperado);
        System.out.println(elemento);
        return textoActual.contains(textoEsperado);
    }
}
