package appConvergente.pageobject.appConvergente;

import appConvergente.BaseClass;
import appConvergente.helpers.Hook;
import appConvergente.utility.ExcelReader;
import appConvergente.utility.ExtentReportUtil;
import appConvergente.utility.GenerateWord;
/*import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;*/
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;

public class PageLoginMovistarC extends BaseClass{

    private static final String EXCEL_APK                = "excel/App_MovistarContigo.xlsx";
    private static final String LOGIN_APK                = "Login";  // HOJA DEL EXCEL 1
    private static final String LOGIN_APK2               = "Login2"; // HOJA DEL EXCEL 2
    private static final String LOGIN_APK3               = "Login3"; // HOJA DEL EXCEL 3

    private static final String COLUMNA_NUMERODOCUMENTO  = "NumDoc"; // COLUMMNA DEL DNI

    private static final String COLUMNA_TIPODOCUMENTO = "TipoDocumento"; //
    private static final String COLUMNA_NUM_DOCUMENTO = "NumDocumento"; //
    private static final String COLUMNA_PASSWORD = "Password"; //
    private static final String COLUMNA_INGRESAR = "CodVer4"; //
    private static final String COLUMNA_CODVERIFICACION5 = "CodVer5"; // COLUMNA DEL COD 5

    private static final String COLUMNA_CORREO           = "Correo";        // COLUMNA DEL CORREO
    private static final String COLUMNA_PAIS             = "Pais";          // COLUMNA DEL CORREO
    private static final String COLUMNA_CELULAR          = "Celular";       // COLUMNA CELULAR
    private static final String COLUMNA_PISO             = "Piso";          // COLUMNA PISO
    private static final String COLUMNA_DESCRIPCION      = "Descripcion";   // COLUMNA DESCRIPCION DEL SINTOMA

    public static GenerateWord generateWord = new GenerateWord();
    public static AppiumDriver<MobileElement> driver;


    public PageLoginMovistarC() {
        this.driver = Hook.getDriver();
    }

    private static List<HashMap<String, String>> getData1() throws Throwable
    {
        return ExcelReader.data(EXCEL_APK, LOGIN_APK);
    }

    private static List<HashMap<String, String>> getData2() throws Throwable
    {
        return ExcelReader.data(EXCEL_APK, LOGIN_APK2);
    }

    private static List<HashMap<String, String>> getData3() throws Throwable
    {
        return ExcelReader.data(EXCEL_APK, LOGIN_APK3);
    }


    //BOTON EMPEZAR AHORA Y LOGIN

    public static String     BTN_EMPEZARAHORA = "//android.widget.Button";//"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.widget.Button";//-"//*[text()='Empezar ahora']";
    //LOGIN

    public static String CMB_TIPODCOCUMENTO = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.Button" ;  //idCountry
    public static String TXT_TIPO_DNI      =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View";
    public static String TXT_NUMERODOC      = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
    public static String TXT_PASSWORD       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText";
    public static String BTN_INGRESAR       =  "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]/android.view.View/android.view.View/android.view.View/android.widget.Button";//-"//android.view.View[1]/android.view.View/android.widget.Button";

    //MI MOVISTAR HOME


    public static String BTN_ASISTENCIA      = "//android.widget.TabWidget/android.view.View[3]/android.view.View";

