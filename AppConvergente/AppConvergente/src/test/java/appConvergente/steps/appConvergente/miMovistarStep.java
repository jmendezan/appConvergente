package appConvergente.steps.appConvergente;

import appConvergente.pageobject.appConvergente.PageLoginMovistarC;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class miMovistarStep extends PageLoginMovistarC {


    @And("^En el login Iniciar Sesion llenar los datos del usuario \"([^\"]*)\"$") // App convergnete
    public void loginIniciarSesion(String CodVerif) throws Throwable
    {
        ingresar_CodigoVerificacion(CodVerif);
    }


    @Given("^Cliente logeado en la app$") // App convergnete
    public void clienteLogeadoEnLaApp() throws Throwable {
        ingreso_Aplicacion();
    }


    @When("^Click boton Empezar ahora") // App convergnete
    public void clickBotonEmpezarAhora1() throws Throwable{
        clickBotonEmpezarAhora();
    }

    @And("^Usuario ingresa el codigo de verificacion \"([^\"]*)\"$") // App convergnete
    public void usuarioIngresaElCodigoDeVerificacion(String CodVerif) throws Throwable
    {
        ingresar_CodigoVerificacion(CodVerif);
    }

    @And("^Selecciona el boton Asistencia$") // App convergnete
    public void seleccionaElBotonAsistencia() throws Throwable {
        clickAsistencia();
    }

    @And("^La app redirecciona a la pantalla Asistencia según diseño definido en el figma$") // App convergnete
    public void laAppRedireccionaALaPantallaSegúnDiseñoDefinidoEnElFigma(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Cliente selecciona el boton Seguimiento de mi averia$")// App convergnete
    public void clienteSeleccionaElBotonSeguimientoDeMiAveria() throws Throwable {
        opcionAveria();
        throw new PendingException();
    }

    @Then("^La app redirecciona a la pantalla de trazabilidad$") // App convergnete
    public void laAppRedireccionaALaPantallaDeTrazabilidad() {
    }
}
