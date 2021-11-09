package MCSS.pageObject.MiMovistar;

import MCSS.helpers.BasePage;
import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class P003_Mi_Movistar_SeleccionarPlanPage extends BasePage {

    String id;
    String sNombrePlan;
    String lbl_planWE = "//tr[contains(@id,'4394703')]//*[text()='Preplan']";
    String btn_LimpiarSeleccionados = "//*[@id=\"Maintable-tabs\"]/div[2]/div/div/div/div/div[2]/div[2]/a";
    String lbl_PrimerNumero = "//*[@id=\"NumberAllocationForm\"]/div[1]/div[2]/div/div/div[1]/div/label/span";
    String img_MCSSLoader = "|id|mcss_loader";

    //Renovar equipo
    String btn_RenovarEquipo = "//a[contains(text(),'Renovar equipo')]";

    //CAEQ+CAPL
    String txt_IMEI = "//input[@id='ownDeviceImei']";
    String btn_Continuar = "//body/div[@id='lienzoB_millon']/div/div/div[@id='main_content']/div/div/div/div/div/div/div/form[@id='ownDeviceForm']/div/input[1]";
    String btn_CAEQCAPL = "//span[1]//input[1]";
    String btn_CAEQ = "//span[2]//input[1]";
    String btn_PostpagoAbierta = "//span[contains(text(),'Postpago Abierta')]";
    String txt_Plan = "//*[@id=\"orderId\"]";
    String btn_Lupa = "//*[@id=\"orderIdIcon\"]";
    String btn_Comprar = "//body/div[@id='lienzoB_millon']/div/div/div[@id='main_content']/div/div/div/div/div[@id='content-center']/div[@id='Maintable-tabs']/div/div/div/div/div/div/div/div/table/tbody[@id='innerGrid']/tr[@id='34632311']/td/div/input[1]";

    String btn_Close = "//*[@id=\"okButton\"]";

    //CAPL
    String menu_Plan = "//*[@menuid=\"plan\"]";
    String btn_cambiarPlan= "//*[text()='Cambiar Plan']";

    //Menu Seleccionar Planes
    String lbl_PlanesMoviles= "//*[text()='";
    String lbl_buscadorPlanes = "//*[text()='Buscador de Planes:']";
    String txt_buscadorPlanes = "|id|orderId";
    String btn_buscadorPlanes = "|id|orderIdIcon";

    /*** doComprar: Método que hace click en el boton COMPRAR segun el Grupo de Plan y Nombre del Plan indicado en el Excel ***/
    public void doComprar(String sGrupoPlanesMoviles, String sNombrePlanInput, int id_2) throws Exception {
        //TipoPlan> Prepago  OR Postpago
        try {
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);
            wait("Esperar elemento", lbl_buscadorPlanes);
            Thread.sleep(500);
            doclickByJS("Click Menu Planes Moviles", lbl_PlanesMoviles+ sGrupoPlanesMoviles+"']", false);
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);
            System.out.println("plan:" + sNombrePlanInput);
            /*** Búsqueda del Plan ***/
            doclickByJS("Click en caja de texto del buscador", txt_buscadorPlanes,false);
            doAddTextField("Ingresar Plan a Buscar", txt_buscadorPlanes, sNombrePlanInput, false);
            doclickByJS("Click buscar Plan", btn_buscadorPlanes, true);
            /*** Click Boton Comprar en el Plan ***/
            sNombrePlan = sNombrePlanInput;
            String lbl_plan = ".//*[text()='" + sNombrePlan + "']";
            WebElement parentElement2 = getParentWebElement(lbl_plan);
            id = parentElement2.getAttribute("id").toString();
            String btn_Comprar = "//tr[contains(@id,'" + id + "')]//input[contains(@value,'Comprar')]";
            Thread.sleep(1000);
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);
            doJSScrollIntoView("Scrolldown hasta el plan", btn_Comprar, false);
            System.out.println("sNombrePlan1:"+sNombrePlan);
            sNombrePlan =sNombrePlan.replace("\\/", "");
            Thread.sleep(1000);
            doClick("Click en el boton de comprar del Plan", btn_Comprar, true);
        } catch (AssertionError e) {
            System.out.println("error en doComprar");
            e.printStackTrace();
        }
    }

    public void doCambioPlan(String sPlan, int id) {
        try {
            Thread.sleep(4000);
            wait("Validar boton Postpago", btn_PostpagoAbierta);
            doclickByJS("Escoger opcion Postpago Abierta",btn_PostpagoAbierta, true);
            wait("Validar Plan", txt_Plan);
            doAddTextField("Buscar Plan",txt_Plan, sPlan, false );
            doclickByJS("Click en boton Lupa", btn_Lupa, false);
            Thread.sleep(20000);
            //ANTES DEL BOTON COMPRAR
            //doclickByJS("Click en boton Comprar", btnComprar, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doRenovarEquipo() throws Throwable {
        try {
            System.out.println("en doRenoverEquipoMetodo");
            waitInvisibility("Esperar", btn_RenovarEquipo, false);
            Thread.sleep(20000);
            doJSScrollIntoView("ScrollDown", btn_RenovarEquipo,false);
            doclickByJS("Renovar equipo", btn_RenovarEquipo, true);
            System.out.println("en Metodo doRenovarEquipo");

        } catch (AssertionError | Exception e) {
            e.printStackTrace();
        }
    }

    public void doCambiarSoloPlan() throws Exception {
        waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);
        doclickByJS("Click Menu Plan", menu_Plan, true);
        waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);
        doJSScrollIntoView("ScrollDown", btn_cambiarPlan, false);
        doClick("Click Boton Cambiar Plan", btn_cambiarPlan, true );
    }

    public void elegirTipoCambio(String sIMEI, int id) {
        try {
            System.out.println("Antes de ingresar IMEI");
            Thread.sleep(5000);
            wait("Validar txtImei", txt_IMEI);
            System.out.println("Ingresar IMEI");
            doAddTextField("Ingresar IMEI del equipo", txt_IMEI, sIMEI, true);
            Thread.sleep(5000);
            wait("Validar boton continuar", btn_Continuar);
            doclickByJS("Click en Continuar", btn_Continuar, true);
            doclickByJS("Cerrar Popup", btn_Close, false);
            doclickByJS("Click en Continuar", btn_Continuar, false);
            wait("Validar boton CAMBIO", btn_CAEQCAPL);
            Thread.sleep(5000);
            doclickByJS("Elegir CAEQ mas CAPL", btn_CAEQCAPL, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
