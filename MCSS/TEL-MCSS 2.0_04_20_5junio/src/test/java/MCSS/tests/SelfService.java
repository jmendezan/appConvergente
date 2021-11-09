package MCSS.tests;

import MCSS.exceptions.ExceptionHandler;
import MCSS.helpers.BasePage;
import MCSS.helpers.Hook;
import MCSS.pageObject.MCSS.P001_MCSS_LoginPage;
import MCSS.pageObject.MiMovistar.*;
import MCSS.pageObject.PermisosPage;
import MCSS.pageObject.SelfService.S001_PrincipalPage;
import MCSS.utility.ExcelUtils;
import MCSS.utility.GlobalVariable;
import MCSS.utility.ScreenshotUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SelfService {

    public WebDriver driver;
    private Hook hook = new Hook();
    BasePage basepage = new BasePage();
    public String sIndice;
    String escenario;
    String feature;
    String tester;
    protected ScreenshotUtility utilitarios = new ScreenshotUtility();
    P001_MCSS_LoginPage p001_mcss_loginPage = new P001_MCSS_LoginPage();
    P001_Mi_Movistar_LoginPage p001_mi_movistar_loginPage = new P001_Mi_Movistar_LoginPage();
    P002_Mi_Movistar_HomePage p002_mi_movistar_homePage = new P002_Mi_Movistar_HomePage();
    P003_Mi_Movistar_SeleccionarPlanPage p003_mi_movistar_seleccionarPlanPage = new P003_Mi_Movistar_SeleccionarPlanPage();
    P004_Mi_Movistar_CheckoutPage p004_mi_movistar_checkoutPage = new P004_Mi_Movistar_CheckoutPage();
    P005_Mi_Movistar_WICPage p005_mi_movistar_wicPage = new P005_Mi_Movistar_WICPage();
    S001_PrincipalPage s001_principalPage = new S001_PrincipalPage();
    PermisosPage permisosPage = new PermisosPage();
    BasePage base = new BasePage();
    int numRows;
    String snum;


    @Given("^Ingreso a SelfService con cliente \"([^\"]*)\"$")
    public void loginSelfService(int id) throws Throwable {
        Object[][] clients = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.SELFSERVICE);//loadExcel("SelfService");
        sIndice = clients[(id - 1)][0].toString();
        escenario= clients[(id - 1)][7].toString();
        feature= clients[(id - 1)][8].toString();
        tester= clients[(id - 1)][9].toString();

        try {
            numRows = ExcelUtils.getTable(GlobalVariable.PATH, "Ejecuciones").length;//numRows("Ejecuciones");
            System.out.println(numRows);
            numRows = numRows + 1;
            snum = Integer.toString(numRows);
            String fecha_inicio = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Inicio", snum, fecha_inicio);//setExcel("Ejecuciones", "Inicio", snum, fecha_inicio);
            Object[][] parameters = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.AMBIENTE);//loadExcel("Ambiente");
            String surl = parameters[0][1].toString();
            String sBrowser = parameters[0][5].toString();
       //     Object[][] Clients = LoadExcel("SelfService");
            String sTipoDocumento = clients[(id - 1)][2].toString();
            String sNumeroDocumento = clients[(id - 1)][3].toString();
            String sTipoVenta = clients[(id - 1)][5].toString();
            hook.setUp(sBrowser, surl);
            permisosPage.continuar();
            Assert.assertTrue(p001_mcss_loginPage.validatechbTipoDocumento(id));
            p001_mcss_loginPage.doLoginMCSSSelfservice(sTipoDocumento, sNumeroDocumento, id);
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "Fail");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "Error en el inicio de sesion de MCSS");//setExcel("Ejecuciones", "Error", snum, "Error en el inicio de sesion de MCSS");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "ID", snum, snum);//setExcel("Ejecuciones", "ID", snum, snum);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NACIONALIDAD", snum, "No se uso");//setExcel("Ejecuciones", "NACIONALIDAD", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "DOCUMENTO", snum, "No se uso");//setExcel("Ejecuciones", "DOCUMENTO", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NUMERO", snum, "No se uso");//setExcel("Ejecuciones", "NUMERO", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TIPOPLAN", snum, "No se uso");//setExcel("Ejecuciones", "TIPOPLAN", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "TipoAlta", snum, "No se uso");//setExcel("Ejecuciones", "TipoAlta", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "NroOrden", snum, "No se genero");//setExcel("Ejecuciones", "NroOrden", snum, "No se genero");
            ExceptionHandler.doException(e, "ERROR_INICIO_De_Sesion_MCSS", tester, id, true);
        }
    }

    @When("^Elijo el tipo de tansacción - Compra paquete de voz pago al recibo \"([^\"]*)\" y realizo operación$")
    public void Elejir_transaccion(int id) throws Throwable {
        try {
            Thread.sleep(20000);
            s001_principalPage.elegirSuscripcion(id);
            Thread.sleep(20000);
            s001_principalPage.comprarPaquetes(id);
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "Fail");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Validacion_WIC");//setExcel("Ejecuciones", "Error", snum, "ERROR_Validacion_WIC");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "SimCard", snum, "No se uso");//setExcel("Ejecuciones", "SimCard", snum, "No se uso");
            ExceptionHandler.doException(e, "Elegir_transaccion", tester, id, true);
        }
    }

    @Then("^Obtengo código de transacción \"([^\"]*)\"$")
    public void obtengo_orden_compra(int id) throws Throwable {
        Object[][] clients = ExcelUtils.getTable(GlobalVariable.PATH, GlobalVariable.SELFSERVICE);//loadExcel("SelfService");
        sIndice = clients[(id - 1)][0].toString();
        try {
            String orden;
            Thread.sleep(2000);
            orden = s001_principalPage.getOrden();
            System.out.println("Orden de compra: " + orden);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.SELFSERVICE, "ORDENCOMPRA", sIndice, orden);//setExcel("SelfService", "ORDENCOMPRA", sIndice, orden);
            hook.closeBrowser(basepage.handleDriver(), tester, id, "EXITO", orden);
        } catch (AssertionError e) {
            String fecha_fin = base.obtenerFechaYHora();
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Fin", snum, fecha_fin);//setExcel("Ejecuciones", "Fin", snum, fecha_fin);
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Resultado", snum, "Fail");//setExcel("Ejecuciones", "Resultado", snum, "Fail");
            ExcelUtils.setCell(GlobalVariable.PATH, GlobalVariable.EJECUCIONES, "Error", snum, "ERROR_Cierre_Venta");//setExcel("Ejecuciones", "Error", snum, "ERROR_Cierre_Venta");
            ExceptionHandler.doException(e, "ERROR_Cierre_Venta", tester, id, true);
        }
    }

   /* public Object[][] loadExcel(String SheetName) throws Exception {
        Object[][] testObjArray = null;
        testObjArray = ExcelUtils.getTableArray("./src/test/resources/data/TestData.xlsx", SheetName);
        return (testObjArray);
    }
*//*
    public void setExcel(String SheetName, String ColName, String SrowNum, String sData) {
        ExcelUtils.setCell("./src/test/resources/data/TestData.xlsx", SheetName, ColName, SrowNum, sData);
    }*/
/*
    public int numRows(String SheetName) throws Exception {
        int num;
        Object[][] parameter = ExcelUtils.getTable(GlobalVariable.PATH, SheetName);//loadExcel(SheetName);
        num = parameter.length;
        return num;
    }
*/
}
