$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FlujoLogin.feature");
formatter.feature({
  "line": 1,
  "name": "Flujo de Ventas Fija",
  "description": "",
  "id": "flujo-de-ventas-fija",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Como Usuario Activo, realizo login en Web Ventas Fijas",
  "description": "",
  "id": "flujo-de-ventas-fija;como-usuario-activo,-realizo-login-en-web-ventas-fijas",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Abre login web de venta fija",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Ingreso codatis y  doy click en continuar",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Obtengo token",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Ingreso password y token,Clic en iniciar sesion",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "flujo-de-ventas-fija;como-usuario-activo,-realizo-login-en-web-ventas-fijas;",
  "rows": [
    {
      "cells": [
        "Id"
      ],
      "line": 10,
      "id": "flujo-de-ventas-fija;como-usuario-activo,-realizo-login-en-web-ventas-fijas;;1"
    },
    {
      "cells": [
        "1"
      ],
      "line": 11,
      "id": "flujo-de-ventas-fija;como-usuario-activo,-realizo-login-en-web-ventas-fijas;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 11,
  "name": "Como Usuario Activo, realizo login en Web Ventas Fijas",
  "description": "",
  "id": "flujo-de-ventas-fija;como-usuario-activo,-realizo-login-en-web-ventas-fijas;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Abre login web de venta fija",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Ingreso codatis y  doy click en continuar",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Obtengo token",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Ingreso password y token,Clic en iniciar sesion",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.abriendo_el_navegador()"
});
formatter.result({
  "duration": 38583368400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.ingresa_codatis_continuar()"
});
formatter.result({
  "duration": 1641413400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Obtener_token()"
});
formatter.result({
  "duration": 1622670000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.ingresar_pass_token()"
});
formatter.result({
  "duration": 5065752900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 26,
  "name": "Como usuario activo,realizo una migracion",
  "description": "",
  "id": "flujo-de-ventas-fija;como-usuario-activo,realizo-una-migracion",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "Selecciono migraciones",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "Ingreso datos cliente a migrar",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Selecciono producto a migrar",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Acepto las condiciones,resumen de venta y contrato",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Hago la validacion de reniec",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Finalizo migracion",
  "keyword": "Then "
});
formatter.examples({
  "line": 33,
  "name": "",
  "description": "",
  "id": "flujo-de-ventas-fija;como-usuario-activo,realizo-una-migracion;",
  "rows": [
    {
      "cells": [
        "Id"
      ],
      "line": 34,
      "id": "flujo-de-ventas-fija;como-usuario-activo,realizo-una-migracion;;1"
    },
    {
      "cells": [
        "1"
      ],
      "line": 35,
      "id": "flujo-de-ventas-fija;como-usuario-activo,realizo-una-migracion;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 35,
  "name": "Como usuario activo,realizo una migracion",
  "description": "",
  "id": "flujo-de-ventas-fija;como-usuario-activo,realizo-una-migracion;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@SmokeTest"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "Selecciono migraciones",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "Ingreso datos cliente a migrar",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "Selecciono producto a migrar",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Acepto las condiciones,resumen de venta y contrato",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "Hago la validacion de reniec",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "Finalizo migracion",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.ClickMigraciones()"
});
formatter.result({
  "duration": 6177502800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.DatosClienteMigrar()"
});
formatter.result({
  "duration": 9249868400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.productoAmigrar()"
});
formatter.result({
  "duration": 33043193600,
  "status": "passed"
});
formatter.match({
  "location": "Steps.ProcesodeCondicionesyVenta2()"
});
formatter.result({
  "duration": 13628444400,
  "status": "passed"
});
formatter.match({
  "location": "Steps.ValidarReniec()"
});
formatter.result({
  "duration": 43279587700,
  "status": "passed"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});