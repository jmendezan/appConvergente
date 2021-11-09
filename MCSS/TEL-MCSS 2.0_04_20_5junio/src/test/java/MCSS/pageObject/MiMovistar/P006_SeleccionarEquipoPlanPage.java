package MCSS.pageObject.MiMovistar;

import MCSS.helpers.BasePage;

public class P006_SeleccionarEquipoPlanPage extends BasePage {
    String txt_buscarIMEI = "id|ownDeviceImei";
    String btn_Continuar = "//input[@value='Continuar']";
    String btn_Calcular = "//*[contains(text(),'Calcular')]";

    public void doAgregarIMEI(int id) throws Exception {
        String i_imei = ;
        doAddTextField("[Escenario_"+id+"] Escribir IMEI", txt_buscarIMEI , txt_buscarIMEI,false );
        doclickByJS("[Escenario_"+id+"] Buscar IMEI", btn_Continuar,true); //963753424
    }


}
