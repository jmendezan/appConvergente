package MCSS.pageObject.MiMovistar;

import MCSS.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;

public class P005_Mi_Movistar_WICPage extends BasePage {
    String btn_PostPago = "//*[contains(text(),'PostPago')]";
    String btn_Prepago = "//*[contains(text(),'Prepago')]";
    String btn_Calcular = "//*[contains(text(),'Calcular')]";

    String btn_Continuar = "//*[contains(text(),'Continuar')]";
    String rb_DiscapacitadoHuellaGastada = "//*[@id=\"idSelectOpciones\"]/div[2]/div/div";
    String btn_ValidacionNoBiometrica = "//*[@id=\"btnValidacionNoBiometrica\"]/span";
    String lbl_Accion = "//*[@id=\"j_idt69_content\"]/div[1]/div[2]";
    String question = "//div[@id='j_idt119_content']";
    String btn_ModalSiguiente = "//*[@id=\"idFrm\"]/div/div/div[2]//*[@id=\"idDlgNoBiometricaMadre\"]//*[@id=\"j_idt125\"]";
    String lbl_HITAprobado = ".//*[text()='HIT: Cuestionario Aprobado']";
    String btn_ModalContinuar = "|id|j_idt102";
    String btn_DescargarDeclaracionJurada = "|id|btnDescargaDJ";
    String btn_DescargarContrato = "|id|btnDescargaContratos";
    String frm_Alert = "//*[@id=\"idDlgDescargaContratos\"]/div[2]";
    String btn_DescargarContratoPopUp = "//*[@id=\"idOutPnlBtnMain\"]//*[contains(text(),'Descargar Contratos')]";
    String btn_DescargarPopupContrato1 = "//table/tbody/tr[1]/td[2]/button";//"|id|j_idt145:0:downloadLink";
    String btn_DescargarPopupContrato2 = "//table/tbody/tr[2]/td[2]/button";//"|id|j_idt145:1:downloadLink";
    String btn_ContinuarPopUp = "//*[@id=\"idDlgDescargaContratos\"]/div[3]/span/div/div/div/div/button"; // Boton continuar del descargar contrato-popup
    String btn_ContinuarFrm = "//*[@id=\"j_idt152\"]/span";
    String btn_ContinuarContrato = "|id|j_idt152";
    String btn_ContinuarSiguientePantalla = "|id|btnContinuar";//*[@id="btnContinuar"]
    String img_Loader = "//*[@id=\"j_idt15\"]";
    String btn_ContinuarValidacionIdentididad = "//*[@id=\"btnContinuar\"]/span";
    String img_MCSSLoader = "|id|mcss_loader";

    /**Incidencia**/
    String lbl_avisoIncidencia = "//*[contains(text(),'Aviso: Actualmente estamos en incidencia, por favor generar los contratos y documentos manualmente.')]";
    /**
    *  WIC 1 para opcion POSTPAGO
    * */
    public void doClickPostpago(int id) throws Exception {
        doClick("Click Boton PostPago", btn_PostPago, true);
        doclickByJS("Se da click en el boton calcular", btn_Calcular, false);
        waitInvisibility("Espera que cargue WIC", img_Loader, false);
        doJSScrollIntoView("Click en el boton calcular", btn_Calcular, false);
        doclickByJS("Click en el boton Calcular", btn_Calcular, true);
        waitInvisibility("Espera que cargue WIC", img_Loader, false);
        doJSScrollIntoView("Scroll down", btn_Continuar, false);
        takeScreenshot("Click en el boton continuar");
        doclickByJS("Click en el boton continuar", btn_Continuar, false);
        waitInvisibility("Espera que cargue WIC", img_Loader, false);

    }


