package appConvergente.listener;

import appConvergente.utility.ExtentReportUtil;
import appConvergente.utility.FileHelper;

public class Listener {

    private static boolean SE_BORRARON_FILES = false;

    public void onTestStart(String nombre) {
        try {
            ExtentReportUtil.INSTANCE.createTest(nombre);
        } catch (Exception e) {
            System.out.println("[ERROR CRL-4213] Error en onTestStart: " + e.getMessage());
        }
    }

    public void onStart() {
        if (!SE_BORRARON_FILES) {
            FileHelper.borrarElementosFolder("/img");
            SE_BORRARON_FILES = true;
        }
    }
    public void onFinish() {
        ExtentReportUtil.INSTANCE.flushReport();
    }
}
