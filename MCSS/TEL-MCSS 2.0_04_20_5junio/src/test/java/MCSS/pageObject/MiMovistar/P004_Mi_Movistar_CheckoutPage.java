package MCSS.pageObject.MiMovistar;

import MCSS.helpers.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;

public class P004_Mi_Movistar_CheckoutPage extends BasePage {
    String rb_ElegirNum="//*[@id=\"NumberAllocationForm\"]/div[1]/div[2]/div/div/div[3]/div/label/input";
    String rb_Num2="//*[@id=\"NumberAllocationForm\"]/div[1]/div[2]/div/div/div[2]/div/label/input";
    String btn_Siguiente="//*[@id=\"NumberAllocationForm\"]/div[3]/button";
    String rb_CrearNuevaCtaFacturacion="//*[@id=\"billing-information\"]/form/div[3]/div/div/label/input";
    String cmb_Departamento="|id|department";
    String cmb_Provincia="|id|province";
    String cmb_Distrito="|id|district";
    String cmb_TipoCalle="|id|street-type";
    String txt_NombreCalle="|id|street-name";
    String txt_Nro="|id|street-number";
    String txt_Mzn="|id|block";
    String btn_Continuar="|id|continueUpdateBar";
    String btn_GenerarContrato= "//*[text()='1.  Generar Contrato']";//*[@id=\"orderSummaryWidget\"]/div/div[1]/div/div[5]/div[10]/a[11]";
    String Btn_GenerarContrato2="id|btnDescargaContratos|";
    String lbl_AceptarPoliticas= "//div[contains(@class,'no-print')]//div[6]//div[1]//label[1]";
    String lbl_AceptarPoliticasWE="//div[contains(@class,'no-print')]//div[6]//div[1]//label[1]";
    String btn_ValidarIdentidadVerContrato=".//*[text()='2.  Validar Identidad y ver contrato']";
    String btn_CerrarError="//*[@id=\"alertModal\"]//*[@id=\"okButton\"]/a";
    String btn_GenerarReciboPago="//*[@id=\"orderSummaryWidget\"]/div/div[1]/div/div[5]/div[10]/a[8]";
    String btn_Cerrar="//*[@id=\"generating-ticket\"]/div/div/div[2]/div[2]/form/input[1]";
    String btn_GuardarCompra=  ".//*[text()='4.  Guardar compra']";  //"//*[@id=\"orderSummaryWidget\"]/div/div[1]/div/div[5]/div[10]/a[5]";
    String txt_NroSIM="|id|iccid";
    String txt_NumCaja="|id|caseNumber";
    String txt_NumTicket="|id|ticketNumber";
    String btn_Confirmar="//*[@id=\"orderSummaryWidget\"]/div/div[1]/div/div[5]/div[10]/a[4]";
    String img_Mcss_loader="|id|mcss_loader";
    String modal_error="//*[@id=\"alertModal\"]//*[@id=\"okButton\"]/a";
    String elemento="//*[@id=\"shopingCartWidget\"]/div/div[6]/div/div[1]/div[1]/div[1]/label/span[1]";
    String lbl_Error="//*[@id=\"dealerDeviceSection\"]/div/div[2]/div/div[2]/span[2]/label";
    String lbl_Exito="//*[@id=\"orderConfirmationWidget\"]/div/div[1]/span[2]";
    String div_MaterialNoDisponible="//*[@id=\"alertModal\"]/div";
    String lbl_Orden="//*[@id=\"numberAllocationWidget-heading\"]/h4/a";
    String lbl_OrdenCambio="//*[@id=\"orderConfirmationWidget\"]/div/p[2]/strong";

    String lblTotalPagoInmediato = "//*[@id=\"shopingCartWidget\"]/div/div[6]/div/div[1]/div[1]/div[1]/p";

