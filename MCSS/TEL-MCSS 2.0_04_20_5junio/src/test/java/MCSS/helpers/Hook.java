/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Agendamiento - Trazabilidad
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package MCSS.helpers;
import cucumber.api.java.Before;
import gherkin.formatter.model.Scenario;
import MCSS.utility.GlobalVariable;
import MCSS.utility.*;
import MCSS.utility.WordUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class Hook {
    public WebDriver driver;
    public BasePage basePage;
    public static String sFeatureName;
    public static String sEscenario;
    public static String sEstadoPrueba;
    public static String sNumOrden;

    @Before
    public void getFeatureFileNameFromScenarioId(cucumber.api.Scenario scenario) {
        String featureName = "Feature ";
        String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
        featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        System.out.println("FeatureName_:"+featureName);
        System.out.println("Escenario:"+scenario.getName());
        sFeatureName = featureName;
        sEscenario = scenario.getName();
    }


    /**
     * Borra todos los coockies e instancia el browser indicado
     */

  //  @Before
    public  WebDriver  setUp(String sbrowser, String strURL) throws Exception {

        System.out.println("scenario:");
        String sCarpAct = "./results/screenshot/";
        ScreenshotUtility.cleanScreenshot(sCarpAct);
        boolean browserFound = true;
        if (sbrowser.toUpperCase().equals("FIREFOX")) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else if (sbrowser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", GlobalVariable.AUT_BROWSER_SERVER_PATH_CHROME);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--force-dev-mode-highlighting");

           /* ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.prompt_for_download", false);
            prefs.put("download.extensions_to_open", "application/pdf");
            prefs.put("safebrowsing.enabled", true);
            options.addArguments("--safebrowsing-disable-download-protection");
            options.addArguments("safebrowsing-disable-extension-blacklist");
            options.setExperimentalOption("prefs", prefs);
            */driver = new ChromeDriver();//options
        } else if (sbrowser.toUpperCase().equals("IE")) {
            System.setProperty("webdriver.ie.driver", GlobalVariable.AUT_BROWSER_SERVER_PATH_CHROME);
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        } else {
            browserFound = false;
        }
        if (browserFound) {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(strURL);
            basePage = new BasePage();
            basePage.setWebDriver(driver);
            System.out.println("Browser Inicializado"+driver.getTitle());
            return driver;
        } else {
            return null;
        }
    }

    /**
     * Cierra el browser y termina la sesion del WebDriver
     */

    //@After
    public static void closeBrowser(WebDriver iDriver, String testername,int id, String sEstadoPrueba, String sNumOrden) throws Exception {
        generarWordFile(testername, id, sEstadoPrueba, sNumOrden);
   //     iDriver.quit();

    }
    public static void generarWordFile(String testername,int id, String sEstadoPrueba, String sNumOrden) throws Exception {
        String sCarpAct = "./results/screenshot/";
        List<String> listScreen = ScreenshotUtility.listScreenshot(sCarpAct);
        if(GlobalVariable.IMPRIMIR_WORD){
            //if (listScreen != null && listScreen.size() > 0) {
            if (listScreen.size() > 0) {
            WordUtils.createDoc(listScreen, testername, id, sEstadoPrueba, sNumOrden);
        } else {
            System.out.println("No hay Data");
            }
        }
    }
}