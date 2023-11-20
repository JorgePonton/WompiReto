Feature: yo como usario quiero automatizar la plataforma WOMPI mediante el metodo de pago PSE
  requiero crear 3 casos de pruebas donde se evaluen los tres estados de una transaccion aprobado error y declinado

  Background:
    Given el usuario abre la pagina del reto


  Scenario: Banco que aprueba
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usuario elije la opcion de Pse e ingresa los siguientes datos ademas elije la opcion que aprueba
      |strCorreo|strNameAndLastName|phoneNumber|cedulaCiudadania|
      |jorgeponton@yandex.com|jorge david ponton|3992222222|8907643|
    Then deberia existir un mensaje de pse transaccion aprobada que diga 'aprobada'

  Scenario: Banco que da error
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usuario elije la opcion de Pse e ingresa los siguientes datos ademas elije la opcion que da error
      |strCorreo|strNameAndLastName|phoneNumber|cedulaCiudadania|
      |jorgeponton@yandex.com|jorge david ponton|3992222222|8907643|
    Then deberia existir un mensaje de pse transaccion erronea 'error'


  Scenario: Banco que declina
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usuario elije la opcion de Pse e ingresa los siguientes datos ademas elije la opcion que declina
      |strCorreo|strNameAndLastName|phoneNumber|cedulaCiudadania|
      |jorgeponton@yandex.com|jorge david ponton|3992222222|8907643|
    Then deberia existir un mensaje de pse transaccion declinada 'declinada'


