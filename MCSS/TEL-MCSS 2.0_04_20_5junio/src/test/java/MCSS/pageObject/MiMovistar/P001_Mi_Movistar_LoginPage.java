package MCSS.pageObject.MiMovistar;

import MCSS.helpers.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class P001_Mi_Movistar_LoginPage extends BasePage {
    private String txt_Usuario="|id|dlUserName";
    private String txt_Password="|id|dlPass";
    private String btn_Buscar="|id|loginDealerButton";

    /*** Metodo doLoginMovistar: Implementa el metodo del Login de Mi Movistar***/
    public void doLoginMovistar(String sUsuario, String sPassword,int id) throws IOException{
        try{
            System.out.println("user:"+sUsuario+" password:"+sPassword);
            wait("Validar boton Buscar", btn_Buscar);
            doAddTextField("Ingresar  el campo de usuario", txt_Usuario, sUsuario, false );
            doAddTextField("Ingresar  el campo de contraseña", txt_Password, sPassword, false );
            Thread.sleep(1000);
            doclickByJS("Login Mi Movistar, con Usuario y Contraseña válidos",btn_Buscar,true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /*** Metodo validarTxtUser: Implementa el metodo de validacion de la existencia de la caja de Texto Usuario***/
    public boolean validarTxtUser(int id) throws Throwable {

        return validateObjExistById("Validar la caja de texto de usuario", txt_Usuario, false);
    }

    /*** Metodo validarTxtPass: Implementa el metodo de validacion de la existencia de la caja de Texto Password***/
    public boolean validarTxtPass(int id) throws Throwable {
        return validateObjExistById("Validar la caja de texto de contraseña", txt_Password, false);
    }


}
