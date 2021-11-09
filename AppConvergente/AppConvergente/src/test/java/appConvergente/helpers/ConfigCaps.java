package appConvergente.helpers;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigCaps {

    static String url = "http://127.0.0.1:4723/wd/hub";


            public static final URL appiumServerUrl(){
                try{
                    return new URL(url);
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }
                return null;
            }

    public static final DesiredCapabilities dcAndroid_SMA515F_App_USSD()
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
        capabilities.setCapability(MobileCapabilityType.UDID, "c6dae5110106");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability("appPackage", "tdp.app.col");
        capabilities.setCapability("appActivity", "tdp.app.col.MainActivity");
        return capabilities;
    }

}
