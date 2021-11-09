Feature: Flujo de Alta Prepago MCSS

  @SmokeTest
  Scenario Outline: Como usuario activo, hago una alta prepago solo chip
    Given Ingreso al login de MCSS con Dealer User "<Id>"
    And Ingreso al login de Mimovistar con "<Id>"
    And Seleccion el Alta Prepago solo chip con "<Id>"
    When Valido identidad del cliente con el "<Id>" y genero recibos en Prepago
    Then Cierro el alta prepago del cliente con "<Id>"
    Examples:
      | Id |
      | 3  |

