Feature: Compra de paquetes

  @SmokeTest
  Scenario Outline: Compra paquete de voz pago al recibo
    Given Ingreso a SelfService con cliente "<Id>"
    When Elijo el tipo de tansacción - Compra paquete de voz pago al recibo "<Id>" y realizo operación
    Then Obtengo código de transacción "<Id>"
    Examples:
      | Id |
      | 1  |
