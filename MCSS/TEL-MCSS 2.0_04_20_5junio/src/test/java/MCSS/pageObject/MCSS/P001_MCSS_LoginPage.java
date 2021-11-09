package MCSS.pageObject.MCSS;

import MCSS.helpers.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;

public class P001_MCSS_LoginPage extends BasePage {

    String rbDealerUser = "|id|rbDealer";
    String rbRegisteredUser = "|id|rbUser";
    String lnkInicioSesion = "//*[@id=\"dearLoginLink\"]/td[2]/a";

    String chbTipoDocumento = "|id|docType";
    String txtDocNumero = "|id|docNumber";
    String btnGO = "|cssselector|body:nth-child(2) form:nth-child(3) div:nth-child(4) > input:nth-child(2)";

    public boolean validarBtnDealer(int id) throws Throwable {
        return validateObjExistById("Validar Boton de dealer", rbDealerUser, false);
    }

    public boolean validatechbTipoDocumento (int id) throws Throwable {
        return validateObjExistById("Validar como Tipo de documento",chbTipoDocumento, false);
    }

    public void doLoginMCSSPrincipal(int id) throws Exception {
        wait("Validacion Checkbutton", rbRegisteredUser);
        doClick("Click en el boton de dealer", rbDealerUser, false);
        doClick("Click de inicio de sesion de dealer", lnkInicioSesion, true);
    }

    public void doLoginMCSSSelfservice(String documento, String numDNI, int id) throws Exception {
        wait("Validacion Tipo Documento", chbTipoDocumento);
        doSelectDropdown("Seleccionar tipo de documento", chbTipoDocumento, documento, false);
        doAddTextField("Anadir Numero de DNI", txtDocNumero, numDNI, false);
        doClick("Click en GO", btnGO, true);
    }


}
