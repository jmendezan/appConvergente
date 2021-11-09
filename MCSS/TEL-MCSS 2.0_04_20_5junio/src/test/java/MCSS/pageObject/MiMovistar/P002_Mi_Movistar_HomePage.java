package MCSS.pageObject.MiMovistar;

import MCSS.helpers.BasePage;
import java.awt.*;
import java.io.IOException;

public class P002_Mi_Movistar_HomePage extends BasePage {
    String txt_NumDocumentoBuscarCliente="//*[@id=\"widget-area-searchCust\"]//*[@id=\"documentNo\"]";
    String btn_SoloChipM7 ="|id|simOnlyPre";
    String btn_SoloChipM4 = "|id|simOnlyPost";
    String btn_comboPre = "|id|comboPre";
    String btn_comboPost = "|id|comboPost";
    String btn_portabilidadSoloChip = "|id|portsimOnly";
    String btn_portabilidadCombo = "|id|portcombo";

    String frm_IngresarDatos="//*[@id=\"loadCustomerIdentificationWrapperCatalog\"]//*[@id=\"customerIdentificationModal\"]//*[@id=\"resident\"]";
    String rb_Residencial="//*[@id=\"loadCustomerIdentificationWrapperCatalog\"]//*[@id=\"customerIdentificationModal\"]//*[@id=\"resident\"]//*[@id=\"customerIdentificationForm\"]/div[1]/label[1]/input";
    String cmb_TipoDocumento2="//*[@id=\"loadCustomerIdentificationWrapperCatalog\"]//*[@id=\"customerIdentificationModal\"]//*[@id=\"resident\"]//*[@id=\"customerIdentificationForm\"]/div[2]/div[2]/div/select";
    String txt_NumDocumento="//*[@id=\"loadCustomerIdentificationWrapperCatalog\"]//*[@id=\"customerIdentificationModal\"]//*[@id=\"resident\"]//*[@id=\"customerIdentificationForm\"]/div[3]/div[2]/input";
    String btn_Siguiente="//*[@id=\"loadCustomerIdentificationWrapperCatalog\"]//*[@id=\"customerIdentificationModal\"]//*[@id=\"resident\"]//*[@id=\"customerIdentificationForm\"]/div[6]/input";
    String lbl_BuscarClientes="//*[@id=\"seek-customers\"]/h1";
    //Buscar Cliente
    String cmb_TipoDocumentoB = "|id|docType";
    String txt_NumDocumentoB = "|id|documentNo";
    String txt_Suscripcion = "|id|lineNo";
    String btn_Buscar = "|id|searchCustButton";
    String imgPage = "//div[@class='block-image seek only-1280']//img";
    String btn_ClosePopUp = "//div[@id='autenticarModal']//span[@class='close-search']";

    //Selecionar cliente
    String btn_SeleccionarCliente = "//div[@id='myModal']//input[1]";
    String btn_Editar = "//form[contains(@class,'form-hor border-blue-top')]//input[@class='btn btn-default']";
    String btn_Flecha = "//span[contains(@class,'link-section small')]//a";

    String loaderMCSS = "|id|mcss_loader";

    /*** Método doBuscarCliente: Implementa busquead de clientes segun documento***/
    public void doBuscarCliente( String sTipodocumento, String sNumDocumento, String tipoAlta, String suscripcion, int id) throws Exception {
        wait("Validar boton Buscar", lbl_BuscarClientes);
        wait("Validar texto", txt_NumDocumentoBuscarCliente);
        Thread.sleep(2000);
        doSelectDropdown("Seleccionar tipo de documento", cmb_TipoDocumentoB, sTipodocumento, false);
        Thread.sleep(4000);
        doAddTextField("Ingresar Numero de Documento", txt_NumDocumentoB, sNumDocumento, false);
        doAddTextField("Ingresar Suscripcion", txt_Suscripcion, suscripcion, false);
        wait("Validar boton buscar",btn_Buscar);
        Thread.sleep(5000);
        doJSScrollIntoView("ScrollDown", btn_Buscar, false);
        doclickByJS(" Prueba ID " + id + " Haciendo click en Buscar", btn_Buscar, false);
        doclickByJS("Close Pop Up", btn_ClosePopUp, false);
        doclickByJS(" Prueba ID " + id + " Haciendo click en Buscar", btn_Buscar, true);
        doJSScrollIntoView("ScrollDown", btn_SeleccionarCliente , true);
        doclickByJS("Seleccionar cliente", btn_SeleccionarCliente, false);
        wait("Validar Boton Editar",btn_Editar);
        doJSScrollIntoView("Click en Boton Flecha", btn_Editar, true);
        doclickByJS("Click en flecha", btn_Flecha, false);
    }

