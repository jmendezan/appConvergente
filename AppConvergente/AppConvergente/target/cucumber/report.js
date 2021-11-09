$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("APP_MovistarContigo.feature");
formatter.feature({
  "line": 1,
  "name": "Validación del flujo de asistencia Como cliente movistar tengo problemas con mis servicio de internet y quiero asistencia a través de la app",
  "description": "",
  "id": "validación-del-flujo-de-asistencia-como-cliente-movistar-tengo-problemas-con-mis-servicio-de-internet-y-quiero-asistencia-a-través-de-la-app",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 3,
      "value": "#Como cliente movistar tengo problemas con mis servicio de internet y quiero asistencia a través de la app"
    }
  ],
  "line": 6,
  "name": "Validar el acceso a trazabilidad al seleccionar seguimiento de mi averia",
  "description": "",
  "id": "validación-del-flujo-de-asistencia-como-cliente-movistar-tengo-problemas-con-mis-servicio-de-internet-y-quiero-asistencia-a-través-de-la-app;validar-el-acceso-a-trazabilidad-al-seleccionar-seguimiento-de-mi-averia",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@Caso1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Cliente logeado en la app",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Click boton Empezar ahora",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "En el login Iniciar Sesion llenar los datos del usuario \"\u003ccaso_prueba\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Selecciona el boton Asistencia",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Cliente selecciona el boton Seguimiento de mi averia",
  "keyword": "And "
});
formatter.examples({
  "comments": [
    {
      "line": 12,
      "value": "# Then    La app redirecciona a la pantalla de trazabilidad"
    }
  ],
  "line": 14,
  "name": "",
  "description": "",
  "id": "validación-del-flujo-de-asistencia-como-cliente-movistar-tengo-problemas-con-mis-servicio-de-internet-y-quiero-asistencia-a-través-de-la-app;validar-el-acceso-a-trazabilidad-al-seleccionar-seguimiento-de-mi-averia;",
  "rows": [
    {
      "cells": [
        "caso_prueba"
      ],
      "line": 15,
      "id": "validación-del-flujo-de-asistencia-como-cliente-movistar-tengo-problemas-con-mis-servicio-de-internet-y-quiero-asistencia-a-través-de-la-app;validar-el-acceso-a-trazabilidad-al-seleccionar-seguimiento-de-mi-averia;;1"
    },
    {
      "cells": [
        "1"
      ],
      "line": 16,
      "id": "validación-del-flujo-de-asistencia-como-cliente-movistar-tengo-problemas-con-mis-servicio-de-internet-y-quiero-asistencia-a-través-de-la-app;validar-el-acceso-a-trazabilidad-al-seleccionar-seguimiento-de-mi-averia;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 38756094300,
  "status": "passed"
});
formatter.before({
  "duration": 175650100,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Validar el acceso a trazabilidad al seleccionar seguimiento de mi averia",
  "description": "",
  "id": "validación-del-flujo-de-asistencia-como-cliente-movistar-tengo-problemas-con-mis-servicio-de-internet-y-quiero-asistencia-a-través-de-la-app;validar-el-acceso-a-trazabilidad-al-seleccionar-seguimiento-de-mi-averia;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@Caso1"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "Cliente logeado en la app",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "Click boton Empezar ahora",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "En el login Iniciar Sesion llenar los datos del usuario \"1\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Selecciona el boton Asistencia",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Cliente selecciona el boton Seguimiento de mi averia",
  "keyword": "And "
});
formatter.match({
  "location": "miMovistarStep.clienteLogeadoEnLaApp()"
});
formatter.result({
  "duration": 7870202300,
  "status": "passed"
});
formatter.match({
  "location": "miMovistarStep.clickBotonEmpezarAhora1()"
});
formatter.result({
  "duration": 6614367200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 57
    }
  ],
  "location": "miMovistarStep.loginIniciarSesion(String)"
});
formatter.result({
  "duration": 7912849900,
  "status": "passed"
});
formatter.match({
  "location": "miMovistarStep.seleccionaElBotonAsistencia()"
});
formatter.result({
  "duration": 12542533200,
  "status": "passed"
});
formatter.match({
  "location": "miMovistarStep.clienteSeleccionaElBotonSeguimientoDeMiAveria()"
});
formatter.result({
  "duration": 3865048400,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat appConvergente.steps.appConvergente.miMovistarStep.clienteSeleccionaElBotonSeguimientoDeMiAveria(miMovistarStep.java:51)\r\n\tat ✽.And Cliente selecciona el boton Seguimiento de mi averia(APP_MovistarContigo.feature:11)\r\n",
  "status": "pending"
});
formatter.after({
  "duration": 2988206500,
  "status": "passed"
});
});