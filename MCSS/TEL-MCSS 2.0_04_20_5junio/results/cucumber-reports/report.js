$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/TC006_ComboConEquipo.feature");
formatter.feature({
  "line": 1,
  "name": "Flujo de Alta Combo MCSS",
  "description": "",
  "id": "flujo-de-alta-combo-mcss",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "Alta Combo con equipo financiado para cliente existente que no tiene suscripciones asignadas, ciclo 99 dummy CE - No desea factura",
  "description": "",
  "id": "flujo-de-alta-combo-mcss;alta-combo-con-equipo-financiado-para-cliente-existente-que-no-tiene-suscripciones-asignadas,-ciclo-99-dummy-ce---no-desea-factura",
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
  "name": "Ingreso al login de MCSS con Dealer User \"\u003cId\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Ingreso al login de Mimovistar con \"\u003cId\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Seleccion el Alta Postpago solo chip con \"\u003cId\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Valido identidad del cliente con el \"\u003cId\u003e\" y genero recibos en Postpago",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Cierro el Alta Postpago del cliente con \"\u003cId\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "flujo-de-alta-combo-mcss;alta-combo-con-equipo-financiado-para-cliente-existente-que-no-tiene-suscripciones-asignadas,-ciclo-99-dummy-ce---no-desea-factura;",
  "rows": [
    {
      "cells": [
        "Id"
      ],
      "line": 11,
      "id": "flujo-de-alta-combo-mcss;alta-combo-con-equipo-financiado-para-cliente-existente-que-no-tiene-suscripciones-asignadas,-ciclo-99-dummy-ce---no-desea-factura;;1"
    },
    {
      "cells": [
        "6"
      ],
      "line": 12,
      "id": "flujo-de-alta-combo-mcss;alta-combo-con-equipo-financiado-para-cliente-existente-que-no-tiene-suscripciones-asignadas,-ciclo-99-dummy-ce---no-desea-factura;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 195700,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Alta Combo con equipo financiado para cliente existente que no tiene suscripciones asignadas, ciclo 99 dummy CE - No desea factura",
  "description": "",
  "id": "flujo-de-alta-combo-mcss;alta-combo-con-equipo-financiado-para-cliente-existente-que-no-tiene-suscripciones-asignadas,-ciclo-99-dummy-ce---no-desea-factura;;2",
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
  "name": "Ingreso al login de MCSS con Dealer User \"6\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Ingreso al login de Mimovistar con \"6\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Seleccion el Alta Postpago solo chip con \"6\"",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Valido identidad del cliente con el \"6\" y genero recibos en Postpago",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Cierro el Alta Postpago del cliente con \"6\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 42
    }
  ],
  "location": "Steps.loginMCSS(int)"
});
formatter.result({
  "duration": 28605884300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 36
    }
  ],
  "location": "Steps.loginMiMovistar(int)"
});
formatter.result({
  "duration": 18981980900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 42
    }
  ],
  "location": "Steps.altaPostpago(int)"
});
formatter.result({
  "duration": 464418654200,
  "error_message": "java.lang.AssertionError: ERROR_Alta_Postpago\r\n\tat org.testng.Assert.fail(Assert.java:85)\r\n\tat MCSS.exceptions.ExceptionHandler.doException(ExceptionHandler.java:17)\r\n\tat MCSS.tests.Steps.altaPostpago(Steps.java:310)\r\n\tat ✽.And Seleccion el Alta Postpago solo chip con \"6\"(src/test/resources/feature/TC006_ComboConEquipo.feature:7)\r\nCaused by: java.lang.AssertionError: Fallo en obtener el label\r\n\tat org.testng.Assert.fail(Assert.java:85)\r\n\tat MCSS.helpers.BasePage.manejoDeAssertExcepciones2(BasePage.java:65)\r\n\tat MCSS.helpers.BasePage.getlabel(BasePage.java:313)\r\n\tat MCSS.pageObject.MiMovistar.P004_Mi_Movistar_CheckoutPage.obtenerNroOrden(P004_Mi_Movistar_CheckoutPage.java:145)\r\n\tat MCSS.tests.Steps.altaPostpago(Steps.java:292)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:40)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:34)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:38)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.model.CucumberScenarioOutline.run(CucumberScenarioOutline.java:46)\r\n\tat cucumber.runtime.model.CucumberFeature.run(CucumberFeature.java:165)\r\n\tat cucumber.api.testng.TestNGCucumberRunner.runCucumber(TestNGCucumberRunner.java:63)\r\n\tat cucumber.api.testng.AbstractTestNGCucumberTests.feature(AbstractTestNGCucumberTests.java:21)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:133)\r\n\tat org.testng.internal.TestInvoker.invokeMethod(TestInvoker.java:584)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethod(TestInvoker.java:172)\r\n\tat org.testng.internal.MethodRunner.runInSequence(MethodRunner.java:46)\r\n\tat org.testng.internal.TestInvoker$MethodInvocationAgent.invoke(TestInvoker.java:804)\r\n\tat org.testng.internal.TestInvoker.invokeTestMethods(TestInvoker.java:145)\r\n\tat org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:146)\r\n\tat org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:128)\r\n\tat java.util.ArrayList.forEach(ArrayList.java:1249)\r\n\tat org.testng.TestRunner.privateRun(TestRunner.java:770)\r\n\tat org.testng.TestRunner.run(TestRunner.java:591)\r\n\tat org.testng.SuiteRunner.runTest(SuiteRunner.java:402)\r\n\tat org.testng.SuiteRunner.runSequentially(SuiteRunner.java:396)\r\n\tat org.testng.SuiteRunner.privateRun(SuiteRunner.java:355)\r\n\tat org.testng.SuiteRunner.run(SuiteRunner.java:304)\r\n\tat org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:53)\r\n\tat org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:96)\r\n\tat org.testng.TestNG.runSuitesSequentially(TestNG.java:1180)\r\n\tat org.testng.TestNG.runSuitesLocally(TestNG.java:1102)\r\n\tat org.testng.TestNG.runSuites(TestNG.java:1032)\r\n\tat org.testng.TestNG.run(TestNG.java:1000)\r\n\tat org.testng.IDEARemoteTestNG.run(IDEARemoteTestNG.java:73)\r\n\tat org.testng.RemoteTestNGStarter.main(RemoteTestNGStarter.java:123)\r\nCaused by: java.lang.AssertionError: Fallo la validacion del objeto\r\n\tat org.testng.Assert.fail(Assert.java:85)\r\n\tat MCSS.helpers.BasePage.wait(BasePage.java:501)\r\n\tat MCSS.helpers.BasePage.getlabel(BasePage.java:310)\r\n\t... 46 more\r\nCaused by: org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.xpath: //*[@id\u003d\"numberAllocationWidget-heading\"]/h4/a (tried for 200 second(s) with 500 milliseconds interval)\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:113)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:283)\r\n\tat MCSS.helpers.BasePage.wait(BasePage.java:495)\r\n\t... 47 more\r\nCaused by: org.openqa.selenium.NoSuchElementException: Cannot locate an element using By.xpath: //*[@id\u003d\"numberAllocationWidget-heading\"]/h4/a\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.14.0\u0027, revision: \u0027aacccce0\u0027, time: \u00272018-08-02T20:19:58.91Z\u0027\nSystem info: host: \u0027DESKTOP-D2B87I9\u0027, ip: \u0027192.168.100.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027x86\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: driver.version: unknown\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.lambda$findElement$0(ExpectedConditions.java:896)\r\n\tat java.util.Optional.orElseThrow(Optional.java:290)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.findElement(ExpectedConditions.java:895)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$000(ExpectedConditions.java:44)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:206)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$7.apply(ExpectedConditions.java:202)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:260)\r\n\t... 48 more\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 37
    }
  ],
  "location": "Steps.ValidacionPostpago(int)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "6",
      "offset": 41
    }
  ],
  "location": "Steps.cierroElAltaPostpagoDelClienteCon(int)"
});
formatter.result({
  "status": "skipped"
});
});