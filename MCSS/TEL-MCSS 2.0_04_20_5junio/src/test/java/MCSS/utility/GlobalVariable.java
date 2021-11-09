package MCSS.utility;

public class GlobalVariable {

	public static final String BROWSER = "CHROME";
	//	public static final String BROWSER = "IE";

	public static final String AUT_BROWSER_SERVER_PATH_CHROME = "src/test/resources/drivers/chromedriver.exe";
	public static final String AUT_BROWSER_SERVER_PATH_IE = "src/test/resources/drivers/IEDriverServer.exe";
	public static final String AUT_BROWSER_SERVER_PATH_FF = "src/test/resources/drivers/geckodriver.exe";


	public static final String AUT_SCREENSHOT_PATH = "target/images/";

	public static final String AUT_STEPREPORT_PATH = "target/Extent_Report/stepReport.html";


	/**
	 * RUTA EXCEL DATAPOOL :
	 **/
	public static final String PATH = "./src/test/resources/data/TestData.xlsx";
	public static final String AMBIENTE = "Ambiente";
	public static final String PREPAGO = "AltaPrepago";//"Usuario";
	public static final String POSTPAGO = "AltaPostpago";
	public static final String CAMBIO = "Cambio";
	public static final String EJECUCIONES ="Ejecuciones";
	public static final String SELFSERVICE ="SelfService";

	/**
	* GENERACION DE ARCHIVO WORD:
	**/
	public static final Boolean IMPRIMIR_WORD = true; //True: Generacion de documento WORD

}
