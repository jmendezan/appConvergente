package MCSS.pageObject;

import MCSS.helpers.BasePage;

import java.awt.*;
import java.io.IOException;

public class PermisosPage extends BasePage {
    String btn_detalles = "|id|details-button";
    String lbl_continuar = "|id|proceed-link";

    public void continuar() throws Exception {

        doClick("Haciendo click en configuracion avanzada", btn_detalles, false);
        doClick("Haciendo click en continuar", lbl_continuar, false);
    }
}
