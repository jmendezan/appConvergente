package MCSS.pageObject.SelfService;

import MCSS.helpers.BasePage;
import MCSS.utility.ObjectMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S001_PrincipalPage extends BasePage {

    String btn_Trinagulo = "//div[@class='logo_select onlydesk js-userUi-linea']//div[@class='arrow_image']";
    String btn_ComprarPaquetes = "//a[contains(text(),'Comprar paquetes')]";
    String op_PaquetesVoz = "//div[@id='recibo']//div//ul//div//a[@id='0']";
    String btn_Comprar_1 =   "//*[@id=\"postpago\"]/div/div/div[1]/button";  //"//body//div[@id='postpago']//div//div//div[1]//button[1]";
   // WebElement lbl_paquete_1 = "//*[text()='Paquete 200 min Todo Destino por 30 dias']";
    String btn_suscripcion = "//div[@id='subList']//div//div//div//div//div//div//a";
    String btn_Aceptar = "//a[contains(text(),'Aceptar')]";
    String lbl_Orden = "/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/span[2]";
    String img_MCSSLoader = "|id|mcss_loader";

    public void elegirSuscripcion(int id) throws Exception {
        wait("Esperar Subscripcion",btn_Trinagulo);
        Thread.sleep(5000);
        doClick("Abrir lista de suscripciones", btn_Trinagulo, false);
        doClick("Elegir suscripcion", btn_suscripcion, true);
    }

    public void comprarPaquetes(int id) throws Exception {
        try {
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);

            takeScreenshot("comprarPaquestes_S001_PrincipalPage_1");
//            Thread.sleep(30000);
            wait("Esperar boton Comprar",btn_ComprarPaquetes);
            doClick("Click en comprar paquete", btn_ComprarPaquetes, true);
            takeScreenshot("comprarPaquestes_S001_PrincipalPage_2");

           // Thread.sleep(30000);
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);

            wait("Paquete de Voz", op_PaquetesVoz);
            System.out.println("Pago en recibo");
            doClick("Click en opción Paquetes Voz", op_PaquetesVoz, true);
          //  Thread.sleep(40000);
            takeScreenshot("comprarPaquestes_S001_PrincipalPage_3");
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);
            wait("Boton Comprar", btn_Comprar_1);
            System.out.println("Paquete 200 min Todo Destino por 30 dias");
            waitInvisibility("Esperar que cargue pagina", img_MCSSLoader, false);

            doClick("Click en Comprar", btn_Comprar_1, true);
            ///
            String lbl_plan = ".//*[text()='" + "Paquete 200 min Todo Destino por 30 dias" + "']";
            System.out.println("btn_ComprarANTES");

            WebElement element = getParentWebElement2(lbl_plan);
            String text1 = element.getAttribute("xpath").toString();
            String btn_Comprar = "//tr[contains(@id,'" + text1 + "')]//input[contains(@value,'Comprar')]";
            System.out.println("btn_Comprar:"+btn_Comprar);
    /** DESCOMENTAR ACAAA
            wait("Boton Aceptar", btn_Aceptar);
            doClick("Click en Aceptar compra", btn_Aceptar, true);
   **/     } catch (Exception e){
            System.out.println("error aca en page123");
            e.printStackTrace();
        }
    }

    public String getOrden() throws Exception {
        wait("Etiqueta Orden", lbl_Orden);
        takeScreenshot("Caturar Orden de compra");
        return getlabel("Orden de compra ", lbl_Orden);
    }

}
