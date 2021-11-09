package MCSS.exceptions;

import MCSS.helpers.BasePage;
import MCSS.helpers.Hook;
import org.testng.Assert;

public class ExceptionHandler {

    public static void  doException (AssertionError f, String message, String tester, int id, Boolean closeBrowser) throws Exception {
        Hook.sEstadoPrueba = "FALLO";
        Hook.sNumOrden = "No se generó";
        System.out.println("aca fallo:"+message);
        f.printStackTrace();
        if(closeBrowser) {
            Hook.closeBrowser(BasePage.handleDriver(), tester, id, Hook.sEstadoPrueba, Hook.sNumOrden);
        }
        Assert.fail(message, f);
    }
}