    public void doDatos(int id) throws Exception {
        System.out.println("doDatos");
       // Thread.sleep(9000);
        waitInvisibility("Esperando que cargue", img_Mcss_loader, false);
        doclickByJS("Click_Segunda_Opcion", rb_Num2, false);
        doJSScrollIntoView("Scroll Down", btn_Siguiente, false);
        doclickByJS("Click boton Siguiente Seleccion Numero",btn_Siguiente, true);
    }
    public void doEntregaFacturacion(String departamento, String provincia, String distrito, String tipoCalle, String nombreCalle, String nro, String mza,int id) throws Exception { // Poner CASE
    //    wait(rbCrearNuevaCtaFacturacion);
     //   wait(imgSpinner);
        System.out.println("En_doEntregaFacturacion");

        System.out.println("despues del crear");
        Thread.sleep(4000);
        wait("Ventana error", modal_error);
        doclickByJS("Click en crear factura",rb_CrearNuevaCtaFacturacion,true);
        wait("Listado Provincia", cmb_Provincia);
        doclickByJS("Click_Cerrar_Error_Tuenti",btn_CerrarError,false);
        System.out.println("CerroTuenti");
        //Set data in form
       waitInvisibility("Esperando que cargue", img_Mcss_loader, false);
        doSelectDropdown("Seleccionar departamento",cmb_Departamento, departamento,false);
      //  Thread.sleep(2000);
        waitInvisibility("Esperando que cargue", img_Mcss_loader, false);
        doSelectDropdown("Selecciona Provincia",cmb_Provincia, provincia,false);
        waitInvisibility("Esperando que cargue", img_Mcss_loader, false);
      //  Thread.sleep(3000);
        doSelectDropdown("Selecciono distrito",cmb_Distrito, distrito,false);
      //  Thread.sleep(3000);
        doSelectDropdown("Selecciono tipo de Calle",cmb_TipoCalle, tipoCalle,false);
        doAddTextField("Ingreso la calle",txt_NombreCalle, nombreCalle,false);
        doAddTextField("Ingreso el numero de la calle",txt_Nro, nro,false);
        doAddTextField("Ingreso direccion",txt_Mzn, mza,true);
        doJSScrollIntoView("Scrolldown", btn_Continuar, false);
        doClick("Click Continuar",btn_Continuar,true);

        //wait(imgSpinner);

    }
    public void doPago(int id) throws Exception {
       // wait(elemento);
       //  doclickByJS( "Click ChechkBox Acepta CondicionesDatos",lblAceptarPoliticas,true);
        /*wait(modal_error);
        doclickByJS("Click_Cerrar_Error_Tuenti",btnCerrarError,true);
        System.out.println("CerroTuenti");*/
       // waitInvisibility("Esperando que cargue", imgMcss_loader, false);
        //Thread.sleep(5000);

        doJSScrollIntoView(" Boton Generar Contrato", btn_GenerarContrato, true);
        doclickByJS ("Click Boton GenerarContrato",btn_GenerarContrato, true);
        System.out.println("DespuesnClick Boton Generar contrto");
        //waitInvisibility("EsperarInvisibilityOFElement", imgMcss_loader, true);
        Thread.sleep(14000);
        takeScreenshot("Click Validar Identidad VerContrato 1");
        doclickByJS("Click Validar Identidad VerContrato",btn_ValidarIdentidadVerContrato,false);
        System.out.println("Pase a la validacion no biometrica");
    }
    public void nuevaLineaOrden(int id) throws Exception {
        System.out.println("wait lblTotalPagoInmediato");
        wait("Label Total Pago", lblTotalPagoInmediato);
        doJSScrollIntoView("Click boton GenerarReciboPago", btn_GenerarReciboPago, true);
        doclickByJS("Click boton GenerarReciboPago",btn_GenerarReciboPago, true);
        doJSScrollIntoView("Click boton Cerrar", btn_Cerrar, false);
        doclickByJS("Click boton Cerrar", btn_Cerrar, true);
        doJSScrollIntoView("Scrolldown", btn_GuardarCompra, false);
        doclickByJS("Click boton GuargarCompra",btn_GuardarCompra, true);
    }

    public void guardarCompra() throws Exception {
        doJSScrollIntoView("Scrolldown", btn_GuardarCompra, false);
        doclickByJS("Click boton GuargarCompra",btn_GuardarCompra, true);


    }
    public void doConfirmarOrden(String numSIM,int id) throws Exception {
        doAddTextField ("AgregarNumSIM", txt_NroSIM, numSIM, false);
        doAddTextField ("AgregarNumCaja", txt_NumCaja, "7", false);
        doAddTextField ("Agregar NumTicket", txt_NumTicket, "7", true);

    }
    public void doConfirmarVenta(int id) throws Exception {
        doJSScrollIntoView("Scroll hasta encontrar el boton de confirmar", btn_Confirmar,false);
        doClick("Click en el boton de confirmar venta", btn_Confirmar,true);
    }
    public boolean ValidarError(int id) throws Throwable {
        return validateObjExistByXpath("Validar el label de error", lbl_Error);
    }
    public String obtenerNroOrden() throws Exception {
        String Orden;
   /*     Thread.sleep(7000);
        System.out.println("ANTES DE  obtenerNroOrden CerroTuenti");

        doclickByJS("Click_Cerrar_Error_Tuenti",btnCerrarError,true);
        System.out.println("DESPUES DE  obtenerNroOrden CerroTuenti");
*/
        Orden=getlabel("Extrayendo nro Orden", lbl_Orden);
        System.out.println("numOrden:"+Orden);
       int  n=Orden.length();
        Orden=Orden.substring(33,n-1);
        System.out.println(Orden);
        return Orden;
    }
    public String obtenerNroOrden2() throws Exception {
        String orden;
        orden=getlabel("Extrayendo nro Orden 2", lbl_Orden);
        System.out.println("NumOrder2:"+orden);
        int  n = orden.length();
        orden = orden.substring(16);
        System.out.println("Order2Subtring:"+orden);
        return orden;
    }
    public String obtenerNroOrden3() throws Exception {
        String orden;
        String orderFinal;
        orden=getlabel("Extrayendo nro Orden 2", lbl_OrdenCambio);
        orderFinal=getlabel("Extrayendo nro Orden 2", lbl_OrdenCambio);
        System.out.println("NumOrder3_Cambio:"+orden);
        return orden;
    }
    public boolean ValidarNumeros(int id) throws Throwable {
        return validateObjExistByXpath("Validar boton de numero", rb_Num2);
    }
    public boolean validarVenta(String sMessageVenta,int id) throws Exception {
        String indice=Integer.toString(id);
        return verifyText(sMessageVenta, lbl_Exito, indice,true);
    }
    public boolean validarMaterialDisponible() throws Throwable {
        return validateObjExistByXpath("Validar error de material", div_MaterialNoDisponible);
    }

    public String obtenerStatusPrueba(String sMessageVenta, int id) throws Exception {
        String statusFinal;
        if(verifyText(sMessageVenta, lbl_Exito, Integer.toString(id),false)){ statusFinal = "PRUEBA_EXITOSA"; }
        else {statusFinal = "PRUEBA_FALLIDA";}
        takeScreenshot("Resultado Final Prueba_"+statusFinal);
        return statusFinal;

    }
}