    /*** Método doClickTipoVenta: Implementa el click en los botones para ALTAS y para busqueda residencial***/
    public void doClickTipoVenta(String tipoVenta, String documento, String numDNI, String tipoAlta, String suscripcion, int id) throws Exception { // Poner CASE
        wait("Validar boton Buscar", lbl_BuscarClientes);
        wait("Validar texto", txt_NumDocumentoBuscarCliente);
        System.out.println("tipoChip:" + tipoAlta);
        if (tipoVenta.equals("ALTA")) {
             switch(tipoAlta)
                      {
                          case "Solo Chip M7":
                              doclickByJS("Click_boton Solo Chip M7", btn_SoloChipM7, true); //prepago
                              System.out.println("Opcion Solo Chip M7");
                              break;
                          case "Solo Chip M4":
                              doclickByJS("Click_boton Solo Chip M4", btn_SoloChipM4, true); //postpago
                              System.out.println("Opcion Solo Chip M4");
                              break;
                          case "Combo Pre":
                              doclickByJS("Click_boton Combo Pre", btn_comboPre, true); //
                              System.out.println("Opcion Compro Pre");
                              break;
                          case "Combo Post":
                              doclickByJS("Click_boton Combo Post", btn_comboPost, true); //
                              System.out.println("Opcion Combo Post");
                              break;
                          case "Portabilidad Solo Chip":
                              doclickByJS("Click_boton Portabilidad Solo Chip", btn_portabilidadSoloChip, true); //
                              System.out.println("Opcion Portabilidad Solo Chip");
                              break;
                          case "Portabilidad Combo":
                              doclickByJS("Click_boton Portabilidad Combo", btn_portabilidadCombo, true); //
                              System.out.println("Opcion Portabilidad Combo");
                              break;
                      }

            wait("Validar Ingresar Datos", frm_IngresarDatos);
            handleDriver().switchTo().activeElement();
            doclickByJS("Click en el boton residencial", rb_Residencial, false);
            doSelectDropdown("Seleccionar tipo de documento", cmb_TipoDocumento2, documento, false);
            doAddTextField("Ingresar Numero de Documento", txt_NumDocumento, numDNI, false);
            doClick("Click en el boton de siguiente", btn_Siguiente, true);
            Thread.sleep(10000);
            handleDriver().switchTo().defaultContent();
        } /*else if (tipoVenta.equals("CAMBIO")) {
            Thread.sleep(2000);
            doSelectDropdown("Seleccionar tipo de documento", cmbTipoDocumentoB, documento, false);
            Thread.sleep(4000);

            doAddTextField("Ingresar Numero de Documento", txtNumDocumentoB, numDNI, false);
            doAddTextField("Ingresar Suscripcion", txtSuscripcion, suscripcion, true);
            wait("Validar boton buscar",btnBuscar);
            Thread.sleep(10000);
            doJSScrollIntoView("ScrollDown", btnBuscar, false);
           // Thread.sleep(4000);

            doclickByJS(" Prueba ID " + id + " Haciendo click en Buscar", btnBuscar, false);
       //     TakeScreenshot("Cerrar Pop Up");

            doclickByJS("Close Pop Up", btnClosePopUp, false);
            doclickByJS(" Prueba ID " + id + " Haciendo click en Buscar", btnBuscar, true);
            doJSScrollIntoView("ScrollDown", btnSeleccionarCliente , true);
            doclickByJS("Seleccionar cliente", btnSeleccionarCliente, false);
            wait("Validar Boton Editar",btnEditar);
           // Thread.sleep(20000);
            doJSScrollIntoView("Click en Boton Flecha", btnEditar, true);
            doclickByJS("Click en flecha", btnFlecha, false);
        }*/
    }

    public boolean ValidarBtnM7Prepago(int id) throws Throwable {
        return validateObjExistByXpath("Validar boton de chip prepago", btn_SoloChipM7);
    }

    public boolean ValidarBtnM4Postpago(int id) throws Throwable {
        return validateObjExistByXpath("Validar boton de chip postpago", btn_SoloChipM4);
    }

    public boolean ValidateCmbTipoDocumentoB(int id) throws Throwable {
        return validateObjExistById("Validar Lista", cmb_TipoDocumentoB, false);
    }

    public boolean validateTxtNumDocumentoB(int id) throws Throwable {
        return validateObjExistById("Validar caja de texto Documento", txt_NumDocumentoB, false);
    }

    public boolean validateTxtSuscripcion(int id) throws Throwable {
        return validateObjExistById("Validar caja de texto Suscripcion", txt_Suscripcion, false);
    }

    public boolean ValidateBtnBuscar(int id) throws Throwable {
        return validateObjExistById("Validar boton Buscar", btn_Buscar , false);
    }
}
