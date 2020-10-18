package clarivate.windows;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class BaseWindows {
	
	public WiniumDriver winiumDriver;
	/**
     * This  method is used to initialize a winium driver object based on the Desktop application
     * @param String appPath This is the Path of the Desktop Application to launch
     * @param hostServer This is the server - host:port to host the winium driver ex. locslhost:9999
     * @return WiniumDriver object after initializing it.
     */
    public WiniumDriver launchDesktopApp(String appPath, String hostServer) throws MalformedURLException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(appPath);
        winiumDriver = new WiniumDriver(new URL(hostServer),options);
        return winiumDriver;
    }
    
    
    /**
	 * This method is to close the winium driver instance
	 * 
	 */

	public void closeDriver() {
		winiumDriver.quit();
	}

}
