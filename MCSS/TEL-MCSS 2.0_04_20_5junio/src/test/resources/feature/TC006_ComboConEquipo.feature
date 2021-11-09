Feature: Flujo de Alta Combo MCSS

  @SmokeTest
  Scenario Outline: Alta Combo con equipo financiado para cliente existente que no tiene suscripciones asignadas, ciclo 99 dummy CE - No desea factura
    Given Ingreso al login de MCSS con Dealer User "<Id>"
    And Ingreso al login de Mimovistar con "<Id>"
    And Seleccionar equipo "<Id>"
    And Seleccionar plan "<Id>"
    When Valido identidad del cliente con el "<Id>" y genero recibos en Postpago
    Then Cierro el Alta Postpago del cliente con "<Id>"
    Examples:
      | Id |
      | 6  |
