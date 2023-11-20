Feature: yo como usario quiero automatizar la plataforma WOMPI mediante el metodo de pago QR
  requiero crear 3 casos de pruebas donde se evaluen los tres estados de una transaccion aprobado error y declinado

  Background:
    Given el usuario abre la pagina del reto


  Scenario: realizar un pago exitoso mediante la opcion de qr
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usaurio elige la opcion de qr e ingresa los siguientes datos
      |strCorreo|strNameAndLastName|phoneNumber|
      |jorgeponton@yandex.com|jorge david ponton|3991111111|
    Then deberia existir un mensaje de transaccion qr aprobada que diga 'aprobada'

  Scenario: realizar un pago erroneo con qr
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usaurio elige la opcion de qr e ingresa los siguientes datos ademas selecciona banco error
      |strCorreo|strNameAndLastName|phoneNumber|
      |jorgeponton@yandex.com|jorge david ponton|3008281465|
    Then deberia existir un mensaje de transaccion qr con error 'error'


  Scenario: realizar un pago declinado con qr
    Given el usuario ingresa el monto de '60000' pesos y procede a continuar con el pago
    When  el usaurio elige la opcion de qr e ingresa los siguientes datos ademas selecciona banco declina
      |strCorreo|strNameAndLastName|phoneNumber|
      |jorgeponton@yandex.com|jorge david ponton|3992222222|
    Then deberia existir un mensaje de transaccion qr declinada 'declinada'
