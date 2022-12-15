package com.fb.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ip;

	public BaseClass() {
		prop = new Properties();
		try {
			ip = new FileInputStream(
					"E:\\ADARSH Current data\\facebook\\src\\main\\java\\com\\fb\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initiazations() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\All software for development\\softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println("title of the web page: " + title);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
}