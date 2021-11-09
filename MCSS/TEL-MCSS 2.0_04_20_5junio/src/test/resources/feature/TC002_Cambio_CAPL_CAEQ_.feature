Feature: Flujo de Cambio MCSS

  @SmokeTest
  Scenario Outline: CAEQ + CAPL + FINANCIAMIENTO 12 CUOTAS
    Given Ingreso al login de MCSS con Dealer User "<Id>"
    And Ingreso al login de Mimovistar con "<Id>"
    And Consulto suscripcion y selecciono Cambio de quipo y Plan con "<Id>"
#    When Valido identidad del cliente con el "<Id>" y genero recibos
#	Then Cierro el alta prepago del cliente con "<Id>"
    Examples:
      | Id |
      | 6  |
