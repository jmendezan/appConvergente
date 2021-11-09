Feature: Flujo de Alta Postpago MCSS

  @SmokeTest
  Scenario Outline: Como usuario activo, hago una alta postpago solo chip
    Given Ingreso al login de MCSS con Dealer User "<Id>"
    And Ingreso al login de Mimovistar con "<Id>"
    And Seleccion el Alta Postpago solo chip con "<Id>"
    When Valido identidad del cliente con el "<Id>" y genero recibos en Postpago
    Then Cierro el Alta Postpago del cliente con "<Id>"
    Examples:
      | Id |
      | 5  |
