Feature: Automatizar transaciones por medio de pago nequi

     Background:
       Given el usuario abre la pagina del reto


    Scenario: realizar un pago exitoso mediante la opcion de nequi
      Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
      When  el usaurio elige la opcion de nequi e ingresa los siguientes datos
      |strCorreo|strNameAndLastName|phoneNumber|
      |jorgeponton@yandex.com|jorge david ponton|3991111111|
      Then deberia existir un mensaje que diga 'aprobada'

      Scenario: realizar un pago erroneo con nequi
        Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
        When  el usaurio elige la opcion de nequi e ingresa los siguientes datos
          |strCorreo|strNameAndLastName|phoneNumber|
          |jorgeponton@yandex.com|jorge david ponton|3008281465|
        Then deberia existir un mensaje de transaccion con error 'error'


  Scenario: realizar un pago declinado con nequi
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usaurio elige la opcion de nequi e ingresa los siguientes datos
      |strCorreo|strNameAndLastName|phoneNumber|
      |jorgeponton@yandex.com|jorge david ponton|3992222222|
    Then deberia existir un mensaje de transaccion declinada 'declinada'