    public static String BTN_AVERIA          = "//android.view.View[3]/android.view.View/android.view.View[1]/android.view.View";
    //CODIGO DE VERIFICACION
    public static String TXT_COD1           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[1]";
    public static String TXT_COD2           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]";
    public static String TXT_COD3           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[3]";
    public static String TXT_COD4           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[4]";
    public static String TXT_COD5           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[5]";
    public static String BTN_COMENZAR       = "pe.com.qallarix.movistarcontigo:id/bienvenido_btComenzar"; //BTN_COMENZAR

    public static String BTN_ICONOSESION    = "pe.com.qallarix.movistarcontigo:id/menu_tvIniciales";
    public static String BTN_CERRAR_SESSION = "pe.com.qallarix.movistarcontigo:id/account_btCerrarSesion";

    // BOTONES DEL ACCESO A APLICACIONES
    public static String BTN_POSITIVO       = "pe.com.qallarix.movistarcontigo:id/md_button_positive"; // BOTON DE ERROR
    public static String BTN_HOME           = "pe.com.qallarix.movistarcontigo:id/navigation_home";
    public static String BTN_MIGESTION      = "pe.com.qallarix.movistarcontigo:id/navigation_management";
    public static String BTN_SAMI           = "pe.com.qallarix.movistarcontigo:id/navigation_sami";
    public static String BTN_BENEFICIOS     = "pe.com.qallarix.movistarcontigo:id/navigation_benefits";
    public static String BTN_NOTIFICACIONES = "pe.com.qallarix.movistarcontigo:id/navigation_notifications";

    public static String OPCION_INGRESO_PERSONAL    = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";
    public static String OPCION_VACACIONES          = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";
    public static String OPCION_HERRAMIENTAS        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView";

    // CORREO ELECTRONICO

    public static String TXT_CORREO         = "pe.com.qallarix.movistarcontigo:id/eteEmail";    // CORREO_ECETRONICO

    // MODULO RETORNO OFICINA
    public static String BTN_ACEPTO_TD      = "pe.com.qallarix.movistarcontigo:id/btnTerms";    // BOTON ACEPTO TRATAMIENTO DE DATOS
    public static String BTN_NOACEPTO_TD    = "pe.com.qallarix.movistarcontigo:id/btnTermsNo";  // BOTON NO ACEPTO TRATAMIENTO DE DATOS
    public static String BTN_PROTEGEMMOS_TD = "pe.com.qallarix.movistarcontigo:id/btnTerms";    // BOTON PROTEGEMOS INFORMACION
    public static String BTN_GUARDAR_CEL    = "pe.com.qallarix.movistarcontigo:id/btnTerms";    // BOTON GUARDAR CELULAR
    public static String TXT_CELULAR        = "pe.com.qallarix.movistarcontigo:id/etePhonePersonal";    // INGRESAR CELULAR
    public static String BTN_INFORMACION    = "pe.com.qallarix.movistarcontigo:id/tviAboutInformation";    // BOTON DE VER INFORMACION
    public static String BTN_PERMITIR_INFO  = "com.android.permissioncontroller:id/permission_allow_button";    // BOTON PERMITIR MOSTRAR INFORMACION
    public static String BTN_RECHAZAR_INFO  = "com.android.permissioncontroller:id/permission_deny_button";    // BOTON NO PERMITIR MOSTRAR INFORMACION
    public static String LKN_REGRESAR_INFO  = "Navegar hacia arriba";    // REGRESAR

    // GENERAR INGRESO EXTRANJERO + SINTOMAS

    public static String BTN_GENERAR_INGRESO                        = "pe.com.qallarix.movistarcontigo:id/textView45";    // BOTON GENERAR INGRESO
    public static String BTN_SWITCH_NO                              = "pe.com.qallarix.movistarcontigo:id/tviNoSwitch";    // BOTON SWITCH_NO
    public static String BTN_SWITCH_SI                              = "pe.com.qallarix.movistarcontigo:id/tviSiSwitch";    // BOTON SWITCH_SI
    public static String BTN_SWITCH_TOS_SI                          = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_TOS_NO                          = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_FIEBRE_SI                       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_FIEBRE_NO                       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_FALTA_AIRE_SI                   = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_FALTA_AIRE_NO                   = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_DOLOR_SI                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_DOLOR_NO                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_PERDIDA_OFLFATO_GUSTO_SI        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_PERDIDA_OLFATO_GUSTO_NO         = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_CONGESTION_NASAL_SI             = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_CONGETION_NASAL_NO              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_FATIGA_SI                       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_FATIGA_NO                       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SIGUIENTE3                             = "pe.com.qallarix.movistarcontigo:id/btnGeneratePass";

//    SINTOMAS PARA PERU Y MEDIA NETWORKS
    public static String BTN_SWITCH_TOS2_SI                         = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_TOS2_NO                         = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_FIEBRE2_SI                      = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_FIEBRE2_NO                      = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_DOLOR1_SI                       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_DOLOR2_NO                       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_FALTA_AIRE2_SI                  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_FALTA_AIRE2_NO                  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_PERDIDA_OLFATO_SI               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_PERDIDA_OLFATO_NO               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_PERDIDA_GUSTO_SI                = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_PERDIDA_GUSTO__NO               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_SWITCH_CONGESTION_SI                   = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_SWITCH_CONGESTION_NO                   = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[2]";

//    SINTOMAS DE REPORTAR

    public static String BTN_REPORTAR_TOS_SI                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_TOS_NO                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_FIEBRE_SI                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_FIEBRE_NO                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_FALTADEAIRE_SI                = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_FALTADEAIRE_NO                = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_DOLORCABEZA_GARGANTA_SI       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_DOLORCABEZA_GARGANTA_NO       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_PERDIDAOLFATO_GUSTO_SI        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_PERDIDAOLFATO_GUSTO_NO        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_CONGESTION_NASAL_SI           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_CONGESTION_NASAL_NO           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_FATIGA_SI                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_FATIGA_NO                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[2]";

    public static String BTN_REPORTAR_TOS2_SI                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_TOS2_NO                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_FIEBRE2_SI                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_FIEBRE2_NO                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_DOLOR_GARGANTA2_SI       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_DOLOR_GARGANTA2_NO       = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_FALTA_AIRE_SI                  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_FALTA_AIRE_NO                  = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_PERDIDAOLFATO_SI               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_PERDIDAOLFATO_NO               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_PERDIDA_GUSTO_SI               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_PERDIDA_GUSTO_NO               = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_REPORTAR_CONGESTION_NASAL2_SI           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String BTN_REPORTAR_CONGESTION_NASAL2_NO           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.LinearLayout[1]/android.widget.TextView[2]";

    public static String TXT_DESCRPCION_SINTOMAS                    = "pe.com.qallarix.movistarcontigo:id/tviCity";
    public static String BTN_REPORTAR_SINTOMA                       = "pe.com.qallarix.movistarcontigo:id/btnGeneratePass";
    public static String BTN_REPORTAR_SEDE                          = "pe.com.qallarix.movistarcontigo:id/tviLocal";
    public static String OPCION_REPORTAR_SEDE                       = "pe.com.qallarix.movistarcontigo:id/tviValueName";
    public static String BTN_REPORTAR_PISO                          = "pe.com.qallarix.movistarcontigo:id/eteDescriptionStep1";
    public static String BTN_REPORTAR_GO_PASE                       = "pe.com.qallarix.movistarcontigo:id/btnGoPersonalPass";
    public static String BTN_OK_ENTIENDO                            = "pe.com.qallarix.movistarcontigo:id/btnTerms";
    public static String BTN_CONTINUAR_HOME                         = "pe.com.qallarix.movistarcontigo:id/account_btHome";
    public static String BTN_CERRAR_SESION                          = "pe.com.qallarix.movistarcontigo:id/account_btCerrarSesion";

    // DATOS DEL SEGUNDO FORMULARIO

