package com.amazon;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdefinition_Mobiles {
	
	public static HttpURLConnection http = null;
	public static WebDriver w ;
	
public static void main(String[] args) throws MalformedURLException, IOException {
WebDriverManager.chromedriver().setup();
String att = null;
	w = new ChromeDriver();
	w.get("https://www.amazon.com");
	List<WebElement> links = w.findElements(By.tagName("link"));
	System.out.println(links.size());
	Iterator<WebElement> link = links.iterator();
	while(link.hasNext()) {
		WebElement next = link.next();
		att = next.getAttribute("href");
		System.out.println(att);
		
		if(att==null||att.isEmpty()) {
			System.out.println("Is is not Assigned");
		}

		if(!att.startsWith("https://www.amazon.com")) {
			System.out.println("not this domain");
		}
		http = (HttpURLConnection) (new java.net.URL(att).openConnection());
		http.setRequestMethod("HEAD");
		http.connect();
		int responseCode = http.getResponseCode();
		
		if(responseCode>=400) {
			System.out.println("It is a broken link"+ att);
		}
		else {
			System.out.println(att+" "+"is valid Link");
		}
		
	}
}
	
}