    public void doClickPrepago(int id) throws Exception {
        doclickByJS("Click_Boton_PrePago", btn_Prepago, true);
        doclickByJS("Hago click en el boton de continuar", btn_Continuar, false);
        Thread.sleep(6000);
    }
    /*** Validacion No Biometrica Peruanos***/
    public void validacionIdentidad(String sTipoDocumento, String answer_padre, String answer_madre, String answer_distrito, int id) throws Throwable {
        System.out.println("En validacionIdentidad");
        if (sTipoDocumento.equalsIgnoreCase("DNI")) {
            System.out.println("Cliente peruano");
            System.out.println("Validacion no biometrica");
            doClick("Click  en el boton de Discapacitados", rb_DiscapacitadoHuellaGastada, true);
            for (int i = 0; i < 3; i++) {
                doClick("Click Validacion No Biometrica", btn_ValidacionNoBiometrica, false);
            }
            handleDriver().switchTo().activeElement();
            System.out.println("Estoy en el cuadro de preguntas");
            Thread.sleep(15000);
            String question_ready = wait("Pregunta Biometrica",question).toString();
            for (int i = 1; i < 4; i++) {
                boolean find_answer = false;
                int cont = 1;
                String string_path_search = "";
                String answer = "";
                String div_answer_contains = "";
                if (question_ready.equalsIgnoreCase("Confirma tu identidad respondiendo. Cual es el nombre de tu padre?")) {
                    System.out.println("PRIMERA CONDICION");
                    System.out.println("PREGUNTA " + i);

                    while (find_answer == false) {
                        string_path_search = "//*[@id=\"j_idt122\"]/div[" + cont + "]";
                        System.out.println(string_path_search);
                        Thread.sleep(20000);
                        div_answer_contains = wait("Primera pregunta", string_path_search).getText().toString();
                        System.out.println(div_answer_contains);
                        answer = div_answer_contains.substring(3);
                        if (answer.equalsIgnoreCase(answer_padre)) {
                            string_path_search = string_path_search.concat("/div/div");
                            find_answer = true;
                            doClick("Haciendo Click Validacion Nomb_Padre", string_path_search, false);
                        } else {
                            find_answer = false;
                        }
                        cont++;
                    }
                }
                if (question_ready.equalsIgnoreCase("Confirma tu identidad respondiendo. Cual es el nombre de tu madre?")) {
                    System.out.println("SEGUNDA CONDICION");
                    System.out.println("PREGUNTA " + i);
                    while (find_answer == false) {
                        string_path_search = "//*[@id=\"j_idt122\"]/div[" + cont + "]";
                        System.out.println(string_path_search);
                        Thread.sleep(20000);
                        div_answer_contains = wait("Segunda Pregunta", string_path_search).getText().toString();
                        System.out.println(div_answer_contains);
                        answer = div_answer_contains.substring(3);
                        if (answer.equalsIgnoreCase(answer_madre)) {
                            string_path_search = string_path_search.concat("/div/div");
                            find_answer = true;
                            doClick("Click Validacion Nomb_Padre", string_path_search, false);
                        } else {
                            find_answer = false;
                        }
                        cont++;
                    }
                }
                if (question_ready.equalsIgnoreCase("Confirma tu identidad respondiendo. En que distrito naciste?")) {
                    System.out.println("TERCERA CONDICION");
                    System.out.println("PREGUNTA " + i);
                    while (find_answer == false) {
                        string_path_search = "//*[@id=\"j_idt122\"]/div[" + cont + "]";
                        System.out.println(string_path_search);
                        Thread.sleep(15000);
                        div_answer_contains = wait("Tercera pregunta", string_path_search).getText().toString();
                        System.out.println(div_answer_contains);
                        answer = div_answer_contains.substring(3);
                        if (answer.equalsIgnoreCase(answer_distrito)) {
                            string_path_search = string_path_search.concat("/div/div");
                            find_answer = true;
                            doClick("Click en la validacion Nomb_Padre", string_path_search, false);
                        } else {
                            find_answer = false;
                        }
                        cont++;
                    }
                }
                System.out.println("Ya pase a siguiente");
                if (i < 3) {
                    Thread.sleep(20000);
                    wait("Ventana Modal ", btn_ModalSiguiente);
                    doClick("Click Validacion No Biometrica siguiente", btn_ModalSiguiente, false);
                    Thread.sleep(40000);
                    wait("Pregunta", question);
                    System.out.println(wait("Pregunta", question).getText());
                    question_ready = wait("Pregunta", question).getText().toString();
                } else {
                    Thread.sleep(30000);
                    wait("Esperando ventana modal", btn_ModalSiguiente);
                    doClick("Click Validacion No Biometrica siguiente", btn_ModalSiguiente, false);
                    Thread.sleep(90000);
                    System.out.println("Ya termine");
                }
            }
            doClick("Click Validacion No Biometrica continuar", btn_ModalContinuar, false);
            handleDriver().switchTo().defaultContent();
            try {
                System.out.println("Descargar declaracion jurada");
                Thread.sleep(30000);
                doClick(" Prueba ID: " + id + "-Haciendo click Boton Decargar Declaracion Jurada", btn_DescargarDeclaracionJurada, false);
                System.out.println("Ya descargue declaracion jurada 2");
                doClick("Haciendo click Boton Cerrar PopUp Descargas", btn_ContinuarFrm, false);
                Thread.sleep(30000);
                handleDriver().switchTo().defaultContent();
                Thread.sleep(30000);
                doClick("Click Boton Decargar Contrato", btn_DescargarContrato, true);
                Thread.sleep(30000);
                doClick("Click Boton Decargar Contrato 1", btn_DescargarPopupContrato1, false);
                Thread.sleep(30000);
                doClick("Haciendo Click Boton Decargar Declaracion Jurada2", btn_DescargarPopupContrato2, false);
                Thread.sleep(30000);
                doClick("Click Boton Continuar Contrato", btn_ContinuarContrato, true);

            } catch (Exception e) {
                utilitarios.takeScreenshot("ErrorAcceptingAlert", handleDriver());
            }
        } else {
           /* try{
                Thread.sleep(800);
                doClick("ClickBoton_Decargar_Contrato", btnDescargarContrato, true);
                Thread.sleep(800);
                doClick("ClickBoton_Descargar_Primer_Contrato", btnDescargarPopupContrato1, false);
                Thread.sleep(800);
                doClick("ClickBoton_Decargar_Segundo_Contrato", btnDescargarPopupContrato2, false);
                Thread.sleep(800);
                doClick("ClickBoton_Continuar_Contrato", btnContinuarContrato, true);
                Thread.sleep(800);
                doClick("ClickBoton_Continuar_Contrato",btnContinuarSiguientePantalla, true);
            }catch (Exception e){
                utilitarios.takeScreenshot("ErrorAcceptingAlert",handleDriver());
            }*/

            takeScreenshot("Validacion de Identidad_WIC 1");
            doJSScrollIntoView("ScrollDown", btn_ContinuarSiguientePantalla, false);
            //xxxx aca con el validacion de lbl_avisoIncidencia is yes,no hacer descarga contrato, en caso no aparezca si descargar
            if(validateObj_WIC_incidencia("Validacion Aviso Incidencia", lbl_avisoIncidencia)){
                doclickByJS("Click Boton Continuar Siguiente Pantalla", btn_ContinuarSiguientePantalla, true);

            }else{
                descargarContrato();
                doclickByJS("Click Boton Continuar Siguiente Pantalla", btn_ContinuarSiguientePantalla, true);

            }
        }

    }

    public void descargarContrato() throws Exception {
        doclickByJS("Click Boton Descargar Contrato Popup", btn_DescargarContratoPopUp, true);
        doClick("Click Boton Descargar 1", btn_DescargarPopupContrato1, false);
        doClick("Click Boton Descargar 2", btn_DescargarPopupContrato2, true);
        doclickByJS("Click Boton Continuar en Descargar Contratos", btn_ContinuarPopUp, true);

    }
    public boolean validarBtn(int id) throws Throwable {
        System.out.println("en_validarBtn");
        if (validateObjExistById("Validar boton continuar", btn_ContinuarSiguientePantalla, false)) {
        } else {
            System.out.println("No paso! - lo cual esta bienn");

        }
        return validateObjExistById("Validar boton continuar", btn_ContinuarSiguientePantalla, false);
    }

    public void continuarWIC_clienteCE() throws Exception {
        doJSScrollIntoView("Scrolldown en WIC",  btn_ContinuarValidacionIdentididad, false);
        doclickByJS("Click Boton Continuar WIC Usuario sin DNI", btn_ContinuarValidacionIdentididad, true);
        waitInvisibility("Espera que cargue WIC", img_Loader, false);

    }

}