//    LUGGAR Y SEDE DE VENEZUELA
    public static String DROP_LUGAR                                 = "pe.com.qallarix.movistarcontigo:id/tviCity";
    public static String LUGAR_ANDES                                = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";
    public static String LUGAR_CENTRO                               = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView";
    public static String LUGAR_CENTRO_LLANOS                        = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView";
    public static String LUGAR_CENTRO_OCCIDENTE                     = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView";
    public static String LUGAR_GRAN_CARACAS                         = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[5]/android.widget.TextView";
    public static String LUGAR_GUAYANA                              = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[6]/android.widget.TextView";
    public static String LUGAR_OCCIDENTE                            = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[7]/android.widget.TextView";
    public static String LUGAR_ORIENTE                              = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.TextView";
    public static String DROP_SEDE                                  = "pe.com.qallarix.movistarcontigo:id/tviLocal";
    public static String SEDE_DELICIA_TERRAZA                       = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";
    public static String SEDE_DELICIA_AVENIDA                       = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";

//    LUGAR Y SEDE DE PERU Y MEDIA NETWORKS
    public static String LUGAR_LIMA                                  = "pe.com.qallarix.movistarcontigo:id/tviValueName";
    public static String LUGAR_LURIN                                = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";
    public static String LUGAR_MIRAFLORES                           = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.TextView";
    public static String LUGAR_JESUSMARIA                           = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.TextView";
    public static String LUGAR_WASHINTON                            = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.TextView";

    public static String TXT_PISO                                   = "pe.com.qallarix.movistarcontigo:id/eteDescriptionStep1";

    public static String DROP_LUGAR_OPCION                          = "pe.com.qallarix.movistarcontigo:id/tviValueName";
    public static String DROP_SEDE_OPCION                           = "pe.com.qallarix.movistarcontigo:id/tviValueName";

    public static String BTN_GENERAR_PASE                           = "pe.com.qallarix.movistarcontigo:id/btnGeneratePass"; // TAMBIEN ES BOTON REPORTAR

    // ENCUESTA DE SALUD

    public static String POPUP_ENCUESTA                             = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup";
    public static String PREGUNTA_1_SI                              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String PREGUNTA_1_NO                              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String PREGUNTA_2_SI                              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String PREGUNTA_2_NO                              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String PREGUNTA_3_SI                              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[1]";
    public static String PREGUNTA_3_NO                              = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.LinearLayout[1]/android.widget.TextView[2]";
    public static String BTN_ENVIAR_RESPUESTA                       = "pe.com.qallarix.movistarcontigo:id/btnOk";
    public static String BTN_NO_DESEO_RESPONDER                     = "pe.com.qallarix.movistarcontigo:id/btnCancel";

    // DATOS DEL MEDIO Y TIPO DE TRANSPORTE: PUBLICO Y PRIVADO

    public static String BTN_TRANSPORTE_PUBLICO                     = "pe.com.qallarix.movistarcontigo:id/btnPublic";
    public static String BTN_TRANSPORTE_PRIVADO                     = "pe.com.qallarix.movistarcontigo:id/btnPrivate";
    public static String BTN_TRANSPORTE_BUS                         = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.ImageView";
    public static String BTN_TRANSPORTE_TAXI                        = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]/android.widget.RelativeLayout/android.widget.ImageView";
    public static String BTN_TRANSPORTE_BICICLETA                   = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.widget.RelativeLayout/android.widget.ImageView";
    public static String BTN_TRANSPORTE_SCOOTER                     = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]/android.widget.RelativeLayout/android.widget.ImageView";

    // BOTON GENERAR PASE PARA EL QR + DECLARACION JURADA

    public static String  BTN_GENERAR_PASE2                         = "pe.com.qallarix.movistarcontigo:id/btnGeneratePass";
    public  static String BTN_OPCION_OK                             = "pe.com.qallarix.movistarcontigo:id/btnOk";
    public  static String BTN_OPCION_CANCEL                         = "pe.com.qallarix.movistarcontigo:id/btnCancel";

    // BOTONES DE DESCARGA DEL PASE DE INGRESO + VOLVER

    public static String BTN_DESCARGAR_QR                           = "pe.com.qallarix.movistarcontigo:id/btnSharedQR";
    public static String BTN_VOLVER_INGRESO_PERSONAL                = "pe.com.qallarix.movistarcontigo:id/btnBackToDash";

    public static String BTN_PASE_INGRESO                           = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView";
    public static String BTN_REPORTAR_SINTOMAS                      = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]";

    public static String BTN_BUG                                    = "pe.com.qallarix.movistarcontigo:id/md_button_positive";
    public static String ICONO                                      = "//android.widget.ImageButton[@content-desc=\"Navegar hacia arriba\"]";
    public static String DENEGARINFO                                ="com.android.permissioncontroller:id/permission_deny_and_dont_ask_again_button";

    public static void ingreso_Aplicacion() throws Throwable
    {
        try{
            Thread.sleep(4000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se inició la aplicación");
            generateWord.sendText("Se inició la aplicación");
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            e.printStackTrace();
            throw e;
        }
    }

    public static void clickBotonEmpezarAhora() throws Exception
    {
        try{
            takeScreenshot(driver, "Antes del click");
            click(driver, "xpath", BTN_EMPEZARAHORA);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Click Boton Empezar Ahora");
            generateWord.sendText("Click Boton Empezar Ahora");
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void Ingreso_NumeroDocumento(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String numDocData = getData1().get(valores).get(COLUMNA_NUMERODOCUMENTO);

        //    driver.findElement(By.id(TXT_DOCUMENTO)).sendKeys(numDocData);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingreso el número de documento: " + numDocData);
            generateWord.sendText("Se ingresó el número de documento: " + numDocData);
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }
public static void Clic_Boton_Aceptar_Terminos_Condiciones() throws Exception
    {
        try
        {
            //SCROLL_TERMINOS_Y_CONDICIONES
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se aceptan los términos y condiciones");
            generateWord.sendText("Se aceptan los términos y condiciones");
            generateWord.addImageToWord(driver);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Aceptar");
            generateWord.sendText("Se da clic en el botón Aceptar");
            generateWord.addImageToWord(driver);

        }

        catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public static void clickAsistencia() throws Throwable {

        click(driver, "xpath", BTN_ASISTENCIA);

    }
    public static void opcionAveria() throws Throwable {

        click(driver,"xpath", BTN_AVERIA);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Click opcion Averia");
        generateWord.sendText("Click opcion Averia");
        generateWord.addImageToWord(driver);

    }
    public static void ingresar_CodigoVerificacion(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String tipoDoc = getData1().get(valores).get(COLUMNA_TIPODOCUMENTO);
            String numDoc = getData1().get(valores).get(COLUMNA_NUM_DOCUMENTO);
            String password = getData1().get(valores).get(COLUMNA_PASSWORD);
            click(driver, "xpath", CMB_TIPODCOCUMENTO);
            click(driver, "xpath", TXT_TIPO_DNI); // Click tipo DNI
            sendKeyValue(driver, "xpath", TXT_NUMERODOC,numDoc);
            sendKeyValue(driver, "xpath", TXT_PASSWORD,password);
            click(driver, "xpath", BTN_INGRESAR);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Login usuario");
            generateWord.sendText("Login usuario");
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Clic_Boton_Comenzar() throws Exception
    {
        driver.findElement(By.id(BTN_COMENZAR)).click();
        Thread.sleep(6000);

        driver.findElement(By.id(BTN_HOME)).click();
        Thread.sleep(3000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Home");
        generateWord.sendText("Se accede a Home");
        generateWord.addImageToWord(driver);
    }

    public static void Clic_Boton_CERRAR_SESION() throws Exception
    {
        try
        {
            driver.findElement(By.id(BTN_ICONOSESION)).click();
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el icono Cerrar Sesión");
            generateWord.sendText("Se da clic en el icono Cerrar Sesión");
            generateWord.addImageToWord(driver);


            driver.findElement(By.id(BTN_CERRAR_SESSION)).click();
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Direcciona a la opción Elegir país");
            generateWord.sendText("Direcciona a la opción Elegir país");
            generateWord.addImageToWord(driver);
        }

        catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

//    ------------------------ FLUJO CORREO ELECTRONICO --------------------------------

    public static void Seleccionar_Paises(String paises) throws Throwable
    {
        try{
            int valores = Integer.parseInt(paises) - 1;
            String paisData = getData3().get(valores).get(COLUMNA_PAIS);

            switch(paisData)
            {

                default:ExtentReportUtil.INSTANCE.stepPass(driver, "País inválido");
                    generateWord.sendText("País inválido");
                    break;
            }

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se seleccionó un país: " + paisData);
            generateWord.sendText("Se seleccionó un país: " + paisData);
            generateWord.addImageToWord(driver);


        }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Ingreso_CorreoElectronico(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String correoData = getData3().get(valores).get(COLUMNA_CORREO);

            driver.findElement(By.id(TXT_CORREO)).sendKeys(correoData);
            Thread.sleep(5000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el correo electrónico: " + correoData);
            generateWord.sendText("Se ingresó el correo electrónico: " + correoData);
            generateWord.addImageToWord(driver);

        }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Ingreso_DNI(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String dniData = getData3().get(valores).get(COLUMNA_NUMERODOCUMENTO);


            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el documento de identidad: " + dniData);
            generateWord.sendText("Se ingresó el documento de identidad: " + dniData);
            generateWord.addImageToWord(driver);

        }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Boton_Aceptar_Terminos_CostaRica() throws Exception  //COSTA RICA
    {
        try
        {
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(2000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(5000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se aceptan los términos y condiciones");
            generateWord.sendText("Se aceptan los términos y condiciones");
            generateWord.addImageToWord(driver);


            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Aceptar");
            generateWord.sendText("Se da clic en el botón Aceptar");
            generateWord.addImageToWord(driver);
        }

        catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public static void Boton_Aceptar_Terminos_Salvador() throws Exception  //EL SALVADOR
    {
        try
        {
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(2000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
             new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(5000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se aceptan los términos y condiciones");
            generateWord.sendText("Se aceptan los términos y condiciones");
            generateWord.addImageToWord(driver);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Aceptar");
            generateWord.sendText("Se da clic en el botón Aceptar");
            generateWord.addImageToWord(driver);
        }

        catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public static void Boton_Aceptar_Terminos_MN() throws Exception  //MEDIA_NETWORKS
    {
        try
        {
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(2000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se aceptan los términos y condiciones");
            generateWord.sendText("Se aceptan los términos y condiciones");
            generateWord.addImageToWord(driver);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Aceptar");
            generateWord.sendText("Se da clic en el botón Aceptar");
            generateWord.addImageToWord(driver);
        }

        catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public static void Boton_Aceptar_Terminos_Venezuela() throws Exception  //VENEZUELA
    {
        try
        {
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(2000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(936, 2137)).waitAction().moveTo(PointOption.point(936,212)).release().perform();
            Thread.sleep(5000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se aceptan los términos y condiciones");
            generateWord.sendText("Se aceptan los términos y condiciones");
            generateWord.addImageToWord(driver);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Aceptar");
            generateWord.sendText("Se da clic en el botón Aceptar");
            generateWord.addImageToWord(driver);
        }

        catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public static void Ingresar_CodigoVerificacion_Correo(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String numCodVerificacion5 = getData3().get(valores).get(COLUMNA_CODVERIFICACION5);

            driver.findElement(By.xpath(TXT_COD5)).sendKeys(numCodVerificacion5);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el código de verificación: " );
            generateWord.sendText("Se ingresó el código de verificación: ");
            generateWord.addImageToWord(driver);

         }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void NO_ACEPTAR_TERMINOS() throws Exception
    {
        driver.findElement(By.id(BTN_COMENZAR)).click();
        Thread.sleep(5000);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Comenzar");
        generateWord.sendText("Se da clic en el botón Comenzar");
        generateWord.addImageToWord(driver);
    }

    public static void Clic_Boton_Comenzar2() throws Exception
    {
        driver.findElement(By.id(BTN_COMENZAR)).click();
        Thread.sleep(5000);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón Comenzar");
        generateWord.sendText("Se da clic en el botón Comenzar");
        generateWord.addImageToWord(driver);
    }

    public static void Clic_Bug() throws Exception
    {
        driver.findElement(By.id(BTN_BUG)).click();
        Thread.sleep(2000);
    }

    public static void Acceso_Funcionalidades() throws Exception
    {
        try
        {
            driver.findElement(By.id(BTN_POSITIVO)).click();

            driver.findElement(By.id(BTN_MIGESTION)).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Mi Gestiión");
            generateWord.sendText("Se accede a Mi Gestiión");
            generateWord.addImageToWord(driver);

            driver.findElement(By.id(BTN_SAMI)).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a SAMI");
            generateWord.sendText("Se accede a SAMI");
            generateWord.addImageToWord(driver);


            driver.findElement(By.id(BTN_BENEFICIOS)).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Mis Beneficios");
            generateWord.sendText("Se accede a Mis Beneficios");
            generateWord.addImageToWord(driver);

            driver.findElement(By.id(BTN_NOTIFICACIONES)).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Notificaciones");
            generateWord.sendText("Se accede a Notificaciones");
            generateWord.addImageToWord(driver);

            driver.findElement(By.id(BTN_HOME)).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Home");
            generateWord.sendText("Se accede a Home");
            generateWord.addImageToWord(driver);

        }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Acceso_Modulo_Ingreso_Personal() throws Exception
    {
            Thread.sleep(3000);
            driver.findElement(By.id(BTN_GENERAR_INGRESO)).click();
            Thread.sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en la opción de Generar Ingreso");
            generateWord.sendText("Se da clic en la opción de Generar Ingreso");
            generateWord.addImageToWord(driver);

    }

    public static void Seleccion_Preguntas_NO() throws Exception
    {
            driver.findElement(By.id(BTN_SWITCH_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en la opción NO");
            generateWord.sendText("Damos clic en la opción NO");
            generateWord.addImageToWord(driver);

            driver.findElement(By.xpath(BTN_SWITCH_TOS_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de tos con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de tos con la opción NO");
            generateWord.addImageToWord(driver);

            driver.findElement(By.xpath(BTN_SWITCH_FIEBRE_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de fiebre con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de fiebre con la opción NO");
            generateWord.addImageToWord(driver);

            driver.findElement(By.xpath(BTN_SWITCH_FALTA_AIRE_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de falta de aire con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de falta de aire con la opción NO");
            generateWord.addImageToWord(driver);

            driver.findElement(By.xpath(BTN_SWITCH_DOLOR_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Dolor de cabeza/garganta de aire con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de Dolor de cabeza/garganta con la opción NO");
            generateWord.addImageToWord(driver);

            driver.findElement(By.xpath(BTN_SWITCH_PERDIDA_OLFATO_GUSTO_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de olfato/gusto de aire con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de Pérdida de olfato/gusto con la opción NO");
            generateWord.addImageToWord(driver);

            driver.findElement(By.xpath(BTN_SWITCH_CONGETION_NASAL_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Congestión nasal con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de Congestión nasal con la opción NO");
            generateWord.addImageToWord(driver);

            Thread.sleep(1000);
            new TouchAction(driver).press(PointOption.point(436, 1436)).waitAction().moveTo(PointOption.point(436,820)).release().perform();
            Thread.sleep(1000);

            driver.findElement(By.xpath(BTN_SWITCH_FATIGA_NO)).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Fatiga o cansancio con la opción NO");
            generateWord.sendText("Damos clic en el síntoma de Fatiga o cansancio con la opción NO");
            generateWord.addImageToWord(driver);
    }

    public static void Seleccion_Preguntas2_NO() throws Exception
    {
        driver.findElement(By.id(BTN_SWITCH_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en la opción NO");
        generateWord.sendText("Damos clic en la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_TOS2_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de tos con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de tos con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_FIEBRE2_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de fiebre con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de fiebre con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_DOLOR2_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma dolor de garganta con la opción NO");
        generateWord.sendText("Damos clic en el síntoma dolor de garganta con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_FALTA_AIRE2_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma Falta de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma Falta de aire con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_PERDIDA_OLFATO_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de olfato con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Pérdida de olfato con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_PERDIDA_GUSTO__NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma Pérdida de gusto con la opción NO");
        generateWord.sendText("Damos clic en el síntoma Pérdida de gusto con la opción NO");
        generateWord.addImageToWord(driver);

        Thread.sleep(1000);
        new TouchAction(driver).press(PointOption.point(436, 1436)).waitAction().moveTo(PointOption.point(436,820)).release().perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath(BTN_SWITCH_CONGESTION_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Congestión nasal con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Congestión nasal con la opción NO");
        generateWord.addImageToWord(driver);
    }

    public static void Seleccion_Preguntas_SI() throws Exception
    {
        driver.findElement(By.id(BTN_SWITCH_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en la opción NO");
        generateWord.sendText("Damos clic en la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_TOS_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de tos con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de tos con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_FIEBRE_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de fiebre con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de fiebre con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_FALTA_AIRE_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de falta de aire con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de falta de aire con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_DOLOR_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Dolor de cabeza/garganta de aire con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Dolor de cabeza/garganta con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_PERDIDA_OFLFATO_GUSTO_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de olfato/gusto de aire con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Pérdida de olfato/gusto con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_SWITCH_CONGESTION_NASAL_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Congestión nasal con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Congestión nasal con la opción SI");
        generateWord.addImageToWord(driver);

        Thread.sleep(1000);
        new TouchAction(driver).press(PointOption.point(436, 1436)).waitAction().moveTo(PointOption.point(436,820)).release().perform();
        Thread.sleep(1000);

        driver.findElement(By.xpath(BTN_SWITCH_FATIGA_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Fatiga o cansancio con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Fatiga o cansancio con la opción SI");
        generateWord.addImageToWord(driver);
    }

    public static void Boton_Siguiente_Sintomas() throws Exception
    {
        driver.findElement(By.id(BTN_SIGUIENTE3)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en el botón siguiente");
        generateWord.sendText("Se da clic en el botón siguiente");
        generateWord.addImageToWord(driver);
    }

    public static void Seleccionar_Tipo_Transporte() throws Exception
    {
        driver.findElement(By.id(BTN_TRANSPORTE_PUBLICO)).click();

        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en la opción de tipo de transporte");
        generateWord.sendText("Se da clic en la opción de tipo de transporte");
        generateWord.addImageToWord(driver);
    }

    public static void Seleccionar_Tipo_Transporte2() throws Exception
    {
        driver.findElement(By.id(BTN_TRANSPORTE_PRIVADO)).click();

        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en la opción de tipo de transporte");
        generateWord.sendText("Se da clic en la opción de tipo de transporte");
        generateWord.addImageToWord(driver);
    }

    public static void Seleccionar_Medio_Transporte() throws Exception
    {
        driver.findElement(By.xpath(BTN_TRANSPORTE_TAXI)).click();

        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en la opción de medio de transporte");
        generateWord.sendText("Se da clic en la opción de medio de transporte");
        generateWord.addImageToWord(driver);
    }

    public static void Completar_Lugar_de_Trabajo() throws Exception
    {
        driver.findElement(By.id(DROP_LUGAR)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciona la opción de lugar de trabajo");
        generateWord.sendText("Se selecciona la opción de lugar de trabajo");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(LUGAR_ANDES)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se visualiza la opción elegida");
        generateWord.sendText("Se visualiza la opción elegida");
        generateWord.addImageToWord(driver);
    }

    public static void Completar_Lugar_de_Trabajo2() throws Exception
    {
        driver.findElement(By.id(DROP_LUGAR)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciona la opción de lugar de trabajo");
        generateWord.sendText("Se selecciona la opción de lugar de trabajo");
        generateWord.addImageToWord(driver);

        driver.findElement(By.id(LUGAR_LIMA)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se visualiza la opción elegida");
        generateWord.sendText("Se visualiza la opción elegida");
        generateWord.addImageToWord(driver);
    }

    public static void Completar_Sede_de_Trabajo() throws Exception
    {
        driver.findElement(By.id(DROP_SEDE)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciona la opción de sede");
        generateWord.sendText("Se selecciona la opción de sede");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(SEDE_DELICIA_TERRAZA)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se visualiza la opción elegida");
        generateWord.sendText("Se visualiza la opción elegida");
        generateWord.addImageToWord(driver);
    }

    public static void Completar_Sede_de_Trabajo2() throws Exception
    {
        driver.findElement(By.id(DROP_SEDE)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se selecciona la opción de sede");
        generateWord.sendText("Se selecciona la opción de sede");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(LUGAR_MIRAFLORES)).click();
        Thread.sleep(2000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se visualiza la opción elegida");
        generateWord.sendText("Se visualiza la opción elegida");
        generateWord.addImageToWord(driver);
    }

    public static void Completar_numero_de_piso(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String numPisoData = getData3().get(valores).get(COLUMNA_PISO);

            driver.findElement(By.id(TXT_PISO)).sendKeys(numPisoData);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó el número de piso: " + numPisoData);
            generateWord.sendText("Se ingresó el número de piso: " + numPisoData);
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Generar_Pase() throws Exception
    {
            driver.findElement(By.id(BTN_GENERAR_PASE2)).click();
            Thread.sleep(4000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en la opción SI de la declaración jurada");
            generateWord.sendText("Se da clic en la opción SI de la declaración jurada");
            generateWord.addImageToWord(driver);
    }

    public static void Declaración_Jurada() throws Exception
    {
            Thread.sleep(3000);
            driver.findElement(By.id(BTN_OPCION_OK)).click();
            Thread.sleep(8000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Visualizamos que se genera el pase de ingreso con éxito");
            generateWord.sendText("Visualizamos que se genera el pase de ingreso con éxito");
            generateWord.addImageToWord(driver);
        }

    public static void Declaración_Jurada2() throws Exception
    {
        Thread.sleep(3000);
        driver.findElement(By.id(BTN_OPCION_OK)).click();
        Thread.sleep(8000);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Visualizamos que se genera el pase de ingreso denegado");
        generateWord.sendText("Visualizamos que se genera el pase de ingreso denegado");
        generateWord.addImageToWord(driver);
    }

    public static void Generacion_QR() throws Exception
    {
            driver.findElement(By.id(BTN_VOLVER_INGRESO_PERSONAL)).click();
            Thread.sleep(5000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en la opción de volver al módulo de Ingreso Personal");
            generateWord.sendText("Se da clic en la opción de volver al módulo de Ingreso Personal");
            generateWord.addImageToWord(driver);
    }

    public static void Tratamiento_Datos_Personales() throws Exception
    {
        Thread.sleep(5000);
        driver.findElement(By.id(BTN_ACEPTO_TD)).click();
        Thread.sleep(8000);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Se da clic en aceptar Tratamiento de datos personales y veracidad de la información");
        generateWord.sendText("Se da clic en aceptar Tratamiento de datos personales y veracidad de la información");
        generateWord.addImageToWord(driver);
    }

    public static void Guardar_celular() throws Exception
    {
        driver.findElement(By.id(BTN_GUARDAR_CEL)).click();
        Thread.sleep(3000);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Guardamos número de celular");
        generateWord.sendText("Guardamos número de celular");
        generateWord.addImageToWord(driver);
    }

    public static void Ingresar_NumCelular(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String numCelularData = getData3().get(valores).get(COLUMNA_CELULAR);

            driver.findElement(By.id(TXT_CELULAR)).sendKeys(numCelularData);
            Thread.sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresó número de celular: " + numCelularData);
            generateWord.sendText("Se ingresó número de celular: " + numCelularData);
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }

    }

    public static void Popup_Encuesta() throws Exception
    {
        driver.findElement(By.id(BTN_NO_DESEO_RESPONDER)).click();
        Thread.sleep(4000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "No respondemos a la encuesta");
        generateWord.sendText("No respondemos a la encuesta");
        generateWord.addImageToWord(driver);

        driver.findElement(By.id(BTN_ENVIAR_RESPUESTA)).click();
        Thread.sleep(4000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Enviamos la encuesta");
        generateWord.sendText("Enviamos la encuesta");
        generateWord.addImageToWord(driver);

        driver.findElement(By.id(BTN_OPCION_OK)).click();
        Thread.sleep(3000);
    }

    public static void Acceso_Modulo_MiGestion() throws Exception
    {
        try
        {
            Thread.sleep(4000);
            driver.findElement(By.id(BTN_MIGESTION)).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Mi Gestión");
            generateWord.sendText("Se accede a Mi Gestión");
            generateWord.addImageToWord(driver);

         }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Acceso_Modulo_IngresoPersonal() throws Exception
    {
        try
        {
            Thread.sleep(6000);
            driver.findElement(By.xpath(OPCION_INGRESO_PERSONAL)).click();
            Thread.sleep(6000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se accede a Ingreso de Personal");
            generateWord.sendText("Se accede a Ingreso de Personal");
            generateWord.addImageToWord(driver);

        }
        catch (Exception e)
        {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Boton_Reportar() throws Exception
    {
        driver.findElement(By.xpath(BTN_REPORTAR_SINTOMAS)).click();
        Thread.sleep(4000);

        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el botón de Reportar síntomas");
        generateWord.sendText("Damos clic en el botón de Reportar síntomas");
        generateWord.addImageToWord(driver);
    }

    public static void Reportar_Preguntas_Extrannjero() throws Exception    // paises de CR, VN, SV
    {
        driver.findElement(By.xpath(BTN_REPORTAR_TOS_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de tos con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de tos con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FIEBRE_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de fiebre con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de fiebre con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FALTADEAIRE_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de falta de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de falta de aire con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_DOLORCABEZA_GARGANTA_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Dolor de cabeza/garganta de aire con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Dolor de cabeza/garganta con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_PERDIDAOLFATO_GUSTO_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de olfato/gusto de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Pérdida de olfato/gusto con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_CONGESTION_NASAL_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Congestión nasal con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Congestión nasal con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FATIGA_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Fatiga o cansancio con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Fatiga o cansancio con la opción NO");
        generateWord.addImageToWord(driver);
    }

    public static void Reportar_Preguntas_Extrannjero_NO() throws Exception    // Reportando sintomas pero con la opcion No
    {
        driver.findElement(By.xpath(BTN_REPORTAR_TOS_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de tos con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de tos con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FIEBRE_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de fiebre con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de fiebre con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FALTADEAIRE_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de falta de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de falta de aire con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_DOLORCABEZA_GARGANTA_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Dolor de cabeza/garganta de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Dolor de cabeza/garganta con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_PERDIDAOLFATO_GUSTO_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de olfato/gusto de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Pérdida de olfato/gusto con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_CONGESTION_NASAL_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Congestión nasal con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Congestión nasal con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FATIGA_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Fatiga o cansancio con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Fatiga o cansancio con la opción NO");
        generateWord.addImageToWord(driver);
    }

    public static void Reportar_Preguntas_Nacional() throws Exception    // paises de Peru y MN
    {
        driver.findElement(By.xpath(BTN_REPORTAR_TOS2_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Tos con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Tos con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FIEBRE2_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Fiebre con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Fiebre con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_DOLOR_GARGANTA2_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Dolor de garganta con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Dolor de garganta con la opción SI");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_FALTA_AIRE_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Falta de aire con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Falta de aire con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_PERDIDAOLFATO_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de olfato con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Pérdida de olfato con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_PERDIDA_GUSTO_NO)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Pérdida de gusto con la opción NO");
        generateWord.sendText("Damos clic en el síntoma de Pérdida de gusto con la opción NO");
        generateWord.addImageToWord(driver);

        driver.findElement(By.xpath(BTN_REPORTAR_CONGESTION_NASAL2_SI)).click();
        Thread.sleep(1000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Damos clic en el síntoma de Congestión nasal con la opción SI");
        generateWord.sendText("Damos clic en el síntoma de Congestión nasal con la opción SI");
        generateWord.addImageToWord(driver);
    }

    public static void Reportar_detalle(String casoDePrueba) throws Throwable
    {
        try{
            int valores = Integer.parseInt(casoDePrueba) - 1;
            String descripcionData = getData3().get(valores).get(COLUMNA_DESCRIPCION);

            driver.findElement(By.id(TXT_DESCRPCION_SINTOMAS)).sendKeys(descripcionData);
            Thread.sleep(3000);

            ExtentReportUtil.INSTANCE.stepPass(driver, "Detallamos desde cuando se presenta síntomas: " + descripcionData);
            generateWord.sendText("Detallamos desde cuando se presenta síntomas: " + descripcionData);
            generateWord.addImageToWord(driver);

        }catch (Exception e) {
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
            throw e;
        }
    }

    public static void Reportar_Sintomas() throws Exception
    {
        driver.findElement(By.id(BTN_REPORTAR_SINTOMA)).click();
        Thread.sleep(5000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Visualizamos el pase denegado");
        generateWord.sendText("Visualizamos el pase denegado");
        generateWord.addImageToWord(driver);
    }

    public static void Reportar_Pase_Sin_Sintomas() throws Exception
    {
        driver.findElement(By.id(BTN_REPORTAR_SINTOMA)).click();
        Thread.sleep(5000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Visualizamos el pase autorizado con las instrucciones a seguir");
        generateWord.sendText("Visualizamos el pase autorizado con las instrucciones a seguir");
        generateWord.addImageToWord(driver);
    }

    public static void Reportar_Pase_Denegado() throws Exception
    {
        driver.findElement(By.id(BTN_REPORTAR_GO_PASE)).click();
        Thread.sleep(4000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Regresamos a ver el pase de ingreso");
        generateWord.sendText("Regresamos a ver el pase de ingreso");
        generateWord.addImageToWord(driver);


        driver.findElement(By.id(BTN_VOLVER_INGRESO_PERSONAL)).click();
        Thread.sleep(3000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Regresamos al módulo de Ingreso personal");
        generateWord.sendText("Regresamos al módulo de Ingreso personal");
        generateWord.addImageToWord(driver);

    }

    public static void Quedate_En_Casa() throws Exception
    {
        driver.findElement(By.id(BTN_OK_ENTIENDO)).click();
        Thread.sleep(4000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Muestra el pop_up de Quédate en casa");
        generateWord.sendText("Muestra el pop_up de Quédate en casa");
        generateWord.addImageToWord(driver);


        driver.findElement(By.id(BTN_CERRAR_SESION)).click();
        Thread.sleep(3000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Se cierra sesión");
        generateWord.sendText("Se cierra sesión");
        generateWord.addImageToWord(driver);

    }

    public static void Ver_Informacion() throws Exception
    {
        driver.findElement(By.id(BTN_INFORMACION)).click();
        Thread.sleep(5000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Seleccionamos la opción de Ver información");
        generateWord.sendText("Seleccionamos la opción de Ver información");
        generateWord.addImageToWord(driver);

        driver.findElement(By.id(BTN_PERMITIR_INFO)).click();
        Thread.sleep(5000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Visualizamos la información detallada del módulo");
        generateWord.sendText("Visualizamos la información detallada del módulo");
        generateWord.addImageToWord(driver);

    }

    public static void Pase_De_Ingreso() throws Exception {
        driver.findElement(By.xpath(BTN_PASE_INGRESO)).click();
        Thread.sleep(5000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Seleccionamos la opción de Pase de Ingreso");
        generateWord.sendText("Seleccionamos la opción de Pase de Ingreso");
        generateWord.addImageToWord(driver);
    }

    public static void Descargar_Pase() throws Exception
    {
        driver.findElement(By.id(BTN_DESCARGAR_QR)).click();
        Thread.sleep(5000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Seleccionamos el botón de Descargar pase de ingreso");
        generateWord.sendText("Seleccionamos el botón de Descargar pase de ingreso");
        generateWord.addImageToWord(driver);
    }
}

