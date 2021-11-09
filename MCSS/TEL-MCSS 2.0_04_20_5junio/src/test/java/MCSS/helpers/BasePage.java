/**************************************************
 * WIPRO PROPIEDAD INTELECTUAL
 #Autor : Wipro Automation Team
 #Description : Portal de Venta Fija
 #Fecha de creación: Feb 2020
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package MCSS.helpers;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import MCSS.utility.*;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage{

    private static WebDriver driver;
    //    public  WebDriver driver;
    public int defaultWaitingTime = 200;
    protected ScreenshotUtility utilitarios = new ScreenshotUtility();
    public String stepTestName;
    protected Reports reporte = new Reports();


    //Este método se usa para aceptar los alert que aparezcan en los sites.
    public  void takeScreenshot(String UIName) throws IOException, AWTException {
        utilitarios.takeScreenshot(UIName, BasePage.handleDriver());
        ScreenshotUtility.saveAccion(UIName);
    }
    /*
    public void ManejoDeExepciones(Exception f, String UIName, String message, String tester, int id ) throws Exception {
      //  f.getMessage();
       // f.getStackTrace();
        f.printStackTrace();
      //  TakeScreenshot(UIName);
        Hook.closeBrowser(BasePage.handleDriver(), tester, id, "EXITO");
    }*/

   /*public void manejoDeAssertExcepciones(AssertionError f, String message, String tester, int id, Boolean closeBrowser) throws Exception {
        f.printStackTrace();
        if(closeBrowser) {
            Hook.closeBrowser(BasePage.handleDriver(), tester, id);
        }
        Assert.fail(message, f);
    }*/
    public void manejoDeAssertExcepciones2(AssertionError f, String UIName, String message) throws Exception {
        f.printStackTrace();
      //  TakeScreenshot("ERROR_Click_en_Boton_" +UIName);
      //  ScreenshotUtility.saveAccion("ERROR_Click_en_Boton_" + UIName);

        //      Hook.closeBrowser(BasePage.handleDriver(), escenario, featureName, tester, id);
        Assert.fail(message, f);
    }

    public void checkAlert_Accept(String UIName) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_En_Aceptar_Alert_"+UIName,"Fallo en check Alert");
        }
    }


    //Este método ingresa el texto.
  /*  public void doAddTextFieldOutWait(String UIName, String objTechName, String text, boolean screenshot) throws Exception {
        try {
            WebElement element = driver.findElement(By.name(objTechName));
            element.click();
            element.sendKeys(text);
            if (screenshot) {
                TakeScreenshot(UIName);
            }
        } catch (AssertionError e) {
            String error="ERROR_En_Agregar_El_Texto_"+ UIName;
            ManejoDeAssertExepciones(e,error,"Fallo en agregar texto");
        } catch (Exception e) {
            String error="ERROR_En_Agregar_El_Texto_"+ UIName;
            ManejoDeExepciones(e,error,"Fallo en agregar texto");
        }
    } */


    public void doAddTextField(String UIName, String objTechName, String text, Boolean screenshot) throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            element.clear();
            element.sendKeys(text);
            if (screenshot) {
                takeScreenshot(UIName);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_En_Agregar_El_Texto_"+ UIName,"Fallo en agregar texto");
        }
    }

    //Método para hacer click al objeto.
    public void doClick(String UIName, String objTechName, Boolean screenshot) throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            if (screenshot) {
                takeScreenshot(UIName);
            }
            element.click();
        } catch (AssertionError e) {

            manejoDeAssertExcepciones2(e,"ERROR_Click_"+ UIName,"Fallo en hacer click");
        }
    }

    //Método para seleccionar objeto combo
    public void doSelectDropdown(String UIName, String objTechName, String Value, Boolean screenshot)
            throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(Value);
            //dropdown.selectByValue(Value);
            if (screenshot) {
                takeScreenshot(UIName);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_SelectDropdown_" + UIName,"Fallo en agregar texto");
        }
    }

    public WebElement getParentWebElement(String objTechName) throws Exception {
        WebElement parentElement2=null;
        try{
            WebDriverWait wait = new WebDriverWait(driver, 120);
            WebElement elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
            WebElement parentElement1 = elementToClick.findElement(By.xpath("./.."));
            parentElement2 = parentElement1.findElement(By.xpath("./.."));
            System.out.println("parentSSS:" + parentElement2.getAttribute("id").toString());
        }catch (AssertionError e){
            manejoDeAssertExcepciones2(e, "ERROR_Seleccionar_Campo_","Fallo en agregar texto");
        }

        return parentElement2;

    }

    public WebElement getParentWebElement2(String objTechName) throws Exception {
        WebElement parentElement2=null;
        try{
            WebDriverWait wait = new WebDriverWait(driver, 120);
            WebElement elementToClick = wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
            WebElement parentElement1 = elementToClick.findElement(By.xpath("./.."));
            parentElement2 = parentElement1.findElement(By.xpath("./.."));
            System.out.println("parentSSS:" + parentElement2.getAttribute("id").toString());
        }catch (AssertionError e){
            manejoDeAssertExcepciones2(e, "ERROR_Seleccionar_Campo_","Fallo en agregar texto");
        }

        return parentElement2;

    }

    public void waitInvisibility(String UIName, String objTechName, Boolean screenshot) throws Exception {
        try {
            WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_invisibilityWait_"+UIName,"Fallo en agregar texto");

        }



    /*    try {
            WebElement element = wait(objTechName);
        } catch (Exception e) {
            String error="Error en  " + UIName;
            ManejoDeExepciones(e,error,"Fallo la espera a que el elemento desaparezca");
        }
    */}

    //Método para elegir la opción index del combo
    public void doSelectDropDownByindex(String UIName, String objTechName, int data, Boolean screenshot) throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            Select dropdown = new Select(element);
            dropdown.selectByIndex(data);
            if (screenshot) {
                takeScreenshot(UIName);
            }
        } catch (AssertionError e) {

            manejoDeAssertExcepciones2(e,"ERROR_SelectDropdownByIndex" + UIName,"Fallo en agregar seleccionar el dropdown");
        }
    }

    //Método para seleccionar el texto de la opción del elemento
    public void select(String UIName, String objTechName, String data) throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            Select selectBox = new Select(element);
            selectBox.selectByVisibleText(data);
            takeScreenshot(UIName);
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_SelectDropdown" + UIName,"Fallo en el select");
        }
    }

    //Método para cambiar de frame
    public void switchiframe(String UIName, String objTechName) throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            driver.switchTo().frame(element);
            takeScreenshot(UIName);
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_switchFrame" + UIName,"Fallo en switch frame");
        }
    }

    public void enterIntoView() throws Exception {
        try {
            Actions builder = new Actions(driver);
            builder.sendKeys(Keys.ENTER).build().perform();
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_EnterToView","Fallo en dar ENTER");
        }

    }

    public void setWebDriver(WebDriver driver) {
        BasePage.driver=driver;
    }

    public enum properties {
        DISPLAYED, VISIBLE, SELECTED;
    }
    //Valida que un objeto exista
    public  boolean validateObject(String UIName, String objTechName, String PropertyToBeVerified, Boolean screenshot) throws Exception {
        boolean ActualPropertyValue = false;
        //   Thread.sleep(7000);
        String prop = PropertyToBeVerified.toUpperCase();
        try {

            if (screenshot) {
                utilitarios.takeScreenshot(UIName+" ", driver);
                ScreenshotUtility.saveAccion(UIName);
            }
            WebElement element =wait(UIName, objTechName);
            // WebElement element =driver.findElement(By.xpath(objTechName));

            System.out.println("despues wait");

            switch (properties.valueOf(prop)) {

                case DISPLAYED:
                    System.out.println("en displayed");

                    ActualPropertyValue = element.isDisplayed();
                    break;
                case VISIBLE:
                    ActualPropertyValue = element.isEnabled();
                    break;
                case SELECTED:
                    ActualPropertyValue = element.isSelected();
                    break;
                default:
                    break;
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Validar_Objeto_" + UIName, "Fallo la validacion del objeto");
        }
        if (ActualPropertyValue) {
            return true;
        }
        return false;
    }

    //Valida que el texto mostrado corresponda al texto comparado
    //No valida mayúsculas, ni minúsculas
    public boolean verifyText(String strText, String objTechName, String indice, Boolean screenshot) throws Exception {
        WebElement element = null;
        element = wait(strText, objTechName);
        try {
            element = wait(strText, objTechName);
            System.out.println("text:" + strText);
            System.out.println("text:" + element.getText());
            if (screenshot) {
                takeScreenshot("[Registro_" + indice + "]Validacion_Texto_" + strText);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Este_Texto_No_Fue_Encontrado_" + strText,"Fallo la verificacion del texto");
        }
        return element.getText().equalsIgnoreCase(strText);
    }

    //Método que obtiene el texto del label
    public String getlabel(String UIName, String objTechName) throws Exception {
        try {
            WebElement element = wait(UIName, objTechName);
            return element.getText();
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_obtenerTexto" + UIName,"Fallo en obtener el label");
        }
        return null;
    }

    //Verifica el contenido del texto
    public boolean verifyContainText(String strText, String objTechName) throws Exception {
        WebElement element = null;
        try {
            element = wait(strText, objTechName);

        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_verificar_texto_contain","Fallo la verificar el texto que contiene un elemento");
        }
        return element.getText().contains(strText);
    }

    public WebElement returnWebElement(String UIName, String objTechName) throws Exception {
        WebElement element = null;

        try {
            element = wait(UIName, objTechName);

        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Retornar_WebElement","Fallo el retorno del elemento");
        }
        return element;
    }

    public static WebDriver handleDriver() {
        return driver;
    }

    //*************JavaScript**************
    public void doclickByJS(String UIName, String objTechName, boolean screenshot) throws Exception {

        try {
            WebElement element = wait(UIName, objTechName);
            if (screenshot) {
                takeScreenshot(UIName);
            }
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click()", element);
            Thread.sleep(2000);


        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_Click_"+UIName,"Fallo el click");
        }
    }
    
    public void doJSScrollIntoView(String UIName, String objTechName, boolean screenshot) throws Exception {
        try {
            if(screenshot){takeScreenshot(UIName);}

            WebElement element = wait(UIName, objTechName);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView()", element);
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_ScrollDown_JS_" + UIName,"Fallo el scrolldown_js");
        }
    }

    public void redirigirPage(String UIName, String url) throws Exception {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("location.replace('" + url + "')");
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_Redirigir_Pagina_" + UIName,"Fallo en redirigir pagina");
        }
    }

    public void updatepage(String UIName, String str) throws Throwable {
        try {
            Thread.sleep(5000);
            while (driver.findElements(By.xpath(str)).size() != 0) {
                driver.navigate().refresh();
                Thread.sleep(7000);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e,"ERROR_Actualizar_Pagina_" + UIName,"ERROR_Actualizar_Pagina_");
        }
    }

    public boolean validateObjExistByXpath(String UIName, String str) throws Throwable {
        boolean respuesta = false;
        try {
            Thread.sleep(3000);
            if (driver.findElements(By.xpath(str)).size()!= 0) {
                System.out.println(" Elemento presente: "+ UIName);
                respuesta = true;
            }else{
                System.out.println("Elemento no presente: "+ UIName);
                respuesta=false;
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo la validacion de existencia de objeto",e);        }
        return respuesta;
    }

    public boolean validateObj_WIC_incidencia(String UIName, String str) throws Throwable {
        boolean respuesta = false;
        try {
            Thread.sleep(10000);
            if (driver.findElements(By.xpath(str)).size()!= 0) {
                System.out.println(" Elemento presente: "+ UIName);
                takeScreenshot("En incidencia");

                respuesta = true;
            }else{
                System.out.println("Elemento no presente: "+ UIName);
                respuesta=false;
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo la validacion de existencia de objeto",e);        }
        return respuesta;
    }

    public boolean validateObjExist(String UIName, String objTechName) throws Throwable {
        boolean respuesta=false;
        try{
            Thread.sleep(3000);
            if (driver.findElements(By.xpath(objTechName)).size()!=0){
                System.out.println(" Elemento presente"+ UIName);
                respuesta=true;
            }else{
                System.out.println("Elemento no presente: "+ UIName);
                respuesta=false;
            }
        }catch (AssertionError e){
            e.printStackTrace();
            Assert.fail("Fallo la validacion de existencia de objeto",e);
        }

        return respuesta;
    }
    public boolean validateObjExistById(String UIName, String element, Boolean screenshot) throws Throwable {
        boolean respuesta = false;
        try {
//            wait(UIName, element);
            Thread.sleep(5000);

            int tamanio = element.length();
            element = element.substring(4, tamanio);
            if (screenshot){
                takeScreenshot(UIName);
            }
            if (driver.findElements(By.id(element)).size() != 0) {
                System.out.println("Elemento presente "+UIName);
                respuesta = true;
            }else{
                System.out.println("Elemento no presente: "+ UIName);
                respuesta=false;
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            Assert.fail("Fallo la validacion de existencia de objeto",e);        }
        return respuesta;
    }



    public void updatepageNoexistElement(String UIName, String str) throws Throwable {
        try {
            Thread.sleep(5000);
            while (driver.findElements(By.xpath(str)).size() == 0) {
                driver.navigate().refresh();
                Thread.sleep(7000);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Actualizar_Pagina_" + UIName,"ERROR_Actualizar_Pagina_");
        }
    }


    public WebElement wait(String UIName, String objTechName) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
        WebElement element = null;

        try {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objTechName)));
        } catch (Exception e) {
            e.printStackTrace();
            Thread.sleep(1000);
            utilitarios.takeScreenshot("ERROR_No se encuentra elemento_" + UIName, driver);
            ScreenshotUtility.saveAccion("ERROR_No se encuentra elemento_" + UIName);
            Assert.fail("Fallo la validacion del objeto",e);
        }
        return element;
    }

    public WebElement expandRootElement(String objtElement) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, defaultWaitingTime);
        WebElement element = null;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectMap.getLocator(objtElement)));
        WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
                element);
        return ele;
    }

    public void doClickRootElement(String UIName, String rootname, String objTechName, boolean screenshot) throws Exception {

        try {
            WebElement root = driver.findElement(By.cssSelector(rootname));
            WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
                    root);
            WebElement elementClick = element.findElement(By.cssSelector(objTechName));
            elementClick.click();
            if (screenshot) {
                takeScreenshot(UIName);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Click_SHALLOW_ROOT" + UIName,"Fallo el click del boton_shallow_root");
        }

    }

    public void doClickRootElementById(String UIName, String rootname, String objTechName, boolean screenshot) throws Exception {

        try {
            WebElement root = driver.findElement(By.cssSelector(rootname));
            WebElement element = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
                    root);
            WebElement elementClick = element.findElement(By.id(objTechName));
            elementClick.click();
            if (screenshot) {
                takeScreenshot(UIName);
            }
        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Click_SHALLOW_ROOT_ByID" + UIName,"Fallo el click del boton_shallow_root_by_id");
        }
    }

    public String obtenerFechaYHora() throws Exception {
        String resultado="";
        try {
            Calendar calendario = Calendar.getInstance();
            calendario = new GregorianCalendar();
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            int mes = calendario.get(Calendar.MONTH);
            mes = mes + 1;
            int year = calendario.get(Calendar.YEAR);
            int hora = calendario.get(Calendar.HOUR_OF_DAY);
            int minutos = calendario.get(Calendar.MINUTE);
            int segundos = calendario.get(Calendar.SECOND);
           resultado = hora + ":" + minutos + ":" + segundos + " " + dia + "/" + mes + "/" + year;

        } catch (AssertionError e) {
            manejoDeAssertExcepciones2(e, "ERROR_Generacion_De_Fecha","Fallo la generacion de fecha");
        }
        return resultado;
    }

    //************ROBOT*****************
/*
    public void moveMousewithRobot(String objTechName) throws Exception {
        try {
            WebElement element = wait(1000);
            Point coordinates = element.getLocation();
            Robot robot = new Robot();
            robot.mouseMove(coordinates.getX(), coordinates.getY() + 120);
        } catch (AssertionError | AWTException e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo en dar Click", e);
        }
    }*/

    public void doClickMousewithRobot() throws Exception {
        try {
            Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (AssertionError | AWTException e) {
            e.getMessage();
            e.getStackTrace();
            e.printStackTrace();
            Assert.fail("Fallo en dar Click", e);
        }
    }
}
