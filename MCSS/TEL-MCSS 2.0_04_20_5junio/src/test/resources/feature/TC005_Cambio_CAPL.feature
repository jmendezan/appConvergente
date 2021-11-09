Feature: Flujo de Cambio MCSS

  @SmokeTest
  Scenario Outline: Cambio de Plan Por Canal DLC
    Given Ingreso al login de MCSS con Dealer User "<Id>"
    And Ingreso al login de Mimovistar con "<Id>"
    And Consulto suscripcion y selecciono Cambio de Plan con "<Id>"
    When Valido identidad del cliente con el "<Id>" para cambio de Plan
	Then Cierro el CAPL del cliente "<Id>" y obtengo numero de orden
    Examples:
      | Id |
      | 3  |