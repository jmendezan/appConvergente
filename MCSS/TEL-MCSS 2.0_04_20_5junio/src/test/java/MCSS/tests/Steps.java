/**************************************************
 #Autor : Wipro
 #Description : E2E - Venta Fija – Alta
 #Fecha de creación: Feb 2020
 # Venta Fija Version: XXXX
 #Input Parameters: --
 #Nombre que modifica : --
 #Fecha modificación: --
 **************************************************/
package MCSS.tests;

import MCSS.exceptions.ExceptionHandler;
import MCSS.helpers.BasePage;
import MCSS.helpers.Hook;
import MCSS.pageObject.MCSS.P001_MCSS_LoginPage;
import MCSS.pageObject.MiMovistar.*;
import MCSS.pageObject.PermisosPage;
import MCSS.utility.ExcelUtils;
import MCSS.utility.GlobalVariable;
import MCSS.utility.ScreenshotUtility;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class Steps {
    public WebDriver driver;
    private Hook hook = new Hook();
    protected ScreenshotUtility utilitarios = new ScreenshotUtility();
    P001_MCSS_LoginPage p001_mcss_loginPage = new P001_MCSS_LoginPage();
    P001_Mi_Movistar_LoginPage p001_mi_movistar_loginPage = new P001_Mi_Movistar_LoginPage();
    P002_Mi_Movistar_HomePage p002_mi_movistar_homePage = new P002_Mi_Movistar_HomePage();
    P003_Mi_Movistar_SeleccionarPlanPage p003_mi_movistar_seleccionarPlanPage = new P003_Mi_Movistar_SeleccionarPlanPage();
    P004_Mi_Movistar_CheckoutPage p004_mi_movistar_checkoutPage = new P004_Mi_Movistar_CheckoutPage();
    P005_Mi_Movistar_WICPage p005_mi_movistar_wicPage = new P005_Mi_Movistar_WICPage();
    P006_SeleccionarEquipoPlanPage p006_seleccionar_equipo_planPage = new P006_SeleccionarEquipoPlanPage();

    PermisosPage permisosPage = new PermisosPage();
    BasePage base = new BasePage();
    int numRows;
    String snum;
    String tester;

    /****FLUJO Prepago, Postpago y Cambio *****/
    @Given("^Ingreso al login de MCSS con Dealer User \"([^\"]*)\"$")
    public void loginMCSS(int id) throws Throwable {
        try {
            System.out.println("id:"+id);
            numRows = ExcelUtils.getTable(GlobalVariable.PATH, "Ejecuciones").length;//numRows("Ejecuciones");
            numRows = numRows + 1;
            snum = Integer.toString(numRows);
            String fecha_inicio = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Inicio", snum, fecha_inicio);//setExcel("Ejecuciones", "Inicio", snum, fecha_inicio);
            Object[][] parameters = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.AMBIENTE);//loadExcel("Ambiente");
            String surl = parameters[0][1].toString();
            String sBrowser = parameters[0][5].toString();
            tester = parameters[0][6].toString();
            hook.setUp(sBrowser, surl);
            permisosPage.continuar();
            Assert.assertTrue(p001_mcss_loginPage.validarBtnDealer(id));
            p001_mcss_loginPage.doLoginMCSSPrincipal(id);

        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            System.out.println("Error en loginMCSS()_AssertionError");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "Error en el inicio de sesion de MCSS");//setExcel("Ejecuciones", "Error", snum, "Error en el inicio de sesion de MCSS");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "ID", snum, snum);//setExcel("Ejecuciones", "ID", snum, snum);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, "No se uso");  //setExcel("Ejecuciones", "NACIONALIDAD", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, "No se uso");//setExcel("Ejecuciones", "DOCUMENTO", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, "No se uso");//setExcel("Ejecuciones", "NUMERO", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, "No se uso");//setExcel("Ejecuciones", "TIPOPLAN", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, "No se uso");//setExcel("Ejecuciones", "TipoAlta", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NroOrden", snum, "No se uso");//setExcel("Ejecuciones", "NroOrden", snum, "No se genero");
            ExceptionHandler.doException(e, "ERROR_INICIO_De_Sesion_MCSS", tester, id, true);
        }

    }

    @And("^Ingreso al login de Mimovistar con \"([^\"]*)\"$")
    public void loginMiMovistar(int id) throws Throwable {
        try {
            Object[][] parameters = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.AMBIENTE);//loadExcel("Ambiente");
            String sUsername = parameters[0][2].toString();
            String sPassword = parameters[0][3].toString();

            Thread.sleep(2000);
            Assert.assertTrue(p001_mi_movistar_loginPage.validarTxtUser(id));
            Assert.assertTrue(p001_mi_movistar_loginPage.validarTxtPass(id));
            p001_mi_movistar_loginPage.doLoginMovistar(sUsername, sPassword, id);
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            System.out.println("Error en LoginMiMovistar()_AssertionError");

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "Fail");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "Error en el inicio de sesion de Mi Movistar");//setExcel("Ejecuciones", "Error", snum, "Error en el inicio de sesion de Mi Movistar");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, "No se uso");//setExcel("Ejecuciones", "NACIONALIDAD", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, "No se uso");//setExcel("Ejecuciones", "DOCUMENTO", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, "No se uso");//setExcel("Ejecuciones", "NUMERO", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, "No se uso");//setExcel("Ejecuciones", "TIPOPLAN", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, "No se uso");//setExcel("Ejecuciones", "TipoAlta", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NroOrden", snum, "No se genero");//setExcel("Ejecuciones", "NroOrden", snum, "No se genero");
            ExceptionHandler.doException(e, "ERROR_Login Mi Movistar", tester, id, true);
        }

    }

    @And("^Seleccion el Alta Prepago solo chip con \"([^\"]*)\"$")
    public void Alta(int id) throws Throwable {
        try {
            Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.PREPAGO);//loadExcel("Usuario");
            String sNacionalidad = parameter[(id - 1)][1].toString();
            String sTipoDocumento = parameter[(id - 1)][2].toString();
            String sNumeroDocumento = parameter[(id - 1)][3].toString();
            String sTipoVenta = parameter[(id - 1)][4].toString();
            String sTipoAlta = parameter[(id - 1)][5].toString(); //TipoAlta='SoloChipPrepago
            String sTipoPlan = parameter[(id - 1)][6].toString();
            String sSuscripcion = parameter[(id - 1)][7].toString();
            String sPlanesMoviles = parameter[(id - 1)][19].toString();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "ID", snum, snum);//setExcel("Ejecuciones", "ID", snum, snum);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, sNacionalidad);//setExcel("Ejecuciones", "NACIONALIDAD", snum, sNacionalida);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, sTipoDocumento);//setExcel("Ejecuciones", "DOCUMENTO", snum, sTipoDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, sNumeroDocumento);//setExcel("Ejecuciones", "NUMERO", snum, sNumeroDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, sTipoPlan);//setExcel("Ejecuciones", "TIPOPLAN", snum, sTipoPlan);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, sTipoAlta);//setExcel("Ejecuciones", "TipoAlta", snum, sTipoAlta);
            Thread.sleep(9000);
            p002_mi_movistar_homePage.doClickTipoVenta(sTipoVenta, sTipoDocumento, sNumeroDocumento, sTipoAlta, sSuscripcion, id); //PREPAGO - sTipoAlta=SoloChipPrepago

            Thread.sleep(5000);
            p003_mi_movistar_seleccionarPlanPage.doComprar(sPlanesMoviles, sTipoPlan, id); //PREPAGO
            Thread.sleep(5000);
            String orden = p004_mi_movistar_checkoutPage.obtenerNroOrden();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NroOrden", snum, orden);//setExcel("Ejecuciones", "NroOrden", snum, orden); //PREPAGO
            p004_mi_movistar_checkoutPage.doDatos(id);
            p004_mi_movistar_checkoutPage.doPago(id);
            permisosPage.continuar();
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            System.out.println("Error en Alta()_AssertionError");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.PREPAGO, "oStatus", Integer.toString(id), "FALLO");//setExcel("Ejecuciones", "NroOrden", snum, orden); //PREPAGO

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "Fail");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Alta_Prepago");//setExcel("Ejecuciones", "Error", snum, "ERROR_Alta_Prepago");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");

            ExceptionHandler.doException(e, "ERROR_Alta_Prepago", tester, id, true);
        }
    }

    @When("^Valido identidad del cliente con el \"([^\"]*)\" y genero recibos en Prepago$")
    public void ValidacionPrepago(int id) throws Throwable {
        try {
            System.out.println("En_Validacion_Identidad_Cliente");
            Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.PREPAGO);//loadExcel("Usuario");
            String sNacionalidad = parameter[(id - 1)][1].toString();
            String sDNI = parameter[(id - 1)][2].toString();
            String sPadre = parameter[(id - 1)][6].toString();
            String sMadre = parameter[(id - 1)][7].toString();
            String sDistrito = parameter[(id - 1)][8].toString();
            Assert.assertTrue(p005_mi_movistar_wicPage.validarBtn(id));
            p005_mi_movistar_wicPage.validacionIdentidad(sDNI, sPadre, sMadre, sDistrito, id); //PREPAGO
            p004_mi_movistar_checkoutPage.nuevaLineaOrden(id); //prepago
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            System.out.println("Error en ValidacionPrepago()_AssertionError");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.PREPAGO, "oStatus", Integer.toString(id), "FALLO");//setExcel("Ejecuciones", "NroOrden", snum, orden); //PREPAGO
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "Fail");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Validacion_WIC");//setExcel("Ejecuciones", "Error", snum, "ERROR_Validacion_WIC");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Validacion_WIC", tester, id, true);
        }


    }

    @When("^Valido identidad del cliente con el \"([^\"]*)\" y genero recibos en Postpago$")
    public void ValidacionPostpago(int id) throws Throwable {
        try {
            System.out.println("En_Validacion_Identidad_Cliente");
            Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.POSTPAGO);//loadExcel("Usuario");
            String sTipoDocumento = parameter[(id - 1)][2].toString();
            String sPadre = parameter[(id - 1)][6].toString();
            String sMadre = parameter[(id - 1)][7].toString();
            String sDistrito = parameter[(id - 1)][8].toString();
            Assert.assertTrue(p005_mi_movistar_wicPage.validarBtn(id));
            p005_mi_movistar_wicPage.validacionIdentidad(sTipoDocumento, sPadre, sMadre, sDistrito, id); //POSTPAGO
            p004_mi_movistar_checkoutPage.nuevaLineaOrden(id); //postpago
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            System.out.println("Error en ValidacionPostpago()_AssertionError");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.POSTPAGO, "oStatus", Integer.toString(id), "FALLO");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Validacion_WIC");//setExcel("Ejecuciones", "Error", snum, "ERROR_Validacion_WIC");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Validacion_WIC", tester, id, true);
        }

    }

    @Then("^Cierro el alta prepago del cliente con \"([^\"]*)\"$")
    public void Cierre_Alta(int id) throws Throwable {
        try {
            Object[][] parameter =  ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.PREPAGO);//loadExcel("Usuario");
            String sSimcard = parameter[(id - 1)][12].toString();
            String sMessage = parameter[(id - 1)][14].toString();
            String sConfirmacion = parameter[(id - 1)][19].toString();
            System.out.println("sConfirmacion:"+sConfirmacion);
            p004_mi_movistar_checkoutPage.doConfirmarOrden(sSimcard, id);
            p004_mi_movistar_checkoutPage.doConfirmarVenta(id);
            Thread.sleep(2000);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, sSimcard);//setExcel("Ejecuciones", "SimCard", snum, sSimcard);
            Assert.assertTrue(!p004_mi_movistar_checkoutPage.validarMaterialDisponible());
            Assert.assertTrue(p004_mi_movistar_checkoutPage.validarVenta(sConfirmacion, id));
            //Assert.assertFalse(p004_mi_movistar_checkoutPage.ValidarError(id));

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.PREPAGO, "oStatus", Integer.toString(id), "EXITO");//setExcel("Ejecuciones", "NroOrden", snum, orden); //PREPAGO

        } catch (AssertionError e) {
            System.out.println("Cierre_Alta()_assertionError");
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.PREPAGO, "oStatus", Integer.toString(id), "FALLO");//setExcel("Ejecuciones", "NroOrden", snum, orden); //PREPAGO
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cierre_Venta");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cierre_Venta");
            ExceptionHandler.doException(e, "ERROR_Cierre_Venta", tester, id, true);
        }
    }


    ////****Postpago *****/////

    @And("^Seleccion el Alta Postpago solo chip con \"([^\"]*)\"$")
    public void altaPostpago(int id) throws Throwable {
        try {
            System.out.println("opcion postpago_id:" + id);

            ///
            ExcelUtils.setExcelFile(GlobalVariable.PATH, GlobalVariable.POSTPAGO);
            String data= ExcelUtils.getCellDataXColumn(GlobalVariable.POSTPAGO, "iNombrePlan", (id - 1));
            System.out.println("Excel_id:"+id+"_data:"+data);
            ///

            Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.POSTPAGO);//loadExcel("AltaPostpago");
            String sNacionalidad = parameter[(id - 1)][1].toString();
            String sTipoDocumento = parameter[(id - 1)][2].toString();
            String sNumeroDocumento = parameter[(id - 1)][3].toString();
            String sTipoVenta = parameter[(id - 1)][4].toString();
            String sTipoAlta = parameter[(id - 1)][5].toString();
            String sTipoPlan = parameter[(id - 1)][10].toString();
            String sNombrePlan = parameter[(id - 1)][24].toString();
            String sSuscripcion = parameter[(id - 1)][7].toString();
            String sPlanesMoviles = parameter[(id - 1)][29].toString();

            //**Datos para Factura Nueva:**//
            String sDepartamento = parameter[(id - 1)][17].toString();
            String sProvincia = parameter[(id - 1)][18].toString();
            String sDistrito = parameter[(id - 1)][19].toString();
            String sTipoCalle = parameter[(id - 1)][20].toString();
            String sNombreCalle = parameter[(id - 1)][21].toString();
            String sNro = parameter[(id - 1)][22].toString();
            String sMza = parameter[(id - 1)][23].toString();

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "ID", snum, snum);//setExcel("Ejecuciones", "ID", snum, snum);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, sNacionalidad);//setExcel("Ejecuciones", "NACIONALIDAD", snum, sNacionalida);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, sTipoDocumento);//setExcel("Ejecuciones", "DOCUMENTO", snum, sTipoDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, sTipoDocumento);//setExcel("Ejecuciones", "NUMERO", snum, sNumeroDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, sTipoPlan);//setExcel("Ejecuciones", "TIPOPLAN", snum, sTipoPlan);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, sTipoAlta);//setExcel("Ejecuciones", "TipoAlta", snum, sTipoAlta);
            Thread.sleep(9000);
            System.out.println("stipoventa:"+sTipoVenta);
            System.out.println("stipoalta:"+sTipoAlta);
            System.out.println("sTipoPlan:"+sTipoPlan);

            /**Llamada al metodo p002_mi_movistar_homePage.doClickTipoVenta para seleccionar el boton correspondiente al tipo de ALTA*/
            p002_mi_movistar_homePage.doClickTipoVenta(sTipoVenta, sTipoDocumento, sNumeroDocumento, sTipoAlta, sSuscripcion, id);//POSTPAGO
            /***Aceptando certificado de seguridad**/
            permisosPage.continuar();
            /***Validacion WIC_1**/
            p005_mi_movistar_wicPage.doClickPostpago(id); // Alta Postpago
            /***Click Comprar Paquete***/
            p003_mi_movistar_seleccionarPlanPage.doComprar(sPlanesMoviles, sNombrePlan, id); //POSTPAGO
        //    Thread.sleep(10000);
            String orden = p004_mi_movistar_checkoutPage.obtenerNroOrden(); //POSTPAGO
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NroOrden", snum, orden);//setExcel("Ejecuciones", "NroOrden", snum, orden);
            System.out.println("String.valueOf(id):"+String.valueOf(id));
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.POSTPAGO, "NroOrden", String.valueOf(id), orden);//setExcel("AltaPostpago", "NroOrden", String.valueOf(id), orden);

            p004_mi_movistar_checkoutPage.doDatos(id); //POSTPAGO
            p004_mi_movistar_checkoutPage.doEntregaFacturacion(sDepartamento, sProvincia, sDistrito, sTipoCalle, sNombreCalle, sNro, sMza, id);
            p004_mi_movistar_checkoutPage.doPago(id);

        } catch (AssertionError e) {
            System.out.println("AltaPostpago()AssertionError");

            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.POSTPAGO, "oStatus", Integer.toString(id), "FALLO");//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Alta_Postpago");//setExcel("Ejecuciones", "Error", snum, "ERROR_Alta_Postpago");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Alta_Postpago", tester, id, false);
        }
    }


    @Then("^Cierro el Alta Postpago del cliente con \"([^\"]*)\"$")
    public void cierroElAltaPostpagoDelClienteCon(int id) throws Throwable {
        try {
            Object[][] parameter =  ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.POSTPAGO);//loadExcel("AltaPostpago");
            String sSimcard = parameter[(id - 1)][9].toString();
            String sMessage = parameter[(id - 1)][14].toString();
            String sConfirmacion = parameter[(id - 1)][15].toString();
            System.out.println("sConfirmacion:"+sConfirmacion);
            p004_mi_movistar_checkoutPage.doConfirmarOrden(sSimcard, id);
            //SE COMENTA LA CONFIRMACION DE LA ORDEN DE ALTA POSTPAGO
            p004_mi_movistar_checkoutPage.doConfirmarVenta(id);
            Thread.sleep(2000);

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, sSimcard);//setExcel("Ejecuciones", "SimCard", snum, sSimcard);
            String numOrder2 = p004_mi_movistar_checkoutPage.obtenerNroOrden2();
            // Assert.assertTrue(!p004_mi_movistar_checkoutPage.ValidarMaterialDisponible(id));
            Assert.assertTrue(p004_mi_movistar_checkoutPage.validarVenta(sConfirmacion, id));

            //Assert.assertFalse(p004_mi_movistar_checkoutPage.ValidarError(id));

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NroOrden2", snum, numOrder2);//setExcel("Ejecuciones", "NroOrden2", snum, numOrder2);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.POSTPAGO, "NroOrden2", snum, numOrder2);//setExcel("AltaPostpago", "NroOrden2", snum, numOrder2);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.POSTPAGO, "oStatus", Integer.toString(id), "EXITO");
        } catch (AssertionError e) {
            System.out.println("cierroElAltaPostpagoDelClienteCon()AssertionError");

            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.POSTPAGO, "oStatus", Integer.toString(id), "FALLO");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cierre_Venta");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cierre_Venta");
            ExceptionHandler.doException(e, "ERROR_En_Confirmar_Cierre_Venta", tester, id, true);
        }
    }

    /****CAEQ + CAPL *****/

    @And("^Consulto suscripcion y selecciono Cambio de quipo y Plan con \"([^\"]*)\"$")
    public void caeq_capl(int id) throws Throwable {
        try {
            Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.CAMBIO);//loadExcel("Cambio");
            String sNacionalidad = parameter[(id - 1)][1].toString();
            String sTipoDocumento = parameter[(id - 1)][2].toString();
            String sNumeroDocumento = parameter[(id - 1)][3].toString();
            String sTipoVenta = parameter[(id - 1)][4].toString();
            String sTipoAlta = parameter[(id - 1)][5].toString();
            String sTipoPlan = parameter[(id - 1)][6].toString();
            String sSuscripcion = parameter[(id - 1)][7].toString();
            String sIMEI = parameter[(id - 1)][11].toString();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "ID", snum, snum);//setExcel("Ejecuciones", "ID", snum, snum);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, sNacionalidad);//setExcel("Ejecuciones", "NACIONALIDAD", snum, sNacionalida);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, sTipoDocumento);//setExcel("Ejecuciones", "DOCUMENTO", snum, sTipoDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, sNumeroDocumento);//setExcel("Ejecuciones", "NUMERO", snum, sNumeroDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, sTipoPlan);//setExcel("Ejecuciones", "TIPOPLAN", snum, sTipoPlan);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, sTipoAlta);//setExcel("Ejecuciones", "TipoAlta", snum, sTipoAlta);
            Thread.sleep(20000);


            /*Assert.assertTrue(p002_mi_movistar_homePage.ValidateCmbTipoDocumentoB(id));
            Assert.assertTrue(p002_mi_movistar_homePage.validateTxtNumDocumentoB(id));
            Assert.assertTrue(p002_mi_movistar_homePage.validateTxtSuscripcion(id));
            Assert.assertTrue(p002_mi_movistar_homePage.ValidateBtnBuscar(id));*/
                                    //doClickTipoVenta(sTipoVenta, sTipoDocumento, sNumeroDocumento, sTipoAlta, sSuscripcion, id);
            p002_mi_movistar_homePage.doBuscarCliente(sTipoDocumento, sNumeroDocumento, sTipoAlta, sSuscripcion, id);//CAEQ + CAPL
            Thread.sleep(60000);
            permisosPage.continuar();
            p005_mi_movistar_wicPage.doClickPostpago(id);
            Thread.sleep(60000);
            p003_mi_movistar_seleccionarPlanPage.doRenovarEquipo();
            Thread.sleep(60000);
            System.out.println("Steps_COmentado TOdo el codigo");
            //Desde aca descomentar linea 410todo hasta linea 422
     /*       p003_mi_movistar_seleccionarPlanPage.elegirTipoCambio(sIMEI, id);
            //Click Comprar Paquete:
            p003_mi_movistar_seleccionarPlanPage.doCambioPlan(sTipoPlan,id);
            Thread.sleep(10000);
            String orden = p004_mi_movistar_checkoutPage.obtenerNroOrden();
            setExcel("Ejecuciones", "NroOrden", snum, orden);



            p004_mi_movistar_checkoutPage.doDatos(id);
            p004_mi_movistar_checkoutPage.doPago(id);
            permisosPage.Continuar();   */
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            System.out.println("caeq_capl()AssertionError");

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Alta_Prepago");//setExcel("Ejecuciones", "Error", snum, "ERROR_Alta_Prepago");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Alta_Prepago", tester, id, true);
        }
    }

    /****CAPL*****/
    @And("^Consulto suscripcion y selecciono Cambio de Plan con \"([^\"]*)\"$")
    public void capl(int id) throws Throwable {
        try {
            Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.CAMBIO);//loadExcel("Cambio");
            String sNacionalidad = parameter[(id - 1)][1].toString();
            String sTipoDocumento = parameter[(id - 1)][2].toString();
            String sNumeroDocumento = parameter[(id - 1)][3].toString();
          //  String sTipoVenta = parameter[(id - 1)][4].toString();
            String sTipoAlta = parameter[(id - 1)][4].toString();
            String sTipoPlan = parameter[(id - 1)][5].toString();
            String sSuscripcion = parameter[(id - 1)][6].toString();
            String sPlanesMoviles = parameter[(id - 1)][10].toString();

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "ID", snum, snum);//setExcel("Ejecuciones", "ID", snum, snum);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, sNacionalidad);//setExcel("Ejecuciones", "NACIONALIDAD", snum, sNacionalida);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, sTipoDocumento);//setExcel("Ejecuciones", "DOCUMENTO", snum, sTipoDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, sNumeroDocumento);//setExcel("Ejecuciones", "NUMERO", snum, sNumeroDocumento);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, "Nuevo Plan_"+sTipoPlan);//setExcel("Ejecuciones", "TIPOPLAN", snum, "Nuevo Plan_"+sTipoPlan);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, sTipoAlta);//setExcel("Ejecuciones", "TipoAlta", snum, sTipoAlta);


            /*Assert.assertTrue(p002_mi_movistar_homePage.ValidateCmbTipoDocumentoB(id));
            Assert.assertTrue(p002_mi_movistar_homePage.validateTxtNumDocumentoB(id));
            Assert.assertTrue(p002_mi_movistar_homePage.validateTxtSuscripcion(id));
            Assert.assertTrue(p002_mi_movistar_homePage.ValidateBtnBuscar(id));*/

          //  p002_mi_movistar_homePage.doClickTipoVenta(sTipoVenta, sTipoDocumento, sNumeroDocumento, sTipoAlta, sSuscripcion, id);
            p002_mi_movistar_homePage.doBuscarCliente(sTipoDocumento, sNumeroDocumento, sTipoAlta, sSuscripcion, id);

            Thread.sleep(10000);
            permisosPage.continuar();
            p005_mi_movistar_wicPage.doClickPostpago(id);
            //Desde aca descomentar linea 410todo hasta linea 422
            p003_mi_movistar_seleccionarPlanPage.doCambiarSoloPlan();
            Thread.sleep(3000);
            p003_mi_movistar_seleccionarPlanPage.doComprar(sPlanesMoviles, sTipoPlan , id);
            p004_mi_movistar_checkoutPage.doPago(id);

        } catch (AssertionError e) {
            System.out.println("AssertionError:_capl");
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oNRO_ORDEN", Integer.toString(id), "");//setExcel("Cambio", "oNRO_ORDEN", snum, orden);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oSTATUS", Integer.toString(id), "FALLO");//setExcel("Cambio", "oSTATUS", snum, "FALLO");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cambio_Plan");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cambio_Plan");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");

            ExceptionHandler.doException(e, "ERROR_En la busqueda del cliente, compra del Plan o Generacion de Contrato", tester, id, true);
        }
    }


    @When("Valido identidad del cliente con el \"([^\"]*)\" para cambio de Plan$")
    public void validoIdentidadDelClienteConElParaCambioDePlan(int id) throws Exception {
        try {
            p005_mi_movistar_wicPage.continuarWIC_clienteCE();
        } catch (AssertionError e) {

            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oNRO_ORDEN", Integer.toString(id), "");//setExcel("Cambio", "oNRO_ORDEN", snum, orden);

            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oSTATUS", Integer.toString(id), "FALLO");//setExcel("Cambio", "oSTATUS", snum, "FALLO");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cambio_Plan");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cambio_Plan");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Alta_Prepago", tester, id, true);
        }
    }

    @Then("Cierro el CAPL del cliente \"([^\"]*)\" y obtengo numero de orden$")
    public void cierroElCAPLDelCliente(int id) throws Exception {
        try{
        Object[][] parameter =  ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.CAMBIO);//loadExcel("Cambio");

        String sConfirmacion = parameter[(id - 1)][11].toString(); //sConfirmacion
        p004_mi_movistar_checkoutPage.guardarCompra();
        Thread.sleep(3000);
        String orden = p004_mi_movistar_checkoutPage.obtenerNroOrden3();
        String status =  p004_mi_movistar_checkoutPage.obtenerStatusPrueba(sConfirmacion, id);
        Assert.assertTrue(p004_mi_movistar_checkoutPage.validarVenta(sConfirmacion, id));

        ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oNRO_ORDEN", Integer.toString(id), orden);//setExcel("Cambio", "oNRO_ORDEN", snum, orden);
        ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oSTATUS", Integer.toString(id), status);//setExcel("Cambio", "oSTATUS", snum, status);
        ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No Aplica");//setExcel("Ejecuciones", "SimCard", snum, "No Aplica");
        String fecha_fin = base.obtenerFechaYHora();
        ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
        ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "EXITO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
        base.takeScreenshot("EXITO_Flujo Cambio de Plan_Orden generada");
        Hook.closeBrowser(BasePage.handleDriver(), tester, id,"EXITO", orden);

    } catch (AssertionError e) {
            System.out.println("AssertionError:cierroElCAPLDelCliente");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oNRO_ORDEN", Integer.toString(id), "");//setExcel("Cambio", "oNRO_ORDEN", snum, orden);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oSTATUS", Integer.toString(id), "FALLO");//setExcel("Cambio", "oSTATUS", snum, "FALLO");
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cambio_Plan");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cambio_Plan");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Alta_Prepago", tester, id, true);
        }
    }

    @And("^Seleccionar equipo\"([^\"]*)\"$")
    public void seleccionarEquipo(int id) throws Throwable {
        try {
            //Pantalla Seleccionar Equipo y Plan

            /**Llamada al metodo p002_mi_movistar_homePage.doClickTipoVenta para seleccionar el boton correspondiente al tipo de ALTA*/
            p006_seleccionar_equipo_planPage.doAgregarIMEI(id);//POSTPAGO
            /***Aceptando certificado de seguridad**/
        }catch(AssertionError e){
            System.out.println("AssertionError:cierroElCAPLDelCliente");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oNRO_ORDEN", Integer.toString(id), "");//setExcel("Cambio", "oNRO_ORDEN", snum, orden);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.CAMBIO, "oSTATUS", Integer.toString(id), "FALLO");//setExcel("Cambio", "oSTATUS", snum, "FALLO");
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "FALLO");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cambio_Plan");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cambio_Plan");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "ERROR_Alta_Prepago", tester, id, true);        }

    }
   /* public Object[][] loadExcel(String SheetName) throws Exception {
        Object[][] testObjArray = null;
        testObjArray = ExcelUtils.getTableArray("./src/test/resources/data/TestData.xlsx", SheetName);
        return (testObjArray);
    }*/

/*  public void setExcel(String SheetName, String ColName, String SrowNum, String sData) {
        ExcelUtils.setCellData("./src/test/resources/data/TestData.xlsx", SheetName, ColName, SrowNum, sData);
    }*/
/*
    public int numRows(String SheetName) throws Exception {
        int num;
        Object[][] Parameter =  ExcelUtils.getTable(GlobalVariable.PATH, SheetName);//loadExcel(SheetName);
        num = Parameter.length;
        return num;

    }*/
}