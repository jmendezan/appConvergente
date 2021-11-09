Feature: Validación del flujo de asistencia Como cliente movistar tengo problemas con mis servicio de internet y quiero asistencia a través de la app

#Como cliente movistar tengo problemas con mis servicio de internet y quiero asistencia a través de la app
  @Caso1

  Scenario Outline: Validar el acceso a trazabilidad al seleccionar seguimiento de mi averia
    Given   Cliente logeado en la app
    When    Click boton Empezar ahora
    And    En el login Iniciar Sesion llenar los datos del usuario "<caso_prueba>"
    And    Selecciona el boton Asistencia
     And     Cliente selecciona el boton Seguimiento de mi averia
   # Then    La app redirecciona a la pantalla de trazabilidad

    Examples:
      | caso_prueba |
      | 1           |

