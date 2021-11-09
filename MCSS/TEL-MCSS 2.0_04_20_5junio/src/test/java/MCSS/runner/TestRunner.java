package MCSS.runner;

//import org.junit.runner.RunWith;
//import cucumber.api.junit.Cucumber;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "src/test/resources/feature/TC001_Compra_Paquete_de_voz_pago_al_recibo.feature"
        //features = "src/test/resources/feature/TC003_Alta_prepago.feature"
        features = "src/test/resources/feature/TC006_ComboConEquipo.feature"
        //features =  "src/test/resources/feature/TC005_Cambio_CAPL.feature" //Se ejecutaran todos los archivos features, por orden alfabetico segun especificado en el campo Feature.
        , plugin = {"com.cucumber.listener.ExtentCucumberFormatter:results/cucumber-reports/report.html",
        "junit:results/cucumber-reports/Cucumber.xml",
        "html:results/cucumber-reports"} //Formato de reporte generado por Cucumber
        , glue = {"MCSS.tests", "MCSS.helpers"} //Ubicación package de la clase steps
        , tags = {"@SmokeTest"} //Filtra por tags los escenarios a ejecutar
//		,tags= {"@RegressionTest"}
        , dryRun = false //Verifica que todos los pasos en el feature esten implementados en los steps
        , monochrome = true //Muestra en consola el output de las pruebas de Cucumber
)

public class TestRunner extends AbstractTestNGCucumberTests {
//public class TestRunner {
@AfterClass
public static void writeExtentReport() {

    Reporter.loadXMLConfig(new File("./src/extent-config.xml"));
}

}

