package org.xde.Xrefresh.Utils;

public class DriverFactory {
	
	private static String chromeDriverPath ;
	private static String geckoDriverPath ;
	
	private static String configPropertyFile ;
	private static String gridPath ;
	private static boolean isRemote ;
	
	
	public static boolean isRemote() {
		return isRemote;
	}
	public static void setRemote(boolean isRemote) {
		DriverFactory.isRemote = isRemote;
	}
	public static String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public static void setChromeDriverPath(String chromeDriverPath) {
		DriverFactory.chromeDriverPath = chromeDriverPath;
	}
	public static String getGeckoDriverPath() {
		return geckoDriverPath;
	}
	public static void setGeckoDriverPath(String geckoDriverPath) {
		DriverFactory.geckoDriverPath = geckoDriverPath;
	}
	public static String getConfigPropertyFile() {
		return configPropertyFile;
	}
	public static void setConfigPropertyFile(String configPropertyFile) {
		DriverFactory.configPropertyFile = configPropertyFile;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	

}
